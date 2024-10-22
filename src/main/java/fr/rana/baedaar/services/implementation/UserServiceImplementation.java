package fr.rana.baedaar.services.implementation;

import fr.rana.baedaar.dao.UserDao;
import fr.rana.baedaar.entities.User;
import fr.rana.baedaar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImplementation(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User createUser(String userName, String password) {
        User user = new User(userName, password);
        try {
            userDao.insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(String userName, String password) {
        try {
            userDao.updateUser(userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String userName, String password) {
        try {
            userDao.deleteUser(userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
