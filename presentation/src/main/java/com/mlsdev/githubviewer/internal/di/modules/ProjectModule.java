package com.mlsdev.githubviewer.internal.di.modules;

import com.mlsdev.githubviewer.data.cache.provider.Cache;
import com.mlsdev.githubviewer.data.cache.provider.user.ProjectCacheImpl;
import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.domain.interactor.GetProjectsUseCase;
import com.mlsdev.githubviewer.domain.interactor.impl.GetProjectsUseCaseImpl;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by roma on 21.05.15.
 */
@Module
public class ProjectModule {

    @Provides
    @Singleton
    Cache<List<ProjectEntity>> providesProjectCache(ProjectCacheImpl projectCache){
        return projectCache;
    }

    @Provides
    @Singleton
    GetProjectsUseCase provideGetProjectsUseCase(GetProjectsUseCaseImpl getProjectsUseCase){
        return getProjectsUseCase;
    }

    
}
