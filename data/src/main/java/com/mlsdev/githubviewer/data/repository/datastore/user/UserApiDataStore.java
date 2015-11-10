package com.mlsdev.githubviewer.data.repository.datastore.user;

import com.mlsdev.githubviewer.data.entity.UserEntity;
import com.mlsdev.githubviewer.data.network.api.RestApi;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by roma on 20.05.15.
 */
public class UserApiDataStore implements UserDataStore {

    private final RestApi restApi;

    public UserApiDataStore(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public void userGet(String username, final UserCallback userCallback) {
        Call<UserEntity> call = restApi.userGet(username);
        call.enqueue(new Callback<UserEntity>() {
            @Override
            public void onResponse(Response<UserEntity> response, Retrofit retrofit) {
                userCallback.onSuccessUser(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                userCallback.onFailUser(t.getMessage());
            }
        });
    }
}
