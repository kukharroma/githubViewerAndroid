package com.mlsdev.githubviewer.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mlsdev.github_viewer.R;
import com.mlsdev.githubviewer.domain.model.Project;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by roma on 25.05.15.
 */
public class ProjectAdapter extends BaseAdapter {

    private Context context;
    private List<Project> projects;

    public ProjectAdapter(Context context, List<Project> projects) {
        this.context = context;
        this.projects = projects;
    }

    @Override
    public int getCount() {
        return projects.size();
    }

    @Override
    public Project getItem(int position) {
        return projects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_project, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        Project project = projects.get(position);
        holder.tvProjectName.setText(project.getName());
        holder.tvProjectLanguage.setText(project.getLanguage());
        holder.tvForksCount.setText(project.getForks());
        holder.tvStarsCount.setText(project.getStars());
        return convertView;
    }

    private static class ViewHolder {
        @InjectView(R.id.tv_project_name) TextView tvProjectName;
        @InjectView(R.id.tv_project_language_name) TextView tvProjectLanguage;
        @InjectView(R.id.tv_fork_count) TextView tvForksCount;
        @InjectView(R.id.tv_stars_count) TextView tvStarsCount;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
