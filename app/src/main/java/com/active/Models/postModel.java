package com.active.Models;

import com.active.Models.CommentModel;
import com.active.Models.UserModel;
import com.active.Models.postModel;
import java.util.ArrayList;

public class postModel {
    private String text;
    private UserModel user;
    private Long CreatedAt;
    private ArrayList<String> likedby = new ArrayList<>();
    private ArrayList<CommentModel> comments = new ArrayList<>();

    public postModel() {}

    public postModel(String text, UserModel user, Long CreatedAt) {
        this.text = text;
        this.user = user;
        this.CreatedAt = CreatedAt;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserModel getUser() {
        return this.user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Long getCreatedAt() {
        return this.CreatedAt;
    }

    public void setCreatedAt(Long CreatedAt) {
        this.CreatedAt = CreatedAt;
    }

    public ArrayList<String> getLikedby() {
        return this.likedby;
    }

    public void setLikedby(ArrayList<String> likedby) {
        this.likedby = likedby;
    }

    public ArrayList<CommentModel> getComments() {
        return this.comments;
    }

    public void setComments(ArrayList<CommentModel> comments) {
        this.comments = comments;
    }
}
