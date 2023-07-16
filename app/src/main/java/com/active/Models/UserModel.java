package com.active.Models;

public class UserModel {
    private String Uid;
    private String DisplayName;
    private String ImageUrl;

    
    public UserModel(){
        
    }
    
    public UserModel(String Uid, String DisplayName, String ImageUrl) {
        this.Uid = Uid;
        this.DisplayName = DisplayName;
        this.ImageUrl = ImageUrl;
    }

    public String getUid() {
        return this.Uid;
    }

    public void setUid(String Uid) {
        this.Uid = Uid;
    }

    public String getDisplayName() {
        return this.DisplayName;
    }

    public void setDisplayName(String DisplayName) {
        this.DisplayName = DisplayName;
    }

    public String getImageUrl() {
        return this.ImageUrl;
    }

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }
}
