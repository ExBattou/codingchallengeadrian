package net.adriann.coding_challenge_adrian.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostFromReddit {

    @SerializedName("author_fullname")
    @Expose
    String author;
    @SerializedName("title")
    @Expose
    String title;
    @SerializedName("created")
    @Expose
    Double dateCreated;
    @SerializedName("num_comments")
    @Expose
    int commentsQuantity;
    @SerializedName("thumbnail")
    @Expose
    String thumbnailUrl;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Double dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getCommentsQuantity() {
        return commentsQuantity;
    }

    public void setCommentsQuantity(int commentsQuantity) {
        this.commentsQuantity = commentsQuantity;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
