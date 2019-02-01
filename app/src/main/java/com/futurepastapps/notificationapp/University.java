package com.futurepastapps.notificationapp;

/**
 * Created by HP on 01-02-2019.
 */

public class University {

    private String eventDescription;
    private String imageUrl;

    public University() {
    }

    public University(String eventDescription, String imageUrl) {
        this.eventDescription = eventDescription;
        this.imageUrl = imageUrl;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}