package com.mlsdev.githubviewer.domain.model;

/**
 * Created by roma on 20.05.15.
 */
public class Repository {

    private String name;
    private String language;
    private int forks;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
