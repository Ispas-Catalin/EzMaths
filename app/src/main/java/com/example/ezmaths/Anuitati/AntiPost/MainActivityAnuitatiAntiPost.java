package com.example.ezmaths.Anuitati.AntiPost;

import android.os.Bundle;


import com.example.ezmaths.Anuitati.MainActivityAnuitati;
import com.example.ezmaths.R;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ezmaths.Anuitati.AntiPost.ui.main.SectionsPagerAdapter;

public class MainActivityAnuitatiAntiPost extends AppCompatActivity {

    int type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_anuitati_anti_post);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {
           type = bundle.getInt(MainActivityAnuitati.TYPE_KEY);
        }


        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        sectionsPagerAdapter.setType(type);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.setOffscreenPageLimit(3);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);



    }


}