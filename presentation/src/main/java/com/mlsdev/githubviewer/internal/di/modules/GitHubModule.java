package com.mlsdev.githubviewer.internal.di.modules;

import com.mlsdev.githubviewer.data.network.api.GitHubViewerRestApi;
import com.mlsdev.githubviewer.data.repository.datastore.GitHubRepositoryImpl;
import com.mlsdev.githubviewer.domain.repository.GitHubRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by roma on 17.11.15.
 */
@Module
public class GitHubModule {

    @Provides
    @Singleton
    GitHubRepository providesGitHubRepository(GitHubRepositoryImpl gitHubRepository) {
        return gitHubRepository;
    }

    @Provides
    @Singleton
    GitHubViewerRestApi providesGitHubViewerRestApi(GitHubViewerRestApi gitHubViewerRestApi) {
        return gitHubViewerRestApi;
    }

}
