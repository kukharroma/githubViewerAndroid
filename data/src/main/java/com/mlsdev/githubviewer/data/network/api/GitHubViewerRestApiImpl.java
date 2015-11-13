package com.mlsdev.githubviewer.data.network.api;


import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.data.entity.UserEntity;
import com.mlsdev.githubviewer.data.network.Urls;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by roma on 20.05.15.
 */
public class GitHubViewerRestApiImpl implements GitHubViewerRestApi {

    private RetrofitRestApi retrofitRestApi;

    public GitHubViewerRestApiImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.apiBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitRestApi = retrofit.create(RetrofitRestApi.class);
    }

    @Override
    public void userGet(String username, final GitHubViewerRestApi.NetModelCallback<UserEntity> callback) {
        Call<UserEntity> userCall = retrofitRestApi.getUser(username);
        userCall.enqueue(new Callback<UserEntity>() {
            @Override
            public void onResponse(Response<UserEntity> response, Retrofit retrofit) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onFail(t.getMessage());
            }
        });

    }

    @Override
    public void repositoriesGet(String username, final GitHubViewerRestApi.NetListCallback<ProjectEntity> callback) {
        Call<List<ProjectEntity>> projectsCall = retrofitRestApi.getRepositories(username);
        projectsCall.enqueue(new Callback<List<ProjectEntity>>() {
            @Override
            public void onResponse(Response<List<ProjectEntity>> response, Retrofit retrofit) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onFail(t.getMessage());
            }
        });
    }
}
