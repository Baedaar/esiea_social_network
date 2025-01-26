package fr.rana.baedaar.adapter.controller;

import fr.rana.baedaar.application.dto.CommentDto;
import fr.rana.baedaar.application.services.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static fr.rana.baedaar.adapter.infrastructure.mappers.CommentMapper.toDTO;
import static fr.rana.baedaar.adapter.infrastructure.mappers.CommentMapper.toEntity;

@Tag(name = "Comments", description = "API de gestion des commentaires")
@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @Operation(summary = "Create a new comment")
    @ApiResponse(responseCode = "200", description = "Comment created successfully")
    @ApiResponse(responseCode = "400", description = "Données de commentaire invalides")
    @PostMapping
    public ResponseEntity<CommentDto> saveComment(@RequestBody CommentDto commentDto) {
        return ResponseEntity.ok( toDTO(commentService.createComment(commentDto.getEmail(), commentDto.getPostId(), toEntity(commentDto))));
    }

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
}
