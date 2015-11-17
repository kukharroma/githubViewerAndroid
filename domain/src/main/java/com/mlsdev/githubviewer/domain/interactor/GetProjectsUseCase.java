package com.mlsdev.githubviewer.domain.interactor;

import com.mlsdev.githubviewer.domain.model.Project;

import java.util.List;

import rx.Subscriber;

/**
 * Created by roma on 21.05.15.
 */
public interface GetProjectsUseCase  {

    void execute(String username, Subscriber<List<Project>> subscriber);

    void unSubscribe();
}
