package com.mlsdev.githubviewer.presenter.impl;

import com.mlsdev.githubviewer.presenter.SearchUserPresenter;
import com.mlsdev.githubviewer.ui.fragment.SearchUserView;

/**
 * Created by roma on 22.05.15.
 */
public class SearchUserPresenterImpl implements SearchUserPresenter {

    private SearchUserView view;

    @Override
    public void setView(SearchUserView view) {
        this.view = view;
    }
}
