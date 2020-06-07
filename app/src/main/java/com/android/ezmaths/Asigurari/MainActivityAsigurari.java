package com.android.ezmaths.Asigurari;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.android.ezmaths.Asigurari.AsigurariPensiiDeces.MainActivityAsigPensiiDecesUnica;
import com.android.ezmaths.Asigurari.AsigurariViata.MaiMultePlati.AsigurariViataMaiMultePlatiMainActivity;
import com.android.ezmaths.Asigurari.AsigurariViata.PlataUnica.AsigurariViataUnicaActivity;
import com.android.ezmaths.R;

public class MainActivityAsigurari extends AppCompatActivity {

    TextView asigurariTitle;
    Button backbtn;

    Button asigurariViataBtn;
    Button asigurariPensiiBtn;
    Button asigurariDecesBtn;

    CheckBox platiCheckBox;
    TextView platiTV;

    private AnuitatiViewModel anuitatiViewModel = new AnuitatiViewModel();

    public final static String ATYPE_KEY = "atype_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_asigurari);

        asigurariTitle = findViewById(R.id.asigurariTitle);
        backbtn = findViewById(R.id.backbtn);

        asigurariViataBtn = findViewById(R.id.asigurariViatabtn);
        asigurariPensiiBtn = findViewById(R.id.asigurariPensiiBtn);
        asigurariDecesBtn = findViewById(R.id.asigurariDecesBtn);

        platiCheckBox = findViewById(R.id.platiCheckBox);
        platiTV = findViewById(R.id.platiTV);


        asigurariViataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (!platiCheckBox.isChecked())
                    {
                        Intent intent11 = new Intent(MainActivityAsigurari.this, AsigurariViataUnicaActivity.class);
                        intent11.putExtra(ATYPE_KEY, 11);
                        startActivity(intent11);
                    }
                    else if(platiCheckBox.isChecked())
                    {
                        Intent intent12 = new Intent(MainActivityAsigurari.this, AsigurariViataMaiMultePlatiMainActivity.class);
                        intent12.putExtra(ATYPE_KEY, 12);
                        startActivity(intent12);
                    }
            }
        });

        asigurariPensiiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!platiCheckBox.isChecked())
                {
                    Intent intent21 = new Intent(MainActivityAsigurari.this, MainActivityAsigPensiiDecesUnica.class);
                    intent21.putExtra(ATYPE_KEY, 21);
                    startActivity(intent21);
                }
                else if(platiCheckBox.isChecked())
                {
                    Intent intent22 = new Intent(MainActivityAsigurari.this, MainActivityAsigPensiiDecesUnica.class);
                    intent22.putExtra(ATYPE_KEY, 22);
                    startActivity(intent22);
                }
            }
        });


        asigurariDecesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!platiCheckBox.isChecked())
                {
                    Intent intent31 = new Intent(MainActivityAsigurari.this, MainActivityAsigPensiiDecesUnica.class);
                    intent31.putExtra(ATYPE_KEY, 31);
                    startActivity(intent31);
                }
                else if(platiCheckBox.isChecked())
                {
                    Intent intent32 = new Intent(MainActivityAsigurari.this, MainActivityAsigPensiiDecesUnica.class);
                    intent32.putExtra(ATYPE_KEY, 32);
                    startActivity(intent32);
                }
            }
        });



        platiCheckBox.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (!platiCheckBox.isChecked())
                {
                    platiTV.setTextColor(getColor(R.color.silver));
                    asigurariTitle.setText("Asigurari cu plata unica");
                }
                else if (platiCheckBox.isChecked())
                {
                    platiTV.setTextColor(getColor(R.color.black));
                    asigurariTitle.setText("Asigurari cu mai multe plati");
                }
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
