package com.sakebakery.opus.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.annotation.NonNull;

import com.sakebakery.opus.obj.Cakeobj;
import com.sakebakery.opus.R;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CakedataListAdapter extends RecyclerView.Adapter<CakedataListAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private Activity activity;
    private ArrayList<Cakeobj> cakeObjs;

    public CakedataListAdapter(ArrayList<Cakeobj> cakeObjs) {
        this.mInflater = LayoutInflater.from(activity);
        this.activity = activity;
        this.cakeObjs = cakeObjs;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.cake_grid_layout, viewGroup, false);
        return new CakedataListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

     //   viewHolder.cake_thumb_iv.setText(cakeObjs.get(position).getCake_thumbnail());
//        viewHolder.cake_name_tv.setText(cakeObjs.get(position).getCake_name());
//        viewHolder.cake_flavor_tv.setText(cakeObjs.get(position).getCake_flavor());
        viewHolder.cake_price_tv.setText(cakeObjs.get(position).getCake_price());
        viewHolder.cake_flavor_tv.setText(cakeObjs.get(position).getCake_flavor());
        viewHolder.cake_name_tv.setText(cakeObjs.get(position).getCake_name());
        viewHolder.activeness.setText(cakeObjs.get(position).getCake_id());
     //   viewHolder.cake_thumb_iv.set

       // viewHolder.cake_thumb_iv.setText(cakeObjs.get(position).getCake_thumbnail());


//
//        try {
//            Picasso.with(activity).load(cakeObjs.get(position).getCake_thumbnail()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(viewHolder.cake_thumb_iv);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public int getItemCount() {
        return cakeObjs.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView cake_name_tv;
        public TextView cake_flavor_tv;
        //   public TextView cake_id;
        // public TextView cake_price;
        public TextView activeness;
        public TextView cake_price_tv;
       // public ImageView cake_thumb_iv;

        public ViewHolder(View view) {
            super(view);
            this.cake_name_tv = view.findViewById(R.id.tv_cake_name);
            this.cake_flavor_tv = view.findViewById(R.id.tv_cake_flavor);
            // this.cake_id=view.findViewById(R.id.tv)
            this.cake_price_tv = view.findViewById(R.id.tv_cake_price);
         //   this.cake_thumb_iv = view.findViewById(R.id.tv_cake_price);
            this.activeness = view.findViewById(R.id.tv_cart_quantity);
        }
    }
}
