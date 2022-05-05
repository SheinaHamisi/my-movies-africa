package com.example.mymovieapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Objects;

public class NotificationModal {

    private String title;
    private String text;
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NotificationModal(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public  NotificationModal(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotificationModal)) return false;
        NotificationModal notification = (NotificationModal) o;
        return getTitle().equals(notification.getTitle()) && getText().equals(notification.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getText());
    }

    @Override
    public String toString() {
        return "Model{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }


}
