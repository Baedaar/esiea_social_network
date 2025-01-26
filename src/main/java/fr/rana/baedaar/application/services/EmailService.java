package fr.rana.baedaar.application.services;

import fr.rana.baedaar.domain.repository.EmailNotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final EmailNotificationRepository repository;


    public EmailService(EmailNotificationRepository repository) {
        this.repository = repository;
    }

    public void sendEmail(String to, String subject, String body) {
        repository.sendEmail(to, subject, body);
    }
}
