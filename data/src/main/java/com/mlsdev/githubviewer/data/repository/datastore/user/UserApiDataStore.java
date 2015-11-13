package com.mlsdev.githubviewer.data.repository.datastore.user;

import com.mlsdev.githubviewer.data.cache.provider.user.UserCacheImpl;
import com.mlsdev.githubviewer.data.entity.UserEntity;
import com.mlsdev.githubviewer.data.network.api.GitHubViewerRestApi;

/**
 * Created by roma on 20.05.15.
 */
public class UserApiDataStore implements UserDataStore {

    private final GitHubViewerRestApi restApi;
    private final UserCacheImpl cache;

    public UserApiDataStore(GitHubViewerRestApi restApi, UserCacheImpl cache) {
        this.restApi = restApi;
        this.cache = cache;
    }

    @Override
    public void userGet(String username, final UserCallback userCallback) {
        GitHubViewerRestApi.NetModelCallback<UserEntity> callback = new GitHubViewerRestApi.NetModelCallback<UserEntity>() {
            @Override
            public void onSuccess(UserEntity response) {
                userCallback.onSuccessUser(response);
            }

            @Override
            public void onFail(String error) {
                userCallback.onFailUser(error);
            }
        };
        this.restApi.userGet(username, callback);
    }
}
