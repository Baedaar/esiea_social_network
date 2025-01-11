package fr.rana.baedaar.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Comment {

    private Long id;
    private User user;
    private List<Like> likes;
    private Post post;
    private String content;

    public Comment() {
    }

    // Constructeur principal avec toutes les données
    public Comment(Long id, User user, String content, Post post, List<Like> likes) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.post = post;
        this.likes = likes != null ? likes : new ArrayList<>();
    }

    // Constructeur simplifié sans likes
    public Comment(Long id, User user, String content, Post post) {
        this(id, user, content, post, null);
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
