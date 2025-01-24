package fr.rana.baedaar.adapter.controller;

import fr.rana.baedaar.application.dto.PostDto;
import fr.rana.baedaar.application.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static fr.rana.baedaar.adapter.infrastructure.mappers.PostMapper.toDTO;
import static fr.rana.baedaar.adapter.infrastructure.mappers.PostMapper.toEntity;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService service;

    @PostMapping("create-post")
    ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return ResponseEntity.ok(toDTO(service.createPost(postDto.getUserName(),toEntity(postDto))));
    }

    public PostController(PostService service) {
        this.service = service;
    }
}
