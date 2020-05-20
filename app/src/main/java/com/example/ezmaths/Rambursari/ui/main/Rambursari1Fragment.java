package com.example.ezmaths.Rambursari.ui.main;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.ezmaths.Rambursari.AlgoritmRambursariSimplu;
import com.example.ezmaths.R;
import com.example.ezmaths.Rambursari.ActivityRambursariTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Rambursari1Fragment extends Fragment {

    private TextView rConstanteTV;
    private TextView cConstanteTV;
    private CheckBox checkboxRC;
    private CheckBox checkboxCC;

    private TextView sumaTV;
    private EditText sumaET;

    private TextView dobandaTV;
    private EditText dobandaET;
    private TextView nPlatiTV;
    private EditText nPlatiEt;
    private CheckBox nPlaticheckbox;

    private TextView numarAniTV;
    private EditText numarAniET;

    private Button rCalculateBtn;

    public static final String KRAMBURSARI_KEY = "krambursari_key";
    public static final String RKAMBURSARI_KEY = "rkrambursari_key";
    public static final String DKRAMBURSARI_KEY = "dkrambursari_key";
    public static final String QKRAMBURSARI_KEY = "qkrambursari_key";
    public static final String OMEGAKRAMBURSARI_KEY = "omegakrambursari_key";

    AlgoritmRambursariSimplu algoritmRambursariSimplu = new AlgoritmRambursariSimplu();

    int ok;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rambursari1, container, false);

        rConstanteTV = rootView.findViewById(R.id.rConstanteTV);
        cConstanteTV = rootView.findViewById(R.id.cConstanteTV);
        checkboxRC = rootView.findViewById(R.id.checkboxRC);
        checkboxCC = rootView.findViewById(R.id.checkboxCC);

        sumaTV = rootView.findViewById(R.id.sumarTV);
        sumaET = rootView.findViewById(R.id.sumarET);

        dobandaTV = rootView.findViewById(R.id.dobandaTV);
        dobandaET = rootView.findViewById(R.id.dobandaET);
        nPlatiTV = rootView.findViewById(R.id.nPlatiTV);
        nPlatiEt = rootView.findViewById(R.id.nPlatiEt);
        nPlaticheckbox = rootView.findViewById(R.id.nPlaticheckbox);

        numarAniET = rootView.findViewById(R.id.numariAniET);
        numarAniTV = rootView.findViewById(R.id.numarAniTV);

        rCalculateBtn = rootView.findViewById(R.id.rCalculateBtn);

         ok = 0;

         checkboxRC.setChecked(true);

        checkboxRC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkboxCC.setChecked(false);
            }
        });

        checkboxCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkboxRC.setChecked(false);
            }
        });

        nPlaticheckbox.setChecked(false);
        nPlatiEt.setEnabled(false);
        nPlatiTV.setTextColor(Objects.requireNonNull(getActivity()).getResources().getColor(R.color.silver));

        nPlaticheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nPlaticheckbox.isChecked())
                {
                    nPlatiEt.setEnabled(true);
                    nPlatiTV.setTextColor(Objects.requireNonNull(getActivity()).getResources().getColor(R.color.black));
                }
                else if (!nPlaticheckbox.isChecked())
                {
                    nPlatiEt.setEnabled(false);
                    nPlatiTV.setTextColor(Objects.requireNonNull(getActivity()).getResources().getColor(R.color.silver));
                }
            }
        });



        rCalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActivityRambursariTable.class);

                Calculate();

                List<String> KRambursari = algoritmRambursariSimplu.getKRambursari();
                List<String> RKRambursari = algoritmRambursariSimplu.getRKRambursari();
                List<String> DKRambursari = algoritmRambursariSimplu.getDKRambursari();
                List<String> OmegaKRambursari = algoritmRambursariSimplu.getOmegaKRambursari();
                List<String> QKRambursari = algoritmRambursariSimplu.getQKRambursari();

                intent.putStringArrayListExtra(KRAMBURSARI_KEY, (ArrayList<String>) KRambursari);
                intent.putStringArrayListExtra(RKAMBURSARI_KEY, (ArrayList<String>) RKRambursari);
                intent.putStringArrayListExtra(DKRAMBURSARI_KEY, (ArrayList<String>) DKRambursari);
                intent.putStringArrayListExtra(OMEGAKRAMBURSARI_KEY, (ArrayList<String>) OmegaKRambursari);
                intent.putStringArrayListExtra(QKRAMBURSARI_KEY, (ArrayList<String>) QKRambursari);


            }
        });


        return rootView;
    }

    private void Calculate ()
    {
        if (checkboxRC.isChecked())
        {
            if(!nPlaticheckbox.isChecked())
            {
                algoritmRambursariSimplu.Generare_oSinguraPlata_RateConstante(Double.parseDouble(sumaET.getText().toString()), Integer.parseInt(numarAniET.getText().toString()), Double.parseDouble(dobandaET.getText().toString()));
            }
            else if(nPlaticheckbox.isChecked())
            {
                algoritmRambursariSimplu.Generare_MaiMultePlati_RateConstante(Double.parseDouble(sumaET.getText().toString()), Integer.parseInt(nPlatiEt.getText().toString()), Integer.parseInt(numarAniET.getText().toString()), Double.parseDouble(dobandaET.getText().toString()));
            }
        }

        else if (checkboxCC.isChecked())
        {
            if(!nPlaticheckbox.isChecked())
            {
                algoritmRambursariSimplu.Generare_OSinguraPlata_CoteConstante(Double.parseDouble(sumaET.getText().toString()), Integer.parseInt(numarAniET.getText().toString()), Double.parseDouble(dobandaET.getText().toString()));
            }
            else if(nPlaticheckbox.isChecked())
            {
                algoritmRambursariSimplu.Generare_MaiMultePlatiPeAn_CoteConstante(Double.parseDouble(sumaET.getText().toString()), Integer.parseInt(nPlatiEt.getText().toString()), Integer.parseInt(numarAniET.getText().toString()), Double.parseDouble(dobandaET.getText().toString()));
            }
        }
    }

}