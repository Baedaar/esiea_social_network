package fr.rana.baedaar.services.implementation;

import fr.rana.baedaar.repository.CommentRepository;
import fr.rana.baedaar.entities.Comment;
import fr.rana.baedaar.entities.Post;
import fr.rana.baedaar.entities.User;
import fr.rana.baedaar.services.CommentService;

import java.sql.SQLException;

public class CommentServiceImplementation implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImplementation(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment createComment(User user, Post post, String content) {
        try {
            Comment createdComment = commentRepository.createComment(content, post);

            if (createdComment != null) {
                System.out.println("Commentaire créé avec succès pour l'utilisateur " + user.getUserName() + " sur le post ID: " + post.getId() + ". ID du commentaire : " + createdComment.getId());
                return createdComment;
            } else {
                System.out.println("Échec de la création du commentaire.");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la création du commentaire : " + e.getMessage());
        }
    }

    @Override
    public void updateComment(Long commentId, String newContent) {
        try {
            commentRepository.updateComment(newContent, commentId);
            System.out.println("Commentaire avec ID: " + commentId + " mis à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la mise à jour du commentaire : " + e.getMessage());
        }
    }

    @Override
    public void deleteComment(Comment comment) {
        try {
            commentRepository.deleteComment(comment);
            System.out.println("Commentaire avec ID: " + comment.getId() + " supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la suppression du commentaire : " + e.getMessage());
        }
    }
}
