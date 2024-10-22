package fr.rana.baedaar.dao;

import fr.rana.baedaar.entities.User;

import java.sql.SQLException;

public interface UserDao {
    void insertUser(User user) throws SQLException;
    User connection(String username, String password) throws SQLException;
    void updateUser(String username, String password) throws SQLException;
    void deleteUser(String username, String password) throws SQLException;
}
