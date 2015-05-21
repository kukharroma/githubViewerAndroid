package com.mlsdev.githubviewer.data.cache.serializer;

import com.google.gson.Gson;
import com.mlsdev.githubviewer.data.entity.UserEntity;

/**
 * Created by roma on 21.05.15.
 */
public class UserSerializerImpl implements Serializer<UserEntity> {

    private final Gson gson = new Gson();

    @Override
    public String serialize(UserEntity userEntity) {
        return gson.toJson(userEntity);
    }

    @Override
    public UserEntity deserialize(String json) {
        return gson.fromJson(json, UserEntity.class);
    }
}
