package fr.rana.baedaar.services;

import fr.rana.baedaar.entities.Post;
import fr.rana.baedaar.entities.User;

import java.util.List;

public interface PostService {
    Post createPost(User user, String content);
    Post updatePost(Post post, String newContent);
    void deletePost( Post post);
    List<String> getAllPostsContent();
}
