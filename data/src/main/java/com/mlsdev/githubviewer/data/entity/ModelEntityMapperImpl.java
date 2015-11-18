package com.mlsdev.githubviewer.data.entity;

import com.mlsdev.githubviewer.domain.model.Project;
import com.mlsdev.githubviewer.domain.model.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by roma on 17.11.15.
 */
public class ModelEntityMapperImpl implements ModelEntityMapper{

    @Inject
    public ModelEntityMapperImpl() {
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
        return user;
    }

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
