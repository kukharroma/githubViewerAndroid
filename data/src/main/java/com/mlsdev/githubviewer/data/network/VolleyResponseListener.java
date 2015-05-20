package com.mlsdev.githubviewer.data.network;

import com.android.volley.Response;

/**
 * Created by roma on 20.05.15.
 */
public interface VolleyResponseListener<T> extends Response.Listener<T>, Response.ErrorListener {
}
