package com.mlsdev.githubviewer.ui.fragment.impl;

import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.makeramen.roundedimageview.RoundedImageView;
import com.mlsdev.github_viewer.R;
import com.mlsdev.githubviewer.domain.model.Project;
import com.mlsdev.githubviewer.domain.model.User;
import com.mlsdev.githubviewer.presenter.ProjectsPresenter;
import com.mlsdev.githubviewer.ui.adapter.ProjectAdapter;
import com.mlsdev.githubviewer.ui.fragment.ProjectsView;
import com.mlsdev.githubviewer.ui.fragment.core.BaseFragment;
import com.mlsdev.githubviewer.utils.ImageUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.pnikosis.materialishprogress.ProgressWheel;

import java.util.List;

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
    @InjectView(R.id.pb_projects) ProgressWheel pbProjects;

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
        presenter.getUser();
        presenter.getProjects();
        return view;
    }

    @Override
    public void initialize() {
        presenter.setView(this);
    }

    @Override
    public void showUserInfo(User user) {
        tvCompanyName.setText(""+user.getCompany());
        tvFollowing.setText(""+user.getFollowing());
        tvFollowers.setText(""+user.getFollowers());
        ImageLoader.getInstance().displayImage(user.getIcon(), ivUserIcon, ImageUtils.getDefaultImageLoaderOptions());
    }

    @Override
    public void showProjects(List<Project> projects) {
        ProjectAdapter adapter = new ProjectAdapter(getActivity(), projects);
        lvProjects.setAdapter(adapter);
    }

    @Override
    public void showLoading() {
        lvProjects.setVisibility(View.INVISIBLE);
        pbProjects.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbProjects.setVisibility(View.INVISIBLE);
        lvProjects.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String message) {
        super.showToastMessage(message);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }
}
