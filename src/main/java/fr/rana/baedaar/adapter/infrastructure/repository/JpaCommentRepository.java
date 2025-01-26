package fr.rana.baedaar.adapter.infrastructure.repository;

import fr.rana.baedaar.adapter.infrastructure.entity.JpaCommentEntity;
import fr.rana.baedaar.domain.model.Comment;
import fr.rana.baedaar.domain.repository.CommentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaCommentRepository implements CommentRepository {

    private final SpringUserRepository userRepository;
    private final SpringCommentRepository commentRepository;
    private final SpringPostRepository postRepository;

    public JpaCommentRepository(SpringUserRepository userRepository, SpringCommentRepository commentRepository, SpringPostRepository postRepository) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public Comment save(String email, Long postId, Comment comment) {
        JpaCommentEntity commentEntity = new JpaCommentEntity();
        commentEntity.setUser(userRepository.findByUserName(email)
                .orElseThrow(() -> new RuntimeException("Invalid username")));
        commentEntity.setPost(postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Invalid postId")));
        commentEntity.setContent(comment.getContent());
        commentRepository.save(commentEntity);
        return commentEntity.toComment();
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
