package com.mlsdev.githubviewer.domain.interactor.impl;

import com.mlsdev.githubviewer.domain.interactor.GetProjectsUseCase;
import com.mlsdev.githubviewer.domain.model.Project;
import com.mlsdev.githubviewer.domain.repository.GitHubRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by roma on 21.05.15.
 */
@Singleton
public class GetProjectsUseCaseImpl implements GetProjectsUseCase {

    private GitHubRepository repository;
    private Subscription subscription;

    @Inject
    public GetProjectsUseCaseImpl(GitHubRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(String username, Subscriber<List<Project>> subscriber) {
        subscription = repository.getProjects(username)
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
