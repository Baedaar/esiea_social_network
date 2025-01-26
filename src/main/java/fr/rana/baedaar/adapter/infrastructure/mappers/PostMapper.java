package fr.rana.baedaar.adapter.infrastructure.mappers;

import fr.rana.baedaar.application.dto.PostDto;
import fr.rana.baedaar.domain.model.Post;

import java.util.stream.Collectors;

public class PostMapper {

    // Conversion du modèle Post vers le DTO PostDTO
    public static PostDto toDTO(Post post) {
        if (post == null) {
            return null;
        }

        return new PostDto(
                post.getUser() != null ? post.getUser().getUserName() : null,
                post.getContent(),
                post.getComments() != null
                        ? post.getComments().stream()
                        .map(CommentMapper::toDTO)
                        .collect(Collectors.toList())
                        : null,
                post.getLikes() != null
                        ? post.getLikes().stream()
                        .map(LikeMapper::toDTO)
                        .collect(Collectors.toList())
                        : null
        );
    }

    // Conversion du DTO PostDTO vers le modèle Post
    public static Post toEntity(PostDto postDTO) {
        if (postDTO == null) {
            return null;
        }

        Post post = new Post();
        post.setContent(postDTO.getContent());
        post.setComments(
                postDTO.getComments() != null
                        ? postDTO.getComments().stream()
                        .map(CommentMapper::toEntity)
                        .collect(Collectors.toList())
                        : null
        );
        post.setLikes(
                postDTO.getLikes() != null
                        ? postDTO.getLikes().stream()
                        .map(LikeMapper::toEntity)
                        .collect(Collectors.toList())
                        : null
        );
        return post;
    }

}
