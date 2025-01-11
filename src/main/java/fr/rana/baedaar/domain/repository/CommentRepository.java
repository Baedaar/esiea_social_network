package fr.rana.baedaar.domain.repository;

import fr.rana.baedaar.domain.model.Comment;
import fr.rana.baedaar.domain.model.Post;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {

    Comment save(Comment comment);

    Comment createComment(String content, Post post);

    void updateComment(String content, Long commentId);

    void deleteComment(Comment comment);

    List<Comment> findAll();

    Optional<Comment> findById();

}
