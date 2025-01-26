package fr.rana.baedaar.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "User creation request")
public class UserDto {

    @Schema(example = "user@example.com")
    private String email;

    @Schema(example = "password123", writeOnly = true)
    private String password;

    @Schema(hidden = true)
    private List<PostDto> posts;

    @Schema(hidden = true)
    private List<LikeDto> likes;

    // Constructeur par défaut
    public UserDto() {
    }

    // Constructeur avec tous les champs
    public UserDto(String email, String password, List<PostDto> posts, List<LikeDto> likes) {
        this.email = email;
        this.password = password;
        this.posts = posts;
        this.likes = likes;
    }

    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
