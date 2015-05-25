package com.mlsdev.githubviewer.ui.activity;

import android.os.Bundle;

import com.mlsdev.github_viewer.R;
import com.mlsdev.githubviewer.ui.activity.core.BaseActivity;
import com.mlsdev.githubviewer.ui.fragment.impl.ProjectsFragment;
import com.mlsdev.githubviewer.ui.fragment.impl.SearchUserFragment;

/**
 * Created by roma on 22.05.15.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showSearchUser();
    }

    @Override
    public void showSearchUser() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fr_container, new SearchUserFragment()).commit();
    }

    @Override
    public void showProjects() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fr_container, new ProjectsFragment()).commit();
    }
}
