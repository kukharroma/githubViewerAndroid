package com.mlsdev.githubviewer.presenter.impl;

import com.mlsdev.githubviewer.domain.interactor.BaseSubscriber;
import com.mlsdev.githubviewer.domain.interactor.GetUserUseCase;
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
            getUserUseCase.execute(username, new GetUserNameSubscriber());
        }
    }

    @Override
    public void onStop() {
        getUserUseCase.unSubscribe();
    }

    public class GetUserNameSubscriber extends BaseSubscriber<User> {
        @Override
        public void onNext(User user) {
            view.showProjects();
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


}
