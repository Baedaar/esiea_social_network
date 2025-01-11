package fr.rana.baedaar.domain.repository;

import fr.rana.baedaar.domain.model.Post;

public interface PostRepository {
    void createPost(Post post);
    Post getPostById(Long id);
    void updatePost(Post post);
    void deletePost(Post post);
}
