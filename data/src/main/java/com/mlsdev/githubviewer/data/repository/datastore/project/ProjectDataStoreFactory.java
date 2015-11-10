package com.mlsdev.githubviewer.data.repository.datastore.project;

import com.mlsdev.githubviewer.data.network.Urls;
import com.mlsdev.githubviewer.data.network.api.RestApi;

import javax.inject.Inject;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by roma on 20.05.15.
 */
public class ProjectDataStoreFactory {

    @Inject
    public ProjectDataStoreFactory() {

    }

    public ProjectApiDataStore createApiDataStore() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Urls.apiBaseUrl()).addConverterFactory(GsonConverterFactory.create()).build();
        RestApi service = retrofit.create(RestApi.class);
        return new ProjectApiDataStore(service);
    }
}
