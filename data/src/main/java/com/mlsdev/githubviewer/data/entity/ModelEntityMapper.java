package com.mlsdev.githubviewer.data.entity;

import com.mlsdev.githubviewer.domain.model.Project;
import com.mlsdev.githubviewer.domain.model.User;

import java.util.List;

/**
 * Created by roma on 18.11.15.
 */
public interface ModelEntityMapper {

    User transform(UserEntity userEntity);
    List<Project> transform(List<ProjectEntity> projectsEntities);
}
