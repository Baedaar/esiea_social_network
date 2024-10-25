package fr.rana.baedaar.repository;

import fr.rana.baedaar.entities.Post;

import java.sql.SQLException;
import java.util.List;

public interface PostRepository {
    void createPost(Post post) throws SQLException;
    Post getPostById(Long id) throws SQLException;
    void updatePost(Post post) throws SQLException;
    void deletePost(Post post) throws SQLException;
    List<Post> getAllPosts() throws SQLException;
}
