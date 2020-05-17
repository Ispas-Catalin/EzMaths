package com.example.ezmaths;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityAV2 extends AppCompatActivity {

    TextView av2Title ;
    Button backbtn;
    int type;
    int version;

    public static final String TYPE_KEY = "type_key";
    private static final int HOME_REQUEST_CODE = 1;

    Button imediataNelimitatabtn;
    Button imediataLimitatabtn;
    Button amanataNelimitatabtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_a_v2);

        av2Title = findViewById(R.id.av2Title);
        backbtn = findViewById(R.id.backbtn);

        imediataNelimitatabtn = findViewById(R.id.imediataNelimitatabtn);
        imediataLimitatabtn = findViewById(R.id.imediataLimitatabtn);
        amanataNelimitatabtn = findViewById(R.id.amanataNelimitatabtn);

        Bundle bundle = getIntent().getExtras();

        if(bundle!= null)
        {
            version = bundle.getInt(MainActivity.VERSION_KEY);
        }


        setTitle(version);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imediataNelimitatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivityAV2.this, MainActivityAV3.class);
                type = version*10 + 1;
                intent1.putExtra(TYPE_KEY,type);
                startActivityForResult(intent1, HOME_REQUEST_CODE);
            }
        });

        imediataLimitatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivityAV2.this, MainActivityAV3.class);
                type = version*10 + 2;
                intent2.putExtra(TYPE_KEY,type);
                startActivityForResult(intent2, HOME_REQUEST_CODE);
            }
        });

        amanataNelimitatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivityAV2.this, MainActivityAV3.class);
                type = version*10 + 3;
                intent3.putExtra(TYPE_KEY,type);
                startActivityForResult(intent3, HOME_REQUEST_CODE);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == HOME_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                finish();
            }
        }
    }


    public void setTitle(int version)
    {
        if(version == 1)
        {
            av2Title.setText(getString(R.string.avpi));
        }
        else if (version == 2)
        {
            av2Title.setText(getString(R.string.avpf));
        }
        else if (version == 3)
        {
            av2Title.setText(getString(R.string.avai));
        }
        else if (version == 4)
        {
            av2Title.setText(getString(R.string.avaf));
        }
    }

}

