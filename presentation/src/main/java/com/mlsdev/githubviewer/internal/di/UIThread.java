package com.mlsdev.githubviewer.internal.di;

import android.os.Handler;
import android.os.Looper;

import com.mlsdev.githubviewer.domain.executor.PostExecutionThread;


/**
 * MainThread (UI Thread) implementation based on a Handler instantiated with the main
 * application Looper.
 */
public class UIThread implements PostExecutionThread {

  private final Handler handler;

//  @Inject
  public UIThread() {
    this.handler = new Handler(Looper.getMainLooper());
  }

  /**
   * Causes the Runnable r to be added to the message queue.
   * The runnable will be run on the main thread.
   *
   * @param runnable {@link Runnable} to be executed.
   */
  @Override
  public void post(Runnable runnable) {
    handler.post(runnable);
  }
}
