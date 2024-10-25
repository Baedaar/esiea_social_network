package fr.rana.baedaar.controller.dto;

import fr.rana.baedaar.entities.User;

public class CreatePostRequest {
    private User user;
    private String content;

    public CreatePostRequest() {}

    public CreatePostRequest(User user, String content) {
        this.user = user;
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
