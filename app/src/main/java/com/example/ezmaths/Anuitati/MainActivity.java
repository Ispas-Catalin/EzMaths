package com.example.ezmaths.Anuitati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ezmaths.R;

public class MainActivity extends AppCompatActivity {


    public static final String VERSION_KEY = "version_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button avAnticipateIntregibtn = findViewById(R.id.avAnticipateIntregibtn);
        Button avAnticipateFractionatebtn = findViewById(R.id.avAnticipateFractionatebtn);
        Button avPosticipateIntregibtn = findViewById(R.id.avPosticipateIntregibtn);
        Button getAvPosticipateFractionatebtn = findViewById(R.id.avPosticipateFractionateibtn);

        Button backbtn = findViewById(R.id.backbtn);

        avAnticipateIntregibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAV2 = new Intent(MainActivity.this , MainActivityAV2.class );
                intentAV2.putExtra(VERSION_KEY, 1);
                startActivity(intentAV2);

            }
        });

        avAnticipateFractionatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAV2 = new Intent(MainActivity.this , MainActivityAV2.class );
                intentAV2.putExtra(VERSION_KEY, 2);
                startActivity(intentAV2);
            }
        });

        avPosticipateIntregibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAV2 = new Intent(MainActivity.this , MainActivityAV2.class );
                intentAV2.putExtra(VERSION_KEY, 3);
                startActivity(intentAV2);

            }
        });

        getAvPosticipateFractionatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAV2 = new Intent(MainActivity.this , MainActivityAV2.class );
                intentAV2.putExtra(VERSION_KEY, 4);
                startActivity(intentAV2);

            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
