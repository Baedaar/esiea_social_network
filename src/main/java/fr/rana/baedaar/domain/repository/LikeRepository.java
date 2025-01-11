package fr.rana.baedaar.domain.repository;

import fr.rana.baedaar.domain.model.Comment;
import fr.rana.baedaar.domain.model.Post;
import fr.rana.baedaar.domain.model.User;

public interface LikeRepository {
    void createLike(Post post, User user);
    void createLike(Comment comment, User user);
    void removeLike(Post post, User user);
    void removeLike(Comment comment, User user);
}
