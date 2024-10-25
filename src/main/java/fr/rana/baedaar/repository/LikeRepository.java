package fr.rana.baedaar.repository;

import fr.rana.baedaar.entities.Comment;
import fr.rana.baedaar.entities.Post;
import fr.rana.baedaar.entities.User;

import java.sql.SQLException;

public interface LikeRepository {
    void createLike(Post post, User user) throws SQLException;
    void createLike(Comment comment, User user) throws SQLException;
    void removeLike(Post post, User user) throws SQLException;
    void removeLike(Comment comment, User user) throws SQLException;
}
