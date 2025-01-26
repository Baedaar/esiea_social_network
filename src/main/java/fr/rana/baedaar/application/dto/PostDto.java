package fr.rana.baedaar.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Post creation request")
public class PostDto {

    @Schema(example = "user@example.com")
    private String userName;

    @Schema(example = "Il fait beau aujourd'hui")
    private String content;

    @Schema(hidden = true)
    private List<CommentDto> comments;

    @Schema(hidden = true)
    private List<LikeDto> likes;

    // Constructeur par défaut
    public PostDto() {
    }

    // Constructeur avec tous les champs
    public PostDto(String userName, String content, List<CommentDto> comments, List<LikeDto> likes) {
        this.userName = userName;
        this.content = content;
        this.comments = comments;
        this.likes = likes;
    }

    // Getters et setters

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
