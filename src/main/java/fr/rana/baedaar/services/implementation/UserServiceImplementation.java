package fr.rana.baedaar.services.implementation;

import fr.rana.baedaar.repository.UserRepository;
import fr.rana.baedaar.entities.User;
import fr.rana.baedaar.services.UserService;

import java.sql.SQLException;

public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String userName, String password) {
        User user = new User(userName, password);
        try {
            userRepository.insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(String userName, String password) {
        try {
            userRepository.updateUser(userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String userName, String password) {
        try {
            userRepository.deleteUser(userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
