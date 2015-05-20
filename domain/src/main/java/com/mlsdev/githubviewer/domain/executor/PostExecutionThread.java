/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 *
 * @author Fernando Cejas (the android10 coder)
 */
package com.mlsdev.githubviewer.domain.executor;

/**
 * Created by roma on 20/05/15.
 */

public interface PostExecutionThread {
    void post(Runnable runnable);
}
