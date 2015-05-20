package com.mlsdev.githubviewer.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by roma on 20.05.15.
 */

public class UserEntity {

    @SerializedName("login")
    private String name;

    @SerializedName("avatar_url")
    private String icon;

    @SerializedName("followers")
    private int followers;

    @SerializedName("following")
    private int following;

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
}
