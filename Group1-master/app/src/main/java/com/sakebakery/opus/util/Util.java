package com.sakebakery.opus.util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.IntDef;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.sakebakery.opus.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static void ShowDialogMessage(Activity activity,String title, String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setTitle(title)
                .setIcon(R.mipmap.ic_launcher)
                .setMessage(message)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        dialoginterface.cancel();
                    }
                })
                .setNeutralButton("Help", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                    }
                }).show();
    }

    public static boolean isOnline(Context c) {
        ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public static String AutoID(String id){

        String id_value;

        String[] part = id.split("(?<=\\D)(?=\\d)");

        String value_1  = part[0];

        int value_2 = Integer.parseInt(part[1]);

        Log.e("nyima", String.valueOf(value_2));

        value_2 = value_2+1;

        Log.e("mama", String.valueOf(value_2));

        id_value = value_1 + String.format("%04d", value_2);

        return id_value;
    }


    @Retention(RetentionPolicy.SOURCE)
    @IntDef({GRANTED, DENIED, BLOCKED})
    public @interface PermissionStatus {
    }

    public static final int GRANTED = 0;
    public static final int DENIED = 1;
    public static final int BLOCKED = 2;

    private static String[] PERMISSIONS_CONTACT = { Manifest.permission.INTERNET,Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

    private static final int REQUEST_PERMISSION = 1;

    public static void RequestPermission(Activity activity) {

        if (getPermissionStatusAll(activity)) {
            try {
                ActivityCompat.requestPermissions(activity, PERMISSIONS_CONTACT, REQUEST_PERMISSION);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Log.e("App Permission Status", "All Done!");
        }

    }

    @PermissionStatus
    public static int getPermissionStatus(Activity activity, String androidPermissionName) {


        if (ContextCompat.checkSelfPermission(activity, androidPermissionName) != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, androidPermissionName)) {
                return BLOCKED;
            }
            return DENIED;
        }
        return GRANTED;
    }

    @SuppressLint("SupportAnnotationUsage")
    @PermissionStatus
    public static boolean getPermissionStatusAll(Activity activity) {


        boolean request_permission = false;

        int value = 1;

        List<String> listPermissionsNeeded = new ArrayList<>();

        for (int i = 0; i < PERMISSIONS_CONTACT.length; i++) {

            if (ContextCompat.checkSelfPermission(activity, PERMISSIONS_CONTACT[i]) != PackageManager.PERMISSION_GRANTED) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, PERMISSIONS_CONTACT[i])) {
                    value = BLOCKED;
                    listPermissionsNeeded.add(PERMISSIONS_CONTACT[i]);
                }
                value = DENIED;
                listPermissionsNeeded.add(PERMISSIONS_CONTACT[i]);

            } else {

                value = GRANTED;

            }

        }

        if (listPermissionsNeeded.size() != 0) {
            request_permission = true;
        }

        Log.e("App PermissionNeedList", listPermissionsNeeded.toString());
        Log.e("App Permission Size", listPermissionsNeeded.size() + "");


        return request_permission;
    }


    public static Typeface Myanmar(Context cmx) {
        return Typeface.createFromAsset(cmx.getAssets(), "zawgyi.ttf");
    }

}
