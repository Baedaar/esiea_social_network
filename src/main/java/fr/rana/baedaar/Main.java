package fr.rana.baedaar;

import fr.rana.baedaar.dao.implementation.CommentDaoImplementation;
import fr.rana.baedaar.dao.implementation.LikeDaoImplementation;
import fr.rana.baedaar.dao.implementation.PostDaoImplementation;
import fr.rana.baedaar.dao.implementation.UserDaoImplementation;
import fr.rana.baedaar.database.DatabaseConnection;
import fr.rana.baedaar.entities.Comment;
import fr.rana.baedaar.entities.Like;
import fr.rana.baedaar.entities.Post;
import fr.rana.baedaar.entities.User;
import fr.rana.baedaar.services.implementation.*;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                System.out.println("Connexion réussie !");

                // Initialisation du DAO
                UserDaoImplementation userDao = new UserDaoImplementation();
                PostDaoImplementation postDao = new PostDaoImplementation();
                CommentDaoImplementation commentDao = new CommentDaoImplementation();
                LikeDaoImplementation likeDao = new LikeDaoImplementation();

                // Initialisation des services avec DAO injecté
                UserServiceImplementation userService = new UserServiceImplementation(userDao);
                AuthenticationServiceImplementation authenticationService = new AuthenticationServiceImplementation(userDao);
                PostServiceImplementation postService = new PostServiceImplementation(postDao);
                CommentServiceImplementation commentService = new CommentServiceImplementation(commentDao);
                LikeServiceImplementation likeService = new LikeServiceImplementation(likeDao);

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

                    // Étape 3 : Création d'un post
                    System.out.println("Création d'un post...");
                    String postContent = "Voici mon premier post !";
                    Post createdPost = postService.createPost(connectedUser, postContent);
                    System.out.println("Post créé avec succès, ID du post : " + createdPost.getId());

                    // Étape 4 : Création d'un commentaire
                    System.out.println("Ajout d'un commentaire au post...");
                    String commentContent = "Super post, bien joué !";
                    Comment createdComment = commentService.createComment(connectedUser, createdPost, commentContent);
                    System.out.println("Commentaire créé avec succès, ID du commentaire : " + createdComment.getId());

                    // Étape 5 : Ajout d'un like au commentaire
                    System.out.println("Ajout d'un like au commentaire...");
                    Like createdLike = likeService.addLike(createdComment, connectedUser);
                    System.out.println("Like ajouté avec succès sur le commentaire.");

                    // Étape 6 : Ajout d'un like au post
                    System.out.println("Ajout d'un like au post...");
                    Like postLike = likeService.addLike(createdPost, connectedUser);
                    System.out.println("Like ajouté avec succès sur le post.");

                } else {
                    System.out.println("Échec de la connexion.");
                }

            } else {
                System.out.println("Échec de la connexion.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
