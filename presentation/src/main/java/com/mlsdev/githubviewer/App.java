package com.mlsdev.githubviewer;

import android.app.Application;
import android.os.Handler;

import com.mlsdev.githubviewer.internal.di.components.ApplicationComponent;
import com.mlsdev.githubviewer.internal.di.components.DaggerApplicationComponent;
import com.mlsdev.githubviewer.internal.di.modules.ApplicationModule;


/**
 * Created by roma on 21.05.15.
 */
public class App extends Application {

    private ApplicationComponent applicationComponent;
    private Handler handler = new Handler();

    @Override
    public void onCreate() {
        initDagger();
        super.onCreate();
    }

    private void initDagger(){
        this.applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        this.applicationComponent.inject(this);
    }

    public Handler getHandler() {
        return handler;
    }
}
