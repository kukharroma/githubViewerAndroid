package com.mlsdev.githubviewer.data.network;

/**
 * Created by roma on 20.05.15.
 */
public class Urls {

    private static String BASE_URL = "https://api.github.com";
    private static String SLASH = "/";

    public interface Prefix {
        String USERS = "/users";
    }

    public interface Action {

        interface REPOSITORIES {
            String BASE = "/repos";
        }

    }

    public static String apiBaseUrl() {
        return BASE_URL;
    }

    public static String userGet(String username) {
        return apiBaseUrl() + Prefix.USERS + SLASH + username;
    }

    public static String repositoreiesGet(String username) {
        return apiBaseUrl() + Prefix.USERS + SLASH + username + Action.REPOSITORIES.BASE  ;
    }

}
