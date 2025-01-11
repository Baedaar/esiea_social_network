package fr.rana.baedaar.application.dto;


import java.util.List;

public class CommentDto {
    private Long id;
    private String userName;
    private String content;
    private Long postId;
    private List<LikeDto> likes;

    // Constructeur par défaut
    public CommentDto() {
    }

    // Constructeur avec tous les champs
    public CommentDto(Long id, String userName, String content, Long postId, List<LikeDto> likes) {
        this.id = id;
        this.userName = userName;
        this.content = content;
        this.postId = postId;
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
