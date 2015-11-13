package com.mlsdev.githubviewer.data.network.api;

import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.data.entity.UserEntity;

import java.util.List;

/**
 * Created by roma on 20.05.15.
 */
public interface GitHubViewerRestApi {

    interface NetFailCallback {
        void onFail(String volleyError);
    }

    interface NetModelCallback<T> extends NetFailCallback {
        void onSuccess(T response);
    }

    interface NetListCallback<T> extends NetFailCallback {
        void onSuccess(List<T> response);
    }

    void userGet(String username, final NetModelCallback<UserEntity> callback);

    void repositoriesGet(String username, final NetListCallback<ProjectEntity> callback);

}
