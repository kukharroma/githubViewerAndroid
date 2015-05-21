package com.mlsdev.githubviewer.data.cache.serializer;

/**
 * Created by roma on 21.05.15.
 */
public interface Serializer<T> {

    String serialize(T t);

    T deserialize(String json);
}
