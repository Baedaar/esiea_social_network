package fr.rana.baedaar.adapter.messaging;

import fr.rana.baedaar.application.event.EventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventPublisher implements EventPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaEventPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishEvent(Object event) {
        String topic = "user.events";
        String message = event.toString();
        kafkaTemplate.send(topic, message);
    }
}