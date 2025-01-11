package fr.rana.baedaar.application.dto;

import java.util.List;

public class PostDto {

    private Long id;
    private String userName; // Pour simplifier, on inclut le nom d'utilisateur de l'auteur
    private String content;
    private List<CommentDto> comments;
    private List<LikeDto> likes;

    // Constructeur par défaut
    public PostDto() {
    }

    // Constructeur avec tous les champs
    public PostDto(Long id, String userName, String content, List<CommentDto> comments, List<LikeDto> likes) {
        this.id = id;
        this.userName = userName;
        this.content = content;
        this.comments = comments;
        this.likes = likes;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public List<LikeDto> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeDto> likes) {
        this.likes = likes;
    }

}
