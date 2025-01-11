package fr.rana.baedaar.adapter.controller;


import fr.rana.baedaar.application.dto.UserDto;
import fr.rana.baedaar.application.services.UserService;
import fr.rana.baedaar.domain.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        fr.rana.baedaar.domain.model.User user = new fr.rana.baedaar.domain.model.User(null, userDto.getUserName(), userDto.getPassword());
        User newUser = userService.createUser(user);
        return ResponseEntity.ok(new UserDto(newUser.getUserName(), user.getPassword()));
    }
}
