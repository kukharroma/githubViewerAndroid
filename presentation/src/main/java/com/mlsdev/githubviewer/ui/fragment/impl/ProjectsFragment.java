package com.mlsdev.githubviewer.ui.fragment.impl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.mlsdev.github_viewer.R;
import com.mlsdev.githubviewer.presenter.ProjectsPresenter;
import com.mlsdev.githubviewer.ui.fragment.ProjectsView;
import com.mlsdev.githubviewer.ui.fragment.core.BaseFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by roma on 22.05.15.
 */
public class ProjectsFragment extends BaseFragment implements ProjectsView {

    @Inject
    ProjectsPresenter presenter;

    @InjectView(R.id.tv_followers) TextView tvFollowers;
    @InjectView(R.id.tv_following) TextView tvFollowing;
    @InjectView(R.id.tv_user_company_name) TextView tvCompanyName;
    @InjectView(R.id.iv_user_icon) RoundedImageView ivUserIcon;
    @InjectView(R.id.iv_open_in_browser) ImageView ivBrowsing;
    @InjectView(R.id.iv_share) ImageView ivSharing;
    @InjectView(R.id.listView) ListView lvProjects;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplication().inject(this);
        initialize();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getApplication(), R.layout.fragment_detail_info_user, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initialize() {
        presenter.setView(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String message) {

    }
}
