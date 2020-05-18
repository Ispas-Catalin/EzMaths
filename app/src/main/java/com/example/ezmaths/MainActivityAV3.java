package com.example.ezmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivityAV3 extends AppCompatActivity {

    Button backbtn;
    Button homebtn;
    Button infobtn;
    Button calculatebtn;
    TextView av3Title;

    EditText varstaET;
    EditText amlimET;
    EditText platiPeAnET;
    EditText sumaET;

    TextView amlimTV;
    TextView platiPeAnTV;

    TextView xTV;
    TextView nAmanataTV;
    TextView nImediataTVaux;
    TextView nImediataTV;
    TextView mTV;
    TextView pointsAnticipateTV ;
    TextView AmLimAuxTV;

    String varstaAux;
    String amlimAux;
    String platiPeAnAux;


    int type;
    double doubleRES;

    String aux;

    formuleAnuitati formuleAnuitati = new formuleAnuitati();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_a_v3);

        backbtn = findViewById(R.id.backbtn);
        homebtn = findViewById(R.id.homebtn);
        infobtn = findViewById(R.id.infobtn);
        calculatebtn = findViewById(R.id.calculatebtn);
        av3Title = findViewById(R.id.av3Title);

        varstaET = findViewById(R.id.varstaET);
        amlimET  = findViewById(R.id.amlimnET);
        platiPeAnET = findViewById(R.id.platiPeAnET);
        sumaET = findViewById(R.id.sumaET);


        amlimTV = findViewById(R.id.amlimnTV);
        platiPeAnTV = findViewById(R.id.platiPeAnTV);

        xTV = findViewById(R.id.xtv);
        nAmanataTV = findViewById(R.id.nAmanatatv);
        nImediataTVaux = findViewById(R.id.nImediatAuxtv);
        nImediataTV = findViewById(R.id.nImediatatv);
        mTV = findViewById(R.id.mtv);
        pointsAnticipateTV = findViewById(R.id.pointsAnticipatetv);
        AmLimAuxTV = findViewById(R.id.amlimauxTV);


        Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {
            type = bundle.getInt(MainActivityAV2.TYPE_KEY);
        }

        setTitle(type);

        /// UI transofrm

        if (type/10 <3)
        {
            pointsAnticipateTV.setVisibility(View.INVISIBLE);
            if(type/10 == 1)
            {
                mTV.setVisibility(View.INVISIBLE);
                platiPeAnET.setVisibility(View.INVISIBLE);
                platiPeAnET.setEnabled(false);
                platiPeAnTV.setVisibility(View.INVISIBLE);

                if (type%10 == 1) {
                nImediataTV.setVisibility(View.INVISIBLE);
                nAmanataTV.setVisibility(View.INVISIBLE);
                nImediataTVaux.setVisibility(View.INVISIBLE);
                amlimTV.setVisibility(View.INVISIBLE);
                AmLimAuxTV.setVisibility(View.INVISIBLE);
                amlimET.setVisibility(View.INVISIBLE);
                amlimET.setEnabled(false);
                }
                if (type%10 == 2) {
                    nAmanataTV.setVisibility(View.INVISIBLE);
                }
                if (type%10 == 3) {
                    nImediataTV.setVisibility(View.INVISIBLE);
                    nImediataTVaux.setVisibility(View.INVISIBLE);
                    amlimTV.setText(getString(R.string.amanata));
                }
            }
            else if (type/10 == 2)
            {
                if (type%10 == 1) {
                    nImediataTV.setVisibility(View.INVISIBLE);
                    nAmanataTV.setVisibility(View.INVISIBLE);
                    nImediataTVaux.setVisibility(View.INVISIBLE);
                    amlimTV.setVisibility(View.INVISIBLE);
                    AmLimAuxTV.setVisibility(View.INVISIBLE);
                    amlimET.setVisibility(View.INVISIBLE);
                    amlimET.setEnabled(false);
                }
                if (type%10 == 2) {
                    nAmanataTV.setVisibility(View.INVISIBLE);
                }
                if (type%10 == 3) {
                    nImediataTV.setVisibility(View.INVISIBLE);
                    nImediataTVaux.setVisibility(View.INVISIBLE);
                    amlimTV.setText(getString(R.string.amanata));
                }
            }
        }
        else if (type/10 >2)
        {
            if (type/10 == 3)
            {
                mTV.setVisibility(View.INVISIBLE);
                platiPeAnET.setVisibility(View.INVISIBLE);
                platiPeAnET.setEnabled(false);
                platiPeAnTV.setVisibility(View.INVISIBLE);

                if (type%10 == 1) {
                    nImediataTV.setVisibility(View.INVISIBLE);
                    nAmanataTV.setVisibility(View.INVISIBLE);
                    nImediataTVaux.setVisibility(View.INVISIBLE);
                    amlimTV.setVisibility(View.INVISIBLE);
                    AmLimAuxTV.setVisibility(View.INVISIBLE);
                    amlimET.setVisibility(View.INVISIBLE);
                    amlimET.setEnabled(false);
                }
                if (type%10 == 2) {
                    nAmanataTV.setVisibility(View.INVISIBLE);
                }
                if (type%10 == 3) {
                    nImediataTV.setVisibility(View.INVISIBLE);
                    nImediataTVaux.setVisibility(View.INVISIBLE);
                    amlimTV.setText(getString(R.string.amanata));
                }
            }
            else if (type/10 ==4)
            {
                if (type%10 == 1) {
                    nImediataTV.setVisibility(View.INVISIBLE);
                    nAmanataTV.setVisibility(View.INVISIBLE);
                    nImediataTVaux.setVisibility(View.INVISIBLE);
                    amlimTV.setVisibility(View.INVISIBLE);
                    AmLimAuxTV.setVisibility(View.INVISIBLE);
                    amlimET.setVisibility(View.INVISIBLE);
                    amlimET.setEnabled(false);
                }
                if (type%10 == 2) {
                    nAmanataTV.setVisibility(View.INVISIBLE);
                }
                if (type%10 == 3) {
                    nImediataTV.setVisibility(View.INVISIBLE);
                    nImediataTVaux.setVisibility(View.INVISIBLE);
                    amlimTV.setText(getString(R.string.amanata));
                }
            }
        }

        // Calculate

        final NumberFormat resfmt = NumberFormat.getInstance();
        resfmt.setMaximumFractionDigits(4);

        calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (type == 11)
                    doubleRES = formuleAnuitati.AVPI_1(Integer.parseInt(varstaET.getText().toString()));
                if (type == 12)
                    doubleRES = formuleAnuitati.AVPI_2(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(amlimET.getText().toString()));
                if (type == 13)
                    doubleRES = formuleAnuitati.AVPI_3(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(amlimET.getText().toString()));


                if (type == 21)
                    doubleRES = formuleAnuitati.AVPF_1(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(platiPeAnET.getText().toString()));
                if (type == 22)
                    doubleRES = formuleAnuitati.AVPF_2(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(amlimET.getText().toString()),Integer.parseInt(platiPeAnET.getText().toString()));
                if (type == 23)
                    doubleRES = formuleAnuitati.AVPF_3(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(amlimET.getText().toString()),Integer.parseInt(platiPeAnET.getText().toString()));



                if (type == 31)
                    doubleRES = formuleAnuitati.AVAI_1(Integer.parseInt(varstaET.getText().toString()));
                if (type == 32)
                    doubleRES = formuleAnuitati.AVAI_2(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(amlimET.getText().toString()));
                if (type == 33)
                    doubleRES = formuleAnuitati.AVAI_3(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(amlimET.getText().toString()));


                if (type == 41)
                    doubleRES = formuleAnuitati.AVAF_1(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(platiPeAnET.getText().toString()));
                if (type == 42)
                    doubleRES = formuleAnuitati.AVAF_2(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(amlimET.getText().toString()),Integer.parseInt(platiPeAnET.getText().toString()));
                if (type == 43)
                    doubleRES = formuleAnuitati.AVAF_3(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(amlimET.getText().toString()),Integer.parseInt(platiPeAnET.getText().toString()));


                av3Title.setText(resfmt.format(doubleRES));

            }
        });






        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome = new Intent();
                setResult(Activity.RESULT_OK, gohome);
                finish();
            }
        });

        infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        varstaET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                varstaAux = s.toString();
                if (varstaAux.isEmpty())
                {
                    xTV.setText("x");
                }
                else {
                    xTV.setText(varstaAux);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        amlimET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    amlimAux=s.toString();
                    if(amlimAux.isEmpty()) {
                        setTextnAmanataTV("n");
                        setTextnImediataTV("n");
                    }
                    else {
                        setTextnImediataTV(amlimAux);
                        setTextnAmanataTV(amlimAux);
                    }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        platiPeAnET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                platiPeAnAux = s.toString();
                if (platiPeAnAux.isEmpty()) {
                    setTextmTV("m");
                }
                else {
                    setTextmTV(platiPeAnAux);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


        void setTextnAmanataTV (String S)
        {
            nAmanataTV.setText(S +"|");
        }

        void setTextnImediataTV (String S)
        {
            nImediataTV.setText(":" + S + "|");
        }

        void setTextmTV (String S)
        {
            mTV.setText("(" + S + ")");
        }

        public void setTitle(int type)
        {
            if (type == 11){
                aux = getString(R.string.avpi) + '\n' + getString(R.string.in);
                av3Title.setText(aux);
            }
            else if (type == 12){
                aux = getString(R.string.avpi) + '\n' + getString(R.string.il);
                av3Title.setText(aux);
            }
            else if (type == 13){
                aux = getString(R.string.avpi) + '\n' + getString(R.string.an);
                av3Title.setText(aux);
            }


            if (type == 21){
                aux = getString(R.string.avpf) + '\n' + getString(R.string.in);
                av3Title.setText(aux);
            }
            else if (type == 22){
                aux = getString(R.string.avaf) + '\n' + getString(R.string.il);
                av3Title.setText(aux);
            }
            else if (type == 23){
                aux = getString(R.string.avpf) + '\n' + getString(R.string.an);
                av3Title.setText(aux);
            }


            if (type == 31){
                aux = getString(R.string.avai) + '\n' + getString(R.string.in);
                av3Title.setText(aux);
            }
            else if (type == 32){
                aux = getString(R.string.avai) + '\n' + getString(R.string.il);
                av3Title.setText(aux);
            }
            else if (type == 33){
                aux = getString(R.string.avai) + '\n' + getString(R.string.an);
                av3Title.setText(aux);
            }


            if (type == 41){
                aux = getString(R.string.avaf) + '\n' + getString(R.string.in);
                av3Title.setText(aux);
            }
            else if (type == 42){
                aux = getString(R.string.avaf) + '\n' + getString(R.string.il);
                av3Title.setText(aux);
            }
            else if (type == 43){
                aux = getString(R.string.avaf) + '\n' + getString(R.string.an);
                av3Title.setText(aux);
            }

        }

        public void openDialog(){
            InfoDialog infoDialog = new InfoDialog();
            infoDialog.show(getSupportFragmentManager(),"info dialog");
        }



}
