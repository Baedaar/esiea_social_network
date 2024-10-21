package fr.rana.baedaar.entities;

public class Like {

    private User user;
    private Comment comment;
    private Post post;

    public Like(User user, Comment comment) {
        this.user = user;
        this.comment = comment;
    }

    public Like(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public Like(User user, Comment comment, Post post) {
        this.user = user;
        this.comment = comment;
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
