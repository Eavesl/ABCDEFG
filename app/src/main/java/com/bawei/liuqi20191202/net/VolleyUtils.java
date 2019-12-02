package com.bawei.liuqi20191202.net;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.liuqi20191202.app.MyApp;

import java.io.UnsupportedEncodingException;

/**
 * author : Eaves
 * desc   : 功能描述
 * date   : 2019/12/2
 */
public class VolleyUtils {
    private RequestQueue mQueue;
    private VolleyUtils() {
        mQueue = Volley.newRequestQueue(MyApp.mContext);
    }
    private static class VolleyHolder{
        private final static VolleyUtils VOLLEY_UTILS = new VolleyUtils();
    }

    public static VolleyUtils getInstance() {
        return VolleyHolder.VOLLEY_UTILS;
    }
    public interface VolleyCallBack{
        void onSuccess(String json);
        void onError(String error);
    }

    public void doGet(String httpUrl, final VolleyCallBack callBack){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, httpUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());
            }
        }){
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String str = "";
                try {
                    str = new String(response.data,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    str = new String(response.data);

                }
                return Response.success(str, HttpHeaderParser.parseCacheHeaders(response));
            }
        };

        mQueue.add(stringRequest);
    }
}
