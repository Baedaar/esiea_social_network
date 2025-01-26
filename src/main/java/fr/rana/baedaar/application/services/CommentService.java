package fr.rana.baedaar.application.services;

import fr.rana.baedaar.domain.model.Comment;
import fr.rana.baedaar.domain.model.Post;
import fr.rana.baedaar.domain.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository repository;

    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public Comment createComment(String email, Long postId, Comment comment) {
        return repository.save(email, postId, comment);
    }
}
