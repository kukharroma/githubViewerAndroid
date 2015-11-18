package com.mlsdev.githubviewer.data.repository.datastore;


import com.mlsdev.githubviewer.data.cache.provider.user.ProjectCacheImpl;
import com.mlsdev.githubviewer.data.cache.provider.user.UserCacheImpl;
import com.mlsdev.githubviewer.data.entity.ModelEntityMapperImpl;
import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.data.entity.UserEntity;
import com.mlsdev.githubviewer.data.network.api.GitHubViewerRestApi;
import com.mlsdev.githubviewer.domain.model.Project;
import com.mlsdev.githubviewer.domain.model.User;
import com.mlsdev.githubviewer.domain.repository.GitHubRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by roma on 17.11.15.
 */

public class GitHubRepositoryImpl implements GitHubRepository {

    private GitHubViewerRestApi restApi;
    private ModelEntityMapperImpl mapper;
    private UserCacheImpl userCache;
    private ProjectCacheImpl projectCache;

    @Inject
    public GitHubRepositoryImpl(GitHubViewerRestApi restApi, ModelEntityMapperImpl mapper, UserCacheImpl userCache, ProjectCacheImpl projectCache) {
        this.restApi = restApi;
        this.mapper = mapper;
        this.userCache = userCache;
        this.projectCache = projectCache;
    }

    @Override
    public Observable<User> getUserFromCache() {
        return Observable.create(
                new Observable.OnSubscribe<User>() {
                    @Override
                    public void call(Subscriber<? super User> subscriber) {
                        User user = mapper.transform(userCache.get());
                        subscriber.onNext(user);
                    }
                }
        );
    }

    @Override
    public Observable<User> getUser(String userName) {
        return restApi.userGet(userName).map(new Func1<UserEntity, User>() {
            @Override
            public User call(UserEntity userEntity) {
                userCache.put(userEntity);
                return mapper.transform(userEntity);
            }
        });
    }

    @Override
    public Observable<List<Project>> getProjects(String userName) {
        return restApi.repositoriesGet(userName).map(new Func1<List<ProjectEntity>, List<Project>>() {
            @Override
            public List<Project> call(List<ProjectEntity> projectEntities) {
                projectCache.put(projectEntities);
                return mapper.transform(projectEntities);
            }
        });
    }
}
