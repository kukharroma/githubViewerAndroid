package com.mlsdev.githubviewer.data.repository.datastore.user;

import com.mlsdev.githubviewer.data.cache.provider.user.UserCacheImpl;
import com.mlsdev.githubviewer.data.network.api.RestApi;
import com.mlsdev.githubviewer.data.network.api.RestApiImpl;
import com.mlsdev.githubviewer.data.repository.datastore.repository.ProjectApiDataStore;

/**
 * Created by roma on 20.05.15.
 */
public class UserDataStoreFactory {

    private final UserCacheImpl cache;

    public UserDataStoreFactory(UserCacheImpl cache) {
        this.cache = cache;
    }

    public UserApiDataStore createApiDataStore() {
        RestApi restApi = new RestApiImpl();
        return new UserApiDataStore(restApi, this.cache);
    }


}
