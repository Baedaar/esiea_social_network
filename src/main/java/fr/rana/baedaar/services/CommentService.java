package fr.rana.baedaar.services;

import fr.rana.baedaar.entities.Comment;
import fr.rana.baedaar.entities.Post;
import fr.rana.baedaar.entities.User;

public interface CommentService {

    Comment createComment(User user, Post post, String content);
    void updateComment( Long commentId, String newContent);
    void deleteComment(Comment comment);

}
