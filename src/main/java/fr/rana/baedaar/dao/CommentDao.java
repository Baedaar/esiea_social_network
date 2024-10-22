package fr.rana.baedaar.dao;

import fr.rana.baedaar.entities.Comment;
import fr.rana.baedaar.entities.Post;

import java.sql.SQLException;

public interface CommentDao {

    Comment createComment(String content, Post post) throws SQLException;
    void updateComment(String content, Long commentId) throws SQLException;
    void deleteComment(Comment comment) throws SQLException;

}
