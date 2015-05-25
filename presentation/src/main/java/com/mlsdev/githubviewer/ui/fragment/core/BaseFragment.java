package com.mlsdev.githubviewer.ui.fragment.core;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.mlsdev.githubviewer.App;

/**
 * Created by roma on 25.05.15.
 */
public class BaseFragment extends Fragment {

    protected App getApplication() {
            return (App) getActivity().getApplication();
    }

    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
