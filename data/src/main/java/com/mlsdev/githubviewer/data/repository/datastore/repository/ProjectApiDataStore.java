package com.mlsdev.githubviewer.data.repository.datastore.repository;

import com.android.volley.VolleyError;
import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.data.network.api.RestApi;

import java.util.List;

/**
 * Created by roma on 20.05.15.
 */
public class ProjectApiDataStore implements ProjectDataStore {

    private final RestApi restApi;

    public ProjectApiDataStore(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public void repositoriesGet(String username, final ProjectsCallback projectCallback) {
        RestApi.NetListCallback<ProjectEntity> callback = new RestApi.NetListCallback<ProjectEntity>() {
            @Override
            public void onSuccess(List<ProjectEntity> response) {
                projectCallback.onSuccessProjects(response);
            }

            @Override
            public void onFail(VolleyError error) {
                projectCallback.onFailProjects(error);
            }
        };
        this.restApi.repositoriesGet(username, callback);
    }
}
