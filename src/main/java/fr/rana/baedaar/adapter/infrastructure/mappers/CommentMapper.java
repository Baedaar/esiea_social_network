package fr.rana.baedaar.adapter.infrastructure.mappers;

import fr.rana.baedaar.application.dto.CommentDto;
import fr.rana.baedaar.domain.model.Comment;
import fr.rana.baedaar.domain.model.Post;
import fr.rana.baedaar.domain.model.User;

import java.util.stream.Collectors;

public class CommentMapper {


    // Conversion du modèle Comment vers le DTO CommentDTO
    public static CommentDto toDTO(Comment comment) {
        if (comment == null) {
            return null;
        }

        return new CommentDto(
                comment.getUser() != null ? comment.getUser().getUserName() : null,
                comment.getContent(),
                comment.getPost() != null ? comment.getPost().getId() : null,
                comment.getLikes() != null
                        ? comment.getLikes().stream()
                        .map(LikeMapper::toDTO)
                        .collect(Collectors.toList())
                        : null
        );
    }

    // Conversion du DTO CommentDTO vers le modèle Comment
    public static Comment toEntity(CommentDto commentDTO) {
        if (commentDTO == null) {
            return null;
        }
        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        // Mapper les likes associés
        comment.setLikes(
                commentDTO.getLikes() != null
                        ? commentDTO.getLikes().stream()
                        .map(LikeMapper::toEntity)
                        .collect(Collectors.toList())
                        : null
        );
        return comment;
    }

}
