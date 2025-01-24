package fr.rana.baedaar.adapter.controller;

import fr.rana.baedaar.application.dto.AuthenticationDto;
import fr.rana.baedaar.application.dto.UserDto;
import fr.rana.baedaar.application.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static fr.rana.baedaar.adapter.infrastructure.mappers.UserMapper.toDTO;
import static fr.rana.baedaar.adapter.infrastructure.mappers.UserMapper.toEntity;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(toDTO(userService.createUser(toEntity(userDto))));
    }

    @PostMapping("/connection")
    public ResponseEntity<UserDto> connection(@RequestBody AuthenticationDto authenticationDto) {
        return ResponseEntity.ok(toDTO(userService.connection(
                authenticationDto.getUsername(),
                authenticationDto.getPassword())
        ));
    }
}
