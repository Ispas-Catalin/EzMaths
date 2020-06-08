package com.icicezmaths.ezmaths.Anuitati.FactorActualizareViager.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

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

import com.icicezmaths.ezmaths.Anuitati.formuleAnuitati;
import com.icicezmaths.ezmaths.R;

import java.text.NumberFormat;


public class FactorDecesFragment extends Fragment {

    private View rootView;

    private TextView nTV, xTV, resTV;

    private TextView nVarstaTV, xDiferentaTV;
    private EditText nVarstaET, xDiferentaET;

    private String varstaAux, diferentaAux;

    private Button calculeazaBtn;

    private com.icicezmaths.ezmaths.Anuitati.formuleAnuitati formuleAnuitati = new formuleAnuitati();
    private NumberFormat format;
    private Double doubleRes;
    private boolean lessThan100ok;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_factor_deces, container, false);


        nTV = rootView.findViewById(R.id.nTVdeces);
        xTV = rootView.findViewById(R.id.xTVdeces);

        nVarstaTV = rootView.findViewById(R.id.nVarstaTVdeces);
        nVarstaET = rootView.findViewById(R.id.nVarstaETdeces);
        xDiferentaTV = rootView.findViewById(R.id.xDiferentaTVdeces);
        xDiferentaET = rootView.findViewById(R.id.xDiferentaETdeces);

        calculeazaBtn = rootView.findViewById(R.id.calculeazaFactorBTNdeces);

        resTV = rootView.findViewById(R.id.resTVdeces);
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
                lessThan100ok = true;
                lessThan100();
                if (toastOK() && lessThan100ok)
                {
                    doubleRes = formuleAnuitati.anuitatiDeces_2(Integer.parseInt(xDiferentaET.getText().toString()),Integer.parseInt(nVarstaET.getText().toString()),Integer.parseInt(nVarstaET.getText().toString())+1);
                    resTV.setText(format.format(doubleRes));
                    resTV.setVisibility(View.VISIBLE);
                }
                else
                {
                    if (lessThan100ok){
                        resTV.setVisibility(View.INVISIBLE);
                        Toast toast = Toast.makeText(getActivity(), getString(R.string.ToastMessage), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.BOTTOM, 0, 40);
                        toast.show();
                    }
                    else if (!lessThan100ok) {
                        resTV.setVisibility(View.INVISIBLE);
                        Toast toast = Toast.makeText(getActivity(), "Limita de varsta depasita", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.BOTTOM, 0, 40);
                        toast.show();
                    }
                }
            }
        });



        return rootView;
    }

    private boolean toastOK()
    {
        return !nVarstaET.getText().toString().isEmpty() && !xDiferentaET.getText().toString().isEmpty();
    }

    private void lessThan100()
    {
        if (!nVarstaET.getText().toString().isEmpty() && !xDiferentaET.getText().toString().isEmpty() && (Integer.parseInt(nVarstaET.getText().toString()) + Integer.parseInt(xDiferentaET.getText().toString()))>98)
            lessThan100ok = false;
    }
}
