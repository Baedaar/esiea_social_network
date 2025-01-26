package fr.rana.baedaar.application.dto;


import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Comment creation request")
public class CommentDto {
    @Schema(example = "user@example.com")
    private String email;

    @Schema(example = "Oui il fait beau tu as raison")
    private String content;

    @Schema(hidden = true)
    private Long postId;

    @Schema(hidden = true)
    private List<LikeDto> likes;

    // Constructeur par défaut
    public CommentDto() {
    }

    // Constructeur avec tous les champs
    public CommentDto(String email, String content, Long postId, List<LikeDto> likes) {
        this.email = email;
        this.content = content;
        this.postId = postId;
        this.likes = likes;
    }

    // Getters et setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public List<LikeDto> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeDto> likes) {
        this.likes = likes;
    }
}
