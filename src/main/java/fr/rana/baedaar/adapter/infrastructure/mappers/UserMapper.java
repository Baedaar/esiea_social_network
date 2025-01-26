package fr.rana.baedaar.adapter.infrastructure.mappers;

import fr.rana.baedaar.application.dto.UserDto;
import fr.rana.baedaar.domain.model.User;

import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto toDTO(User user) {
        if (user == null) {
            return null;
        }

        return new UserDto(
                user.getUserName(),
                user.getPassword(),
                user.getPosts() != null
                        ? user.getPosts().stream()
                        .map(PostMapper::toDTO)
                        .collect(Collectors.toList())
                        : null,
                user.getLikes() != null
                        ? user.getLikes().stream()
                        .map(LikeMapper::toDTO)
                        .collect(Collectors.toList())
                        : null
        );
    }

    // Conversion du DTO UserDTO vers le modèle User
    public static User toEntity(UserDto userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setUserName(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPosts(
                userDTO.getPosts() != null
                        ? userDTO.getPosts().stream()
                        .map(PostMapper::toEntity)
                        .collect(Collectors.toList())
                        : null
        );
        user.setLikes(
                userDTO.getLikes() != null
                        ? userDTO.getLikes().stream()
                        .map(LikeMapper::toEntity)
                        .collect(Collectors.toList())
                        : null
        );
        return user;
    }

}
