package fr.rana.baedaar.adapter.infrastructure.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class JpaCommentEntity {

    @Id
    private Long id;

    @ManyToOne
    private JpaUserEntity user;

    @OneToMany
    private List<JpaLikeEntity> likes;

    @ManyToOne
    private JpaPostEntity post;

    private String content;

    // Constructeur principal avec toutes les données
    public JpaCommentEntity(Long id, JpaUserEntity user, List<JpaLikeEntity> likes, JpaPostEntity post, String content) {
        this.id = id;
        this.user = user;
        this.likes = likes;
        this.post = post;
        this.content = content;
    }

    public JpaCommentEntity() {}

    // Getters et Setters
    public JpaUserEntity getUser() {
        return user;
    }

    public void setUser(JpaUserEntity user) {
        this.user = user;
    }

    public List<JpaLikeEntity> getLikes() {
        return likes;
    }

    public void setLikes(List<JpaLikeEntity> likes) {
        this.likes = likes;
    }

    public JpaPostEntity getPost() {
        return post;
    }

    public void setPost(JpaPostEntity post) {
        this.post = post;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
