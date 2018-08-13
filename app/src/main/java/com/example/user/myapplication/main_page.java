package com.example.user.myapplication;

  import android.support.v7.app.ActionBar;
          import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;

/**
 * Created by user on 8/7/2018.
 */

public class main_page extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPageradapter viewPageradapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager)findViewById(R.id.viewpage_id);
        viewPageradapter = new ViewPageradapter(getSupportFragmentManager());
        viewPageradapter.AddFragment(new Weedding_Activity() , "Weeding");
        viewPageradapter.AddFragment(new Ring_Activity(),"Ring");

        viewPager.setAdapter(viewPageradapter);
        tabLayout.setupWithViewPager(viewPager);
       /* tabLayout.getTabAt(0).setIcon(R.drawable.weeding);
        tabLayout.getTabAt(1).setIcon(R.drawable.ring);
        tabLayout.getTabAt(2).setIcon(R.drawable.family);*/


    //

    }
}
