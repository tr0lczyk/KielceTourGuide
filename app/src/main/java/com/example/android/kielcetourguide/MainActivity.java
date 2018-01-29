package com.example.android.kielcetourguide;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView see;
    TextView eat;
    TextView sleep;
    TextView doing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        KielceTourFragmentPagerAdapter categoryAdapter = new KielceTourFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(categoryAdapter);
    }
}
