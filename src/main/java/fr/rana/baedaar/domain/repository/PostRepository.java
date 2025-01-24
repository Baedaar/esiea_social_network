package fr.rana.baedaar.domain.repository;

import fr.rana.baedaar.domain.model.Post;
import fr.rana.baedaar.domain.model.User;

import java.util.List;

public interface PostRepository {
    Post save(String username, Post post);
    Post getPostById(Long id);
    List<Post> findAll();
    void updatePost(Post post);
    void deletePost(Post post);
}
