package com.futurepastapps.notificationapp;

/**
 * Created by HP on 01-02-2019.
 */

public class Students {

    private String studentName;
    private String activityDescription;
    private String activityLink;
    private String imageUrl;

    public Students() {
    }

    public Students(String studentName, String activityDescription, String activityLink, String imageUrl) {
        this.studentName = studentName;
        this.activityDescription = activityDescription;
        this.activityLink = activityLink;
        this.imageUrl = imageUrl;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public String getActivityLink() {
        return activityLink;
    }

    public void setActivityLink(String activityLink) {
        this.activityLink = activityLink;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
