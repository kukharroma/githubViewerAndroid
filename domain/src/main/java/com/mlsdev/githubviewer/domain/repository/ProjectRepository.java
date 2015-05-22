package com.mlsdev.githubviewer.domain.repository;

import com.mlsdev.githubviewer.domain.model.Project;

import java.util.List;

/**
 * Created by roma on 20.05.15.
 */
public interface ProjectRepository {

    interface ProjectCallback {
        void onSuccessProjects(List<Project> response);

        void onFailProjects(String message);
    }

    void repositoriesGet(String username, ProjectCallback callback);

    List<Project> repositoriesGet();

    void clear();
}
