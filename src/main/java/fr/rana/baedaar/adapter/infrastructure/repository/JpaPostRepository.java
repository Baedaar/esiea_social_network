package fr.rana.baedaar.adapter.infrastructure.repository;

import fr.rana.baedaar.adapter.infrastructure.entity.JpaPostEntity;
import fr.rana.baedaar.adapter.infrastructure.mappers.PostMapper;
import fr.rana.baedaar.domain.model.Post;
import fr.rana.baedaar.domain.repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaPostRepository implements PostRepository {

    private final SpringPostRepository repository;
    private final SpringUserRepository userRepository;

    public JpaPostRepository(SpringPostRepository repository, SpringUserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public Post save(String username, Post post) {
        JpaPostEntity postEntity = new JpaPostEntity();
        postEntity.setUser(userRepository.findByUserName(username)
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
        return repository.findAll().stream()
                .map(JpaPostEntity::toPost)
                .collect(Collectors.toList());
    }

    @Override
    public void updatePost(Post post) {

    }

    @Override
    public void deletePost(Post post) {

    }
}
