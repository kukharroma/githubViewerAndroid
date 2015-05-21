package com.mlsdev.githubviewer.data.entity.mapper;

import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.domain.model.Project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roma on 20.05.15.
 */
public class ProjectMapper {

    public List<Project> transform(List<ProjectEntity> projectsEntities) {
        List<Project> projects = null;

        if (projectsEntities != null) {
            projects = new ArrayList<>();
            for (ProjectEntity projectEntity : projectsEntities) {
                Project project = new Project();
                project.setName(projectEntity.getName());
                project.setLanguage(projectEntity.getLanguage());
                project.setForks(projectEntity.getForks());
                project.setStars(projectEntity.getStars());
                projects.add(project);
            }
        }
        return projects;
    }

}
