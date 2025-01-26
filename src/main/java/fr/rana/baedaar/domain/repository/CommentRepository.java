package fr.rana.baedaar.domain.repository;

import fr.rana.baedaar.domain.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {

    Comment save(String email, Long postId, Comment comment);

    void updateComment(String content, Long commentId);

    void deleteComment(Comment comment);

    List<Comment> findAll();

    Optional<Comment> findById();

}
