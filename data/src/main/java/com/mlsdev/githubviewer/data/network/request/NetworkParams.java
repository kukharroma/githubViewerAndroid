package com.mlsdev.githubviewer.data.network.request;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RetryPolicy;

/**
 * Created by roma on 3/17/15.
 */
public class NetworkParams {

    public final static int DEFAULT_TIMEOUT = 30000;
    public final static int DEFAULT_NUM_RETRY = 0;
    public final static float DEFAULT_MULTIPLIER = 0.0f;

    public static RetryPolicy getDefaultRetryPolicy(){
        return new DefaultRetryPolicy(DEFAULT_TIMEOUT, DEFAULT_NUM_RETRY, DEFAULT_MULTIPLIER);
    }

}
