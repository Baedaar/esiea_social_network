package fr.rana.baedaar.adapter.infrastructure.mappers;

import fr.rana.baedaar.application.dto.LikeDto;
import fr.rana.baedaar.domain.model.Like;

public class LikeMapper {

    // Conversion du modèle Like vers le DTO LikeDTO
    public static LikeDto toDTO(Like like) {
        if (like == null) {
            return null;
        }

        return new LikeDto(
                like.getUser() != null ? like.getUser().getUserName() : null,
                like.getPost() != null ? like.getPost().getId() : null,
                like.getComment() != null ? like.getComment().getId() : null
        );
    }

    public static Like toEntity(LikeDto likeDTO) {
        if (likeDTO == null) {
            return null;
        }
        return new Like();
    }

}
