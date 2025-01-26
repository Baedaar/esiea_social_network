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
        User savedUser = userRepository.save(user);
        EventUserCreated eventUserCreated = new EventUserCreated(
                savedUser.getId(),
                savedUser.getUserName(),
                savedUser.getPassword()
        );
        eventPublisher.publishEvent(eventUserCreated);
        return savedUser;
    }

    public User connection(String username, String password) {
        return userRepository.connection(username, password);
    }
}
