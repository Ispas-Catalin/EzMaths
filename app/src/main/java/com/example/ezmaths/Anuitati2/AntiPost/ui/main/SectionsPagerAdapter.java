package com.example.ezmaths.Anuitati2.AntiPost.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ezmaths.Asigurari.ui.main.AsigurariFragment;
import com.example.ezmaths.Asigurari.ui.main.AsigurariFragmentAV1;
import com.example.ezmaths.Asigurari.ui.main.AsigurariFragmentAV2;
import com.example.ezmaths.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_in, R.string.tab_text_il, R.string.tab_text_an};
    private final Context mContext;

    private int type;

    public void setType(int type) {
        this.type = type;
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
                fragment = new AvImediateNelimFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("key_pula", type);
                fragment.setArguments(bundle);
                break;

            case 1:
                fragment = new AvImediateLimitateFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putInt("key_pula", type);
                fragment.setArguments(bundle1);
                break;

            case 2:
                fragment = new AvAmanateFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("key_pula", type);
                fragment.setArguments(bundle2);
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