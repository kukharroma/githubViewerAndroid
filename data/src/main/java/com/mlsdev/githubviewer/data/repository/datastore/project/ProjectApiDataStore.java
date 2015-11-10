package com.mlsdev.githubviewer.data.repository.datastore.project;

import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.data.network.api.RestApi;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

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
        Call<List<ProjectEntity>> call = restApi.repositoriesGet(username);
        call.enqueue(new Callback<List<ProjectEntity>>() {
            @Override
            public void onResponse(Response<List<ProjectEntity>> response, Retrofit retrofit) {
                projectCallback.onSuccessProjects(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                projectCallback.onFailProjects(t.getMessage());
            }
        });
    }
}
