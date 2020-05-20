package com.example.ezmaths.Anuitati;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ezmaths.InfoDialog;
import com.example.ezmaths.R;

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
    TextView rezultatTV;

    TextView xTV;
    TextView nAmanataTV;
    TextView nImediataTVaux;
    TextView nImediataTV;
    TextView mTV;
    TextView pointsAnticipateTV ;
    TextView AmLimAuxTV;
    TextView sumaTV;

    String varstaAux;
    String amlimAux;
    String platiPeAnAux;

    NumberFormat resfmt;

    int type;
    double doubleRES;
    Boolean setTextok;

    String aux;

    formuleAnuitati formuleAnuitati = new formuleAnuitati();


    @RequiresApi(api = Build.VERSION_CODES.M)
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
        sumaTV = findViewById(R.id.sumaTV);
        rezultatTV = findViewById(R.id.rezultatTV);

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
        sumaTV.setTextColor(getColor(R.color.silver));
        sumaET.setTextColor(getColor(R.color.silver));
        sumaET.setEnabled(false);
        if (type/10 <3)
        {
            pointsAnticipateTV.setVisibility(View.INVISIBLE);
            if(type/10 == 1)
            {
                mTV.setVisibility(View.INVISIBLE);
                platiPeAnET.setTextColor(getColor(R.color.silver));
                platiPeAnET.setEnabled(false);
                platiPeAnTV.setTextColor(getColor(R.color.silver));

                if (type%10 == 1) {
                nImediataTV.setVisibility(View.INVISIBLE);
                nAmanataTV.setVisibility(View.INVISIBLE);
                nImediataTVaux.setVisibility(View.INVISIBLE);
                amlimTV.setTextColor(getColor(R.color.silver));
                AmLimAuxTV.setTextColor(getColor(R.color.silver));
                amlimET.setTextColor(getColor(R.color.silver));
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
                    amlimTV.setTextColor(getColor(R.color.silver));
                    AmLimAuxTV.setTextColor(getColor(R.color.silver));
                    amlimET.setTextColor(getColor(R.color.silver));;
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
                platiPeAnET.setTextColor(getColor(R.color.silver));;
                platiPeAnET.setEnabled(false);
                platiPeAnTV.setTextColor(getColor(R.color.silver));;

                if (type%10 == 1) {
                    nImediataTV.setVisibility(View.INVISIBLE);
                    nAmanataTV.setVisibility(View.INVISIBLE);
                    nImediataTVaux.setVisibility(View.INVISIBLE);
                    amlimTV.setTextColor(getColor(R.color.silver));;
                    AmLimAuxTV.setTextColor(getColor(R.color.silver));;
                    amlimET.setTextColor(getColor(R.color.silver));;
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
                    amlimTV.setTextColor(getColor(R.color.silver));;
                    AmLimAuxTV.setTextColor(getColor(R.color.silver));;
                    amlimET.setTextColor(getColor(R.color.silver));;
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

        resfmt = NumberFormat.getInstance();
        resfmt.setMaximumFractionDigits(4);

        calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Calculate(type);

               if(setTextok){
                   rezultatTV.setText(resfmt.format(doubleRES));
                   rezultatTV.setVisibility(View.VISIBLE);}
               else
               {
                   rezultatTV.setVisibility(View.INVISIBLE);
                   Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.ToastMessage), Toast.LENGTH_SHORT);
                   toast.setGravity(Gravity.BOTTOM, 0, 40);
                   toast.show();
               }

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

        private void Calculate (int type)
        {
            setTextok = true;

            if (type == 11)
            {
                if(varstaET.getText().toString().isEmpty())
                    setTextok = false;
                else
                    doubleRES = formuleAnuitati.AVPI_1(Integer.parseInt(varstaET.getText().toString()));}
            if (type == 12){
                if(varstaET.getText().toString().isEmpty() || amlimET.getText().toString().isEmpty())
                    setTextok = false;
                else
                    doubleRES = formuleAnuitati.AVPI_2(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(amlimET.getText().toString()));}
            if (type == 13){
                if(varstaET.getText().toString().isEmpty() || amlimET.getText().toString().isEmpty())
                    setTextok = false;
                else
                    doubleRES = formuleAnuitati.AVPI_3(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(amlimET.getText().toString()));}


            if (type == 21){
                if(varstaET.getText().toString().isEmpty() || platiPeAnET.getText().toString().isEmpty())
                    setTextok = false;
                else
                    doubleRES = formuleAnuitati.AVPF_1(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(platiPeAnET.getText().toString()));}
            if (type == 22){
                if(varstaET.getText().toString().isEmpty() || amlimET.getText().toString().isEmpty() || platiPeAnET.getText().toString().isEmpty())
                    setTextok = false;
                else
                    doubleRES = formuleAnuitati.AVPF_2(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(amlimET.getText().toString()),Integer.parseInt(platiPeAnET.getText().toString()));}
            if (type == 23){
                if(varstaET.getText().toString().isEmpty() || amlimET.getText().toString().isEmpty() || platiPeAnET.getText().toString().isEmpty())
                    setTextok = false;
                else
                    doubleRES = formuleAnuitati.AVPF_3(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(amlimET.getText().toString()),Integer.parseInt(platiPeAnET.getText().toString()));}



            if (type == 31){
                if(varstaET.getText().toString().isEmpty() )
                    setTextok = false;
                else
                    doubleRES = formuleAnuitati.AVAI_1(Integer.parseInt(varstaET.getText().toString()));}
            if (type == 32){
                if(varstaET.getText().toString().isEmpty() || amlimET.getText().toString().isEmpty())
                    setTextok = false;
                else
                    doubleRES = formuleAnuitati.AVAI_2(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(amlimET.getText().toString()));}
            if (type == 33){
                if(varstaET.getText().toString().isEmpty() || amlimET.getText().toString().isEmpty())
                    setTextok = false;
                else
                    doubleRES = formuleAnuitati.AVAI_3(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(amlimET.getText().toString()));}


            if (type == 41){
                if(varstaET.getText().toString().isEmpty() || platiPeAnET.getText().toString().isEmpty())
                    setTextok = false;
                else
                    doubleRES = formuleAnuitati.AVAF_1(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(platiPeAnET.getText().toString()));}
            if (type == 42){
                if(varstaET.getText().toString().isEmpty() || amlimET.getText().toString().isEmpty() || platiPeAnET.getText().toString().isEmpty())
                    setTextok = false;
                else
                    doubleRES = formuleAnuitati.AVAF_2(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(amlimET.getText().toString()),Integer.parseInt(platiPeAnET.getText().toString()));}
            if (type == 43){
                if(varstaET.getText().toString().isEmpty() || amlimET.getText().toString().isEmpty() || platiPeAnET.getText().toString().isEmpty())
                    setTextok = false;
                else
                    doubleRES = formuleAnuitati.AVAF_3(Integer.parseInt(varstaET.getText().toString()),Integer.parseInt(amlimET.getText().toString()),Integer.parseInt(platiPeAnET.getText().toString()));}


        }



}