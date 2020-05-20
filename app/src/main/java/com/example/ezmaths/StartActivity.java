package com.example.ezmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ezmaths.Anuitati.MainActivity;
import com.example.ezmaths.Rambursari.ActivityRambursariTable;
import com.example.ezmaths.Rambursari.MainActivityRambursari;

public class StartActivity extends AppCompatActivity {

    Button DobanziBtn;
    Button RambursariBtn;
    Button AnuitatiBtn;
    Button AsigurariBtn;
    Button RezervaMatematicaBtn;
    public static Dialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        DobanziBtn = findViewById(R.id.DobanziBtn);
        RambursariBtn = findViewById(R.id.RambursariBtn);
        AnuitatiBtn = findViewById(R.id.AnuitatiBtn);
        AsigurariBtn = findViewById(R.id.AsigurariBtn);
        RezervaMatematicaBtn = findViewById(R.id.RezervaMatematicaBtn);



        AnuitatiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentav = new Intent(StartActivity.this, MainActivity.class);
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

        }




}
