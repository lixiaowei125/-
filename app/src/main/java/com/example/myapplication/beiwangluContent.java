package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class beiwangluContent {
    private String content;
    private String date;

    beiwangluContent() {
    }

    beiwangluContent(String content, String date) {
        this.content = content;
        this.date = date;
    }

    public void set(String content, String date) {
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
