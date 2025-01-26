package fr.rana.baedaar.application.dto;

public class LikeDto {

    private String userName;
    private Long postId;
    private Long commentId;

    // Constructeur par défaut
    public LikeDto() {
    }

    // Constructeur avec tous les champs
    public LikeDto(String userName, Long postId, Long commentId) {
        this.userName = userName;
        this.postId = postId;
        this.commentId = commentId;
    }

    // Getters et setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

}
