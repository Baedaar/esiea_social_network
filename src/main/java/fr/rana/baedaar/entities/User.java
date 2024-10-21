package fr.rana.baedaar.entities;

import java.util.List;

public class User {

    private String userName;
    private String password;
    private List<Post> posts;
    private List<Like> likes;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public User(String userName, String password, List<Post> posts, List<Like> likes) {
        this.userName = userName;
        this.password = password;
        this.posts = posts;
        this.likes = likes;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
