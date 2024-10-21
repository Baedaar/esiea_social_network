package fr.rana.baedaar;

import fr.rana.baedaar.database.DatabaseConnection;
import fr.rana.baedaar.services.implementation.UserServiceImplementation;
import fr.rana.baedaar.services.implementation.AuthenticationServiceImplementation;
import fr.rana.baedaar.entities.User;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                System.out.println("Connexion réussie !");

                // Initialisation des services
                UserServiceImplementation userService = new UserServiceImplementation();
                AuthenticationServiceImplementation authenticationService = new AuthenticationServiceImplementation();

                // Étape 1 : Création de l'utilisateur
                String username = "Babidi";
                String password = "123";
                System.out.println("Création de l'utilisateur...");
                User newUser = userService.createUser(username, password);
                System.out.println("Utilisateur créé en base de données : " + newUser.getUserName());

                // Étape 2 : Connexion de l'utilisateur créé
                System.out.println("Tentative de connexion de l'utilisateur...");
                User connectedUser = authenticationService.connection(username, password);
                if (connectedUser != null) {
                    System.out.println("Connexion réussie pour l'utilisateur : " + connectedUser.getUserName());
                } else {
                    System.out.println("Échec de la connexion.");
                }

                // Étape 3 : Mise à jour du mot de passe de l'utilisateur
                System.out.println("Mise à jour du mot de passe...");
                String newPassword = "newPassword123";
                userService.updateUser(username, newPassword);
                System.out.println("Mot de passe mis à jour en base de données avec succès.");

                // Étape 4 : Connexion avec le nouveau mot de passe
                System.out.println("Tentative de connexion avec le nouveau mot de passe...");
                connectedUser = authenticationService.connection(username, newPassword);
                if (connectedUser != null) {
                    System.out.println("Connexion réussie avec le nouveau mot de passe pour l'utilisateur : " + connectedUser.getUserName());
                } else {
                    System.out.println("Échec de la connexion avec le nouveau mot de passe.");
                }

                // Étape 5 : Suppression de l'utilisateur
                System.out.println("Suppression de l'utilisateur en base de données...");
               // userService.deleteUser(username, newPassword);
                System.out.println("Utilisateur supprimé avec succès.");

                // Étape 6 : Tentative de connexion après suppression
                System.out.println("Tentative de connexion après suppression...");
                connectedUser = authenticationService.connection(username, newPassword);
                if (connectedUser == null) {
                    System.out.println("Connexion impossible, l'utilisateur a bien été supprimé de la base de données.");
                } else {
                    System.out.println("Erreur : l'utilisateur existe encore après suppression.");
                }

            } else {
                System.out.println("Échec de la connexion.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
