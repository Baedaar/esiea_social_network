package fr.rana.baedaar.domain.repository;

import fr.rana.baedaar.domain.model.User;

public interface UserRepository {
    User save(User user);
    User connection(String username, String password);
    void updateUserPassword(String newPassword);
    void updateUserUsername(String newUsername);
    void deleteUser(String username, String password);
}
