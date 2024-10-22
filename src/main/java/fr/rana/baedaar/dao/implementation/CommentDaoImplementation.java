package fr.rana.baedaar.dao.implementation;

import fr.rana.baedaar.dao.CommentDao;
import fr.rana.baedaar.database.DatabaseConnection;
import fr.rana.baedaar.entities.Comment;
import fr.rana.baedaar.entities.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentDaoImplementation implements CommentDao {

    @Override
    public Comment createComment(String content, Post post) throws SQLException {
        String sql = "INSERT INTO comments (content, post_id, user_id) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, content);
            preparedStatement.setLong(2, post.getId());
            preparedStatement.setLong(3, post.getUser().getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        Long generatedId = generatedKeys.getLong(1);
                        System.out.println("Commentaire créé avec succès. ID du commentaire : " + generatedId);

                        return new Comment(generatedId, post.getUser(), content, post, null);
                    }
                }
            } else {
                System.out.println("Échec de la création du commentaire.");
            }
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la création du commentaire : " + e.getMessage(), e);
        }

        return null;
    }

    @Override
    public void updateComment(String content, Long commentId) throws SQLException {
        String sql = "UPDATE comments SET content = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, content);
            preparedStatement.setLong(2, commentId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Commentaire mis à jour avec succès.");
            } else {
                System.out.println("Aucun commentaire trouvé avec cet ID : " + commentId);
            }
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la mise à jour du commentaire : " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteComment(Comment comment) throws SQLException {
        String sql = "DELETE FROM comments WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, comment.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Commentaire supprimé avec succès.");
            } else {
                System.out.println("Aucun commentaire trouvé avec cet ID : " + comment.getId());
            }
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la suppression du commentaire : " + e.getMessage(), e);
        }
    }
}
