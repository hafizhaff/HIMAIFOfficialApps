package com.example.personal.himaifofficialapps.model;

/**
 * Created by rahmatridham on 8/17/2016.
 */
public class AspirasiModel {
    String title,advice,date;

    public AspirasiModel(String title, String advice, String date) {
        this.title = title;
        this.advice = advice;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
