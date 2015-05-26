package com.mlsdev.githubviewer.presenter.impl;

import com.mlsdev.githubviewer.domain.interactor.project.GetProjectsUseCase;
import com.mlsdev.githubviewer.domain.interactor.user.GetUserUseCase;
import com.mlsdev.githubviewer.domain.model.Project;
import com.mlsdev.githubviewer.presenter.ProjectsPresenter;
import com.mlsdev.githubviewer.ui.fragment.ProjectsView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by roma on 22.05.15.
 */
@Singleton
public class ProjectsPresenterImpl implements ProjectsPresenter {

    ProjectsView view;
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
    public void getUser() {
        view.showUserInfo(getUserUseCase.execute());
    }

    @Override
    public void getProjects() {
        view.showLoading();
        getProjectsUseCase.execute(getUserUseCase.execute().getName(), new GetProjectsUseCase.Callback() {
            @Override
            public void onSuccess(List<Project> projects) {
                view.hideLoading();
                view.showProjects(projects);
            }

            @Override
            public void onFail(String message) {
                view.hideLoading();
                view.showError(message);
            }
        });
    }

    @Override
    public void onPause() {
        getUserUseCase.cancel();
        getProjectsUseCase.cancel();
    }

    @Override
    public void onResume() {

    }
}
