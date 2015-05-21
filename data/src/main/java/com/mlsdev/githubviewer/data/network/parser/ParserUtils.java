package com.mlsdev.githubviewer.data.network.parser;

import com.google.gson.Gson;

/**
 * Created by roma on 21.05.15.
 */
public class ParserUtils {

    private static Gson gson;

    static synchronized Gson parser(){
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }
}
