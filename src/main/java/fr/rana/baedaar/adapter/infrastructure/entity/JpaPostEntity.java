package fr.rana.baedaar.adapter.infrastructure.entity;


import fr.rana.baedaar.domain.model.Comment;
import fr.rana.baedaar.domain.model.Post;
import fr.rana.baedaar.domain.model.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class JpaPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private JpaUserEntity user;

    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JpaCommentEntity> comments;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
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
                new User(this.user.getId(), this.user.getUserName(), this.user.getPassword(), null, null, null),
                this.content,
                this.comments != null
                        ? this.comments.stream()
                        .map(comment -> new Comment(
                                comment.getUser() != null
                                        ? new User(comment.getUser().getId(), comment.getUser().getUserName(), null, null, null, null)
                                        : null,
                                null,
                                null,
                                comment.getContent()
                        ))
                        .toList()
                        : new ArrayList<>(),
                this.likes != null
                        ? this.likes.stream()
                        .map(JpaLikeEntity::toPostLike)
                        .toList()
                        : new ArrayList<>()
        );
    }
}
