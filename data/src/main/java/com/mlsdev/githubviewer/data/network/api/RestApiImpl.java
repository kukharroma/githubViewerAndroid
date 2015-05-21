package com.mlsdev.githubviewer.data.network.api;


import com.android.volley.VolleyError;
import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.data.entity.UserEntity;
import com.mlsdev.githubviewer.data.network.ExtendedVolley;
import com.mlsdev.githubviewer.data.network.request.ProjectRequest;
import com.mlsdev.githubviewer.data.network.request.UserRequest;
import com.mlsdev.githubviewer.data.network.request.VolleyResponseListener;

import java.util.List;

/**
 * Created by roma on 20.05.15.
 */
public class RestApiImpl implements RestApi {

    @Override
    public void userGet(String username, final NetModelCallback<UserEntity> callback) {
        final VolleyResponseListener<UserEntity> requestListener = new VolleyResponseListener<UserEntity>() {
            @Override public void onResponse(UserEntity response) {
                callback.onSuccess(response);
            }

            @Override public void onErrorResponse(VolleyError error) {
                callback.onFail(error.getMessage());
            }
        };
        ExtendedVolley.getRequestQueue().add(new UserRequest(username, requestListener));
    }

    @Override
    public void repositoriesGet(String username, final NetListCallback<ProjectEntity> callback) {
        final VolleyResponseListener<List<ProjectEntity>> requestListener = new VolleyResponseListener<List<ProjectEntity>>() {
            @Override public void onErrorResponse(VolleyError error) {
                callback.onFail(error.getMessage());
            }

            @Override public void onResponse(List<ProjectEntity> response) {
                callback.onSuccess(response);
            }
        };
        ExtendedVolley.getRequestQueue().add(new ProjectRequest(username, requestListener));
    }
}
