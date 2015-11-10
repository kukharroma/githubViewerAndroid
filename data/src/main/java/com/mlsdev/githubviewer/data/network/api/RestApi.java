package com.mlsdev.githubviewer.data.network.api;

import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.data.entity.UserEntity;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by roma on 20.05.15.
 */
public interface RestApi {

    @GET("/users/{username}")
    Call<UserEntity> userGet(@Path("username") String username);

    @GET("users/{username}/repos")
    Call<List<ProjectEntity>> repositoriesGet(@Path("username") String username);

}
