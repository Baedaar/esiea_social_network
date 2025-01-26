package fr.rana.baedaar.adapter.infrastructure.entity;

import fr.rana.baedaar.domain.model.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class JpaUserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JpaPostEntity> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JpaLikeEntity> likes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JpaCommentEntity> comments;

    // Constructeur avec ID
    public JpaUserEntity(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.posts = new ArrayList<>();
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    // Constructeur sans ID
    public JpaUserEntity(String userName, String password, List<JpaPostEntity> posts, List<JpaLikeEntity> likes, List<JpaCommentEntity> comments) {
        this.userName = userName;
        this.password = password;
        this.posts = posts;
        this.likes = likes;
        this.comments = comments;
    }

    public JpaUserEntity(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.posts = new ArrayList<>();
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public JpaUserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<JpaPostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<JpaPostEntity> posts) {
        this.posts = posts;
    }

    public List<JpaLikeEntity> getLikes() {
        return likes;
    }

    public void setLikes(List<JpaLikeEntity> likes) {
        this.likes = likes;
    }

    public List<JpaCommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<JpaCommentEntity> comments) {
        this.comments = comments;
    }

    public User toUser() {
        return new User(
                this.id,
                this.userName,
                this.password,
                null,
                null,
                null
        );
    }

    public User toUserWithDetails() {
        return new User(
                this.id,
                this.userName,
                this.password,
                this.posts != null
                        ? this.posts.stream()
                        .map(JpaPostEntity::toPost)
                        .toList()
                        : new ArrayList<>(),
                this.likes != null
                        ? this.likes.stream()
                        .map(JpaLikeEntity::toPostLike)
                        .toList()
                        : new ArrayList<>(),
                this.comments != null
                        ? this.comments.stream()
                        .map(JpaCommentEntity::toComment)
                        .toList()
                        : new ArrayList<>()
        );
    }
}
