package com.icicezmaths.ezmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.icicezmaths.ezmaths.Anuitati.MainActivityAnuitati;
import com.icicezmaths.ezmaths.Rambursari.MainActivityRambursari;
import com.icicezmaths.ezmaths.Asigurari.MainActivityAsigurari;
import com.icicezmaths.ezmaths.R;
import com.icicezmaths.ezmaths.RezervaMatematica.MainActivityRezerva;

public class StartActivity extends AppCompatActivity {

    Button RambursariBtn;
    Button AnuitatiBtn;
    Button AsigurariBtn;
    Button RezervaMatematicaBtn;
    public static Dialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        RambursariBtn = findViewById(R.id.RambursariBtn);
        AnuitatiBtn = findViewById(R.id.AnuitatiBtn);
        AsigurariBtn = findViewById(R.id.AsigurariBtn);
        RezervaMatematicaBtn = findViewById(R.id.RezervaMatematicaBtn);



        AnuitatiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentav = new Intent(StartActivity.this, MainActivityAnuitati.class);
                startActivity(intentav);
            }
        });


        RambursariBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, MainActivityRambursari.class);
                startActivity(intent);
            }
        });

        AsigurariBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, MainActivityAsigurari.class);
                startActivity(intent);
            }
        });

        RezervaMatematicaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, MainActivityRezerva.class);
                startActivity(intent);
            }
        });

        }




}
