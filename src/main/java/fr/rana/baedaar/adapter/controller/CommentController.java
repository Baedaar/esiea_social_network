package fr.rana.baedaar.adapter.controller;

import fr.rana.baedaar.application.dto.CommentDto;
import fr.rana.baedaar.application.services.CommentService;
import fr.rana.baedaar.domain.model.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public ResponseEntity<Comment> saveComment(@RequestBody CommentDto commentDto) {
        return null;
    }

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
}
