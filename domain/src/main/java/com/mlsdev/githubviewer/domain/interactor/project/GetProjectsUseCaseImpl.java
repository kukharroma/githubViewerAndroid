package com.mlsdev.githubviewer.domain.interactor.project;

import com.mlsdev.githubviewer.domain.executor.PostExecutionThread;
import com.mlsdev.githubviewer.domain.executor.ThreadExecutor;
import com.mlsdev.githubviewer.domain.model.Project;
import com.mlsdev.githubviewer.domain.repository.ProjectRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by roma on 21.05.15.
 */
@Singleton
public class GetProjectsUseCaseImpl implements GetProjectsUseCase {

    private final ProjectRepository projectRepository;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private Callback callback = null;
    private String username;

    @Inject
    public GetProjectsUseCaseImpl(ProjectRepository projectRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.projectRepository = projectRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    @Override
    public void execute(String username, Callback callback) {
        this.callback = callback;
        this.username = username;
        this.threadExecutor.execute(this);
    }

    @Override
    public void run() {
        this.projectRepository.repositoriesGet(this.username, projectCallback);
    }

    ProjectRepository.ProjectCallback projectCallback = new ProjectRepository.ProjectCallback() {
        @Override
        public void onSuccessProjects(List<Project> response) {
            if (callback != null) {
                notifyWithSuccessProjects(response);
            }
        }

        @Override
        public void onFailProjects(String message) {
            if (callback != null) {
                notifyWithErrorProjects(message);
            }
        }
    };

    private void notifyWithSuccessProjects(final List<Project> projects) {
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(projects);
            }
        });
    }

    private void notifyWithErrorProjects(final String message) {
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onFail(message);
            }
        });
    }

    @Override
    public void cancel() {
        this.callback = null;
    }
}
