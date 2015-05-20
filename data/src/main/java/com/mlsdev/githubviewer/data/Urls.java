package com.mlsdev.githubviewer.data;

/**
 * Created by roma on 20.05.15.
 */
public class Urls {

    private static String BASE_URL = "https://api.github.com";

    public interface Prefix {

        String USERS = "/users";

    }

    public interface Action {

        interface REPOSITORIES {
            String BASE = "/repos";
        }

    }


}
