package fr.rana.baedaar.adapter.infrastructure.repository;

import fr.rana.baedaar.domain.model.Post;
import fr.rana.baedaar.domain.repository.PostRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaPostRepository implements PostRepository {
    @Override
    public void createPost(Post post) {

    }

    @Override
    public Post getPostById(Long id) {
        return null;
    }

    @Override
    public void updatePost(Post post) {

    }

    @Override
    public void deletePost(Post post) {

    }
}
