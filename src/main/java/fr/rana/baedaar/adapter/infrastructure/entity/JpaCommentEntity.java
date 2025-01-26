package fr.rana.baedaar.adapter.infrastructure.entity;


import fr.rana.baedaar.domain.model.Comment;
import fr.rana.baedaar.domain.model.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "comments")
public class JpaCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private JpaUserEntity user;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JpaLikeEntity> likes;

    @ManyToOne
    @JoinColumn(name = "post_id")
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

    public Comment toComment() {
        return new Comment(
                this.user != null
                        ? new User(this.user.getId(), this.user.getUserName(), null, null, null, null)
                        : null,
                this.likes != null
                        ? this.likes.stream()
                        .map(JpaLikeEntity::toCommentLike)
                        .collect(Collectors.toList())
                        : new ArrayList<>(),
                null,
                this.content
        );
    }

}
