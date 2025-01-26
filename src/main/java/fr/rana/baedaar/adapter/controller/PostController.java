package fr.rana.baedaar.adapter.controller;

import fr.rana.baedaar.adapter.infrastructure.mappers.PostMapper;
import fr.rana.baedaar.application.dto.PostDto;
import fr.rana.baedaar.application.services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static fr.rana.baedaar.adapter.infrastructure.mappers.PostMapper.toDTO;
import static fr.rana.baedaar.adapter.infrastructure.mappers.PostMapper.toEntity;

@RestController
@RequestMapping("/posts")
@Tag(name = "Posts", description = "API de gestion des Post")
public class PostController {

    private final PostService service;

    @Operation(summary = "Create a new post")
    @ApiResponse(responseCode = "200", description = "Post created successfully")
    @ApiResponse(responseCode = "400", description = "Données de post invalides")
    @PostMapping("create-post")
    ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return ResponseEntity.ok(toDTO(service.createPost(postDto.getUserName(),toEntity(postDto))));
    }

    @Operation(summary = "See all posts")
    @ApiResponse(responseCode = "200", description = "Posts shown successfully")
    @ApiResponse(responseCode = "400", description = "Données invalides")
    @GetMapping("all-posts")
    ResponseEntity<List<PostDto>> seeAllPosts() {
        return ResponseEntity.ok(
                service.findAll().stream()
                        .map(PostMapper::toDTO)
                        .collect(Collectors.toList())
        );
    }

    public PostController(PostService service) {
        this.service = service;
    }
}
