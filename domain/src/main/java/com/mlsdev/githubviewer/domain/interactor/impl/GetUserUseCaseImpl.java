package com.mlsdev.githubviewer.domain.interactor.impl;

import com.mlsdev.githubviewer.domain.interactor.GetUserUseCase;
import com.mlsdev.githubviewer.domain.model.User;
import com.mlsdev.githubviewer.domain.repository.GitHubRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.observers.Subscribers;
import rx.schedulers.Schedulers;

/**
 * Created by roma on 21.05.15.
 */
@Singleton
public class GetUserUseCaseImpl implements GetUserUseCase {

    GitHubRepository repository;
    Subscription subscription = Subscribers.empty();

    @Inject
    public GetUserUseCaseImpl(GitHubRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(String username, Subscriber<User> subscriber) {
        subscription = repository.getUser(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void execute(Subscriber<User> subscriber) {
        subscription = repository.getUserFromCache()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void unSubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

}
