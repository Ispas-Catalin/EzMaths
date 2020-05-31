package com.example.ezmaths.Rambursari.ui.main;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.ezmaths.Rambursari.AlgoritmRambursariSimplu;
import com.example.ezmaths.R;
import com.example.ezmaths.Rambursari.ActivityRambursariTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Rambursari1Fragment extends Fragment {

    private TextView sumaTV;
    private EditText sumaET;

    private TextView dobandaTV;
    private EditText dobandaET;
    private TextView nPlatiTV;
    private EditText nPlatiEt;
    private CheckBox nPlaticheckbox;

    private TextView numarLuniTV;
    private EditText numarLuniET;

    private Button rCalculateBtn;


    private TextView acumulareTitle, acumulareTitleTopAux, acumulareTitleBottomAux;

    private TextView dobandaTVacum, nPlatiTVacum, numarLuniTVacum;
    private EditText dobandaETacum, nPlatiETacum, numarLuniETacum;

    private CheckBox nPlaticheckBoxacum, acumulareCheckBox;

    public static final String KRAMBURSARI_KEY = "krambursari_key";
    public static final String RKAMBURSARI_KEY = "rkrambursari_key";
    public static final String DKRAMBURSARI_KEY = "dkrambursari_key";
    public static final String QKRAMBURSARI_KEY = "qkrambursari_key";
    public static final String OMEGAKRAMBURSARI_KEY = "omegakrambursari_key";


    private AlgoritmRambursariSimplu algoritmRambursariSimplu = new AlgoritmRambursariSimplu();

    private int ok;
    private int type;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rambursari1, container, false);


        sumaTV = rootView.findViewById(R.id.sumarTV);
        sumaET = rootView.findViewById(R.id.sumarET);

        dobandaTV = rootView.findViewById(R.id.dobandaTV);
        dobandaET = rootView.findViewById(R.id.dobandaET);
        nPlatiTV = rootView.findViewById(R.id.nPlatiTV);
        nPlatiEt = rootView.findViewById(R.id.nPlatiEt);
        nPlaticheckbox = rootView.findViewById(R.id.nPlaticheckbox);

        numarLuniET = rootView.findViewById(R.id.numariLuniET);
        numarLuniTV = rootView.findViewById(R.id.numarLuniTV);

        rCalculateBtn = rootView.findViewById(R.id.rCalculateBtn);

        acumulareTitle = rootView.findViewById(R.id.acumulareTitle);
        acumulareTitleTopAux = rootView.findViewById(R.id.middleAux);
        acumulareTitleBottomAux = rootView.findViewById(R.id.acumulareAux);

        dobandaTVacum = rootView.findViewById(R.id.dobandaTVacum);
        dobandaETacum = rootView.findViewById(R.id.dobandaETacum);
        nPlatiTVacum = rootView.findViewById(R.id.nPlatiTVacum);
        nPlatiETacum = rootView.findViewById(R.id.nPlatiEtacum);
        nPlaticheckBoxacum = rootView.findViewById(R.id.nPlatiCheckboxacum);

        numarLuniETacum = rootView.findViewById(R.id.numariLuniETacum);
        numarLuniTVacum = rootView.findViewById(R.id.numarLuniTVacum);

        acumulareCheckBox = rootView.findViewById(R.id.acumulareCheckBox);

         ok = 0;

        nPlaticheckbox.setChecked(false);
        nPlatiEt.setEnabled(false);
        nPlatiTV.setTextColor(Objects.requireNonNull(getActivity()).getResources().getColor(R.color.silver));

        final String [] rambursari = {
                "Rate constante",
                "Cote constante",
                "Plata dobanzilor",
                "Plata integrala la final"
        };

        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinnerRambursari);
        ArrayAdapter<String> LTRadapter = new ArrayAdapter<String>(Objects.requireNonNull(this.getActivity()), android.R.layout.simple_spinner_item, rambursari);
        LTRadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(LTRadapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = position;
                TransformUI(type);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        acumulareCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acumulareTransform(acumulareCheckBox.isChecked());
            }
        });

        nPlaticheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nPlatiTransform();
            }
        });

        nPlaticheckBoxacum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nPlatiAcumTransform();
            }
        });




        rCalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                List<String> KRambursari = null;
                List<String> RKRambursari = null;
                List<String> DKRambursari = null;
                List<String> OmegaKRambursari = null;
                List<String> QKRambursari = null;

                if(okToast())
                    Calculate();
                else if(!okToast())
                {
                    Toast toast = Toast.makeText(getActivity(), getString(R.string.ToastMessage), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 40);
                    toast.show();
                }


                Intent intent = new Intent(getActivity(), ActivityRambursariTable.class);

                if(okToast()) {
                    if (type == 0 || type == 2) {
                        if (!acumulareCheckBox.isChecked()) {
                            KRambursari = algoritmRambursariSimplu.getKRambursari();
                            RKRambursari = algoritmRambursariSimplu.getRKRambursari();
                            DKRambursari = algoritmRambursariSimplu.getDKRambursari();
                            OmegaKRambursari = algoritmRambursariSimplu.getOmegaKRambursari();
                            QKRambursari = algoritmRambursariSimplu.getQKRambursari();

                            intent.putStringArrayListExtra(KRAMBURSARI_KEY, (ArrayList<String>) KRambursari);
                            intent.putStringArrayListExtra(RKAMBURSARI_KEY, (ArrayList<String>) RKRambursari);
                            intent.putStringArrayListExtra(DKRAMBURSARI_KEY, (ArrayList<String>) DKRambursari);
                            intent.putStringArrayListExtra(OMEGAKRAMBURSARI_KEY, (ArrayList<String>) OmegaKRambursari);
                            intent.putStringArrayListExtra(QKRAMBURSARI_KEY, (ArrayList<String>) QKRambursari);


                            startActivity(intent);
                        } else {
                            KRambursari = algoritmRambursariSimplu.getKRambursari();
                            KRambursari.addAll(algoritmRambursariSimplu.getK_acumulare());

                            RKRambursari = algoritmRambursariSimplu.getRKRambursari();
                            RKRambursari.addAll(algoritmRambursariSimplu.getrk_acumulare());

                            DKRambursari = algoritmRambursariSimplu.getDKRambursari();
                            DKRambursari.addAll(algoritmRambursariSimplu.getSinK_acumulare());

                            OmegaKRambursari = algoritmRambursariSimplu.getOmegaKRambursari();
                            OmegaKRambursari.addAll(algoritmRambursariSimplu.getSfinK_acumulare());

                            QKRambursari = algoritmRambursariSimplu.getQKRambursari();
                            QKRambursari.addAll(algoritmRambursariSimplu.getDK_acumulare());


                            intent.putStringArrayListExtra(KRAMBURSARI_KEY, (ArrayList<String>) KRambursari);
                            intent.putStringArrayListExtra(RKAMBURSARI_KEY, (ArrayList<String>) RKRambursari);
                            intent.putStringArrayListExtra(DKRAMBURSARI_KEY, (ArrayList<String>) DKRambursari);
                            intent.putStringArrayListExtra(OMEGAKRAMBURSARI_KEY, (ArrayList<String>) OmegaKRambursari);
                            intent.putStringArrayListExtra(QKRAMBURSARI_KEY, (ArrayList<String>) QKRambursari);

                            startActivity(intent);
                        }
                    }
                }
                if (type == 1)
                {
                    KRambursari = algoritmRambursariSimplu.getKRambursari();
                    RKRambursari = algoritmRambursariSimplu.getRKRambursari();
                    DKRambursari = algoritmRambursariSimplu.getDKRambursari();
                    OmegaKRambursari = algoritmRambursariSimplu.getOmegaKRambursari();
                    QKRambursari = algoritmRambursariSimplu.getQKRambursari();

                    intent.putStringArrayListExtra(KRAMBURSARI_KEY, (ArrayList<String>) KRambursari);
                    intent.putStringArrayListExtra(RKAMBURSARI_KEY, (ArrayList<String>) RKRambursari);
                    intent.putStringArrayListExtra(DKRAMBURSARI_KEY, (ArrayList<String>) DKRambursari);
                    intent.putStringArrayListExtra(OMEGAKRAMBURSARI_KEY, (ArrayList<String>) OmegaKRambursari);
                    intent.putStringArrayListExtra(QKRAMBURSARI_KEY, (ArrayList<String>) QKRambursari);


                    startActivity(intent);
                }

                if (type == 3)
                {
                    KRambursari = algoritmRambursariSimplu.getK_acumulare();
                    RKRambursari = algoritmRambursariSimplu.getrk_acumulare();
                    DKRambursari = algoritmRambursariSimplu.getSinK_acumulare();
                    OmegaKRambursari = algoritmRambursariSimplu.getSfinK_acumulare();
                    QKRambursari = algoritmRambursariSimplu.getDK_acumulare();

                    intent.putStringArrayListExtra(KRAMBURSARI_KEY, (ArrayList<String>) KRambursari);
                    intent.putStringArrayListExtra(RKAMBURSARI_KEY, (ArrayList<String>) RKRambursari);
                    intent.putStringArrayListExtra(DKRAMBURSARI_KEY, (ArrayList<String>) DKRambursari);
                    intent.putStringArrayListExtra(OMEGAKRAMBURSARI_KEY, (ArrayList<String>) OmegaKRambursari);
                    intent.putStringArrayListExtra(QKRAMBURSARI_KEY, (ArrayList<String>) QKRambursari);


                    startActivity(intent);
                }

            }
        });


        return rootView;
    }

    private void Calculate () {
        if (type == 0)
        {
            if(!nPlaticheckbox.isChecked())
            {
                algoritmRambursariSimplu.Generare_oSinguraPlata_RateConstante(Double.parseDouble(sumaET.getText().toString()), Double.parseDouble(numarLuniET.getText().toString())/12, Double.parseDouble(dobandaET.getText().toString()));
            }
            else if(nPlaticheckbox.isChecked())
            {
                algoritmRambursariSimplu.Generare_MaiMultePlati_RateConstante(Double.parseDouble(sumaET.getText().toString()), Integer.parseInt(nPlatiEt.getText().toString()), Double.parseDouble(numarLuniET.getText().toString())/12, Double.parseDouble(dobandaET.getText().toString()));
            }
            if (acumulareCheckBox.isChecked())
            {
                if (!nPlaticheckBoxacum.isChecked())
                {
                    algoritmRambursariSimplu.generare_fond_acumulare_rateConstante(Double.parseDouble(dobandaETacum.getText().toString()), Double.parseDouble(numarLuniETacum.getText().toString())/12, 1);
                }
                else if (nPlaticheckBoxacum.isChecked())
                {
                    algoritmRambursariSimplu.generare_fond_acumulare_rateConstante(Double.parseDouble(dobandaETacum.getText().toString()), Double.parseDouble(numarLuniETacum.getText().toString())/12, Double.parseDouble(nPlatiETacum.getText().toString()));
                }
            }
        }

        if (type == 1)
        {
            if(!nPlaticheckbox.isChecked())
            {
                algoritmRambursariSimplu.Generare_OSinguraPlata_CoteConstante(Double.parseDouble(sumaET.getText().toString()), Double.parseDouble(numarLuniET.getText().toString())/12, Double.parseDouble(dobandaET.getText().toString()));
            }
            else if(nPlaticheckbox.isChecked())
            {
                algoritmRambursariSimplu.Generare_MaiMultePlatiPeAn_CoteConstante(Double.parseDouble(sumaET.getText().toString()), Double.parseDouble(numarLuniET.getText().toString())/12, Integer.parseInt(nPlatiEt.getText().toString()), Double.parseDouble(dobandaET.getText().toString()));
            }
        }

        if (type == 2)
        {
            if (!nPlaticheckbox.isChecked())
            {
                algoritmRambursariSimplu.Generare_Plata_Dobanzilor(Double.parseDouble(sumaET.getText().toString()),Double.parseDouble(numarLuniET.getText().toString())/12,1,Double.parseDouble(dobandaET.getText().toString()));
            }
            else if (nPlaticheckbox.isChecked())
            {
                algoritmRambursariSimplu.Generare_Plata_Dobanzilor(Double.parseDouble(sumaET.getText().toString()),Double.parseDouble(numarLuniET.getText().toString())/12,Double.parseDouble(nPlatiEt.getText().toString()),Double.parseDouble(dobandaET.getText().toString()));
            }
            if (acumulareCheckBox.isChecked())
            {
                if (!nPlaticheckBoxacum.isChecked())
                {
                    algoritmRambursariSimplu.generare_fond_acumulare(Double.parseDouble(sumaET.getText().toString()),Double.parseDouble(dobandaETacum.getText().toString()), Double.parseDouble(numarLuniETacum.getText().toString())/12,1);
                }
                else if (nPlaticheckBoxacum.isChecked())
                {
                    algoritmRambursariSimplu.generare_fond_acumulare(Double.parseDouble(sumaET.getText().toString()),Double.parseDouble(dobandaETacum.getText().toString()), Double.parseDouble(numarLuniETacum.getText().toString())/12,Double.parseDouble(nPlatiETacum.getText().toString()));
                }
            }
        }

        if (type == 3)
        {
            if (!nPlaticheckBoxacum.isChecked())
            {
                algoritmRambursariSimplu.generare_fond_acumulare_INTEGRAL(Double.parseDouble(sumaET.getText().toString()),Double.parseDouble(dobandaETacum.getText().toString()),Double.parseDouble(numarLuniETacum.getText().toString())/12,1 ,Double.parseDouble(dobandaET.getText().toString()), Double.parseDouble(numarLuniET.getText().toString())/12);
            }
            else if (nPlaticheckBoxacum.isChecked())
            {
                algoritmRambursariSimplu.generare_fond_acumulare_INTEGRAL(Double.parseDouble(sumaET.getText().toString()),Double.parseDouble(dobandaETacum.getText().toString()),Double.parseDouble(numarLuniETacum.getText().toString())/12,Double.parseDouble(nPlatiETacum.getText().toString()) ,Double.parseDouble(dobandaET.getText().toString()), Double.parseDouble(numarLuniET.getText().toString())/12);
            }
        }

    }

    private Boolean okToast () {
        boolean ok;
        ok = true;
        if (type == 0)
        {
            if(!nPlaticheckbox.isChecked())
            {
                if(sumaET.getText().toString().isEmpty() || dobandaET.getText().toString().isEmpty() || numarLuniET.getText().toString().isEmpty())
                    ok = false;
            }
            else if(nPlaticheckbox.isChecked())
            {
                if(sumaET.getText().toString().isEmpty() || dobandaET.getText().toString().isEmpty() || numarLuniET.getText().toString().isEmpty() || nPlatiEt.getText().toString().isEmpty())
                    ok = false;
            }
            if (acumulareCheckBox.isChecked())
            {
                if (!nPlaticheckBoxacum.isChecked())
                {
                    if(dobandaETacum.getText().toString().isEmpty() || numarLuniETacum.getText().toString().isEmpty())
                       ok = false;
                }
                else if (nPlaticheckBoxacum.isChecked())
                {
                    if(dobandaETacum.getText().toString().isEmpty() || numarLuniETacum.getText().toString().isEmpty() || nPlatiETacum.getText().toString().isEmpty())
                        ok = false;
                }
            }

        }
        if (type == 1)
        {
            if(!nPlaticheckbox.isChecked())
            {
                if(sumaET.getText().toString().isEmpty() || dobandaET.getText().toString().isEmpty() || numarLuniET.getText().toString().isEmpty())
                    ok = false;

            }
            else if(nPlaticheckbox.isChecked())
            {
                if(sumaET.getText().toString().isEmpty() || dobandaET.getText().toString().isEmpty() || numarLuniET.getText().toString().isEmpty() || nPlatiEt.getText().toString().isEmpty())
                    ok = false;
            }
        }
        if (type == 2)
        {
            if(!nPlaticheckbox.isChecked())
            {
                if(sumaET.getText().toString().isEmpty() || dobandaET.getText().toString().isEmpty() || numarLuniET.getText().toString().isEmpty())
                    ok = false;
            }
            else if(nPlaticheckbox.isChecked())
            {
                if(sumaET.getText().toString().isEmpty() || dobandaET.getText().toString().isEmpty() || numarLuniET.getText().toString().isEmpty() || nPlatiEt.getText().toString().isEmpty())
                    ok = false;
            }
            if (acumulareCheckBox.isChecked())
            {
                if (!nPlaticheckBoxacum.isChecked())
                {
                    if(dobandaETacum.getText().toString().isEmpty() || numarLuniETacum.getText().toString().isEmpty())
                        ok = false;
                }
                else if (nPlaticheckBoxacum.isChecked())
                {
                    if(dobandaETacum.getText().toString().isEmpty() || numarLuniETacum.getText().toString().isEmpty() || nPlatiETacum.getText().toString().isEmpty())
                        ok = false;
                }
            }
        }
        if (type == 3)
        {
            if (!nPlaticheckBoxacum.isChecked())
            {
               if (sumaET.getText().toString().isEmpty() || dobandaETacum.getText().toString().isEmpty() || numarLuniETacum.getText().toString().isEmpty() || dobandaET.getText().toString().isEmpty() || numarLuniET.getText().toString().isEmpty());
                ok=false;
            }
            else if (nPlaticheckBoxacum.isChecked())
            {
                if (sumaET.getText().toString().isEmpty() || nPlatiETacum.getText().toString().isEmpty() || dobandaETacum.getText().toString().isEmpty() || numarLuniETacum.getText().toString().isEmpty() || dobandaET.getText().toString().isEmpty() || numarLuniET.getText().toString().isEmpty());
                ok=false;
            }
        }

        return ok;
    }

    private void TransformUI(int type)
    {
        if (type == 0)
        {
            nPlatiTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            nPlatiEt.setEnabled(true);
            nPlaticheckbox.setEnabled(true);
            nPlaticheckbox.setVisibility(View.VISIBLE);

            acumulareTitle.setVisibility(View.VISIBLE);
            acumulareTitleTopAux.setVisibility(View.VISIBLE);
            acumulareTitleBottomAux.setVisibility(View.VISIBLE);
            acumulareCheckBox.setVisibility(View.VISIBLE);
            acumulareCheckBox.setChecked(false);
            acumulareCheckBox.setEnabled(true);

            dobandaTVacum.setVisibility(View.VISIBLE);
            dobandaETacum.setVisibility(View.VISIBLE);
            dobandaETacum.setEnabled(true);

            nPlatiTVacum.setVisibility(View.VISIBLE);
            nPlatiETacum.setVisibility(View.VISIBLE);
            nPlatiETacum.setEnabled(true);
            nPlaticheckBoxacum.setVisibility(View.VISIBLE);
            nPlaticheckBoxacum.setEnabled(true);

            numarLuniTVacum.setVisibility(View.VISIBLE);
            numarLuniETacum.setVisibility(View.VISIBLE);
            numarLuniETacum.setEnabled(true);

            dobandaET.setText("");
            nPlatiEt.setText("");
            nPlatiETacum.setText("");
            numarLuniET.setText("");
            numarLuniETacum.setText("");
            dobandaETacum.setText("");
            sumaET.setText("");

            acumulareTransform(false);

        }
        else if (type == 1)
        {
            nPlatiTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            nPlatiEt.setEnabled(true);
            nPlaticheckbox.setEnabled(true);
            nPlaticheckbox.setVisibility(View.VISIBLE);

            acumulareTitle.setVisibility(View.INVISIBLE);
            acumulareTitleTopAux.setVisibility(View.INVISIBLE);
            acumulareTitleBottomAux.setVisibility(View.INVISIBLE);
            acumulareCheckBox.setVisibility(View.INVISIBLE);
            acumulareCheckBox.setChecked(false);
            acumulareCheckBox.setEnabled(false);

            dobandaTVacum.setVisibility(View.INVISIBLE);
            dobandaETacum.setVisibility(View.INVISIBLE);
            dobandaETacum.setEnabled(false);

            nPlatiTVacum.setVisibility(View.INVISIBLE);
            nPlatiETacum.setVisibility(View.INVISIBLE);
            nPlatiETacum.setEnabled(false);
            nPlaticheckBoxacum.setVisibility(View.INVISIBLE);
            nPlaticheckBoxacum.setEnabled(false);

            numarLuniTVacum.setVisibility(View.INVISIBLE);
            numarLuniETacum.setVisibility(View.INVISIBLE);
            numarLuniETacum.setEnabled(false);

            dobandaET.setText("");
            nPlatiEt.setText("");
            nPlatiETacum.setText("");
            numarLuniET.setText("");
            numarLuniETacum.setText("");
            dobandaETacum.setText("");
            sumaET.setText("");

        }
        else if (type == 2)
        {
            nPlatiTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            nPlatiEt.setEnabled(true);
            nPlaticheckbox.setEnabled(true);
            nPlaticheckbox.setVisibility(View.VISIBLE);

            acumulareTitle.setVisibility(View.VISIBLE);
            acumulareTitleTopAux.setVisibility(View.VISIBLE);
            acumulareTitleBottomAux.setVisibility(View.VISIBLE);
            acumulareCheckBox.setVisibility(View.VISIBLE);
            acumulareCheckBox.setChecked(false);
            acumulareCheckBox.setEnabled(true);

            dobandaTVacum.setVisibility(View.VISIBLE);
            dobandaETacum.setVisibility(View.VISIBLE);
            dobandaETacum.setEnabled(true);

            nPlatiTVacum.setVisibility(View.VISIBLE);
            nPlatiETacum.setVisibility(View.VISIBLE);
            nPlatiETacum.setEnabled(true);
            nPlaticheckBoxacum.setVisibility(View.VISIBLE);
            nPlaticheckBoxacum.setEnabled(true);

            numarLuniTVacum.setVisibility(View.VISIBLE);
            numarLuniETacum.setVisibility(View.VISIBLE);
            numarLuniETacum.setEnabled(true);

            dobandaET.setText("");
            nPlatiEt.setText("");
            nPlatiETacum.setText("");
            numarLuniET.setText("");
            numarLuniETacum.setText("");
            dobandaETacum.setText("");
            sumaET.setText("");

            acumulareTransform(false);

        }
        else if (type == 3)
        {
            nPlatiTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            nPlatiEt.setEnabled(false);
            nPlaticheckbox.setEnabled(false);
            nPlaticheckbox.setVisibility(View.INVISIBLE);

            acumulareTitle.setVisibility(View.VISIBLE);
            acumulareTitleTopAux.setVisibility(View.VISIBLE);
            acumulareTitleBottomAux.setVisibility(View.VISIBLE);
            acumulareCheckBox.setVisibility(View.INVISIBLE);
            acumulareCheckBox.setChecked(true);
            acumulareCheckBox.setEnabled(false);

            dobandaTVacum.setVisibility(View.VISIBLE);
            dobandaETacum.setVisibility(View.VISIBLE);
            dobandaETacum.setEnabled(true);

            nPlatiTVacum.setVisibility(View.VISIBLE);
            nPlatiETacum.setVisibility(View.VISIBLE);
            nPlatiETacum.setEnabled(true);
            nPlaticheckBoxacum.setVisibility(View.VISIBLE);
            nPlaticheckBoxacum.setEnabled(true);

            numarLuniTVacum.setVisibility(View.VISIBLE);
            numarLuniETacum.setVisibility(View.VISIBLE);
            numarLuniETacum.setEnabled(true);

            dobandaET.setText("");
            nPlatiEt.setText("");
            nPlatiETacum.setText("");
            numarLuniET.setText("");
            numarLuniETacum.setText("");
            dobandaETacum.setText("");
            sumaET.setText("");

            acumulareTransform(true);
        }

        nPlatiTransform();
        nPlatiAcumTransform();
    }

    private void acumulareTransform(boolean isChecked)
    {
        if (!isChecked)
        {
           dobandaTVacum.setTextColor(getActivity().getResources().getColor(R.color.silver));
           dobandaETacum.setEnabled(false);

           nPlatiTVacum.setTextColor(getActivity().getResources().getColor(R.color.silver));
           nPlatiETacum.setEnabled(false);
           nPlaticheckBoxacum.setEnabled(false);
           nPlaticheckBoxacum.setChecked(false);

           numarLuniTVacum.setTextColor(getActivity().getResources().getColor(R.color.silver));
           numarLuniETacum.setEnabled(false);
           nPlatiAcumTransform();
        }
        else {
            dobandaTVacum.setTextColor(getActivity().getResources().getColor(R.color.black));
            dobandaETacum.setEnabled(true);

            nPlaticheckBoxacum.setEnabled(true);
            nPlaticheckBoxacum.setChecked(false);
            nPlatiAcumTransform();

            numarLuniTVacum.setTextColor(getActivity().getResources().getColor(R.color.black));
            numarLuniETacum.setEnabled(true);
        }
    }


    private void nPlatiTransform()
    {
        if (nPlaticheckbox.isChecked())
        {
            nPlatiEt.setEnabled(true);
            nPlatiTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            nPlatiEt.setText("");
        }
        else if (!nPlaticheckbox.isChecked())
        {
            nPlatiEt.setEnabled(false);
            nPlatiTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            nPlatiEt.setText("");
        }
    }

    private void nPlatiAcumTransform()
    {
        if (nPlaticheckBoxacum.isChecked())
        {
            nPlatiETacum.setEnabled(true);
            nPlatiTVacum.setTextColor(getActivity().getResources().getColor(R.color.black));
            nPlatiETacum.setText("");
        }
        else if (!nPlaticheckBoxacum.isChecked())
        {
            nPlatiETacum.setEnabled(false);
            nPlatiTVacum.setTextColor(getActivity().getResources().getColor(R.color.silver));
            nPlatiETacum.setText("");
        }
    }
}