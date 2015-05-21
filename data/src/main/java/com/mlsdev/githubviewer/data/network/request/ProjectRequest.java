package com.mlsdev.githubviewer.data.network.request;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.mlsdev.githubviewer.data.entity.ProjectEntity;
import com.mlsdev.githubviewer.data.network.Urls;
import com.mlsdev.githubviewer.data.network.parser.ProjectEntityParser;

import org.apache.http.protocol.HTTP;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.apache.http.protocol.HTTP.UTF_8;

/**
 * Created by roma on 20.05.15.
 */
public class ProjectRequest extends BaseRequest<List<ProjectEntity>> {

    public ProjectRequest(String username, VolleyResponseListener<List<ProjectEntity>> listener) {
        super(Method.GET, Urls.repositoreiesGet(username), listener);
    }

    @Override
    protected Response<List<ProjectEntity>> parseNetworkResponse(NetworkResponse response) {
        try {
            if (response != null && response.data != null) {
                String json = new String(response.data, HTTP.UTF_8);
                return Response.success(new ProjectEntityParser().parseList(json), HttpHeaderParser.parseCacheHeaders(response));
            }
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected VolleyError parseNetworkError(VolleyError volleyError) {
        try {
            if ((null != volleyError) && (null != volleyError.networkResponse) && (null != volleyError.networkResponse.data)) {
                String stringResponse = new String(volleyError.networkResponse.data, UTF_8);
                return new VolleyError(stringResponse);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return super.parseNetworkError(volleyError);
    }
}
