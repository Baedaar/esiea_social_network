package fr.rana.baedaar.services;

import fr.rana.baedaar.entities.Comment;
import fr.rana.baedaar.entities.Like;
import fr.rana.baedaar.entities.Post;
import fr.rana.baedaar.entities.User;

public interface InteractionService {
    Post createPost(User user, String content);
    Post updatePost( String newContent);
    void deletePost( Post post);
    Post createComment(User user, Post post, String content);
    Post updateComment( String newContent);
    void deleteComment(Comment comment);
    Like addLike(Post post);
    Like addLike(Comment comment);
    void removeLike(Like like);


}
