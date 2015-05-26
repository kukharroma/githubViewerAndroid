package com.mlsdev.githubviewer.data.cache.provider.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.mlsdev.githubviewer.data.cache.provider.Cache;
import com.mlsdev.githubviewer.data.cache.serializer.ProjectSerializerImpl;
import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.domain.utils.Lg;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by roma on 21.05.15.
 */
public class ProjectCacheImpl implements Cache<List<ProjectEntity>> {

    private static final String PROJECTS_CACHE_PREFS_KEY = "com.mlsdev.githubviewer.data.cache.provider.user.ProjectCacheImpl";
    private static final String PROJECTS_PREFS_KEY = "projects";

    private final Context context;
    private final SharedPreferences preferences;
    private final ProjectSerializerImpl serializer;

    @Inject
    public ProjectCacheImpl(Context context, ProjectSerializerImpl serializer) {
        this.context = context;
        this.serializer = serializer;
        this.preferences = context.getSharedPreferences(PROJECTS_CACHE_PREFS_KEY, Context.MODE_PRIVATE);
    }

    @Override
    public List<ProjectEntity> get() {
        if (isCached()){
            Lg.p("getting projects from cache");
            return serializer.deserialize(preferences.getString(PROJECTS_PREFS_KEY, null));
        }
        return null;
    }

    @Override
    public void put(List<ProjectEntity> projectEntities) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PROJECTS_PREFS_KEY, serializer.serialize(projectEntities));
        editor.apply();
        Lg.p("saved projects in cache");
    }

    @Override
    public void clear() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(PROJECTS_PREFS_KEY);
        editor.apply();
        Lg.p("deleted projects from cache");
    }

    @Override
    public boolean isCached() {
        return preferences.getString(PROJECTS_PREFS_KEY, null) !=null ;
    }
}
