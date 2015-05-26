package com.mlsdev.githubviewer.data.entity.mapper;

import com.mlsdev.githubviewer.data.entity.UserEntity;
import com.mlsdev.githubviewer.domain.model.User;
import com.mlsdev.githubviewer.domain.utils.Lg;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by roma on 20.05.15.
 */
@Singleton
public class UserMapper {

    @Inject
    public UserMapper() {
    }

    public User transform(UserEntity userEntity) {
        User user = null;
        if (userEntity != null) {
            user = new User();
            user.setName(userEntity.getName());
            user.setIcon(userEntity.getIcon());
            user.setFollowers(userEntity.getFollowers());
            user.setFollowing(userEntity.getFollowing());
            user.setCompany(userEntity.getCompany());
        }
        Lg.u("transforming user");
        return user;
    }
}
