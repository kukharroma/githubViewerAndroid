package com.mlsdev.githubviewer.domain.repository;

import com.android.volley.VolleyError;
import com.mlsdev.githubviewer.domain.model.User;

/**
 * Created by roma on 20.05.15.
 */
public interface UserRepository {

    interface UserCallback{
        void onSuccessUser(User user);
        void onFailUser(String message);
    }

    void userGet(String username, UserCallback callback);

    User userGet();

    void clear();

}
