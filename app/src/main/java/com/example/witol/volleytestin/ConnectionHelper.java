package com.example.witol.volleytestin;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by witol on 16.05.2017.
 */

public class ConnectionHelper {

    private static Context contx;
    private  RequestQueue myRequestQueue;

    private ConnectionHelper(Context context) {
        contx = context;
        myRequestQueue = getRequestQueue();
    }

    private static ConnectionHelper instance = null;


    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public RequestQueue getRequestQueue() {
        RequestQueue requestQueue = Volley.newRequestQueue(contx.getApplicationContext());
        return requestQueue;
    }

    public static ConnectionHelper getInstance(Context context) {
        if(instance == null)instance = new ConnectionHelper(context);
        return instance;
    }
}
