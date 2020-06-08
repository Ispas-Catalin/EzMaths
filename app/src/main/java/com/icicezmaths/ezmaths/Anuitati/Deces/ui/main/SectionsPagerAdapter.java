package com.icicezmaths.ezmaths.Anuitati.Deces.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.icicezmaths.ezmaths.R;


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_deces_1, R.string.tab_text_deces_2, R.string.tab_text_deces_3, R.string.tab_text_deces_4};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position)
        {
            case 0:
                fragment = new AvDecesFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putInt("deces_key", 1);
                fragment.setArguments(bundle1);
                break;

            case 1:
                fragment = new AvDecesFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("deces_key", 2);
                fragment.setArguments(bundle2);
                break;

            case 2:
                fragment = new AvDecesFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putInt("deces_key", 3);
                fragment.setArguments(bundle3);
                break;

            case 3:
                fragment = new AvDecesFragment();
                Bundle bundle4 = new Bundle();
                bundle4.putInt("deces_key", 4);
                fragment.setArguments(bundle4);
                break;
        }

        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 4;
    }
}