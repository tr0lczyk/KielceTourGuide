package com.example.android.kielcetourguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Mateusz on 29.01.2018.
 */

public class KielceTourFragmentPagerAdapter extends FragmentPagerAdapter {

    public KielceTourFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new SeeFragment();
        } else if (position == 1) {
            return new EatFragment();
        } else if (position == 2) {
            return new SleepFragment();
        } else {
            return new DoingFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
