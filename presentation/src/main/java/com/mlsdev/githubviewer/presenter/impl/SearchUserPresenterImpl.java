package com.mlsdev.githubviewer.presenter.impl;

import com.mlsdev.githubviewer.domain.interactor.user.GetUserUseCase;
import com.mlsdev.githubviewer.domain.model.User;
import com.mlsdev.githubviewer.presenter.SearchUserPresenter;
import com.mlsdev.githubviewer.ui.fragment.SearchUserView;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by roma on 22.05.15.
 */
@Singleton
public class SearchUserPresenterImpl implements SearchUserPresenter {

    SearchUserView view;
    GetUserUseCase getUserUseCase;

    @Inject
    public SearchUserPresenterImpl(GetUserUseCase getUserUseCase) {
        this.getUserUseCase = getUserUseCase;
    }

    @Override
    public void setView(SearchUserView view) {
        this.view = view;
    }

    @Override
    public void searchUser(String username) {
        if (!username.isEmpty()) {
            view.showLoading();
            getUserUseCase.execute(username, new GetUserUseCase.Callback() {
                @Override
                public void onSuccessUser(User user) {
                    view.hideLoading();
                    view.showProjects();
                }

                @Override
                public void onFailUser(String message) {
                    view.showError(message);
                    view.hideLoading();
                }
            });
        }
    }

    @Override
    public void onPause() {
        getUserUseCase.cancel();
    }

    @Override
    public void onResume() {

    }
}
