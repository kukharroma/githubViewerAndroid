package com.mlsdev.githubviewer.data.cache.provider.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.mlsdev.githubviewer.data.cache.provider.Cache;
import com.mlsdev.githubviewer.data.cache.serializer.UserSerializerImpl;
import com.mlsdev.githubviewer.data.entity.UserEntity;
import com.mlsdev.githubviewer.domain.utils.Lg;

import javax.inject.Inject;

/**
 * Created by roma on 21.05.15.
 */
public class UserCacheImpl implements Cache<UserEntity> {

    private static final String USER_CACHE_PREFS_KEY = "com.mlsdev.githubviewer.data.cache.provider.user.UserCacheImpl";
    private static final String USER_PREFS_KEY = "user";

    private final Context context;
    private final SharedPreferences preferences;
    private final UserSerializerImpl serializer;

    @Inject
    public UserCacheImpl(Context context, UserSerializerImpl serializer) {
        this.context = context;
        this.serializer = serializer;
        this.preferences = context.getSharedPreferences(USER_CACHE_PREFS_KEY, Context.MODE_PRIVATE);
    }

    @Override
    public UserEntity get() {
        if (isCached()){
            Lg.u("getting user from cache");
            return serializer.deserialize(preferences.getString(USER_PREFS_KEY, null));
        }
        return null;
    }

    @Override
    public void put(UserEntity userEntity) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USER_PREFS_KEY, serializer.serialize(userEntity));
        editor.apply();
        Lg.u("saved user in cache");
    }

    @Override
    public void clear() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(USER_PREFS_KEY);
        editor.apply();
        Lg.u("deleted user from cache");
    }

    @Override
    public boolean isCached() {
        return preferences.getString(USER_PREFS_KEY, null) != null;
    }
}
