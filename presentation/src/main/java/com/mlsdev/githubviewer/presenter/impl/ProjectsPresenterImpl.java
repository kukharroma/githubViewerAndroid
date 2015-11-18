package com.mlsdev.githubviewer.presenter.impl;

import com.mlsdev.githubviewer.domain.interactor.BaseSubscriber;
import com.mlsdev.githubviewer.domain.interactor.GetProjectsUseCase;
import com.mlsdev.githubviewer.domain.interactor.GetUserUseCase;
import com.mlsdev.githubviewer.domain.model.Project;
import com.mlsdev.githubviewer.domain.model.User;
import com.mlsdev.githubviewer.presenter.ProjectsPresenter;
import com.mlsdev.githubviewer.ui.fragment.ProjectsView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dalvik.system.BaseDexClassLoader;

/**
 * Created by roma on 22.05.15.
 */
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
    public void getUserAndProject() {
        view.showLoading();
        getUserUseCase.execute(new UserInfoSubscriber());
    }

    @Override
    public void onStop() {
        getProjectsUseCase.unSubscribe();
    }

    private class ProjectsSubscriber extends BaseSubscriber<List<Project>>{
        @Override
        public void onNext(List<Project> projects) {
            view.showProjects(projects);
        }

        @Override
        public void onCompleted() {
            view.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            view.showError(e.getMessage());
        }
    }

    private class UserInfoSubscriber extends BaseSubscriber<User> {
        @Override
        public void onNext(User user) {
            view.showUserInfo(user);
            getProjectsUseCase.execute(user.getName(), new ProjectsSubscriber());
        }

        @Override
        public void onError(Throwable e) {
            view.showError(e.getMessage());
        }
    }

}
