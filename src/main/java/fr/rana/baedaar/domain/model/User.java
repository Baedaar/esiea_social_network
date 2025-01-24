package fr.rana.baedaar.domain.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Long id;
    private String userName;
    private String password;
    private List<Post> posts;
    private List<Like> likes;
    private List<Comment> comments;

    // Constructeur avec ID
    public User(Long id,String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.posts = new ArrayList<>();
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    // Constructeur sans ID
    public User(String userName, String password, List<Post> posts, List<Like> likes, List<Comment> comments) {
        this.userName = userName;
        this.password = password;
        this.posts = posts != null ? posts : new ArrayList<>();
        this.likes = likes != null ? likes : new ArrayList<>();
        this.comments = comments != null ? comments : new ArrayList<>();
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.posts = new ArrayList<>();
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts != null ? posts : new ArrayList<>();
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes != null ? likes : new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
