package com.mlsdev.githubviewer.data.repository.datastore.user;

import com.android.volley.VolleyError;
import com.mlsdev.githubviewer.data.cache.provider.user.UserCacheImpl;
import com.mlsdev.githubviewer.data.entity.UserEntity;
import com.mlsdev.githubviewer.data.network.api.RestApi;

/**
 * Created by roma on 20.05.15.
 */
public class UserApiDataStore implements UserDataStore {

    private final RestApi restApi;
    private final UserCacheImpl cache;

    public UserApiDataStore(RestApi restApi, UserCacheImpl cache) {
        this.restApi = restApi;
        this.cache = cache;
    }

    @Override
    public void userGet(String username, final UserCallback userCallback) {
        RestApi.NetModelCallback<UserEntity> callback = new RestApi.NetModelCallback<UserEntity>() {
            @Override
            public void onSuccess(UserEntity response) {
                if (response != null) cache.put(response);
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
