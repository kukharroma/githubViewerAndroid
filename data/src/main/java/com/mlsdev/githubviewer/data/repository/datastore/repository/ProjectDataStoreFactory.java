package com.mlsdev.githubviewer.data.repository.datastore.repository;

import com.mlsdev.githubviewer.data.network.api.RestApi;
import com.mlsdev.githubviewer.data.network.api.RestApiImpl;

/**
 * Created by roma on 20.05.15.
 */
public class ProjectDataStoreFactory {

    private final RestApi restApi;

    public ProjectDataStoreFactory(RestApi restApi) {
        this.restApi = restApi;
    }

    public ProjectApiDataStore createApiDataStore() {
        RestApi restApi = new RestApiImpl();
        return new ProjectApiDataStore(this.restApi);
    }
}
