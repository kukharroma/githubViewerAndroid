package com.mlsdev.githubviewer.data.repository.datastore.user;

import com.mlsdev.githubviewer.data.entity.UserEntity;

/**
 * Created by roma on 20.05.15.
 */
public interface UserDataStore {

    interface UserCallback {
        void onSuccessUser(UserEntity user);

        void onFailUser(String message);
    }

    void userGet(String username, UserCallback userCallback);

}
