package com.mlsdev.githubviewer.data.entity.mapper;

import com.mlsdev.githubviewer.data.entity.UserEntity;
import com.mlsdev.githubviewer.domain.model.User;

/**
 * Created by roma on 20.05.15.
 */
public class UserMapper {

    public User transform(UserEntity userEntity) {
        User user = null;
        if (userEntity != null) {
            user = new User();
            user.setName(userEntity.getName());
            user.setIcon(userEntity.getIcon());
            user.setFollowers(userEntity.getFollowers());
            user.setFollowing(userEntity.getFollowing());
        }
        return user;
    }
}
