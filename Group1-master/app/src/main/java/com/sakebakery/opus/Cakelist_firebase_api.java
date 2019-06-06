package com.sakebakery.opus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.view.Event;
import com.sakebakery.opus.adapter.CakeImagelistAdapter;
import com.sakebakery.opus.adapter.CakedataListAdapter;
import com.sakebakery.opus.obj.Cakeobj;
import com.sakebakery.opus.util.Util;

import java.util.ArrayList;

public class Cakelist_firebase_api extends AppCompatActivity {

    private CakeImagelistAdapter cakeImagelistAdapter;

    private RecyclerView cake_list;

    private ProgressDialog progressDialog;

    private ArrayList<Cakeobj> cakeObjs;

    private static FirebaseAnalytics firebaseAnalytics;

    private DatabaseReference mDatabase;
    RecyclerView recyclerView;
    SearchView searchView;

    DatabaseReference ref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cake_list_layout);

        cake_list = findViewById(R.id.cake_list);

        cakeObjs = new ArrayList<>();

        if (Util.isOnline(getApplicationContext())) {
            LoadFirebaseDB();
        } else {
            Toast.makeText(getApplicationContext(), "No internet connection!", Toast.LENGTH_SHORT).show();
        }

        recyclerView = findViewById(R.id.cake_list);
        searchView = findViewById(R.id.edittext);

    }


    @Override
    protected void onResume() {
        super.onResume();
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        firebaseAnalytics.setCurrentScreen(Cakelist_firebase_api.this, "FirebaseAPI_Screen", null);
    }

    public void LoadFirebaseDB() {


        if (progressDialog == null) {
            progressDialog = new ProgressDialog(Cakelist_firebase_api.this);
            progressDialog.setCancelable(true);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("cakedata").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Log.d("Cake_list", "" + dataSnapshot.toString());

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    cakeObjs = new ArrayList<>();
                    Cakeobj cakeobj = new Cakeobj();
                    cakeobj.setCake_id(ds.child("id").getValue() + "");
                    cakeobj.setCake_name(ds.child("name").getValue() + "");
                    cakeobj.setCake_flavor(ds.child("flavor").getValue() + "");
                    cakeobj.setCake_price(ds.child("price").getValue() + "");
                     cakeobj.setCake_image(ds.child("thumbnail").getValue() + "");
                    cakeobj.setActive(Integer.parseInt(ds.child("active").getValue() + ""));
//                    cakeObjs.add(ds.getValue(Cakeobj.class));
                  //  cakeObjs.add(ds.getValue(Cakeobj.class));
                 //   System.out.println("HERE KITTY KITTY" + cakeObjs);

                    try {
                        if (cakeobj.getActive() == 1) {
                            cakeObjs.add(cakeobj);
                        }

                        if (cakeObjs.size() == 0) {
                            Toast.makeText(Cakelist_firebase_api.this, "No Data!", Toast.LENGTH_SHORT).show();
                        }
                        Log.e("DBerror", "No");
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("DBerror", "Yes");
                    }

                }


                Log.e("CakeObj is here: ", cakeObjs.toString());

                CakedataListAdapter adapterClass = new CakedataListAdapter(cakeObjs);
                recyclerView.setAdapter(adapterClass);

                LoadUI();

                if (searchView != null) {
                    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                        @Override
                        public boolean onQueryTextSubmit(String s) {
                            return false;
                        }

                        @Override
                        public boolean onQueryTextChange(String s) {
                            search(s);
                            return true;
                        }
                    });
                }

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

        cakeImagelistAdapter = new CakeImagelistAdapter(Cakelist_firebase_api.this, cakeObjs);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        cake_list.setLayoutManager(mLayoutManager);
        cake_list.setItemAnimator(new DefaultItemAnimator());
        cake_list.setAdapter(cakeImagelistAdapter);

    }


//    @Override
//    protected void onStart() {
//        ref = FirebaseDatabase.getInstance().getReference().child("opus-sakebakery").child("cakedata");
//        recyclerView = findViewById(R.id.cake_list);
//        searchView = findViewById(R.id.edittext);
//        super.onStart();
//        if (ref != null) {
//            ref.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    if (dataSnapshot.exists())
//                    {
//                        list = new ArrayList<>();
//                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                            list.add(ds.getValue(cake_search.class));
//                        }
//                        AdapterClass adapterClass = new AdapterClass(list);
//                        recyclerView.setAdapter(adapterClass);
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//                    Toast.makeText(Cakelist_firebase_api.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//        if (searchView != null) {
//            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//                @Override
//                public boolean onQueryTextSubmit(String s) {
//                    return false;
//                }
//
//                @Override
//                public boolean onQueryTextChange(String s) {
//                    search(s);
//                    return true;
//                }
//            });
//        }
//    }

    private void search(String str) {
        ArrayList<Cakeobj> mylist = new ArrayList<>();
        for (Cakeobj object : cakeObjs) {
            if (object.getCake_name().toLowerCase().contains(str.toLowerCase())) {
                mylist.add(object);
            }
        }
        CakedataListAdapter adapterClass = new CakedataListAdapter(mylist);
        recyclerView.setAdapter(adapterClass);
    }

}