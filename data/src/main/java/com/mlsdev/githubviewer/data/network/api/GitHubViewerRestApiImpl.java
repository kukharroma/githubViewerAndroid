package com.mlsdev.githubviewer.data.network.api;


import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.data.entity.UserEntity;
import com.mlsdev.githubviewer.data.network.Urls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;

/**
 * Created by roma on 20.05.15.
 */
public class GitHubViewerRestApiImpl implements GitHubViewerRestApi {

    private RetrofitRestApi retrofitRestApi;

    @Inject
    public GitHubViewerRestApiImpl() {
        retrofitRestApi = new Retrofit.Builder()
                .baseUrl(Urls.apiBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(RetrofitRestApi.class);
    }

    @Override
    public Observable<UserEntity> userGet(String username) {
        return retrofitRestApi.getUser(username);
    }

    @Override
    public Observable<List<ProjectEntity>> repositoriesGet(String username) {
        return retrofitRestApi.getRepositories(username);
    }
}
