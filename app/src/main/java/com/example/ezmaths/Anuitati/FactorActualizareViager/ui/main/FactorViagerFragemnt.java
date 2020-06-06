package com.example.ezmaths.Anuitati.FactorActualizareViager.ui.main;

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

import com.example.ezmaths.Anuitati.formuleAnuitati;
import com.example.ezmaths.R;

import java.text.NumberFormat;


public class FactorViagerFragemnt extends Fragment {

    private View rootView;

    private TextView nTV, xTV, resTV;

    private TextView nVarstaTV, xDiferentaTV;
    private EditText nVarstaET, xDiferentaET;

    private String varstaAux, diferentaAux;

    private Button calculeazaBtn;

    private com.example.ezmaths.Anuitati.formuleAnuitati formuleAnuitati = new formuleAnuitati();
    private NumberFormat format;
    private Double doubleRes;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_factor_viager, container, false);



        nTV = rootView.findViewById(R.id.nTVviager);
        xTV = rootView.findViewById(R.id.xTVviager);

        nVarstaTV = rootView.findViewById(R.id.nVarstaTVviager);
        nVarstaET = rootView.findViewById(R.id.nVarstaETviager);
        xDiferentaTV = rootView.findViewById(R.id.xDiferentaTVviager);
        xDiferentaET = rootView.findViewById(R.id.xDiferentaETviager);

        calculeazaBtn = rootView.findViewById(R.id.calculeazaFactorBTNviager);

        resTV = rootView.findViewById(R.id.resTVviager);
        resTV.setVisibility(View.INVISIBLE);

        nVarstaET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                varstaAux = s.toString();
                if (varstaAux.isEmpty())
                {
                    nTV.setText("n");
                }
                else
                {
                    nTV.setText(varstaAux);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        xDiferentaET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                diferentaAux = s.toString();
                if (diferentaAux.isEmpty())
                {
                    xTV.setText("x");
                }
                else
                    xTV.setText(diferentaAux);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(4);

        calculeazaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toastOK())
                {
                    doubleRes = formuleAnuitati.FAV(Integer.parseInt(xDiferentaET.getText().toString()),Integer.parseInt(nVarstaET.getText().toString()));
                    resTV.setText(format.format(doubleRes));
                    resTV.setVisibility(View.VISIBLE);
                }
                else
                {
                    resTV.setVisibility(View.INVISIBLE);
                    Toast toast = Toast.makeText(getActivity(), getString(R.string.ToastMessage), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 40);
                    toast.show();
                }
            }
        });

        return rootView;
    }

    private boolean toastOK()
    {
        return !nVarstaET.getText().toString().isEmpty() && !xDiferentaET.getText().toString().isEmpty();
    }

}

