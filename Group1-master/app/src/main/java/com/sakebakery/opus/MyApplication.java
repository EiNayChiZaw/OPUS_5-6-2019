package com.sakebakery.opus;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.sakebakery.opus.db.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;

public class MyApplication extends Application {

    private RequestQueue requestQueue;
    private static final String TAG = "GustoStudent";
    private DatabaseHelper databaseHelper = null;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public RequestQueue getRequestQueue() {

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {

        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);

        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {

        req.setTag(TAG);

        getRequestQueue().add(req);

    }

    public void cancelPendingRequests(Object tag) {

        if (requestQueue != null) {
            requestQueue.cancelAll(tag);
        }

    }

    public boolean CheckRequestRunning() {

        if (requestQueue != null) {
            return true;
        } else {
            return false;
        }
    }

    public DatabaseHelper getDBHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }

    public void CloseDB() {
        if (databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }
}
