package com.example.ezmaths.Asigurari.AsigurariPensiiDeces.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import com.example.ezmaths.Asigurari.AsigAnuitatiFragment;
import com.example.ezmaths.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private int version;

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_asig_viata_multe_plati_1, R.string.tab_text_asig_viata_multe_plati_2};
    private final Context mContext;

    public void setVersion(int version) {
        this.version = version;
    }

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
                fragment = new AsigAnuitatiFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("key_version", version);
                fragment.setArguments(bundle);
                break;
            case 1:
                fragment = new AsigurariPensiDecesFragment();
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
        return 2;
    }

}