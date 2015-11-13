package com.mlsdev.githubviewer.data.repository.datastore.project;

import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.data.network.api.GitHubViewerRestApi;

import java.util.List;

/**
 * Created by roma on 20.05.15.
 */
public class ProjectApiDataStore implements ProjectDataStore {

    private final GitHubViewerRestApi restApi;

    public ProjectApiDataStore(GitHubViewerRestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public void repositoriesGet(String username, final ProjectsCallback projectCallback) {
        GitHubViewerRestApi.NetListCallback<ProjectEntity> callback = new GitHubViewerRestApi.NetListCallback<ProjectEntity>() {
            @Override
            public void onSuccess(List<ProjectEntity> response) {
                projectCallback.onSuccessProjects(response);
            }

            @Override
            public void onFail(String error) {
                projectCallback.onFailProjects(error);
            }
        };
        this.restApi.repositoriesGet(username, callback);
    }
}
