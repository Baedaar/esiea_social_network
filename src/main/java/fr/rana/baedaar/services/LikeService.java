package fr.rana.baedaar.services;

import fr.rana.baedaar.entities.Comment;
import fr.rana.baedaar.entities.Like;
import fr.rana.baedaar.entities.Post;
import fr.rana.baedaar.entities.User;

public interface LikeService {

    Like addLike(Post post, User user);
    Like addLike(Comment comment, User user);
    void removeLike(Like like);

}
