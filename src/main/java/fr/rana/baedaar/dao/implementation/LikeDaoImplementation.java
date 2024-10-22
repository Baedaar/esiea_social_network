package fr.rana.baedaar.dao.implementation;

import fr.rana.baedaar.dao.LikeDao;
import fr.rana.baedaar.database.DatabaseConnection;
import fr.rana.baedaar.entities.Comment;
import fr.rana.baedaar.entities.Post;
import fr.rana.baedaar.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LikeDaoImplementation implements LikeDao {

    private static final String INSERT_LIKE_POST_SQL = "INSERT INTO likes (user_id, post_id) VALUES (?, ?)";
    private static final String INSERT_LIKE_COMMENT_SQL = "INSERT INTO likes (user_id, comment_id) VALUES (?, ?)";
    private static final String REMOVE_LIKE_POST_SQL = "DELETE FROM likes WHERE user_id = ? AND post_id = ?";
    private static final String REMOVE_LIKE_COMMENT_SQL = "DELETE FROM likes WHERE user_id = ? AND comment_id = ?";

    @Override
    public void createLike(Post post, User user) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LIKE_POST_SQL)) {

            preparedStatement.setLong(1, user.getId());
            preparedStatement.setLong(2, post.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Like sur le post ajouté avec succès.");
            } else {
                System.out.println("Échec de l'ajout du like sur le post.");
            }
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de l'ajout du like sur le post : " + e.getMessage(), e);
        }
    }

    @Override
    public void removeLike(Post post, User user) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_LIKE_POST_SQL)) {

            preparedStatement.setLong(1, user.getId());
            preparedStatement.setLong(2, post.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Like sur le post supprimé avec succès.");
            } else {
                System.out.println("Échec de la suppression du like sur le post.");
            }
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la suppression du like sur le post : " + e.getMessage(), e);
        }
    }

    @Override
    public void createLike(Comment comment, User user) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LIKE_COMMENT_SQL)) {

            preparedStatement.setLong(1, user.getId());
            preparedStatement.setLong(2, comment.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Like sur le commentaire ajouté avec succès.");
            } else {
                System.out.println("Échec de l'ajout du like sur le commentaire.");
            }
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de l'ajout du like sur le commentaire : " + e.getMessage(), e);
        }
    }

    @Override
    public void removeLike(Comment comment, User user) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_LIKE_COMMENT_SQL)) {

            preparedStatement.setLong(1, user.getId());
            preparedStatement.setLong(2, comment.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Like sur le commentaire supprimé avec succès.");
            } else {
                System.out.println("Échec de la suppression du like sur le commentaire.");
            }
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la suppression du like sur le commentaire : " + e.getMessage(), e);
        }
    }
}
