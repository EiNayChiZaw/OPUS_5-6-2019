package com.sakebakery.opus.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sakebakery.opus.R;
import com.sakebakery.opus.obj.Cakeobj;
import com.sakebakery.opus.obj.Cartobj;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CartDatalistAdapter extends RecyclerView.Adapter<CartDatalistAdapter.ViewHolder> {


    private LayoutInflater mInflater;
    private Activity activity;
    private ArrayList<Cartobj> cartobjs;

    int sub;
    int subwithtax;
    int finaltotal;

    public CartDatalistAdapter(Activity activity, ArrayList<Cartobj> cartobjs) {
        this.mInflater = LayoutInflater.from(activity);
        this.activity = activity;
        this.cartobjs = cartobjs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.order_cart, viewGroup, false);
        return new CartDatalistAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        try{
            viewHolder.name_tv.setText(cartobjs.get(position).getCart_cake_name());
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            viewHolder.subtotal_tv.setText(cartobjs.get(position).getCart_sub_total() + "  MMK");
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            viewHolder.quantity_tv.setText(cartobjs.get(position).getCart_quantity());
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            Picasso.with(activity).load(cartobjs.get(position).getCart_thumbnail()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(viewHolder.thumb_iv);
        }catch (Exception e){
            e.printStackTrace();
        }

        sub=Integer.parseInt(cartobjs.get(position).getCart_sub_total())*Integer.parseInt(cartobjs.get(position).getCart_quantity());
        subwithtax= (int) (sub*0.05);
        finaltotal= subwithtax +sub;

        String s= String.valueOf(sub);
        String tax=String.valueOf(subwithtax);
        String st=String.valueOf(finaltotal);

        Log.e("Subtotal",s);
        Log.e("tax",tax);
        Log.e("final_total",st);

        try{
            viewHolder.subtotalall_tv.setText(s);
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            viewHolder.tax_tv.setText(tax);
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            viewHolder.total_tv.setText(st);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return cartobjs.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name_tv;
        public TextView subtotal_tv;
        public TextView quantity_tv;
        public ImageView thumb_iv;

        public TextView total_tv;
        public TextView subtotalall_tv;
        public TextView tax_tv;


        public ViewHolder(View view) {
            super(view);
            this.name_tv = view.findViewById(R.id.tv_cart_name);
            this.subtotal_tv = view.findViewById(R.id.tv_cart_price);
            this.quantity_tv = view.findViewById(R.id.tv_cart_quantity);
            this.thumb_iv = view.findViewById(R.id.cart_image);

            this.total_tv=view.findViewById(R.id.tv_total);
            this.tax_tv=view.findViewById(R.id.tv_tax);
            this.subtotalall_tv=view.findViewById(R.id.tv_subtotal);
        }
    }
}
