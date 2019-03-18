package com.lesnyg.recyclerexam4.models;

public class CardItem {
    int image;
    String title;
    String contents;
    float ratingscore;

    public CardItem(int image, String title, float ratingscore) {
        this.image = image;
        this.title = title;
        this.ratingscore = ratingscore;
    }

    public CardItem(int image, String title, String contents) {
        this.image = image;
        this.title = title;
        this.contents = contents;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public float getRatingscore() {
        return ratingscore;
    }

    public void setRatingscore(float ratingscore) {
        this.ratingscore = ratingscore;
    }
}
