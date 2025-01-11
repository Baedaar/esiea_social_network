package fr.rana.baedaar.application.services;

import fr.rana.baedaar.domain.model.User;
import fr.rana.baedaar.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

}
