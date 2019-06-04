package com.sakebakery.opus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.sakebakery.opus.adapter.CakedataListAdapter;
import com.sakebakery.opus.obj.Cakeobj;

import java.util.ArrayList;


public class Cake_details extends AppCompatActivity {

   // public TextView side, flavor, icing, top, description, price;
    private DatabaseReference mData;
    private CakedataListAdapter cakedataListAdapter;
  //private CakeImagelistAdapter cakeImagelistAdapter;
    private RecyclerView cake_list;
    private Cakeobj cakeObjnormal;
    private ArrayList<Cakeobj> cakeObjs;
    private ProgressDialog progressDialog;
    private Button btn_test;
    private Button btn_addtocart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake_details);
        final Button button=findViewById(R.id.button8);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Cake_details.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Cake_details.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_addtocart= findViewById(R.id.add_tocart);

        btn_addtocart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Cake_details.this, Cartlist_firebase_api.class);
                startActivity(intent);
            }
        });

        // cakeObjnormal=(Cakeobj)getIntent().getSerializableExtra("obj"); //getting position
     //   ArrayList<Cakeobj> array  = (ArrayList<Cakeobj>)getIntent().getSerializableExtra("array"); //getting arraylist
//        cake_list= findViewById(R.id.cake_list);
//        cakeObjs = new ArrayList<>();
//        ArrayList<Cakeobj> cakeObjs;


      //  Log.e("becomingdog",Cake_details.);
//        if(Util.isOnline(getApplicationContext())){
//            LoadFirebaseDB();
//        }else {
//            Toast.makeText(getApplicationContext(), "No internet connection!", Toast.LENGTH_SHORT).show();
//        }


    }
//    public void gotoCreate (View view){
//        //Intent intent = new Intent (this, CreatingDesign.class); //to go to Create Design class
//        //startActivity(intent);
//    }



//
//            public void LoadFirebaseDB() {
//
//        if (progressDialog == null) {
//            progressDialog = new ProgressDialog(Cake_details.this);
//            progressDialog.setCancelable(true);
//            progressDialog.setMessage("Loading...");
//            progressDialog.show();
//        }
//
//        mData = FirebaseDatabase.getInstance().getReference();
//       // Query query=mData.orderByChild("cake_ID").equalTo(cakeObjnormal.getCake_id());
//        mData.child("cakedata").addListenerForSingleValueEvent(new ValueEventListener() {
//       // query.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                Log.d("Cake_list", "" + dataSnapshot.toString());
//
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//
//                    Cakeobj cakeobj = new Cakeobj();
//                    cakeobj.setCake_id(ds.child("id").getValue() + "");
//                    cakeobj.setCake_flavor(ds.child("flavor").getValue() + "");
//                    cakeobj.setIcing_flavor(ds.child("icing").getValue() + "");
//                    cakeobj.setTop_deco(ds.child("top_deco").getValue() + "");
//                    cakeobj.setSide_deco(ds.child("side_deco").getValue() + "");
//                    cakeobj.setDescription(ds.child("description").getValue() + "");
//                    cakeobj.setCake_price(ds.child("price").getValue()+ "");
//                    cakeobj.setActive(Integer.parseInt(ds.child("active").getValue() + ""));
//
////                    ArrayList<Cakeobj> cakeObjs;
////                    cakeObjs = new ArrayList<>();
//
//                    if (cakeobj.getActive() == 1) {
//                        cakeObjs.add(cakeobj);
//                    }
//
//                    if (cakeObjs.size() == 0) {
//                        Toast.makeText(Cake_details.this, "No Data!", Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//                LoadUI();
//                DismissDialog();
//            }
//
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                DismissDialog();
//            }
//        });
//
//    }
//
//    public void DismissDialog() {
//        if (progressDialog != null && progressDialog.isShowing()) {
//            progressDialog.dismiss();
//        }
//    }
//
//    public void LoadUI() {
//
//        cakedataListAdapter = new CakedataListAdapter(Cake_details.this, cakeObjs);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        cake_list.setLayoutManager(mLayoutManager);
//        cake_list.setItemAnimator(new DefaultItemAnimator());
//        cake_list.setAdapter(cakedataListAdapter);
//
//    }
}