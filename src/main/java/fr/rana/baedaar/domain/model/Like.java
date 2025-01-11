package fr.rana.baedaar.domain.model;


public class Like {

    private Long id;
    private User user;
    private Comment comment;
    private Post post;

    public Like() {
    }

    // Constructeur pour un like sur un post (sans ID)
    public Like(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    // Constructeur pour un like sur un commentaire (sans ID)
    public Like(User user, Comment comment) {
        this.user = user;
        this.comment = comment;
    }

    // Constructeur pour un like sur un post (avec ID)
    public Like(Long id, User user, Post post) {
        this.id = id;
        this.user = user;
        this.post = post;
    }

    // Constructeur pour un like sur un commentaire (avec ID)
    public Like(Long id, User user, Comment comment) {
        this.id = id;
        this.user = user;
        this.comment = comment;
    }

    // Getters et setters
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
