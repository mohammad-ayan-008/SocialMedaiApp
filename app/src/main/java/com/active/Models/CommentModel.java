package com.active.Models;
import com.active.Models.CommentModel;

public class CommentModel {
    private String Comment, U_pic;

    
    public CommentModel(){
        
    }
    
    public CommentModel(String Comment, String U_pic) {
        this.Comment = Comment;
        this.U_pic = U_pic;
    }

    public String getComment() {
        return this.Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public String getU_pic() {
        return this.U_pic;
    }

    public void setU_pic(String U_pic) {
        this.U_pic = U_pic;
    }
}
