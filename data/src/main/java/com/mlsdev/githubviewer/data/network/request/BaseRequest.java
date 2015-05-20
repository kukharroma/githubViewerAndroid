package com.mlsdev.githubviewer.data.network.request;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.mlsdev.githubviewer.data.network.NetworkErrors;
import com.mlsdev.githubviewer.data.network.VolleyResponseListener;


import org.apache.http.HttpStatus;

/**
 * Created by fir on 13.11.14.
 */
public abstract class BaseRequest<T> extends Request<T> {
    private VolleyResponseListener<T> mListener;

    public BaseRequest(int method, String url, VolleyResponseListener<T> listener) {
        super(method, url, listener);
        setRetryPolicy(NetworkParams.getDefaultRetryPolicy());
        mListener = listener;
    }
    @Override
    protected void deliverResponse(T t) {
        if (mListener != null){
            mListener.onResponse(t);
        }
    }

    @Override
    protected VolleyError parseNetworkError(VolleyError volleyError) {
        if (volleyError instanceof NoConnectionError){
            VolleyError error = new VolleyError(NetworkErrors.NO_INTERNET_CONNECTION);
            return error;
        }
        if (volleyError.networkResponse != null && volleyError.networkResponse.statusCode == HttpStatus.SC_INTERNAL_SERVER_ERROR){
            VolleyError error = new VolleyError(NetworkErrors.SERVER_TEMPORARY_UNAVAILABLE);
            return error;
        }

        if (volleyError.networkResponse != null && volleyError.networkResponse.statusCode == HttpStatus.SC_UNPROCESSABLE_ENTITY){
            VolleyError error = new VolleyError(NetworkErrors.DATA_WAS_MISSING);
            return error;
        }

        /*if (volleyError.networkResponse != null && volleyError.networkResponse.statusCode == HttpStatus.SC_UNAUTHORIZED){
            ApplicationState.getApplicationState().showLoginActivity();
        }*/
        return super.parseNetworkError(volleyError);
    }
}
