package fr.rana.baedaar.adapter.controller;

import fr.rana.baedaar.application.dto.AuthenticationDto;
import fr.rana.baedaar.application.dto.UserDto;
import fr.rana.baedaar.application.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static fr.rana.baedaar.adapter.infrastructure.mappers.UserMapper.toDTO;
import static fr.rana.baedaar.adapter.infrastructure.mappers.UserMapper.toEntity;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "API de gestion des utilisateurs")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Create a new user")
    @ApiResponse(responseCode = "200", description = "User created successfully")
    @ApiResponse(responseCode = "400", description = "Données d'utilisateur invalides")
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(toDTO(userService.createUser(toEntity(userDto))));
    }

    @Operation(summary = "Connection")
    @ApiResponse(responseCode = "200", description = "User connected")
    @ApiResponse(responseCode = "400", description = "Saisies incorrect")
    @PostMapping("/connection")
    public ResponseEntity<UserDto> connection(@RequestBody AuthenticationDto authenticationDto) {
        return ResponseEntity.ok(toDTO(userService.connection(
                authenticationDto.getUsername(),
                authenticationDto.getPassword())
        ));
    }
}
