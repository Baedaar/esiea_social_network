package fr.rana.baedaar.entities;

import java.util.List;

public class Post {

    private Long id;
    private User user;
    private String content;
    private List<Comment> comments;
    private List<Like> likes;

    public Post(User user, String content, List<Comment> comments, List<Like> likes) {
        this.user = user;
        this.content = content;
        this.comments = comments;
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public Long getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
