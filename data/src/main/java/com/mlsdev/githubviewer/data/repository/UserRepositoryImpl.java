package com.mlsdev.githubviewer.data.repository;

import android.content.Context;

import com.mlsdev.githubviewer.data.cache.provider.user.UserCacheImpl;
import com.mlsdev.githubviewer.data.entity.UserEntity;
import com.mlsdev.githubviewer.data.entity.mapper.UserMapper;
import com.mlsdev.githubviewer.data.repository.datastore.user.UserDataStore;
import com.mlsdev.githubviewer.data.repository.datastore.user.UserDataStoreFactory;
import com.mlsdev.githubviewer.domain.model.User;
import com.mlsdev.githubviewer.domain.repository.UserRepository;
import com.mlsdev.githubviewer.domain.utils.Lg;

import javax.inject.Inject;

/**
 * Created by roma on 20.05.15.
 */
public class UserRepositoryImpl implements UserRepository {

    private final UserDataStoreFactory userDataStoreFactory;
    private final UserMapper userMapper;
    private final UserCacheImpl userCache;

    private Context context;

    @Inject
    public UserRepositoryImpl(Context context, UserDataStoreFactory userDataStoreFactory, UserCacheImpl userCache, UserMapper userMapper) {
        this.context = context;
        this.userDataStoreFactory = userDataStoreFactory;
        this.userCache = userCache;
        this.userMapper = userMapper;
    }

    @Override
    public void userGet(String username, final UserCallback callback) {
        UserDataStore userDataStore = this.userDataStoreFactory.createApiDataStore();
        UserDataStore.UserCallback userCallback = new UserDataStore.UserCallback() {
            @Override
            public void onSuccessUser(UserEntity userEntity) {
                UserRepositoryImpl.this.userCache.put(userEntity);
                User user = UserRepositoryImpl.this.userMapper.transform(userEntity);
                callback.onSuccessUser(user);
            }

            @Override
            public void onFailUser(String message) {
                callback.onFailUser(message);
            }
        };
        userDataStore.userGet(username, userCallback);
        Lg.u("getting user from repository");
    }

    @Override
    public User userGet() {
        return userMapper.transform(userCache.get());
    }

    @Override
    public void clear() {
        userCache.clear();
    }
}
