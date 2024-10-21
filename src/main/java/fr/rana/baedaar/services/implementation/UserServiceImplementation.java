package fr.rana.baedaar.services.implementation;

import fr.rana.baedaar.dao.UserDao;
import fr.rana.baedaar.dao.implementation.UserDaoImplementation;
import fr.rana.baedaar.entities.User;
import fr.rana.baedaar.services.UserService;

import java.sql.SQLException;

public class UserServiceImplementation implements UserService {

    private final UserDao userDAO = new UserDaoImplementation();


    @Override
    public User createUser(String userName, String password) {
        User user = new User(userName, password);
        try {
            userDAO.insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(String userName, String password) {
        try {
            userDAO.updateUser(userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String userName, String password) {
        try {
            userDAO.deleteUser(userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
