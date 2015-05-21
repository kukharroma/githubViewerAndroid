package com.mlsdev.githubviewer.domain.interactor.project;

import com.android.volley.VolleyError;
import com.mlsdev.githubviewer.domain.interactor.Cancelable;
import com.mlsdev.githubviewer.domain.interactor.Interactor;
import com.mlsdev.githubviewer.domain.model.Project;

import java.util.List;

/**
 * Created by roma on 21.05.15.
 */
public interface GetProjectsUseCase extends Interactor, Cancelable{

    interface Callback{
        void onSuccess(List<Project> projects);
        void onFail(VolleyError error);
    }

    void execute(String username, Callback callback);
}
