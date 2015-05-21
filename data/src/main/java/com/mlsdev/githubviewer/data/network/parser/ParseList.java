package com.mlsdev.githubviewer.data.network.parser;

import java.util.List;

/**
 * Created by roma on 21.05.15.
 */
public interface ParseList <T> {
    List<T> parseList(String json);
}
