package com.mlsdev.githubviewer.data.entity.mapper;

import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.domain.model.Project;

/**
 * Created by roma on 20.05.15.
 */
public class ProjectMapper {

    public Project transform(ProjectEntity projectEntity) {
        Project project = null;
        if (projectEntity != null) {
            project = new Project();
            project.setName(projectEntity.getName());
            project.setLanguage(projectEntity.getLanguage());
            project.setForks(projectEntity.getForks());
            project.setStars(projectEntity.getStars());
        }
        return project;
    }
}
