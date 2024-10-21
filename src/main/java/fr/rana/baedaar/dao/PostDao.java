package fr.rana.baedaar.dao;

import fr.rana.baedaar.entities.Post;

import java.sql.SQLException;

public interface PostDao {
    void createPost(String content) throws SQLException;
    void updatePost(Post post, String content) throws SQLException;
    void deletePost(Post post) throws SQLException;
}
