package com.example.user.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 8/9/2018.
 */

public class Ring_items_adapter extends RecyclerView.Adapter<Ring_items_adapter.Pic_views_holder> {
    private Context context;
    private List<Ring_Pic_Items> ring_pic_items;
    public Ring_items_adapter(Context context , List<Ring_Pic_Items> ring_pic_items)
    {
        this.context=context;
        this.ring_pic_items = ring_pic_items;
        
    }
    @Override
    public Ring_items_adapter.Pic_views_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.ring_pic_lis,null);
        return new Pic_views_holder(view);
    }

    @Override
    public void onBindViewHolder(Ring_items_adapter.Pic_views_holder holder, int position) {
   final Ring_Pic_Items rind_item_list = ring_pic_items.get(position);
          holder.mainImages.setImageResource(rind_item_list.getImage());
        holder.Date.setText(rind_item_list.getDate());
//        holder.Time.setText(rind_item_list.getTime());
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
      intent.putExtra("UserImage",rind_item_list.getImage());
        intent.putExtra("ImageDate",rind_item_list.getDate());
        intent.putExtra("ImageTime",rind_item_list.getTime());
        intent.setClass(context,View_Image_Detaile.class);
        context.startActivity(intent);
    }
});
    }

    @Override
    public int getItemCount() {
        return ring_pic_items.size();
    }

    public class Pic_views_holder extends RecyclerView.ViewHolder {
        TextView Date , Time;
        ImageView mainImages;
        public Pic_views_holder(View view) {
            super(view);
           Date = (TextView)view.findViewById(R.id.ringdate);
           mainImages = (ImageView)view.findViewById(R.id.RingImge);
        }
    }
}
