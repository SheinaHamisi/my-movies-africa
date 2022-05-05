//package com.example.mymovieapp;
//
//import java.util.Objects;
//
//public class NotificationModel {
//    private String title;
//    private String text;
//
//    public NotificationModel() {
//    }
//    public NotificationModel(String title, String text) {
//        this.title = title;
//        this.text = text;
//    }
//
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof NotificationModel)) return false;
//        NotificationModel notification = (NotificationModel) o;
//        return getTitle().equals(notification.getTitle()) && getText().equals(notification.getText());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getTitle(), getText());
//    }
//
//    @Override
//    public String toString() {
//        return "Model{" +
//                "title='" + title + '\'' +
//                ", text='" + text + '\'' +
//                '}';
//    }
//}
