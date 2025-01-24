package fr.rana.baedaar.application.services;

import fr.rana.baedaar.application.event.EventPublisher;
import fr.rana.baedaar.domain.event.EventUserCreated;
import fr.rana.baedaar.domain.model.User;
import fr.rana.baedaar.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final EventPublisher eventPublisher;

    public UserService(UserRepository userRepository, EventPublisher eventPublisher) {
        this.userRepository = userRepository;
        this.eventPublisher = eventPublisher;
    }

    public User createUser(User user) {
        EventUserCreated eventUserCreated = new EventUserCreated(
                user.getId(),
                user.getUserName(),
                user.getPassword()
        );
        eventPublisher.publishEvent(eventUserCreated);
        return userRepository.save(user);
    }

    public User connection(String username, String password) {
        return userRepository.connection(username, password);
    }
}
