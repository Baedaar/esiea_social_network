package fr.rana.baedaar.services;

import fr.rana.baedaar.entities.Post;
import fr.rana.baedaar.entities.User;

public interface PostService {
    Post createPost(User user, String content);
    Post updatePost(Post post, String newContent);
    void deletePost( Post post);
}
