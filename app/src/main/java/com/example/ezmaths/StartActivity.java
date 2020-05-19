package com.example.ezmaths;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

public class StartActivity extends AppCompatActivity {

    Button DobanziBtn;
    Button RambursariBtn;
    Button AnuitatiBtn;
    Button AsigurariBtn;
    Button RezervaMatematicaBtn;




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
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
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
