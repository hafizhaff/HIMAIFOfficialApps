package com.example.personal.himaifofficialapps.model;

/**
 * Created by rahmatridham on 8/17/2016.
 */
public class TimelineModel {
    String date, eventTitle, desc, division;

    public TimelineModel(String date, String eventTitle, String desc, String division) {
        this.date = date;
        this.eventTitle = eventTitle;
        this.desc = desc;
        this.division = division;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public String toString() {
        return eventTitle + "    " + division ;
    }
}
