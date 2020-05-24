package com.example.ezmaths.Anuitati2.AntiPost;

import android.os.Bundle;


import com.example.ezmaths.Anuitati2.AntiPost.ui.main.AvAmanateFragment;
import com.example.ezmaths.Anuitati2.AntiPost.ui.main.AvImediateLimitateFragment;
import com.example.ezmaths.Anuitati2.AntiPost.ui.main.AvImediateNelimFragment;
import com.example.ezmaths.Anuitati2.MainActivityAnuitati;
import com.example.ezmaths.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.ezmaths.Anuitati2.AntiPost.ui.main.SectionsPagerAdapter;

import org.w3c.dom.Text;

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
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);



    }


}