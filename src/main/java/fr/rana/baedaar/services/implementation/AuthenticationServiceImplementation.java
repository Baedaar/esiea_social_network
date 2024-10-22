package fr.rana.baedaar.services.implementation;

import fr.rana.baedaar.dao.UserDao;
import fr.rana.baedaar.entities.User;
import fr.rana.baedaar.services.AuthenticationService;

import java.sql.SQLException;

public class AuthenticationServiceImplementation implements AuthenticationService {

    private final UserDao userDao;

    public AuthenticationServiceImplementation(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User connection(String userName, String password) {
        User authenticatedUser = null;
        try {
            authenticatedUser = userDao.connection(userName, password);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la tentative de connexion de l'utilisateur : " + e.getMessage());
        }
        return authenticatedUser;
    }
}
