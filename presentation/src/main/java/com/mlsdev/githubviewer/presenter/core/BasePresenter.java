package com.mlsdev.githubviewer.presenter.core;

/**
 * Created by roma on 25.05.15.
 */
public interface BasePresenter<T> {

    void setView(T t);

    void onStop();

}
