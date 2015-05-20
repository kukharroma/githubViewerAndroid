package com.mlsdev.githubviewer.data.entity.mapper;

import com.mlsdev.githubviewer.data.entity.RepositoryEntity;
import com.mlsdev.githubviewer.domain.model.Repository;

/**
 * Created by roma on 20.05.15.
 */
public class RepositoryMapper {

    public Repository transform(RepositoryEntity repositoryEntity) {
        Repository repository = null;
        if (repositoryEntity != null) {
            repository = new Repository();
            repository.setName(repositoryEntity.getName());
            repository.setLanguage(repositoryEntity.getLanguage());
            repository.setForks(repositoryEntity.getForks());
            repository.setStars(repositoryEntity.getStars());
        }
        return repository;
    }
}
