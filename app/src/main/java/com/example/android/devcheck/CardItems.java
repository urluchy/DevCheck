package com.example.android.devcheck;

public class CardItems {

    private String imageUrl;
    private String devUrl;
    private String userName;


    public String getUserName() {
        return userName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDevUrl() {
        return devUrl;
    }

    public CardItems(String login, String html_url, String avatar_url) {
        this.userName = login;
        this.imageUrl = avatar_url;
        this.devUrl = html_url;
    }
}
