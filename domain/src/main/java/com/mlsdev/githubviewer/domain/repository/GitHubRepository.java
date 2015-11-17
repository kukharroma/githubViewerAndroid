package com.mlsdev.githubviewer.domain.repository;



import com.mlsdev.githubviewer.domain.model.Project;
import com.mlsdev.githubviewer.domain.model.User;

import java.util.List;

import rx.Observable;

/**
 * Created by roma on 17.11.15.
 */
public interface GitHubRepository {

    Observable<User> getUserFromCache();

    Observable<User> getUser(String userName);

    Observable<List<Project>> getProjects(String userName);
}
