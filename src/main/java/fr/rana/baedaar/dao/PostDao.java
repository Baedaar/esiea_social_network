package fr.rana.baedaar.dao;

import fr.rana.baedaar.entities.Post;

import java.sql.SQLException;

public interface PostDao {
    void createPost(Post post) throws SQLException;
    Post getPostById(Long id) throws SQLException;
    void updatePost(Post post) throws SQLException;
    void deletePost(Post post) throws SQLException;
}
