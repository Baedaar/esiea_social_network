package fr.rana.baedaar.adapter.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.rana.baedaar.application.services.EmailService;
import fr.rana.baedaar.domain.event.EventUserCreated;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final EmailService emailService;

    public KafkaEventConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "user.events", groupId = "group_id_example")
    public void listen(String message) {
        System.out.println("Received message: " + message);

        try {
            // Désérialisez le message en un objet EventUserCreated
            EventUserCreated event = objectMapper.readValue(message, EventUserCreated.class);

            // Traitez l'événement
            System.out.println("Processed Event: userId=" + event.getUserId() +
                    ", username=" + event.getUsername() +
                    ", password=" + event.getPassword());

            // Envoyer un e-mail
            emailService.sendEmail(
                    event.getUsername(),
                    "Welcome to SocialVibe",
                    "Hi " + event.getUsername() + ", thank you for joining SocialVibe!"
            );
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}