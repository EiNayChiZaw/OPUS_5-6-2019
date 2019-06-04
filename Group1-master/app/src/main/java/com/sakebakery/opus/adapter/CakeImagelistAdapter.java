package com.sakebakery.opus.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sakebakery.opus.Cake_details;
import com.sakebakery.opus.obj.Cakeobj;
import com.sakebakery.opus.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CakeImagelistAdapter extends RecyclerView.Adapter<CakeImagelistAdapter.ViewHolder> {


    private LayoutInflater mInflater;
    private Activity activity;
    private ArrayList<Cakeobj> cakeobjs;

    public CakeImagelistAdapter(Activity activity, ArrayList<Cakeobj> cakeobjs) {
        this.mInflater = LayoutInflater.from(activity);
        this.activity = activity;
        this.cakeobjs = cakeobjs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.cake_grid_layout, viewGroup, false);
        return new CakeImagelistAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        try{
            viewHolder.name_tv.setText(cakeobjs.get(position).getCake_name());
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            viewHolder.flavor_tv.setText(cakeobjs.get(position).getCake_flavor());
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            viewHolder.price_tv.setText(cakeobjs.get(position).getCake_price()+"MMK");
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            Picasso.with(activity).load(cakeobjs.get(position).getCake_image()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(viewHolder.thumb_iv);
        }catch (Exception e){
            e.printStackTrace();
        }

        viewHolder.parent_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, Cake_details.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cakeobjs.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name_tv;
        public TextView flavor_tv;
        public TextView price_tv;
        public ImageView thumb_iv;
        public CardView parent_view;

        public ViewHolder(View view) {
            super(view);
            this.name_tv = view.findViewById(R.id.gtv_cake_name);
            this.flavor_tv = view.findViewById(R.id.gtv_cake_flavor);
            this.price_tv = view.findViewById(R.id.gtv_cake_price);
            this.thumb_iv = view.findViewById(R.id.g_thumbnail);
            this.parent_view=view.findViewById(R.id.gcard_view);
        }

    }
}
