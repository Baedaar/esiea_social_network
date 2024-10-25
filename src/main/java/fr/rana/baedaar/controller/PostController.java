package fr.rana.baedaar.controller;

import fr.rana.baedaar.controller.dto.CreatePostRequest;
import fr.rana.baedaar.entities.Post;
import fr.rana.baedaar.entities.User;
import fr.rana.baedaar.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/create-post")
    public ResponseEntity<Post> createPost(@RequestBody CreatePostRequest createPostRequest) {
        return null;
    }

}
