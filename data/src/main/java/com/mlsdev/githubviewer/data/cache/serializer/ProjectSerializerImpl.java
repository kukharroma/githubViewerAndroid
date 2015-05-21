package com.mlsdev.githubviewer.data.cache.serializer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mlsdev.githubviewer.data.entity.ProjectEntity;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by roma on 21.05.15.
 */
public class ProjectSerializerImpl implements Serializer<List<ProjectEntity>> {

    private final Gson gson = new Gson();

    @Override
    public String serialize(List<ProjectEntity> projectEntities) {
        return gson.toJson(projectEntities);
    }

    @Override
    public List<ProjectEntity> deserialize(String json) {
        Type listType = new TypeToken<List<ProjectEntity>>() {}.getType();
        return gson.fromJson(json, listType);
    }
}
