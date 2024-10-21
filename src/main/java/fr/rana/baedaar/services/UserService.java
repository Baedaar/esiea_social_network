package fr.rana.baedaar.services;

import fr.rana.baedaar.entities.User;

public interface UserService {

    User createUser(String userName, String password);
    void updateUser(String userName, String password);
    void deleteUser(String userName, String password);

}
