package com.mlsdev.githubviewer.ui.fragment;

import com.mlsdev.githubviewer.domain.model.Project;
import com.mlsdev.githubviewer.domain.model.User;

import java.util.List;

/**
 * Created by roma on 25.05.15.
 */
public interface ProjectsView extends BaseView, LoadingView{

    void showUserInfo(User user);
    void showProjects(List<Project> projects);
}
