package fr.rana.baedaar.controller;

import fr.rana.baedaar.entities.User;
import fr.rana.baedaar.services.AuthenticationService;
import fr.rana.baedaar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    // Endpoint pour l'enregistrement d'un utilisateur
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            User newUser = userService.createUser(user.getUserName(), user.getPassword());
            return ResponseEntity.ok("Utilisateur enregistré avec succès : " + newUser.getUserName());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'enregistrement de l'utilisateur : " + e.getMessage());
        }
    }

    // Endpoint pour la connexion d'un utilisateur
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            User authenticatedUser = authenticationService.connection(user.getUserName(), user.getPassword());
            if (authenticatedUser != null) {
                return ResponseEntity.ok("Connexion réussie pour l'utilisateur : " + authenticatedUser.getUserName());
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Échec de la connexion. Vérifiez vos identifiants.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la connexion : " + e.getMessage());
        }
    }
}
