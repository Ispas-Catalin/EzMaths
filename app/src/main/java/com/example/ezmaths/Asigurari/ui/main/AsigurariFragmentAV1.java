package com.example.ezmaths.Asigurari.ui.main;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.ezmaths.R;

import java.text.NumberFormat;


public class AsigurariFragmentAV1 extends Fragment {

    private View rootView;

    private Button selecteazabtn;
    private TextView Title;

    private EditText varstaET;
    private EditText amlimET;
    private EditText platiPeAnET;
    private EditText sumaET;

    private TextView amlimTV;
    private TextView platiPeAnTV;
    private TextView rezultatTV;

    private  TextView xTV;
    private TextView nAmanataTV;
    private TextView nImediataTVaux;
    private TextView nImediataTV;
    private TextView mTV;
    private  TextView pointsAnticipateTV ;
    private TextView AmLimAuxTV;
    private  TextView sumaTV;

    String varstaAux;
    String amlimAux;
    String platiPeAnAux;

    NumberFormat resfmt;

    int type;
    double doubleRES;
    Boolean setTextok;
    Fragment thisFragment;

    String aux;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_asigurari_av1, container, false);

        String [] anuitati =
                {"A.V.P.I. " + getString(R.string.in),
                        "A.V.P.I. " + getString(R.string.il),
                        "A.V.P.I. " + getString(R.string.an),

                        "A.V.P.F. "  + getString(R.string.in),
                        "A.V.P.F. " + getString(R.string.il),
                        "A.V.P.F. "  + getString(R.string.an),

                        "A.V.A.I. "  + getString(R.string.in),
                        "A.V.A.I. " + getString(R.string.il),
                        "A.V.A.I. "  + getString(R.string.an),

                        "A.V.A.F. " + getString(R.string.in),
                        "A.V.A.F. "  + getString(R.string.il),
                        "A.V.A.F. " + getString(R.string.an)};


        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinneraAV1);
        ArrayAdapter<String> LTRadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, anuitati);
        LTRadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(LTRadapter);



        selecteazabtn = rootView.findViewById(R.id.selecteazaBtnAV1);
        Title = rootView.findViewById(R.id.av3TitleAV1);

        varstaET = rootView.findViewById(R.id.varstaETAV1);
        amlimET  = rootView.findViewById(R.id.amlimnETAV1);
        platiPeAnET = rootView.findViewById(R.id.platiPeAnETAV1);
        sumaET = rootView.findViewById(R.id.sumaETAV1);


        amlimTV = rootView.findViewById(R.id.amlimnTVAV1);
        platiPeAnTV = rootView.findViewById(R.id.platiPeAnTVAV1);
        sumaTV = rootView.findViewById(R.id.sumaTVAV1);
        rezultatTV = rootView.findViewById(R.id.rezultatTVAV1);

        xTV = rootView.findViewById(R.id.xtvAV1);
        nAmanataTV = rootView.findViewById(R.id.nAmanatatvAV1);
        nImediataTVaux = rootView.findViewById(R.id.nImediatAuxtvAV1);
        nImediataTV = rootView.findViewById(R.id.nImediatatvAV1);
        mTV = rootView.findViewById(R.id.mtvAV1);
        pointsAnticipateTV = rootView.findViewById(R.id.pointsAnticipatetvAV1);
        AmLimAuxTV = rootView.findViewById(R.id.amlimauxTVAV1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    type = 11;
                }
                if (position == 1)
                {
                    type = 12;
                }
                if (position == 2)
                {
                    type = 13;
                }

                if (position == 3)
                {
                    type = 21;
                }
                if (position == 4)
                {
                    type = 22;
                }
                if (position == 5)
                {
                    type = 23;
                }

                if (position == 6)
                {
                    type = 31;
                }
                if (position == 7)
                {
                    type = 32;
                }
                if (position == 8)
                {
                    type = 33;
                }

                if (position == 9)
                {
                    type = 41;
                }
                if (position == 10)
                {
                    type = 42;
                }
                if (position == 11)
                {
                    type = 43;
                }


                setTitle(type);
                TransformUI(type);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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



        return  rootView;
    }

    private void setTextnAmanataTV(String S)
    {
        nAmanataTV.setText(S +"|");
    }

    private void setTextnImediataTV(String S)
    {
        nImediataTV.setText(":" + S + "|");
    }

    private void setTextmTV(String S)
    {
        mTV.setText("(" + S + ")");
    }

    public void setTitle(int type)
    {
        if (type == 11){
            aux = getString(R.string.avpi)  + getString(R.string.in);
            Title.setText(aux);
        }
        else if (type == 12){
            aux = getString(R.string.avpi) + getString(R.string.il);
            Title.setText(aux);
        }
        else if (type == 13){
            aux = getString(R.string.avpi)  + getString(R.string.an);
            Title.setText(aux);
        }


        if (type == 21){
            aux = getString(R.string.avpf) + getString(R.string.in);
            Title.setText(aux);
        }
        else if (type == 22){
            aux = getString(R.string.avaf)  + getString(R.string.il);
            Title.setText(aux);
        }
        else if (type == 23){
            aux = getString(R.string.avpf)  + getString(R.string.an);
            Title.setText(aux);
        }


        if (type == 31){
            aux = getString(R.string.avai) + '\n' + getString(R.string.in);
            Title.setText(aux);
        }
        else if (type == 32){
            aux = getString(R.string.avai) + '\n' + getString(R.string.il);
            Title.setText(aux);
        }
        else if (type == 33){
            aux = getString(R.string.avai) + '\n' + getString(R.string.an);
            Title.setText(aux);
        }


        if (type == 41){
            aux = getString(R.string.avaf) + '\n' + getString(R.string.in);
            Title.setText(aux);
        }
        else if (type == 42){
            aux = getString(R.string.avaf) + '\n' + getString(R.string.il);
            Title.setText(aux);
        }
        else if (type == 43){
            aux = getString(R.string.avaf) + '\n' + getString(R.string.an);
            Title.setText(aux);
        }

    }

    public void TransformUI(int type)
    {
        sumaTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
        sumaET.setTextColor(getActivity().getResources().getColor(R.color.silver));
        sumaET.setEnabled(false);
        if (type/10 <3)
        {
            pointsAnticipateTV.setVisibility(View.INVISIBLE);
            if(type/10 == 1)
            {
                mTV.setVisibility(View.INVISIBLE);
                platiPeAnET.setTextColor(getActivity().getResources().getColor(R.color.silver));
                platiPeAnET.setEnabled(false);
                platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.silver));

                if (type%10 == 1) {
                    nImediataTV.setVisibility(View.INVISIBLE);
                    nAmanataTV.setVisibility(View.INVISIBLE);
                    nImediataTVaux.setVisibility(View.INVISIBLE);
                    amlimTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
                    AmLimAuxTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
                    amlimET.setTextColor(getActivity().getResources().getColor(R.color.silver));
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
                    amlimTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
                    AmLimAuxTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
                    amlimET.setTextColor(getActivity().getResources().getColor(R.color.silver));;
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
                platiPeAnET.setTextColor(getActivity().getResources().getColor(R.color.silver));;
                platiPeAnET.setEnabled(false);
                platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.silver));;

                if (type%10 == 1) {
                    nImediataTV.setVisibility(View.INVISIBLE);
                    nAmanataTV.setVisibility(View.INVISIBLE);
                    nImediataTVaux.setVisibility(View.INVISIBLE);
                    amlimTV.setTextColor(getActivity().getResources().getColor(R.color.silver));;
                    AmLimAuxTV.setTextColor(getActivity().getResources().getColor(R.color.silver));;
                    amlimET.setTextColor(getActivity().getResources().getColor(R.color.silver));;
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
                    amlimTV.setTextColor(getActivity().getResources().getColor(R.color.silver));;
                    AmLimAuxTV.setTextColor(getActivity().getResources().getColor(R.color.silver));;
                    amlimET.setTextColor(getActivity().getResources().getColor(R.color.silver));;
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
    }

}