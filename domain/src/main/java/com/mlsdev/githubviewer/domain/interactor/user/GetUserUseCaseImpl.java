package com.mlsdev.githubviewer.domain.interactor.user;

import com.android.volley.VolleyError;
import com.mlsdev.githubviewer.domain.executor.PostExecutionThread;
import com.mlsdev.githubviewer.domain.executor.ThreadExecutor;
import com.mlsdev.githubviewer.domain.interactor.Cancelable;
import com.mlsdev.githubviewer.domain.model.User;
import com.mlsdev.githubviewer.domain.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by roma on 21.05.15.
 */
@Singleton
public class GetUserUseCaseImpl implements GetUserUseCase {

    private final UserRepository userRepository;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private Callback callback = null;
    private String username = null;

    @Inject
    public GetUserUseCaseImpl(UserRepository userRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.userRepository = userRepository;
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
    public User execute() {
        return userRepository.userGet();
    }

    @Override
    public void run() {
        userRepository.userGet(this.username, userRepositoryCallback);
    }

    UserRepository.UserCallback userRepositoryCallback = new UserRepository.UserCallback() {
        @Override
        public void onSuccessUser(User user) {
            notifyWithSuccessUser(user);
        }

        @Override
        public void onFailUser(String message) {
            notifyWithErrorUser(message);
        }
    };

    private void notifyWithSuccessUser(final User user) {
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                if (callback != null)
                    callback.onSuccessUser(user);
            }
        });
    }

    private void notifyWithErrorUser(final String message) {
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                if (callback != null)
                    callback.onFailUser(message);
            }
        });
    }

    @Override
    public void cancel() {
        this.callback = null;
    }
}
