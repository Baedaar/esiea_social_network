package fr.rana.baedaar.application.services;

import fr.rana.baedaar.domain.model.Post;
import fr.rana.baedaar.domain.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;


    public Post createPost(String email, Post post) {
        return repository.save(email, post);
    }

    public List<Post> findAll() {
        return repository.findAll();
    }



    public PostService(PostRepository repository) {
        this.repository = repository;
    }
}
