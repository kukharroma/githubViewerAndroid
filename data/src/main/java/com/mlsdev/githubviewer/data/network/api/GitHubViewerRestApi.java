package com.mlsdev.githubviewer.data.network.api;


import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.data.entity.UserEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by roma on 20.05.15.
 */
public interface GitHubViewerRestApi {

    Observable<UserEntity> userGet(String username);

    Observable<List<ProjectEntity>> repositoriesGet(String username);

}
