package com.mlsdev.githubviewer.ui.fragment.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mlsdev.github_viewer.R;
import com.mlsdev.githubviewer.presenter.SearchUserPresenter;
import com.mlsdev.githubviewer.ui.activity.MainActivity;
import com.mlsdev.githubviewer.ui.fragment.SearchUserView;
import com.mlsdev.githubviewer.ui.fragment.core.BaseFragment;
import com.pnikosis.materialishprogress.ProgressWheel;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by roma on 22.05.15.
 */
public class SearchUserFragment extends BaseFragment implements SearchUserView {

    @Inject
    SearchUserPresenter presenter;

    @InjectView(R.id.pb_search_user) ProgressWheel pbSearchUser;
    @InjectView(R.id.et_username) EditText etUsername;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplication().inject(this);
        initialize();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_search_user, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initialize() {
        presenter.setView(this);
    }

    @Override
    @OnClick(R.id.bt_search_user)
    public void searchUser() {
        presenter.searchUser(etUsername.getText().toString());
    }

    @Override
    public void showProjects() {
        ((MainActivity) getActivity()).showProjects();
    }

    @Override
    public void showLoading() {
        pbSearchUser.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbSearchUser.setVisibility(View.INVISIBLE);
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
