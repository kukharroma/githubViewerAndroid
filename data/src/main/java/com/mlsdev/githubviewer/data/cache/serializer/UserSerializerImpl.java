package com.mlsdev.githubviewer.data.cache.serializer;

import com.google.gson.Gson;
import com.mlsdev.githubviewer.data.entity.UserEntity;
import com.mlsdev.githubviewer.domain.utils.Lg;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by roma on 21.05.15.
 */
@Singleton
public class UserSerializerImpl implements Serializer<UserEntity> {

    private final Gson gson = new Gson();

    @Inject
    public UserSerializerImpl() {
    }

    @Override
    public String serialize(UserEntity userEntity) {
        Lg.u("serialize user in json");
        return gson.toJson(userEntity);
    }

    @Override
    public UserEntity deserialize(String json) {
        Lg.u("deserialize user from json");
        return gson.fromJson(json, UserEntity.class);
    }
}
