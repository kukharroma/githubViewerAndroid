package com.mlsdev.githubviewer.internal.di.modules;

import com.mlsdev.githubviewer.presenter.ProjectsPresenter;
import com.mlsdev.githubviewer.presenter.SearchUserPresenter;
import com.mlsdev.githubviewer.presenter.impl.ProjectsPresenterImpl;
import com.mlsdev.githubviewer.presenter.impl.SearchUserPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by roma on 25.05.15.
 */
@Module
public class PresenterModule {

    @Provides
    SearchUserPresenter provideSearchUserPresenter(SearchUserPresenterImpl searchUserPresenter){
        return searchUserPresenter;
    }

    @Provides
    ProjectsPresenter provideProjectPresenter(ProjectsPresenterImpl projectsPresenter){
        return  projectsPresenter;
    }


}
