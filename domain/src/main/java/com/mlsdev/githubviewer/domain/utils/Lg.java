package com.mlsdev.githubviewer.domain.utils;

import android.util.Log;

/**
 * Created by roma on 26.05.15.
 */
public class Lg {

    static final String BASE_TAG = "com.mlsdev.githubviewer_Log ";

    interface PERMISSIONS {
        boolean IS_NETWORK = true;
        boolean IS_NETWORK_ERROR = true;
        boolean IS_USER = true;
        boolean IS_USER_ERROR = true;
        boolean IS_PROJECT = true;
        boolean IS_PROJECT_ERROR = true;
    }

    interface TAGS {
        /* n  */ String NETWORK_INFO = "NetworkCall";
        /* ne */ String NETWORK_ERROR = "Network error";
        /* u  */ String USER_INFO = "User";
        /* ue */ String USER_ERROR = "User error";
        /* p  */ String PROJECT_INFO = "Project";
        /* pe */ String PROJECT_ERROR = "Project error";
    }

    private static String buildTag(String tag) {
        return BASE_TAG + tag;
    }

    public static void n(String msg) {
        n(null, msg);
    }

    public static void n(String tag, String message) {
        if (tag == null) tag = buildTag(TAGS.NETWORK_INFO);
        if (PERMISSIONS.IS_NETWORK) Log.i(tag, message);
    }

    public static void ne(String msg) {
        if (PERMISSIONS.IS_NETWORK_ERROR) Log.e(buildTag(TAGS.NETWORK_ERROR), msg);
    }

    public static void u(String msg) {
        u(null, msg);
    }

    public static void u(String tag, String msg) {
        if (tag == null) tag = buildTag(TAGS.USER_INFO);
        if (PERMISSIONS.IS_USER) Log.i(tag, msg);
    }

    public static void ue(String msg) {
        if (PERMISSIONS.IS_USER_ERROR) Log.e(buildTag(TAGS.USER_ERROR), msg);
    }

    public static void p(String msg) {
        p(null, msg);
    }

    public static void p(String tag, String msg) {
        if (tag == null) tag = buildTag(TAGS.PROJECT_INFO);
        if (PERMISSIONS.IS_PROJECT) Log.i(tag, msg);
    }

    public static void pe(String msg) {
        if (PERMISSIONS.IS_PROJECT_ERROR) Log.e(buildTag(TAGS.PROJECT_ERROR), msg);
    }

}
