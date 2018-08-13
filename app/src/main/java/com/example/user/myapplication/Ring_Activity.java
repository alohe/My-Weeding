package com.example.user.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Ring_Activity extends Fragment {
    View view;
    RecyclerView recyclerView;
    List<Ring_Pic_Items> ring_item_list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.activity_ring_,container,false);
         recyclerView =(RecyclerView)view.findViewById(R.id.ring_recycle_view);
        Ring_items_adapter adapter = new Ring_items_adapter(getContext(),ring_item_list);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));

        // recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
       return view;
    }
@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       ring_item_list = new ArrayList<>();
     
       ring_item_list.add(new Ring_Pic_Items(R.drawable.pone,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.ptwo,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pfoure,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pone,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.ptwo,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pfoure,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pone,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.ptwo,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pfoure,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pone,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.ptwo,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pfoure,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pone,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.ptwo,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pfoure,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pone,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.ptwo,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pfoure,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pone,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.ptwo,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pfoure,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pone,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.ptwo,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pfoure,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pone,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.ptwo,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pfoure,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pone,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.ptwo,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pfoure,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pone,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.ptwo,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pfoure,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pone,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.ptwo,"Jun 2018" ,"4:00" ));
    ring_item_list.add(new Ring_Pic_Items(R.drawable.pfoure,"Jun 2018" ,"4:00" ));
    }
}
