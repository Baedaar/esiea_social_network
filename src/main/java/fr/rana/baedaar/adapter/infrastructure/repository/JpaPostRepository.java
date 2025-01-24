package fr.rana.baedaar.adapter.infrastructure.repository;

import fr.rana.baedaar.adapter.infrastructure.entity.JpaPostEntity;
import fr.rana.baedaar.adapter.infrastructure.entity.JpaUserEntity;
import fr.rana.baedaar.domain.model.Post;
import fr.rana.baedaar.domain.model.User;
import fr.rana.baedaar.domain.repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaPostRepository implements PostRepository {

    private final SpringPostRepository repository;

    public JpaPostRepository(SpringPostRepository repository) {
        this.repository = repository;
    }

    @Override
    public Post save(String username, Post post) {
        JpaPostEntity postEntity = new JpaPostEntity();
        postEntity.setUser(repository.findByUserUserName(username)
                .orElseThrow(() -> new RuntimeException("Invalid username")));
        postEntity.setContent(post.getContent());
        repository.save(postEntity);
       return postEntity.toPost();
    }

    @Override
    public Post getPostById(Long id) {
        return null;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public void updatePost(Post post) {

    }

    @Override
    public void deletePost(Post post) {

    }
}
