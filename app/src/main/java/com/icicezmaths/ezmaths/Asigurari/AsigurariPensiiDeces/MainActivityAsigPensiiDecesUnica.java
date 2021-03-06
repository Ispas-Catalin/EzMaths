package com.icicezmaths.ezmaths.Asigurari.AsigurariPensiiDeces;

import android.os.Bundle;

import com.icicezmaths.ezmaths.Asigurari.AnuitatiViewModel;
import com.icicezmaths.ezmaths.Asigurari.AsigurariPensiiDeces.ui.main.SectionsPagerAdapter;
import com.icicezmaths.ezmaths.Asigurari.AsigurariPensiiDeces.ui.main.SectionsPagerAdapter3Tabs;
import com.icicezmaths.ezmaths.Asigurari.MainActivityAsigurari;
import com.icicezmaths.ezmaths.R;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivityAsigPensiiDecesUnica extends AppCompatActivity {

    int aux;
    private AnuitatiViewModel anuitatiViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_asig_pensii_deces);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            aux = bundle.getInt(MainActivityAsigurari.ATYPE_KEY);
        }

        if(aux%10 == 1) {
            SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
            if (aux == 21)
                sectionsPagerAdapter.setVersion(2);
            if (aux == 31)
                sectionsPagerAdapter.setVersion(4);
            sectionsPagerAdapter.setAsigType(aux);
            ViewPager viewPager = findViewById(R.id.view_pager);
            viewPager.setOffscreenPageLimit(2);
            viewPager.setAdapter(sectionsPagerAdapter);
            TabLayout tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewPager);
        }

        if(aux%10 == 2) {
            SectionsPagerAdapter3Tabs sectionsPagerAdapter3Tabs = new SectionsPagerAdapter3Tabs(this, getSupportFragmentManager());
            if (aux == 22)
            {
                sectionsPagerAdapter3Tabs.setVersionTab1(2);
                sectionsPagerAdapter3Tabs.setVersionTab2(3);
            }
            if (aux == 32)
            {
                sectionsPagerAdapter3Tabs.setVersionTab1(3);
                sectionsPagerAdapter3Tabs.setVersionTab2(4);
            }
            sectionsPagerAdapter3Tabs.setAsigType(aux);
            ViewPager viewPager = findViewById(R.id.view_pager);
            viewPager.setAdapter(sectionsPagerAdapter3Tabs);
            viewPager.setOffscreenPageLimit(3);
            TabLayout tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewPager);
        }

    }


}