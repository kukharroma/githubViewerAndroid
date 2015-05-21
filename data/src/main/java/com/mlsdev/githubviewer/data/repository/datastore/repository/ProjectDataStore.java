package com.mlsdev.githubviewer.data.repository.datastore.repository;

import com.android.volley.VolleyError;
import com.mlsdev.githubviewer.data.entity.ProjectEntity;

import java.util.List;

/**
 * Created by roma on 20.05.15.
 */
public interface ProjectDataStore {

    interface ProjectsCallback{
        void onSuccessProjects(List<ProjectEntity> projects);
        void onFailProjects(VolleyError error);
    }

    void repositoriesGet(String username, ProjectsCallback callback);
}
