package com.icicezmaths.ezmaths.Anuitati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.icicezmaths.ezmaths.Anuitati.Deces.MainActivityAnuitatiDeces;
import com.icicezmaths.ezmaths.Anuitati.AntiPost.MainActivityAnuitatiAntiPost;
import com.icicezmaths.ezmaths.Anuitati.FactorActualizareViager.MainActivityFactorViager;
import com.icicezmaths.ezmaths.R;

public class MainActivityAnuitati extends AppCompatActivity {

    public final static String TYPE_KEY = "type_key";
    private int type;

    Button backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_anuitati);

        Button avPosticipateBtn = findViewById(R.id.avPosticipatebtn);
        Button avAnticipateBtn = findViewById(R.id.avAnticipatebtn);
        Button avDecesBtn = findViewById(R.id.avDecesbtn);
        Button avFactor = findViewById(R.id.avFactorbtn);

        backbtn = findViewById(R.id.backbtn);

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
                Intent intet3 = new Intent(MainActivityAnuitati.this, MainActivityAnuitatiDeces.class);
                startActivity(intet3);
            }
        });

        avFactor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intet4 = new Intent(MainActivityAnuitati.this, MainActivityFactorViager.class);
                startActivity(intet4);
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
