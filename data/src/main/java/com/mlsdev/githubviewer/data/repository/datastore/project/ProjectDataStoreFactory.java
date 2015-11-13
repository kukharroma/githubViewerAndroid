package com.mlsdev.githubviewer.data.repository.datastore.project;

import com.mlsdev.githubviewer.data.cache.provider.user.ProjectCacheImpl;
import com.mlsdev.githubviewer.data.network.api.GitHubViewerRestApi;
import com.mlsdev.githubviewer.data.network.api.GitHubViewerRestApiImpl;
import com.mlsdev.githubviewer.domain.utils.Lg;

import javax.inject.Inject;

/**
 * Created by roma on 20.05.15.
 */
public class ProjectDataStoreFactory {

    private final ProjectCacheImpl cache;

    @Inject
    public ProjectDataStoreFactory(ProjectCacheImpl cache) {
        this.cache = cache;
    }

    public ProjectApiDataStore createApiDataStore() {
        GitHubViewerRestApi restApi = new GitHubViewerRestApiImpl();
        Lg.p("created project api data store");
        return new ProjectApiDataStore(restApi);
    }
}
