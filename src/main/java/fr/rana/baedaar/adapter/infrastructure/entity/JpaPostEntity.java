package fr.rana.baedaar.adapter.infrastructure.entity;


import fr.rana.baedaar.domain.model.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class JpaPostEntity {

    @Id
    private Long id;

    @ManyToOne
    private JpaUserEntity user;

    private String content;

    @OneToMany
    private List<JpaCommentEntity> comments;

    @OneToMany
    private List<JpaLikeEntity> likes;

    public JpaPostEntity(JpaUserEntity user, String content, List<JpaCommentEntity> comments, List<JpaLikeEntity> likes) {
        this.user = user;
        this.content = content;
        this.comments = comments;
        this.likes = likes;
    }

    public JpaPostEntity(JpaUserEntity user, String content) {
        this.user = user;
        this.content = content;
        this.comments = new ArrayList<>();
        this.likes = new ArrayList<>();
    }

    public JpaPostEntity() {
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<JpaCommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<JpaCommentEntity> comments) {
        this.comments = comments;
    }

    public List<JpaLikeEntity> getLikes() {
        return likes;
    }

    public void setLikes(List<JpaLikeEntity> likes) {
        this.likes = likes;
    }

    public Post toPost() {
        return new Post(
                this.user.toUser(),
                this.content,
                this.comments != null
                        ? this.comments.stream()
                        .map(JpaCommentEntity::toComment)
                        .toList() : new ArrayList<>(),
                this.likes != null
                ? this.likes.stream()
                        .map(JpaLikeEntity::toPostLike)
                        .toList() : new ArrayList<>()
        );
    }
}
