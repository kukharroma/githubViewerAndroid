package com.mlsdev.githubviewer.data.network.parser;

import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.domain.model.Project;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by roma on 20.05.15.
 */
public class ProjectEntityParser implements ParseModel<ProjectEntity>, ParseList<ProjectEntity>{

    @Override
    public ProjectEntity parse(String json) {

        return ParserUtils.parser().fromJson(json, ProjectEntity.class);
    }

    @Override
    public List<ProjectEntity> parseList(String json) {

        Type listType = new TypeToken<List<ProjectEntity>>() {}.getType();
        return ParserUtils.parser().fromJson(json, listType);
    }
}
