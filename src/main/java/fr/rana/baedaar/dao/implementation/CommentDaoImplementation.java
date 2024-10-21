package fr.rana.baedaar.dao.implementation;

import fr.rana.baedaar.dao.CommentDao;
import fr.rana.baedaar.entities.Comment;
import fr.rana.baedaar.entities.Post;

import java.sql.SQLException;

public class CommentDaoImplementation implements CommentDao {
    @Override
    public void createComment(String content, Post post) throws SQLException {

    }

    @Override
    public void updateComment(String content) throws SQLException {

    }

    @Override
    public void deleteComment(Comment comment) throws SQLException {

    }
}
