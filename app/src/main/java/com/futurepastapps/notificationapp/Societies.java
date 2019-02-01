package com.futurepastapps.notificationapp;

/**
 * Created by HP on 31-01-2019.
 */

public class Societies {

    private String societyName;
    private String eventName;
    private String date;
    private String imageUrl;

    public Societies() {

    }

    public Societies(String societyName, String eventName, String date, String imageUrl) {
        this.societyName = societyName;
        this.eventName = eventName;
        this.date = date;
        this.imageUrl = imageUrl;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
