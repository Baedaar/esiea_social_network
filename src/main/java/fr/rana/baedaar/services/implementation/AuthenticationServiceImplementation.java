package fr.rana.baedaar.services.implementation;

import fr.rana.baedaar.dao.UserDao;
import fr.rana.baedaar.dao.implementation.UserDaoImplementation;
import fr.rana.baedaar.entities.User;
import fr.rana.baedaar.services.AuthenticationService;

import java.sql.SQLException;

public class AuthenticationServiceImplementation implements AuthenticationService {

    private final UserDao userDao = new UserDaoImplementation();

    @Override
    public User connection(String userName, String password) {
        User user = new User(userName, password);
        try {
            userDao.connection(userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
