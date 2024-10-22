package fr.rana.baedaar.dao.implementation;

import fr.rana.baedaar.dao.PostDao;
import fr.rana.baedaar.database.DatabaseConnection;
import fr.rana.baedaar.entities.Comment;
import fr.rana.baedaar.entities.Like;
import fr.rana.baedaar.entities.Post;
import fr.rana.baedaar.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImplementation implements PostDao {

    @Override
    public void createPost(Post post) throws SQLException {
        String sql = "INSERT INTO posts (user_id, content) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setLong(1, post.getUser().getId());
            preparedStatement.setString(2, post.getContent());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        post.setId(generatedKeys.getLong(1));
                        System.out.println("Post créé avec succès avec ID: " + post.getId());
                    }
                }
            } else {
                System.out.println("Échec de la création du post.");
            }
        }
    }

    @Override
    public Post getPostById(Long id) throws SQLException {
        String sql = "SELECT * FROM posts WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            preparedStatement.setLong(1, id);

            if (resultSet.next()) {
                Long userId = resultSet.getLong("user_id");
                String content = resultSet.getString("content");
                User user = getUserById(userId);
                List<Comment> comments = getCommentsByPostId(id);
                List<Like> likes = getLikesByPostId(id);
                return new Post(user, content, comments, likes);
            }
        }
        return null;
    }

    private User getUserById(Long userId) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String userName = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    return new User(id, userName, password);
                }
            }
        }
        return null;
    }

    @Override
    public void updatePost(Post post) throws SQLException {
        String sql = "UPDATE posts SET content = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, post.getContent());
            preparedStatement.setLong(2, post.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Post mis à jour avec succès !");
            }
        }
    }

    @Override
    public void deletePost(Post post) throws SQLException {
        String sql = "DELETE FROM posts WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, post.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Post supprimé avec succès !");
            }
        }
    }

    // Méthode pour charger les commentaires d'un post
    private List<Comment> getCommentsByPostId(Long postId) throws SQLException {
        String sql = "SELECT c.id, c.content, c.user_id, c.post_id, u.username, u.password FROM comments c " +
                "JOIN users u ON c.user_id = u.id WHERE c.post_id = ?";
        List<Comment> comments = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, postId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Long commentId = resultSet.getLong("id");
                    String content = resultSet.getString("content");

                    Long userId = resultSet.getLong("user_id");
                    String userName = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    User user = new User(userId, userName, password);

                    Post post = getPostById(postId);
                    comments.add(new Comment(commentId, user, content, post, new ArrayList<>()));
                }
            }
        }
        return comments;
    }

    private Comment getCommentById(Long commentId) throws SQLException {
        String sql = "SELECT c.id, c.content, c.user_id, u.username, u.password, c.post_id " +
                "FROM comments c JOIN users u ON c.user_id = u.id WHERE c.id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, commentId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String content = resultSet.getString("content");

                    Long userId = resultSet.getLong("user_id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    User user = new User(userId, username, password);

                    Long postId = resultSet.getLong("post_id");
                    Post post = getPostById(postId);

                    return new Comment(id, user, content, post, new ArrayList<>());
                }
            }
        }

        return null;
    }



    private List<Like> getLikesByPostId(Long postId) throws SQLException {
        String sql = "SELECT l.id, l.user_id, u.username, u.password, l.comment_id " +
                "FROM likes l JOIN users u ON l.user_id = u.id WHERE l.post_id = ?";
        List<Like> likes = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, postId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Long likeId = resultSet.getLong("id");

                    Long userId = resultSet.getLong("user_id");
                    String userName = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    User user = new User(userId, userName, password);

                    Long commentId = resultSet.getLong("comment_id");
                    Comment comment = null;
                    if (commentId != 0) {
                        comment = getCommentById(commentId);
                        likes.add(new Like(likeId, user, comment));
                    } else {
                        Post post = getPostById(postId);
                        likes.add(new Like(likeId, user, post));
                    }
                }
            }
        }
        return likes;
    }
}
