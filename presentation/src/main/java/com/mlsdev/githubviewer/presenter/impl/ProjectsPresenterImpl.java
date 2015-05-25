package com.mlsdev.githubviewer.presenter.impl;

import com.mlsdev.githubviewer.domain.interactor.project.GetProjectsUseCase;
import com.mlsdev.githubviewer.domain.interactor.user.GetUserUseCase;
import com.mlsdev.githubviewer.domain.model.User;
import com.mlsdev.githubviewer.presenter.ProjectsPresenter;
import com.mlsdev.githubviewer.ui.fragment.ProjectsView;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by roma on 22.05.15.
 */
@Singleton
public class ProjectsPresenterImpl implements ProjectsPresenter {

    private ProjectsView view;

    GetUserUseCase getUserUseCase;
    GetProjectsUseCase getProjectsUseCase;

    @Inject
    public ProjectsPresenterImpl(GetUserUseCase getUserUseCase, GetProjectsUseCase getProjectsUseCase) {
        this.getUserUseCase = getUserUseCase;
        this.getProjectsUseCase = getProjectsUseCase;
    }

    @Override
    public void setView(ProjectsView view) {
        this.view = view;
    }

    @Override
    public void showUser() {
        User user = getUserUseCase.execute();

    }

    @Override
    public void getProjects() {

    }

    @Override
    public void showProjects() {

    }
}
