package com.mlsdev.githubviewer.domain.interactor;

import com.mlsdev.githubviewer.domain.model.User;

import rx.Subscriber;

/**
 * Created by roma on 21.05.15.
 */
public interface GetUserUseCase {

    void execute(String username, Subscriber<User> subscriber);

    void execute(Subscriber<User> subscriber);

    void unSubscribe();

}
