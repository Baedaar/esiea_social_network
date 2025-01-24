package fr.rana.baedaar.adapter.infrastructure.entity;

import fr.rana.baedaar.domain.model.Like;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class JpaLikeEntity {

    @Id
    private Long id;
    @ManyToOne
    private JpaUserEntity user;

    @ManyToOne
    private JpaCommentEntity comment;

    @ManyToOne
    private JpaPostEntity post;

    // Constructeur pour un like sur un post (sans ID)


    public JpaLikeEntity(JpaUserEntity user, JpaPostEntity post) {
        this.user = user;
        this.post = post;
    }

    // Constructeur pour un like sur un commentaire (sans ID)
    public JpaLikeEntity(JpaUserEntity user, JpaCommentEntity comment) {
        this.user = user;
        this.comment = comment;
    }

    // Constructeur pour un like sur un post (avec ID)
    public JpaLikeEntity(Long id, JpaUserEntity user, JpaPostEntity post) {
        this.id = id;
        this.user = user;
        this.post = post;
    }

    // Constructeur pour un like sur un commentaire (avec ID)
    public JpaLikeEntity(Long id, JpaUserEntity user, JpaCommentEntity comment) {
        this.id = id;
        this.user = user;
        this.comment = comment;
    }

    public JpaLikeEntity() {

    }

    // Getters et setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JpaUserEntity getUser() {
        return user;
    }

    public void setUser(JpaUserEntity user) {
        this.user = user;
    }

    public JpaCommentEntity getComment() {
        return comment;
    }

    public void setComment(JpaCommentEntity comment) {
        this.comment = comment;
    }

    public JpaPostEntity getPost() {
        return post;
    }

    public void setPost(JpaPostEntity post) {
        this.post = post;
    }

    public Like toCommentLike() {
        return new Like(
                this.user.toUser(),
                this.comment.toComment()
        );
    }
    public Like toPostLike() {
        return new Like(
                this.user.toUser(),
                this.post.toPost()
        );
    }
}
