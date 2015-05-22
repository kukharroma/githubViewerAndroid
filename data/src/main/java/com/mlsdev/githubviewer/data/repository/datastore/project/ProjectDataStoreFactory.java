package com.mlsdev.githubviewer.data.repository.datastore.project;

import com.mlsdev.githubviewer.data.cache.provider.user.ProjectCacheImpl;
import com.mlsdev.githubviewer.data.network.api.RestApi;
import com.mlsdev.githubviewer.data.network.api.RestApiImpl;

/**
 * Created by roma on 20.05.15.
 */
public class ProjectDataStoreFactory {

    private final ProjectCacheImpl cache;

    public ProjectDataStoreFactory(ProjectCacheImpl cache) {
        this.cache = cache;
    }

    public ProjectApiDataStore createApiDataStore() {
        RestApi restApi = new RestApiImpl();
        return new ProjectApiDataStore(restApi);
    }
}
