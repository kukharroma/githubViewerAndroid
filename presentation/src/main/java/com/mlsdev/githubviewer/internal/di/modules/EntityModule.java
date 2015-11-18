package com.mlsdev.githubviewer.internal.di.modules;

import com.mlsdev.githubviewer.data.cache.provider.Cache;
import com.mlsdev.githubviewer.data.cache.provider.user.ProjectCacheImpl;
import com.mlsdev.githubviewer.data.cache.provider.user.UserCacheImpl;
import com.mlsdev.githubviewer.data.entity.ModelEntityMapper;
import com.mlsdev.githubviewer.data.entity.ModelEntityMapperImpl;
import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.data.entity.UserEntity;
import com.mlsdev.githubviewer.domain.interactor.GetProjectsUseCase;
import com.mlsdev.githubviewer.domain.interactor.GetUserUseCase;
import com.mlsdev.githubviewer.domain.interactor.impl.GetProjectsUseCaseImpl;
import com.mlsdev.githubviewer.domain.interactor.impl.GetUserUseCaseImpl;

import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by roma on 21.05.15.
 */
@Module
public class EntityModule {

    @Provides
    Cache<UserEntity> providesUserCache(UserCacheImpl userCache){
        return userCache;
    }

    @Provides
    Cache<List<ProjectEntity>> providesProjectCache(ProjectCacheImpl projectCache){
        return projectCache;
    }

    @Provides
    GetUserUseCase provideUserUseCase(GetUserUseCaseImpl getUserUseCase){
        return getUserUseCase;
    }

    @Provides
    GetProjectsUseCase provideGetProjectsUseCase(GetProjectsUseCaseImpl getProjectsUseCase){
        return getProjectsUseCase;
    }

    @Provides
    ModelEntityMapper provideModelEntityMapper(ModelEntityMapperImpl mapper){
        return mapper;
    }

}
