package com.mlsdev.githubviewer.internal.di.components;

import com.mlsdev.githubviewer.App;
import com.mlsdev.githubviewer.internal.di.modules.ApplicationModule;
import com.mlsdev.githubviewer.internal.di.modules.GitHubModule;
import com.mlsdev.githubviewer.internal.di.modules.PresenterModule;
import com.mlsdev.githubviewer.internal.di.modules.ProjectModule;
import com.mlsdev.githubviewer.internal.di.modules.UserModule;
import com.mlsdev.githubviewer.ui.fragment.impl.ProjectsFragment;
import com.mlsdev.githubviewer.ui.fragment.impl.SearchUserFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by roma on 21.05.15.
 */
@Singleton
@Component(modules = {ApplicationModule.class, UserModule.class, ProjectModule.class, PresenterModule.class, GitHubModule.class})
public interface ApplicationComponent {
    void inject(App application);
    void inject(SearchUserFragment fragment);
    void inject(ProjectsFragment fragment);
}
