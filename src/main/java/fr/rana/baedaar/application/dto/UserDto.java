package fr.rana.baedaar.application.dto;

import java.util.List;

public class UserDto {
    private Long id;
    private String userName;
    private String password;
    private List<PostDto> posts;
    private List<LikeDto> likes;

    // Constructeur par défaut
    public UserDto() {
    }

    // Constructeur avec tous les champs
    public UserDto(Long id, String userName, String password, List<PostDto> posts, List<LikeDto> likes) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.posts = posts;
        this.likes = likes;
    }

    public UserDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
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

    public List<PostDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDto> posts) {
        this.posts = posts;
    }

    public List<LikeDto> getLikes() {
        return likes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLikes(List<LikeDto> likes) {
        this.likes = likes;
    }
}
