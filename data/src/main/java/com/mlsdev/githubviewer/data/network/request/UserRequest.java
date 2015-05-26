package com.mlsdev.githubviewer.data.network.request;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.mlsdev.githubviewer.data.entity.UserEntity;
import com.mlsdev.githubviewer.data.network.Urls;
import com.mlsdev.githubviewer.data.network.parser.UserEntityParser;
import com.mlsdev.githubviewer.domain.utils.Lg;

import org.apache.http.protocol.HTTP;

import java.io.UnsupportedEncodingException;

import static org.apache.http.protocol.HTTP.UTF_8;

/**
 * Created by roma on 20.05.15.
 */
public class UserRequest extends BaseRequest<UserEntity> {

    public UserRequest(String username, VolleyResponseListener<UserEntity> listener) {
        super(Method.GET, Urls.userGet(username), listener);
    }

    @Override
    protected Response<UserEntity> parseNetworkResponse(NetworkResponse response) {
        try {
            if ((response != null) && (response.data != null)) {
                String json = new String(response.data, HTTP.UTF_8);
                Lg.u("parsing success user request ");
                return Response.success(new UserEntityParser().parse(json), HttpHeaderParser.parseCacheHeaders(response));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected VolleyError parseNetworkError(VolleyError volleyError) {
        try {
            if ((null != volleyError) && (null != volleyError.networkResponse) && (null != volleyError.networkResponse.data)) {
                String errorResponse = new String(volleyError.networkResponse.data, UTF_8);
                Lg.ue("network error during user request --> " + errorResponse);
                return new VolleyError(errorResponse);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return super.parseNetworkError(volleyError);
    }
}
