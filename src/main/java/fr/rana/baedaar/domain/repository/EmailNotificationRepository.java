package fr.rana.baedaar.domain.repository;

public interface EmailNotificationRepository {
    void sendEmail(String to, String subject, String body);
}
