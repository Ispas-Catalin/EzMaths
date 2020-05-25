package com.example.ezmaths.Asigurari;

import android.os.Build;
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

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.ezmaths.Asigurari.AsigurariViata.AsigDataSource;
import com.example.ezmaths.R;

import java.text.NumberFormat;
import java.util.Objects;


public class AsigAnuitatiFragment extends Fragment {


    View rootView;

    private Button selecteazabtn;
    private TextView titleAsigAnuFrag;

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

    private String varstaAux;
    private String amlimAux;
    private String platiPeAnAux;

    private TextView mDecesTV;
    private TextView mDecesAuxTV;
    private TextView aTV;

    NumberFormat resfmt;

    private int type;
    double doubleRES;
    Boolean setTextok;
    Fragment thisFragment;

    private int variant;

    AsigDataSource asigDataSource = new AsigDataSource();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_asigurari_anuitate, container, false);

        Bundle b = getArguments();

        if(b != null)
        {
            variant = b.getInt("key_version",0);
        }

        String [] anuitati = asigDataSource.getAnuitati(variant);


        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinneraAV1);
        ArrayAdapter<String> LTRadapter = new ArrayAdapter<String>(Objects.requireNonNull(this.getActivity()), android.R.layout.simple_spinner_item, anuitati);
        LTRadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(LTRadapter);


        selecteazabtn = rootView.findViewById(R.id.selecteazaBtnAV1);
        titleAsigAnuFrag = rootView.findViewById(R.id.titleAsigAnuitFragTV);

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

        aTV = rootView.findViewById(R.id.atvAV1);
        mDecesTV = rootView.findViewById(R.id.mLimInftvAVDecesAsig);
        mDecesAuxTV =rootView.findViewById(R.id.mDecesAuxTVAsig);



        /// Retine ce o fost ales din spinner si apeleaza setTitle si TransformUI
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { ///
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                getType(position);

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
        if (type == 53)
            nAmanataTV.setText(S);
        else
            nAmanataTV.setText(S +"|");
    }

    private void setTextnImediataTV(String S)
    {
        nImediataTV.setText(":" + S + "|");
    }

    private void setTextmTV(String S)
    {
        if (type == 53)
            mDecesTV.setText(S+"|");
        else
            mTV.setText("(" + S + ")");
    }

    private void getType(int position){
        if (variant == 1)
        {
            if (position == 0)
            {
                type = 12;
            }
            if (position == 1)
            {
                type = 22;
            }
            if (position == 2)
            {
                type = 32;
            }

            if (position == 3)
            {
                type = 42;
            }
        }

        if (variant == 2)
        {

            if (position == 0)
            {
                type = 13;
            }
            if (position == 1)
            {
                type = 23;
            }
            if (position == 2)
            {
                type = 33;
            }

            if (position == 3)
            {
                type = 43;
            }
        }

        if (variant == 3)
        {
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
        }

        if (variant == 4)
        {
            if (position == 0)
            {
                type = 51;
            }
            if (position == 1)
            {
                type = 52;
            }
            if (position == 2)
            {
                type = 53;
            }

            if (position == 3)
            {
                type = 54;
            }
        }
    }

    /// In functie de tipul primit din spinner schimba titlul
    private void setTitle(int type)
    {
        String aux;
        if (type == 11){
            aux = "Anuitati viagere posticipate intregi" + '\n' + "Imediate si nelimitate";
            titleAsigAnuFrag.setText(aux);
        }
        else if (type == 12){
            aux = "Anuitati viagere posticipate intregi" + '\n' + "Imediate si limitate la N ani";
            titleAsigAnuFrag.setText(aux);
        }
        else if (type == 13){
            aux = "Anuitati viagere posticipate intregi" + '\n' + "Nelimitate si amanate cu N ani";
            titleAsigAnuFrag.setText(aux);
        }


        if (type == 21){
            aux = "Anuitati viagere posticipate fractionate" + '\n' + "Imediate si nelimitate";
            titleAsigAnuFrag.setText(aux);
        }
        else if (type == 22){
            aux = "Anuitati viagere posticipate fractionate" + '\n' + "Imediate si limitate la N ani";
            titleAsigAnuFrag.setText(aux);
        }
        else if (type == 23){
            aux = "Anuitati viagere posticipate fractionate" + '\n' + "Nelimitate si amanate cu N ani";
            titleAsigAnuFrag.setText(aux);
        }


        if (type == 31){
            aux = "Anuitati viagere anticipate intregi" + '\n' + "Imediate si nelimitate";
            titleAsigAnuFrag.setText(aux);
        }
        else if (type == 32){
            aux = "Anuitati viagere anticipate intregi" + '\n' + "Imediate si limitate la N ani";
            titleAsigAnuFrag.setText(aux);
        }
        else if (type == 33){
            aux = "Anuitati viagere anticipate intregi" + '\n' + "Nelimitate si amanate cu N ani";
            titleAsigAnuFrag.setText(aux);
        }


        if (type == 41){
            aux = "Anuitati viagere anticipate fractionate" + '\n' + "Imediate si nelimitate";
            titleAsigAnuFrag.setText(aux);
        }
        else if (type == 42){
            aux = "Anuitati viagere anticipate fractionate" + '\n' + "Imediate si limitate la N ani";
            titleAsigAnuFrag.setText(aux);
        }
        else if (type == 43){
            aux = "Anuitati viagere anticipate fractionate" + '\n' + "Nelimitate si amanate cu N ani";
            titleAsigAnuFrag.setText(aux);
        }

        if (type == 51){
            aux = "Anuitati de deces";
            titleAsigAnuFrag.setText(aux);
        }
        else if (type == 52){
            aux = "Anuitati de deces" + '\n' + "limitate la N ani";
            titleAsigAnuFrag.setText(aux);
        }
        else if (type == 53){
            aux = "Anuitati de deces" + '\n' + "dublu limitate";
            titleAsigAnuFrag.setText(aux);
        }
        else if (type == 54){
            aux = "Anuitati de deces" + '\n' + "amanate cu N ani";
            titleAsigAnuFrag.setText(aux);
        }


    }

    /// In functie de tipul primit din spinner schimba culoarea/vizibilitate/interactibilitatea la elmente din layout
    private void TransformUI(int type)
    {
        sumaET.setTextColor(getActivity().getResources().getColor(R.color.silver));
        sumaET.setEnabled(false);
        sumaTV.setTextColor(getActivity().getResources().getColor(R.color.silver));

        if(type == 11)
        {
            pointsAnticipateTV.setVisibility(View.INVISIBLE);
            mTV.setVisibility(View.INVISIBLE);
            platiPeAnET.setTextColor(getActivity().getResources().getColor(R.color.silver));
            platiPeAnET.setEnabled(false);
            platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            nImediataTV.setVisibility(View.INVISIBLE);
            nAmanataTV.setVisibility(View.INVISIBLE);
            nImediataTVaux.setVisibility(View.INVISIBLE);
            amlimTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            AmLimAuxTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            amlimET.setTextColor(getActivity().getResources().getColor(R.color.silver));
            amlimET.setEnabled(false);
            aTV.setText("a");
            mDecesAuxTV.setVisibility(View.INVISIBLE);
            mDecesTV.setVisibility(View.INVISIBLE);

            platiPeAnET.getText().clear();
            amlimET.getText().clear();
            varstaET.getText().clear();
            sumaET.getText().clear();
        }
        if (type == 12)
        {
            pointsAnticipateTV.setVisibility(View.INVISIBLE);
            mTV.setVisibility(View.INVISIBLE);
            platiPeAnET.setTextColor(getActivity().getResources().getColor(R.color.silver));
            platiPeAnET.setEnabled(false);
            platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            nImediataTV.setVisibility(View.VISIBLE);
            nAmanataTV.setVisibility(View.INVISIBLE);
            nImediataTVaux.setVisibility(View.VISIBLE);
            amlimTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            AmLimAuxTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            amlimET.setTextColor(getActivity().getResources().getColor(R.color.black));
            amlimET.setEnabled(true);
            amlimTV.setText("Limita la ");
            aTV.setText("a");
            mDecesAuxTV.setVisibility(View.INVISIBLE);
            mDecesTV.setVisibility(View.INVISIBLE);

            platiPeAnET.getText().clear();
            amlimET.getText().clear();
            varstaET.getText().clear();
            sumaET.getText().clear();

        }
        if (type == 13)
        {
            pointsAnticipateTV.setVisibility(View.INVISIBLE);
            mTV.setVisibility(View.INVISIBLE);
            platiPeAnET.setTextColor(getActivity().getResources().getColor(R.color.silver));
            platiPeAnET.setEnabled(false);
            platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            nImediataTV.setVisibility(View.INVISIBLE);
            nAmanataTV.setVisibility(View.VISIBLE);
            nImediataTVaux.setVisibility(View.INVISIBLE);
            amlimTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            AmLimAuxTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            amlimET.setTextColor(getActivity().getResources().getColor(R.color.black));
            amlimET.setEnabled(true);
            amlimTV.setText("Amanata cu ");
            aTV.setText("a");
            mDecesAuxTV.setVisibility(View.INVISIBLE);
            mDecesTV.setVisibility(View.INVISIBLE);

            platiPeAnET.getText().clear();
            amlimET.getText().clear();
            varstaET.getText().clear();
            sumaET.getText().clear();
        }

        if(type == 21)
        {
            pointsAnticipateTV.setVisibility(View.INVISIBLE);
            mTV.setVisibility(View.VISIBLE);
            platiPeAnET.setTextColor(getActivity().getResources().getColor(R.color.black));
            platiPeAnET.setEnabled(true);
            platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            nImediataTV.setVisibility(View.INVISIBLE);
            nAmanataTV.setVisibility(View.INVISIBLE);
            nImediataTVaux.setVisibility(View.INVISIBLE);
            amlimTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            AmLimAuxTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            amlimET.setTextColor(getActivity().getResources().getColor(R.color.silver));
            amlimET.setEnabled(false);
            aTV.setText("a");
            mDecesAuxTV.setVisibility(View.INVISIBLE);
            mDecesTV.setVisibility(View.INVISIBLE);

            platiPeAnET.getText().clear();
            amlimET.getText().clear();
            varstaET.getText().clear();
            sumaET.getText().clear();

        }
        if (type == 22)
        {
            pointsAnticipateTV.setVisibility(View.INVISIBLE);
            mTV.setVisibility(View.VISIBLE);
            platiPeAnET.setTextColor(getActivity().getResources().getColor(R.color.black));
            platiPeAnET.setEnabled(true);
            platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            nImediataTV.setVisibility(View.VISIBLE);
            nAmanataTV.setVisibility(View.INVISIBLE);
            nImediataTVaux.setVisibility(View.VISIBLE);
            amlimTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            AmLimAuxTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            amlimET.setTextColor(getActivity().getResources().getColor(R.color.black));
            amlimET.setEnabled(true);
            amlimTV.setText("Limita la ");
            aTV.setText("a");
            mDecesAuxTV.setVisibility(View.INVISIBLE);
            mDecesTV.setVisibility(View.INVISIBLE);

            platiPeAnET.getText().clear();
            amlimET.getText().clear();
            varstaET.getText().clear();
            sumaET.getText().clear();


        }
        if (type == 23)
        {
            pointsAnticipateTV.setVisibility(View.INVISIBLE);
            mTV.setVisibility(View.VISIBLE);
            platiPeAnET.setTextColor(getActivity().getResources().getColor(R.color.black));
            platiPeAnET.setEnabled(true);
            platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            nImediataTV.setVisibility(View.INVISIBLE);
            nAmanataTV.setVisibility(View.VISIBLE);
            nImediataTVaux.setVisibility(View.INVISIBLE);
            amlimTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            AmLimAuxTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            amlimET.setTextColor(getActivity().getResources().getColor(R.color.black));
            amlimET.setEnabled(true);
            amlimTV.setText("Amanata cu ");
            aTV.setText("a");
            mDecesAuxTV.setVisibility(View.INVISIBLE);
            mDecesTV.setVisibility(View.INVISIBLE);

            platiPeAnET.getText().clear();
            amlimET.getText().clear();
            varstaET.getText().clear();
            sumaET.getText().clear();
        }

        if(type == 31)
        {
            pointsAnticipateTV.setVisibility(View.VISIBLE);
            mTV.setVisibility(View.INVISIBLE);
            platiPeAnET.setTextColor(getActivity().getResources().getColor(R.color.silver));
            platiPeAnET.setEnabled(false);
            platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            nImediataTV.setVisibility(View.INVISIBLE);
            nAmanataTV.setVisibility(View.INVISIBLE);
            nImediataTVaux.setVisibility(View.INVISIBLE);
            amlimTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            AmLimAuxTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            amlimET.setTextColor(getActivity().getResources().getColor(R.color.silver));
            amlimET.setEnabled(false);
            aTV.setText("a");
            mDecesAuxTV.setVisibility(View.INVISIBLE);
            mDecesTV.setVisibility(View.INVISIBLE);

            platiPeAnET.getText().clear();
            amlimET.getText().clear();
            varstaET.getText().clear();
            sumaET.getText().clear();
        }
        if (type == 32)
        {
            pointsAnticipateTV.setVisibility(View.VISIBLE);
            mTV.setVisibility(View.INVISIBLE);
            platiPeAnET.setTextColor(getActivity().getResources().getColor(R.color.silver));
            platiPeAnET.setEnabled(false);
            platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            nImediataTV.setVisibility(View.VISIBLE);
            nAmanataTV.setVisibility(View.INVISIBLE);
            nImediataTVaux.setVisibility(View.VISIBLE);
            amlimTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            AmLimAuxTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            amlimET.setTextColor(getActivity().getResources().getColor(R.color.black));
            amlimET.setEnabled(true);
            amlimTV.setText("Limita la ");
            aTV.setText("a");
            mDecesAuxTV.setVisibility(View.INVISIBLE);
            mDecesTV.setVisibility(View.INVISIBLE);

            platiPeAnET.getText().clear();
            amlimET.getText().clear();
            varstaET.getText().clear();
            sumaET.getText().clear();

        }
        if (type == 33)
        {
            pointsAnticipateTV.setVisibility(View.VISIBLE);
            mTV.setVisibility(View.INVISIBLE);
            platiPeAnET.setTextColor(getActivity().getResources().getColor(R.color.silver));
            platiPeAnET.setEnabled(false);
            platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            nImediataTV.setVisibility(View.INVISIBLE);
            nAmanataTV.setVisibility(View.VISIBLE);
            nImediataTVaux.setVisibility(View.INVISIBLE);
            amlimTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            AmLimAuxTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            amlimET.setTextColor(getActivity().getResources().getColor(R.color.black));
            amlimET.setEnabled(true);
            amlimTV.setText("Amanata cu ");
            aTV.setText("a");
            mDecesAuxTV.setVisibility(View.INVISIBLE);
            mDecesTV.setVisibility(View.INVISIBLE);

            platiPeAnET.getText().clear();
            amlimET.getText().clear();
            varstaET.getText().clear();
            sumaET.getText().clear();
        }

        if(type == 41)
        {
            pointsAnticipateTV.setVisibility(View.VISIBLE);
            mTV.setVisibility(View.VISIBLE);
            platiPeAnET.setTextColor(getActivity().getResources().getColor(R.color.black));
            platiPeAnET.setEnabled(true);
            platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            nImediataTV.setVisibility(View.INVISIBLE);
            nAmanataTV.setVisibility(View.INVISIBLE);
            nImediataTVaux.setVisibility(View.INVISIBLE);
            amlimTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            AmLimAuxTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            amlimET.setTextColor(getActivity().getResources().getColor(R.color.silver));
            amlimET.setEnabled(false);
            aTV.setText("a");
            mDecesAuxTV.setVisibility(View.INVISIBLE);
            mDecesTV.setVisibility(View.INVISIBLE);

            platiPeAnET.getText().clear();
            amlimET.getText().clear();
            varstaET.getText().clear();
            sumaET.getText().clear();
        }
        if (type == 42)
        {
            pointsAnticipateTV.setVisibility(View.VISIBLE);
            mTV.setVisibility(View.VISIBLE);
            platiPeAnET.setTextColor(getActivity().getResources().getColor(R.color.black));
            platiPeAnET.setEnabled(true);
            platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            nImediataTV.setVisibility(View.VISIBLE);
            nAmanataTV.setVisibility(View.INVISIBLE);
            nImediataTVaux.setVisibility(View.VISIBLE);
            amlimTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            AmLimAuxTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            amlimET.setTextColor(getActivity().getResources().getColor(R.color.black));
            amlimET.setEnabled(true);
            amlimTV.setText("Limita la ");
            aTV.setText("a");
            mDecesAuxTV.setVisibility(View.INVISIBLE);
            mDecesTV.setVisibility(View.INVISIBLE);

            platiPeAnET.getText().clear();
            amlimET.getText().clear();
            varstaET.getText().clear();
            sumaET.getText().clear();
        }
        if (type == 43)
        {
            pointsAnticipateTV.setVisibility(View.VISIBLE);
            mTV.setVisibility(View.VISIBLE);
            platiPeAnET.setTextColor(getActivity().getResources().getColor(R.color.black));
            platiPeAnET.setEnabled(true);
            platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            nImediataTV.setVisibility(View.INVISIBLE);
            nAmanataTV.setVisibility(View.VISIBLE);
            nImediataTVaux.setVisibility(View.INVISIBLE);
            amlimTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            AmLimAuxTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            amlimET.setTextColor(getActivity().getResources().getColor(R.color.black));
            amlimET.setEnabled(true);
            amlimTV.setText("Amanata cu ");
            aTV.setText("a");
            mDecesAuxTV.setVisibility(View.INVISIBLE);
            mDecesTV.setVisibility(View.INVISIBLE);

            platiPeAnET.getText().clear();
            amlimET.getText().clear();
            varstaET.getText().clear();
            sumaET.getText().clear();
        }

        if (type/10 == 5)
            titleAsigAnuFrag.setVisibility(View.INVISIBLE);

        if (type == 51)
        {
                pointsAnticipateTV.setVisibility(View.INVISIBLE);
                mTV.setVisibility(View.INVISIBLE);

                platiPeAnET.setVisibility(View.INVISIBLE);
                platiPeAnET.setEnabled(false);
                platiPeAnTV.setVisibility(View.INVISIBLE);
                mDecesAuxTV.setVisibility(View.INVISIBLE);

                mDecesTV.setVisibility(View.INVISIBLE);

                nImediataTV.setVisibility(View.INVISIBLE);
                nAmanataTV.setVisibility(View.INVISIBLE);
                nImediataTVaux.setVisibility(View.INVISIBLE);

                amlimTV.setVisibility(View.INVISIBLE);
                AmLimAuxTV.setVisibility(View.INVISIBLE);
                amlimET.setVisibility(View.INVISIBLE);
                amlimET.setEnabled(false);
                aTV.setText("A");

            platiPeAnET.getText().clear();
            amlimET.getText().clear();
            varstaET.getText().clear();
            sumaET.getText().clear();
        }

        if (type == 52)
        {
            pointsAnticipateTV.setVisibility(View.INVISIBLE);
            mTV.setVisibility(View.INVISIBLE);

            platiPeAnET.setVisibility(View.INVISIBLE);
            platiPeAnET.setEnabled(false);
            platiPeAnTV.setVisibility(View.INVISIBLE);
            mDecesAuxTV.setVisibility(View.INVISIBLE);

            mDecesTV.setVisibility(View.INVISIBLE);

            nImediataTV.setVisibility(View.VISIBLE);
            nAmanataTV.setVisibility(View.INVISIBLE);
            nImediataTVaux.setVisibility(View.VISIBLE);

            amlimTV.setVisibility(View.VISIBLE);
            AmLimAuxTV.setVisibility(View.VISIBLE);
            amlimET.setVisibility(View.VISIBLE);
            amlimET.setEnabled(true);
            amlimTV.setText("Limitata la ");
            aTV.setText("A");

            platiPeAnET.getText().clear();
            amlimET.getText().clear();
            varstaET.getText().clear();
            sumaET.getText().clear();
        }

        if (type == 53)
        {
            pointsAnticipateTV.setVisibility(View.INVISIBLE);
            mTV.setVisibility(View.INVISIBLE);

            platiPeAnET.setVisibility(View.VISIBLE);
            platiPeAnET.setEnabled(true);
            platiPeAnTV.setVisibility(View.VISIBLE);
            platiPeAnTV.setText("Limitata inferior la ");
            mDecesAuxTV.setVisibility(View.VISIBLE);

            mDecesTV.setVisibility(View.VISIBLE);
            mDecesTV.setText("m|");

            nImediataTV.setVisibility(View.INVISIBLE);
            nAmanataTV.setVisibility(View.VISIBLE);
            nAmanataTV.setText("n");
            nImediataTVaux.setVisibility(View.INVISIBLE);

            amlimTV.setVisibility(View.VISIBLE);
            AmLimAuxTV.setVisibility(View.VISIBLE);
            amlimET.setVisibility(View.VISIBLE);
            amlimET.setEnabled(true);
            amlimTV.setText("Limitata superior la ");
            aTV.setText("A");

            platiPeAnET.getText().clear();
            amlimET.getText().clear();
            varstaET.getText().clear();
            sumaET.getText().clear();
        }

        if (type == 54)
        {
            pointsAnticipateTV.setVisibility(View.INVISIBLE);
            mTV.setVisibility(View.INVISIBLE);

            platiPeAnET.setVisibility(View.INVISIBLE);
            platiPeAnET.setEnabled(false);
            platiPeAnTV.setVisibility(View.INVISIBLE);
            mDecesAuxTV.setVisibility(View.INVISIBLE);

            mDecesTV.setVisibility(View.INVISIBLE);

            nImediataTV.setVisibility(View.INVISIBLE);
            nAmanataTV.setVisibility(View.VISIBLE);
            nAmanataTV.setText("n|");
            nImediataTVaux.setVisibility(View.INVISIBLE);

            amlimTV.setVisibility(View.VISIBLE);
            AmLimAuxTV.setVisibility(View.VISIBLE);
            amlimET.setVisibility(View.VISIBLE);
            amlimET.setEnabled(true);
            amlimTV.setText("Amanata cu ");
            aTV.setText("A");

            platiPeAnET.getText().clear();
            amlimET.getText().clear();
            varstaET.getText().clear();
            sumaET.getText().clear();
        }

    }


}