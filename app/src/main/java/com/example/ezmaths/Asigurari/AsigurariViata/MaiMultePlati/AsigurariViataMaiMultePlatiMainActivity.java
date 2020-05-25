package com.example.ezmaths.Asigurari.AsigurariViata.MaiMultePlati;

import android.os.Bundle;

import com.example.ezmaths.Asigurari.MainActivityAsigurari;
import com.example.ezmaths.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.ezmaths.Asigurari.AsigurariViata.MaiMultePlati.ui.main.SectionsPagerAdapter;

public class AsigurariViataMaiMultePlatiMainActivity extends AppCompatActivity {

    int aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asigurari_viata_mai_multe_plati_main);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            aux = bundle.getInt(MainActivityAsigurari.ATYPE_KEY);
        }

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        if (aux == 12)
            sectionsPagerAdapter.setVersion(1);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }
}