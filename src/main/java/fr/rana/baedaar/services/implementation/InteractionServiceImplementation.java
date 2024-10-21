package fr.rana.baedaar.services.implementation;

import fr.rana.baedaar.entities.Comment;
import fr.rana.baedaar.entities.Like;
import fr.rana.baedaar.entities.Post;
import fr.rana.baedaar.entities.User;
import fr.rana.baedaar.services.InteractionService;

public class InteractionServiceImplementation implements InteractionService {
    @Override
    public Post createPost(User user, String content) {
        return null;
    }

    @Override
    public Post updatePost(String newContent) {
        return null;
    }

    @Override
    public void deletePost(Post post) {

    }

    @Override
    public Post createComment(User user, Post post, String content) {
        return null;
    }

    @Override
    public Post updateComment(String newContent) {
        return null;
    }

    @Override
    public void deleteComment(Comment comment) {

    }

    @Override
    public Like addLike(Post post) {
        return null;
    }

    @Override
    public Like addLike(Comment comment) {
        return null;
    }

    @Override
    public void removeLike(Like like) {

    }
}
