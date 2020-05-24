package com.example.ezmaths.Anuitati2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ezmaths.Anuitati2.AntiPost.MainActivityAnuitatiAntiPost;
import com.example.ezmaths.Anuitati2.AntiPost.ui.main.SectionsPagerAdapter;
import com.example.ezmaths.R;

public class MainActivityAnuitati extends AppCompatActivity {

    public final static String TYPE_KEY = "type_key";
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_anuitati);

        Button avPosticipateBtn = findViewById(R.id.avPosticipatebtn);
        Button avAnticipateBtn = findViewById(R.id.avAnticipatebtn);
        Button avDecesBtn = findViewById(R.id.avDecesbtn);

        avPosticipateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivityAnuitati.this, MainActivityAnuitatiAntiPost.class);
                intent1.putExtra(TYPE_KEY, 1);
                startActivity(intent1);


            }
        });

        avAnticipateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivityAnuitati.this, MainActivityAnuitatiAntiPost.class);
                type = 2;
                intent2.putExtra(TYPE_KEY, 2);
                startActivity(intent2);
            }
        });

        avDecesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
