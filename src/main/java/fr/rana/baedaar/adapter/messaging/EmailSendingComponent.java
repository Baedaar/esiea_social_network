package fr.rana.baedaar.adapter.messaging;

import fr.rana.baedaar.domain.repository.EmailNotificationRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSendingComponent implements EmailNotificationRepository {

    private final JavaMailSender mailSender;

    public EmailSendingComponent(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            message.setFrom("test@localhost");
            mailSender.send(message);
            System.out.println("Email sent to: " + to);
        } catch (Exception e) {
            System.err.println("Error sending email: " + e.getMessage());
        }
    }
}