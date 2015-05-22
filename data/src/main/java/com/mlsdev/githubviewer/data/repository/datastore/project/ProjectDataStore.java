package com.mlsdev.githubviewer.data.repository.datastore.project;

import com.mlsdev.githubviewer.data.entity.ProjectEntity;

import java.util.List;

/**
 * Created by roma on 20.05.15.
 */
public interface ProjectDataStore {

    interface ProjectsCallback{
        void onSuccessProjects(List<ProjectEntity> projects);
        void onFailProjects(String message);
    }

    void repositoriesGet(String username, ProjectsCallback callback);
}
