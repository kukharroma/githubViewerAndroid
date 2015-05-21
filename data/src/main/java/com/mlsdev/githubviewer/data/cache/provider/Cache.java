package com.mlsdev.githubviewer.data.cache.provider;

/**
 * Created by roma on 21.05.15.
 */
public interface Cache<T> {

    T get();
    void put(T t);
    void clear();
    boolean isCached();
}
