package com.sakebakery.opus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//import static com.sakebakery.opus.LoginActivity.MY_PREFS_NAME;

public class UserFilter extends AppCompatActivity {

    private String f_email;

    private String f_password;

    private FirebaseAuth mAuth;

    public ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

//        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
//        String restoredText = prefs.getString("text", null);
//        Log.e("Restored Text", restoredText);
//        if (restoredText != null) {
//            f_email = prefs.getString("name", "");
//            Log.e("filter_name",f_email);
//            f_password = prefs.getString("password", "");
//            Log.e("filter_password",f_password);
//        }

//        f_email="";
//        f_password="";
//
//        if(f_email.equals("")&f_password.equals("")){
//
//        }else{
//
//        }
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user) {
        hideProgressDialog();
        if (user != null) {
            Intent intent = new Intent(UserFilter.this, MainActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(UserFilter.this, WelcomeActivity.class);
            startActivity(intent);
        }
    }


    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

//    public void showProgressDialog() {
//        if (mProgressDialog == null) {
//            mProgressDialog = new ProgressDialog(this);
//            mProgressDialog.setMessage(getString(R.string.loading));
//            mProgressDialog.setIndeterminate(true);
//        }
//
//        mProgressDialog.show();
//    }
}
