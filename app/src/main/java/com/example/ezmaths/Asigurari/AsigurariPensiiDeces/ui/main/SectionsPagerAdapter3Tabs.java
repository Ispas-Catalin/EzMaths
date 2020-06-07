package com.example.ezmaths.Asigurari.AsigurariPensiiDeces.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
public class SectionsPagerAdapter3Tabs extends FragmentPagerAdapter {

    private int versiontab1;
    private int versiontab2;
    private int asigType;

    @StringRes
    private static int[] TAB_TITLES;
    private final Context mContext;


    public void setVersionTab1(int version) {
        this.versiontab1 = version;
    }

    public void setVersionTab2(int version) {
        this.versiontab2 = version;
    }

    public void setAsigType(int AsigType){
        this.asigType = AsigType;
        if (AsigType == 22)
            TAB_TITLES = new int[]{R.string.tab_anuitateI_22,R.string.tab_anuitateII_22, R.string.tab_III_22};
        if (AsigType == 32)
            TAB_TITLES = new int[]{R.string.tab_anuitateI_32,R.string.tab_anuitateII_32, R.string.tab_III_32};
    }

    public SectionsPagerAdapter3Tabs(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    AsigAnuitatiFragment asigAnuitatiFragment = new AsigAnuitatiFragment();

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position)
        {
            case 0:
                fragment = new AsigAnuitatiFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("key_version", versiontab1);
                bundle.putInt("asig_type_version", asigType);
                fragment.setArguments(bundle);
                asigAnuitatiFragment.setframgentVersion(versiontab1);
                break;
            case 1:
                fragment = new AsigAnuitatiFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("key_version", versiontab2);
                bundle2.putInt("asig_type_version", asigType);
                asigAnuitatiFragment.setframgentVersion(versiontab2);
                fragment.setArguments(bundle2);
                break;
            case 2:
                fragment = new AsigurariPensiDecesFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putInt("asig_type_version", asigType);
                fragment.setArguments(bundle3);
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
        return 3;
    }

}