package com.mlsdev.githubviewer.internal.di.modules;

import com.mlsdev.githubviewer.data.cache.provider.Cache;
import com.mlsdev.githubviewer.data.cache.provider.user.UserCacheImpl;
import com.mlsdev.githubviewer.data.entity.UserEntity;
import com.mlsdev.githubviewer.data.repository.UserRepositoryImpl;
import com.mlsdev.githubviewer.domain.interactor.user.GetUserUseCase;
import com.mlsdev.githubviewer.domain.interactor.user.GetUserUseCaseImpl;
import com.mlsdev.githubviewer.domain.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by roma on 21.05.15.
 */
@Module
public class UserModule {

    @Provides
    @Singleton
    Cache<UserEntity> providesUserCache(UserCacheImpl userCache){
        return userCache;
    }

    @Provides
    @Singleton
    UserRepository providesUserRepository(UserRepositoryImpl userRepository){
        return userRepository;
    }

    @Provides
    GetUserUseCase provideUserUseCase(GetUserUseCaseImpl getUserUseCase){
        return getUserUseCase;
    }





}
