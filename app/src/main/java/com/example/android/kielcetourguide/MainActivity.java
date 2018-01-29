package com.example.android.kielcetourguide;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setting the view pager that allows to swiping through fragments
//        + setting tab layout's name based on the fragments name that is swiped
        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        TabLayout tabLayout = findViewById(R.id.tabs);
        KielceTourFragmentPagerAdapter categoryAdapter = new KielceTourFragmentPagerAdapter(this,getSupportFragmentManager());
        pager.setAdapter(categoryAdapter);
        tabLayout.setupWithViewPager(pager);
    }
}
