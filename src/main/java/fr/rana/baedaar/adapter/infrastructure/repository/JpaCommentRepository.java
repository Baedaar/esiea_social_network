package fr.rana.baedaar.adapter.infrastructure.repository;

import fr.rana.baedaar.domain.model.Comment;
import fr.rana.baedaar.domain.model.Post;
import fr.rana.baedaar.domain.repository.CommentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaCommentRepository implements CommentRepository {
    @Override
    public Comment save(Comment comment) {
        return null;
    }

    @Override
    public Comment createComment(String content, Post post) {
        return null;
    }

    @Override
    public void updateComment(String content, Long commentId) {

    }

    @Override
    public void deleteComment(Comment comment) {

    }

    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public Optional<Comment> findById() {
        return Optional.empty();
    }
}
