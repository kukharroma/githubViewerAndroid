package com.mlsdev.githubviewer.domain.model;

/**
 * Created by roma on 20.05.15.
 */
public class User {

    private String name;
    private String icon;
    private int followers;
    private int following;
    private String company;

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
