package com.mlsdev.githubviewer.domain.interactor;

import rx.Subscriber;

/**
 * Created by roma on 17.11.15.
 */
public class BaseSubscriber<T> extends Subscriber<T> {


    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }
}
