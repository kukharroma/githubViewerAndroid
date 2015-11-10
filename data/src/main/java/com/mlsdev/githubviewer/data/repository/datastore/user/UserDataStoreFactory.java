package com.mlsdev.githubviewer.data.repository.datastore.user;

import com.mlsdev.githubviewer.data.cache.provider.user.UserCacheImpl;
import com.mlsdev.githubviewer.data.network.Urls;
import com.mlsdev.githubviewer.data.network.api.RestApi;

import javax.inject.Inject;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by roma on 20.05.15.
 */
public class UserDataStoreFactory {

    private final UserCacheImpl cache;

    @Inject
    public UserDataStoreFactory(UserCacheImpl cache) {
        this.cache = cache;
    }

    public UserApiDataStore createApiDataStore() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Urls.apiBaseUrl()).addConverterFactory(GsonConverterFactory.create()).build();
        RestApi restApi = retrofit.create(RestApi.class);
        return new UserApiDataStore(restApi);
    }

}
