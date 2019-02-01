package com.futurepastapps.notificationapp;

/**
 * Created by HP on 30-01-2019.
 */

public class Placements {

    private String companyName;
    private String branches;
    private String date;
    private String imageUrl;

    public Placements() {

    }

    public Placements(String companyName, String branches, String date, String imageUrl) {
        this.companyName = companyName;
        this.branches = branches;
        this.date = date;
        this.imageUrl = imageUrl;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBranches() {
        return branches;
    }

    public void setBranches(String branches) {
        this.branches = branches;
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
