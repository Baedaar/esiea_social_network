package fr.rana.baedaar.application.services;

import fr.rana.baedaar.domain.model.Post;
import fr.rana.baedaar.domain.model.User;
import fr.rana.baedaar.domain.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository repository;


    public Post createPost(String username, Post post) {
        return repository.save(username, post);
    }



    public PostService(PostRepository repository) {
        this.repository = repository;
    }
}
