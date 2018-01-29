package com.example.android.kielcetourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Mateusz on 29.01.2018.
 */

public class KielceTourFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public KielceTourFragmentPagerAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
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

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return mContext.getString(R.string.what_to_see);
        } else if (position == 1) {
            return mContext.getString(R.string.where_to_eat);
        } else if (position == 2) {
            return mContext.getString(R.string.where_to_sleep);
        } else {
            return mContext.getString(R.string.what_to_do);
        }
    }
}
