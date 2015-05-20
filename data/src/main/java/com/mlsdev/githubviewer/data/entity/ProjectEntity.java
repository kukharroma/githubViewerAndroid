package com.mlsdev.githubviewer.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by roma on 20.05.15.
 */
public class ProjectEntity {

    @SerializedName("name")
    private String name;

    @SerializedName("language")
    private String language;

    @SerializedName("forks")
    private int forks;

    @SerializedName("stargazers_count")
    private int stars;

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public int getForks() {
        return forks;
    }

    public int getStars() {
        return stars;
    }
}
