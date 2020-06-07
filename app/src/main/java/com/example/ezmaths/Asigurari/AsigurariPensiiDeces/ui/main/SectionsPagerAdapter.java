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
    private int asigType;

    @StringRes
    private static int[] TAB_TITLES;
    private final Context mContext;

    public void setVersion(int version) {
        this.version = version;
    }

    public void setAsigType(int AsigType){
        this.asigType = AsigType;
        if (AsigType == 21)
        {
            TAB_TITLES = new int[]{R.string.tab_anuitateI_22,R.string.tab_III_22};
        }
        if (AsigType == 31)
        {
            TAB_TITLES = new int[]{R.string.tab_anuitateII_32,R.string.tab_III_32};
        }
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
                bundle.putInt("asig_type_version", asigType);
                fragment.setArguments(bundle);
                break;
            case 1:
                fragment = new AsigurariPensiDecesFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putInt("asig_type_version", asigType);
                fragment.setArguments(bundle1);

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