package com.example.ezmaths.Asigurari.AsigurariViata.PlataUnica;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CaseMap;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ezmaths.Asigurari.FormuleAsigurari;
import com.example.ezmaths.R;

import java.text.NumberFormat;

public class AsigurariViataUnicaActivity extends AppCompatActivity {


    TextView titleTV;
    TextView resultTV;
    Button backbtn;

    TextView nAsigurareTV;
    EditText nAsigurareET;

    TextView xAsigurareTV;
    TextView xAsigurareET;

    TextView primaAsiguratorTV;
    EditText primaAsiguratorET;
    CheckBox primaAsiguratorCheckBox;

    TextView primaAsiguratTV;
    EditText primaAsiguratET;
    CheckBox primaAsiguratCheckBox;

    Button calculeazaBtn;
    private NumberFormat resfmt;

    private double dres;

    FormuleAsigurari formuleAsigurari = new FormuleAsigurari();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asigurari_viata_unica);

        resultTV = findViewById(R.id.resultAsigTVuv);
        backbtn = findViewById(R.id.backbtnuv);

        nAsigurareTV = findViewById(R.id.nAsigurareTVvu);
        nAsigurareET = findViewById(R.id.nAsigurareETvu);

        xAsigurareTV = findViewById(R.id.xAsigurareTVvu);
        xAsigurareET = findViewById(R.id.xAsigurareETvu);

        primaAsiguratorTV = findViewById(R.id.primaAsiguratorTVvu);
        primaAsiguratorET = findViewById(R.id.primaAsiguratorETvu);
        primaAsiguratorCheckBox = findViewById(R.id.primaAsiguratorCheckBoxTVvu);

        primaAsiguratTV = findViewById(R.id.primaAsiguratTVvu);
        primaAsiguratET = findViewById(R.id.primaAsiguratETvu);
        primaAsiguratCheckBox = findViewById(R.id.primaAsiguratCheckBoxTVvu);

        calculeazaBtn = findViewById(R.id.calculeazaAsigurareBtnvu);

        primaAsiguratorCheckBox.setChecked(true);
        primaAsiguratCheckBox.setChecked(false);
        primaAsiguratET.setEnabled(false);
        primaAsiguratTV.setTextColor(getColor(R.color.silver));

        primaAsiguratorCheckBox.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                if (primaAsiguratorCheckBox.isChecked())
                {
                    primaAsiguratorET.setEnabled(true);
                    primaAsiguratorTV.setTextColor(getColor(R.color.black));
                    primaAsiguratCheckBox.setChecked(false);
                    primaAsiguratET.setEnabled(false);
                    primaAsiguratET.setText("");
                    primaAsiguratTV.setTextColor(getColor(R.color.silver));
                }
            }
        });

        primaAsiguratCheckBox.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                if (primaAsiguratCheckBox.isChecked())
                {
                    primaAsiguratET.setEnabled(true);
                    primaAsiguratTV.setTextColor(getColor(R.color.black));
                    primaAsiguratorCheckBox.setChecked(false);
                    primaAsiguratorET.setEnabled(false);
                    primaAsiguratorET.setText("");
                    primaAsiguratorTV.setTextColor(getColor(R.color.silver));
                }
            }
        });

        resfmt = NumberFormat.getInstance();
        resfmt.setMaximumFractionDigits(4);

        calculeazaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (primaAsiguratCheckBox.isChecked())
                {
                    if (primaAsiguratET.getText().toString().isEmpty() || nAsigurareET.getText().toString().isEmpty() || xAsigurareET.getText().toString().isEmpty())
                    {
                        resultTV.setVisibility(View.INVISIBLE);
                        Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.ToastMessage), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.BOTTOM, 0, 40);
                        toast.show();
                    }
                    else
                    {
                     resultTV.setVisibility(View.VISIBLE);
                     dres = formuleAsigurari.asigViata_Unic_P(Double.parseDouble(primaAsiguratET.getText().toString()), Integer.parseInt(nAsigurareET.getText().toString()),Integer.parseInt(xAsigurareET.getText().toString()));
                     resultTV.setText(resfmt.format(dres));
                    }

                }
                else
                {
                    if (primaAsiguratorET.getText().toString().isEmpty() || nAsigurareET.getText().toString().isEmpty() || xAsigurareET.getText().toString().isEmpty())
                    {
                        resultTV.setVisibility(View.INVISIBLE);
                        Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.ToastMessage), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.BOTTOM, 0, 40);
                        toast.show();
                    }
                    else
                    {
                        resultTV.setVisibility(View.VISIBLE);
                        dres = formuleAsigurari.asigViata_Unic_S(Double.parseDouble(primaAsiguratorET.getText().toString()), Integer.parseInt(nAsigurareET.getText().toString()),Integer.parseInt(xAsigurareET.getText().toString()));
                        resultTV.setText(resfmt.format(dres));
                    }
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
