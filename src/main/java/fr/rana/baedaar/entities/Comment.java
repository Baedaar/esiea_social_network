package fr.rana.baedaar.entities;

import java.util.List;

public class Comment {

    private User user;
    private List<Like> likes;
    private Post post;

    public Comment(User user, List<Like> likes, Post post) {
        this.user = user;
        this.likes = likes;
        this.post = post;
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
}
