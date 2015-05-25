package com.mlsdev.githubviewer.presenter.impl;

import com.mlsdev.githubviewer.presenter.ProjectsPresenter;
import com.mlsdev.githubviewer.ui.fragment.ProjectsView;

/**
 * Created by roma on 22.05.15.
 */
public class ProjectsPresenterImpl implements ProjectsPresenter {

    private ProjectsView view;

    @Override
    public void setView(ProjectsView view) {
        this.view = view;
    }
}
