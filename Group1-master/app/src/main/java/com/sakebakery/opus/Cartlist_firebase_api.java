package com.sakebakery.opus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sakebakery.opus.adapter.CakeImagelistAdapter;
import com.sakebakery.opus.adapter.CartDatalistAdapter;
import com.sakebakery.opus.obj.Cartobj;
import com.sakebakery.opus.util.Util;

import java.util.ArrayList;

public class Cartlist_firebase_api extends AppCompatActivity {

    private CartDatalistAdapter cartDatalistAdapter;

    private RecyclerView cart_list;

    private ProgressDialog progressDialog;

    private ArrayList<Cartobj> cartobjs;

    private static FirebaseAnalytics firebaseAnalytics;

    private DatabaseReference mDatabase;

    private Button checkout_bt;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_data_layout);

        cart_list = findViewById(R.id.cart_list);

        cartobjs = new ArrayList<>();

        if(Util.isOnline(getApplicationContext())){
            LoadFirebaseDB();
        }else {
            Toast.makeText(getApplicationContext(), "No internet connection!", Toast.LENGTH_SHORT).show();
        }

        checkout_bt = findViewById(R.id.bt_checkout);

        checkout_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "List Event", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Cartlist_firebase_api.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        firebaseAnalytics.setCurrentScreen(Cartlist_firebase_api.this,"FirebaseAPI_Screen",null);
    }

    public void LoadFirebaseDB() {


        if (progressDialog == null) {
            progressDialog = new ProgressDialog(Cartlist_firebase_api.this);
            progressDialog.setCancelable(true);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("cart").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Log.d("Cart_list", "" + dataSnapshot.toString());

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    Cartobj cartobj = new Cartobj();
                    cartobj.setCart_id(ds.child("id").getValue() + "");
                    cartobj.setCart_cake_name(ds.child("cake_name").getValue() + "");
                    cartobj.setCart_cake_price(ds.child("price").getValue() + "");
                    cartobj.setCart_quantity(ds.child("quantity").getValue() + "");
                    cartobj.setCart_thumbnail(ds.child("thumbnail").getValue() + "");
                    cartobj.setCart_sub_total(ds.child("sub_total").getValue() + "");
                    cartobj.setCart_user_id(ds.child("user_id").getValue() + "");
                    cartobj.setActive(Integer.parseInt(ds.child("active").getValue() + ""));


                    if (cartobj.getActive() == 1) {
                        cartobjs.add(cartobj);
                    }

                    if (cartobjs.size() == 0) {
                        Toast.makeText(Cartlist_firebase_api.this, "No Data!", Toast.LENGTH_SHORT).show();
                    }

                }

                LoadUI();

                DismissDialog();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                    DismissDialog();
            }
        });

        }

    public void DismissDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }


    public void LoadUI() {

        cartDatalistAdapter = new CartDatalistAdapter(Cartlist_firebase_api.this,cartobjs);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        cart_list.setLayoutManager(mLayoutManager);
        cart_list.setItemAnimator(new DefaultItemAnimator());
        cart_list.setAdapter(cartDatalistAdapter);

    }

}
