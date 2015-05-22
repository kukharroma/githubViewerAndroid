package com.mlsdev.githubviewer.internal.di.components;

import com.mlsdev.githubviewer.App;
import com.mlsdev.githubviewer.internal.di.modules.ApplicationModule;
import com.mlsdev.githubviewer.internal.di.modules.ProjectModule;
import com.mlsdev.githubviewer.internal.di.modules.UserModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by roma on 21.05.15.
 */
@Singleton
@Component(modules = {ApplicationModule.class, UserModule.class, ProjectModule.class})
public interface ApplicationComponent {
    void inject(App application);
}
