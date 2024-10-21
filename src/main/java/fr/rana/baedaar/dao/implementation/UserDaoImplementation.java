package fr.rana.baedaar.dao.implementation;

import fr.rana.baedaar.dao.UserDao;
import fr.rana.baedaar.database.DatabaseConnection;
import fr.rana.baedaar.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImplementation implements UserDao {

    private static final String INSERT_USER_SQL = "INSERT INTO users (username, password) VALUES (?, ?)";
    private static final String CHECK_CREDENTIAL = "SELECT * FROM users WHERE username = ? AND password = ?";
    private static final String UPDATE_USER = "UPDATE users SET password = ? WHERE username = ?";
    private static final String DELETE_USER = "DELETE FROM users WHERE username = ? AND password = ?";



    @Override
    public void insertUser(User user) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error inserting user into database");
        }
    }

    @Override
    public void connection(String username, String password) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_CREDENTIAL)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error checking user credentials");
        }
    }

    @Override
    public void updateUser(String username, String password) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {

            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Le mot de passe de l'utilisateur a été mis à jour avec succès.");
            } else {
                System.out.println("Aucun utilisateur trouvé avec ce nom d'utilisateur.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erreur lors de la mise à jour du mot de passe.");
        }

    }

    @Override
    public void deleteUser(String username, String password) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("L'utilisateur a été supprimé avec succès.");
            } else {
                System.out.println("Aucun utilisateur trouvé avec ce nom d'utilisateur.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erreur lors de la suppression de l'utilisateur.");
        }
    }
}
