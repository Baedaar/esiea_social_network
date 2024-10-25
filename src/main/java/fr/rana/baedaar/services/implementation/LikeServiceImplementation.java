package fr.rana.baedaar.services.implementation;

import fr.rana.baedaar.repository.LikeRepository;
import fr.rana.baedaar.entities.Comment;
import fr.rana.baedaar.entities.Like;
import fr.rana.baedaar.entities.Post;
import fr.rana.baedaar.entities.User;
import fr.rana.baedaar.services.LikeService;

import java.sql.SQLException;

public class LikeServiceImplementation implements LikeService {

    private final LikeRepository likeRepository;

    public LikeServiceImplementation(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public Like addLike(Post post, User user) {
        try {
            likeRepository.createLike(post, user);
            return new Like(user, post);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de l'ajout du like : " + e.getMessage());
        }
    }

    @Override
    public Like addLike(Comment comment, User user) {
        try {
            likeRepository.createLike(comment, user);
            return new Like(user, comment);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de l'ajout du like sur le commentaire : " + e.getMessage());
        }
    }

    @Override
    public void removeLike(Like like) {
        try {
            if (like.getPost() != null) {
                likeRepository.removeLike(like.getPost(), like.getUser());
            } else if (like.getComment() != null) {
                likeRepository.removeLike(like.getComment(), like.getUser());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la suppression du like : " + e.getMessage());
        }
    }
}
