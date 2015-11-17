package com.mlsdev.githubviewer.data.network.api;

import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.data.entity.UserEntity;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by roma on 13.11.15.
 */
public interface RetrofitRestApi {

    @GET("users/{username}")
    Observable<UserEntity> getUser(@Path("username") String username);

    @GET("users/{username}/repos")
    Observable<List<ProjectEntity>> getRepositories(@Path("username") String username);
}
