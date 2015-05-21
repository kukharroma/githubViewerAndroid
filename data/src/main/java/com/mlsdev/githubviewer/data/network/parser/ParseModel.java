package com.mlsdev.githubviewer.data.network.parser;

/**
 * Created by roma on 21.05.15.
 */
public interface ParseModel<T> {
    T parse(String json);
}
