package com.example.personal.himaifofficialapps.model;

/**
 * Created by rahmatridham on 8/17/2016.
 */
public class NewsModel {

    String urlPhoto,title,desc,sourceNews,writer;

    public NewsModel(String urlPhoto, String title, String desc, String sourceNews, String writer) {
        this.urlPhoto = urlPhoto;
        this.title = title;
        this.desc = desc;
        this.sourceNews = sourceNews;
        this.writer = writer;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSourceNews() {
        return sourceNews;
    }

    public void setSourceNews(String sourceNews) {
        this.sourceNews = sourceNews;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
