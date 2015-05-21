package com.mlsdev.githubviewer.data.network.parser;

import com.mlsdev.githubviewer.data.entity.UserEntity;
import com.mlsdev.githubviewer.domain.model.User;

/**
 * Created by roma on 20.05.15.
 */
public class UserEntityParser implements ParseModel<UserEntity>{

    @Override
    public UserEntity parse(String json) {
        return ParserUtils.parser().fromJson(json, UserEntity.class);
    }
}
