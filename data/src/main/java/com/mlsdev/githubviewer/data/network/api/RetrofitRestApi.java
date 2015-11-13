package com.mlsdev.githubviewer.data.network.api;

import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.data.entity.UserEntity;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by roma on 13.11.15.
 */
public interface RetrofitRestApi {

    @GET("users/{username}")
    Call<UserEntity> getUser(@Path("username") String username);

    @GET("users/{username}/repos")
    Call<List<ProjectEntity>> getRepositories(@Path("username") String username);
}
