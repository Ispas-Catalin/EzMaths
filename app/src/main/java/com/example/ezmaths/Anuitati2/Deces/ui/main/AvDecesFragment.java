package com.example.ezmaths.Anuitati2.Deces.ui.main;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ezmaths.Anuitati2.formuleAnuitati;
import com.example.ezmaths.R;

import java.text.NumberFormat;


public class AvDecesFragment extends Fragment {

    View rootView;
    private int type;

    private TextView title;

    private TextView resultTV;

    private TextView nImeidataTV;
    private TextView nImediataAxuTV;
    private TextView xTV;
    private TextView nAmanataTV;
    private TextView mTV;

    private TextView sumaTV;
    private EditText sumaET;

    private TextView varstaTV;
    private EditText varstaET;

    private TextView amlimTV;
    private EditText amlimET;
    private TextView amlimAuxTV;

    private TextView limitaTV;
    private EditText limitaET;
    private TextView limitaAuxTV;

    private Button calculeaza;

    private String varstaAux;
    private String amlimAux;
    private String mAux;

    private Boolean setTextok;
    private TextView rezultatTV;
    NumberFormat resfmt;
    private Double doubleRes;

    com.example.ezmaths.Anuitati2.formuleAnuitati formuleAnuitati = new formuleAnuitati();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_anuitati_deces, container, false);

        title = rootView.findViewById(R.id.avTitleTVDeces);
        resultTV = rootView.findViewById(R.id.rezultatTVAVDeces);
        nImediataAxuTV = rootView.findViewById(R.id.nImediatAuxtvAVDeces);
        nImeidataTV = rootView.findViewById(R.id.nImediatatvAVDeces);
        xTV = rootView.findViewById(R.id.xtvAVDeces);
        nAmanataTV = rootView.findViewById(R.id.nAmanatatvAVDeces);
        mTV = rootView.findViewById(R.id.mLimInftvAVDeces);
        sumaTV = rootView.findViewById(R.id.sumaTVAVDeces);
        sumaET = rootView.findViewById(R.id.sumaETAVDeces);
        varstaTV = rootView.findViewById(R.id.varstaTVAVDeces);
        varstaET = rootView.findViewById(R.id.varstaETAVDeces);
        amlimTV = rootView.findViewById(R.id.amlimnTVAVDeces);
        amlimAuxTV = rootView.findViewById(R.id.amlimauxTVAVDeces);
        amlimET = rootView.findViewById(R.id.amlimnETAVDeces);
        limitaTV = rootView.findViewById(R.id.limitataInferiorTVAVDeces);
        limitaAuxTV = rootView.findViewById(R.id.limitataInferiorAuxTVAVDeces);
        limitaET = rootView.findViewById(R.id.limitataInferiorETAVDeces);
        calculeaza = rootView.findViewById(R.id.calculeazaBtnAVDeces);
        rezultatTV = rootView.findViewById(R.id.rezultatTVAVDeces);

        Bundle b = getArguments();

        if(b != null)
        {
            type = b.getInt("deces_key",0);
        }

        TransformUI(type);

        resfmt = NumberFormat.getInstance();
        resfmt.setMaximumFractionDigits(4);

        calculeaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculeaza();

                if(setTextok){
                    rezultatTV.setText(resfmt.format(doubleRes));
                    rezultatTV.setVisibility(View.VISIBLE);}
                else
                {
                    rezultatTV.setVisibility(View.INVISIBLE);
                    Toast toast = Toast.makeText(getActivity(), getString(R.string.ToastMessage), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 40);
                    toast.show();
                }
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
                amlimAux = s.toString();
                setTextAmlim(amlimAux);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        limitaET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAux = s.toString();
                if (mAux.isEmpty())
                    mTV.setText("m|");
                else
                    mTV.setText(mAux + "|");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return  rootView;
    }

    private void TransformUI(int type)
    {
        if (type == 1)
        {
            title.setText("Anuitati de deces" + '\n' + "Imediate si nelimitate");

            nImeidataTV.setVisibility(View.INVISIBLE);
            nImediataAxuTV.setVisibility(View.INVISIBLE);
            nAmanataTV.setVisibility(View.INVISIBLE);
            mTV.setVisibility(View.INVISIBLE);

            sumaTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            sumaET.setEnabled(false);

            amlimTV.setVisibility(View.INVISIBLE);
            amlimAuxTV.setVisibility(View.INVISIBLE);
            amlimET.setVisibility(View.INVISIBLE);

            limitaTV.setVisibility(View.INVISIBLE);
            limitaAuxTV.setVisibility(View.INVISIBLE);
            limitaET.setVisibility(View.INVISIBLE);

        }

        if (type == 2)
        {
            title.setText("Anuitati de deces" + '\n' + "Imediate si limitate la N ani");

            nImeidataTV.setVisibility(View.VISIBLE);
            nImediataAxuTV.setVisibility(View.VISIBLE);
            nAmanataTV.setVisibility(View.INVISIBLE);
            mTV.setVisibility(View.INVISIBLE);

            sumaTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            sumaET.setEnabled(false);

            amlimTV.setVisibility(View.VISIBLE);
            amlimAuxTV.setVisibility(View.VISIBLE);
            amlimET.setVisibility(View.VISIBLE);
            amlimTV.setText("Limitata la ");

            limitaTV.setVisibility(View.INVISIBLE);
            limitaAuxTV.setVisibility(View.INVISIBLE);
            limitaET.setVisibility(View.INVISIBLE);
        }

        if (type == 3)
        {
            title.setText("Anuitati de deces" + '\n' + "Dublu limitate");

            nImeidataTV.setVisibility(View.INVISIBLE);
            nImediataAxuTV.setVisibility(View.INVISIBLE);
            nAmanataTV.setVisibility(View.VISIBLE);
            nAmanataTV.setText("n");
            mTV.setVisibility(View.VISIBLE);

            sumaTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            sumaET.setEnabled(false);

            amlimTV.setVisibility(View.VISIBLE);
            amlimAuxTV.setVisibility(View.VISIBLE);
            amlimET.setVisibility(View.VISIBLE);
            amlimTV.setText("Limitata superior la ");

            limitaTV.setVisibility(View.VISIBLE);
            limitaAuxTV.setVisibility(View.VISIBLE);
            limitaET.setVisibility(View.VISIBLE);
            limitaTV.setText("Limitata inferior la ");
        }

        if(type == 4)
        {
            title.setText("Anuitati de deces" + '\n' + "Nelimitate si amanate cu N ani");

            nImeidataTV.setVisibility(View.INVISIBLE);
            nImediataAxuTV.setVisibility(View.INVISIBLE);
            nAmanataTV.setVisibility(View.VISIBLE);
            mTV.setVisibility(View.INVISIBLE);

            sumaTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            sumaET.setEnabled(false);

            amlimTV.setVisibility(View.VISIBLE);
            amlimAuxTV.setVisibility(View.VISIBLE);
            amlimET.setVisibility(View.VISIBLE);
            amlimTV.setText("Amanata cu ");

            limitaTV.setVisibility(View.INVISIBLE);
            limitaAuxTV.setVisibility(View.INVISIBLE);
            limitaET.setVisibility(View.INVISIBLE);
        }
    }

    private void setTextAmlim(String s)
    {
        if (type == 2)
        {
            if(s.isEmpty())
                nImeidataTV.setText(":n|");
            else
                nImeidataTV.setText(":" + s + "|");
        }
        if (type == 3)
        {
            if (s.isEmpty())
                nAmanataTV.setText("n");
            else
                nAmanataTV.setText(s);
        }
        if (type == 4)
        {
            if (s.isEmpty())
                nAmanataTV.setText("n|");
            else
                nAmanataTV.setText(s + "|");
        }
    }

    private void Calculeaza()
    {
        setTextok = true;
        if (type == 1)
        {
            if (varstaET.getText().toString().isEmpty())
                setTextok = false;
            else
                doubleRes = formuleAnuitati.anuitatiDeces_1(Integer.parseInt(varstaET.getText().toString()));
        }
        if (type == 2)
        {
            if (varstaET.getText().toString().isEmpty() || amlimET.getText().toString().isEmpty())
                setTextok = false;
            else
                doubleRes = formuleAnuitati.anutiatiDeces_3(Integer.parseInt(varstaET.getText().toString()), Integer.parseInt(amlimET.getText().toString()));
        }
        if (type == 3)
        {
            if (varstaET.getText().toString().isEmpty() || amlimET.getText().toString().isEmpty() || limitaET.getText().toString().isEmpty())
                setTextok = false;
            else
                doubleRes = formuleAnuitati.anuitatiDeces_2(Integer.parseInt(varstaET.getText().toString()), Integer.parseInt(limitaET.getText().toString()), Integer.parseInt(amlimET.getText().toString()));
        }
        if (type == 4)
        {
            if (varstaET.getText().toString().isEmpty() || amlimET.getText().toString().isEmpty())
                setTextok = false;
            else
                doubleRes = formuleAnuitati.anuitatiDeces_4(Integer.parseInt(varstaET.getText().toString()), Integer.parseInt(amlimET.getText().toString()));
        }
    }

}