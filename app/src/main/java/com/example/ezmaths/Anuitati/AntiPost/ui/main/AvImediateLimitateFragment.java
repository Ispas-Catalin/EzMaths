package com.example.ezmaths.Anuitati.AntiPost.ui.main;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.ezmaths.Anuitati.formuleAnuitati;
import com.example.ezmaths.R;

import java.text.NumberFormat;


public class AvImediateLimitateFragment extends Fragment {


    View rootView;
    int type;

    private TextView pointsAnticipateTV;
    private TextView title;
    private CheckBox platiPeAnCheckbox;

    private TextView mTV;
    private TextView xTV;
    private TextView nImediataTV;

    private TextView platiPeAnTV;
    private TextView sumatTV;

    private EditText platiPeAnET;
    private EditText sumaET;
    private EditText varstaET;
    private EditText amlimET;


    private String varstaAux;
    private String platiPeAnAux;
    private String amlimAux;

    private Button calculeazaBtn;
    private boolean setTextok;
    private double doubleRes;
    private TextView rezultatTV;
    NumberFormat resfmt;

    com.example.ezmaths.Anuitati.formuleAnuitati formuleAnuitati = new formuleAnuitati();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_av_imeidiate_limitate, container, false);




        pointsAnticipateTV = rootView.findViewById(R.id.pointsAnticipatetvIL);
        title = rootView.findViewById(R.id.av3TitleIL);
        platiPeAnCheckbox = rootView.findViewById(R.id.platiPeAnCheckBoxIL);

        mTV = rootView.findViewById(R.id.mtvIL);
        xTV = rootView.findViewById(R.id.xtvIL);
        nImediataTV = rootView.findViewById(R.id.nImediatatvIL);

        platiPeAnTV = rootView.findViewById(R.id.platiPeAnTVIL);
        sumatTV = rootView.findViewById(R.id.sumaTVIL);

        platiPeAnET = rootView.findViewById(R.id.platiPeAnETIL);
        sumaET = rootView.findViewById(R.id.sumaETIL);
        varstaET = rootView.findViewById(R.id.varstaETIL);
        amlimET = rootView.findViewById(R.id.amlimnETIL);

        calculeazaBtn = rootView.findViewById(R.id.calculeazaBtnIL);
        rezultatTV = rootView.findViewById(R.id.rezultatTVIL);


        Bundle b = getArguments();

        if(b != null)
        {
            type = b.getInt("key_pula",0);
        }


        transformUI(type);


        platiPeAnCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transformUI(type);
            }
        });

        resfmt = NumberFormat.getInstance();
        resfmt.setMaximumFractionDigits(4);

        calculeazaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculeaza(platiPeAnCheckbox.isChecked());

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

        amlimET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                amlimAux=s.toString();
                if(amlimAux.isEmpty()) {
                    setTextnImediataTV("n");
                }
                else {
                    setTextnImediataTV(amlimAux);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return  rootView;
    }

    private void transformUI(int type) {
        sumatTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
        sumaET.setEnabled(false);
        if (type == 1) {
            pointsAnticipateTV.setVisibility(View.INVISIBLE);
            if (platiPeAnCheckbox.isChecked()) {
                title.setText(getActivity().getResources().getString(R.string.avpf) + getActivity().getResources().getString(R.string.in));
                mTV.setVisibility(View.VISIBLE);
                platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.black));
                platiPeAnET.setEnabled(true);
            } else if (!platiPeAnCheckbox.isChecked()) {
                title.setText(getActivity().getResources().getString(R.string.avpi)  + getActivity().getResources().getString(R.string.in));
                mTV.setVisibility(View.INVISIBLE);
                platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
                platiPeAnET.setEnabled(false);
            }
        }

        if (type == 2) {
            pointsAnticipateTV.setVisibility(View.VISIBLE);
            if (platiPeAnCheckbox.isChecked()) {
                title.setText(getActivity().getResources().getString(R.string.avaf) + getActivity().getResources().getString(R.string.in));
                mTV.setVisibility(View.VISIBLE);
                platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.black));
                platiPeAnET.setEnabled(true);
            } else if (!platiPeAnCheckbox.isChecked()) {
                title.setText(getActivity().getResources().getString(R.string.avai)  + getActivity().getResources().getString(R.string.in));
                mTV.setVisibility(View.INVISIBLE);
                platiPeAnTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
                platiPeAnET.setEnabled(false);
            }
        }
    }

    void setTextmTV (String S)
    {
        mTV.setText("(" + S + ")");
    }

    void setTextnImediataTV (String S)
    {
        nImediataTV.setText(":" + S + "|");
    }

    private void Calculeaza (boolean mok)
    {
        setTextok = true;
        if(type == 1) {
            if (mok) {
                if (varstaET.getText().toString().isEmpty() || platiPeAnET.getText().toString().isEmpty() || amlimET.getText().toString().isEmpty())
                    setTextok = false;
                else
                    doubleRes = formuleAnuitati.AVPF_2(Integer.parseInt(varstaET.getText().toString()), Integer.parseInt(amlimET.getText().toString()), Integer.parseInt(platiPeAnET.getText().toString()));

            } else if (!mok) {
                if (varstaET.getText().toString().isEmpty() || amlimET.getText().toString().isEmpty())
                    setTextok = false;
                else
                    doubleRes = formuleAnuitati.AVPI_2(Integer.parseInt(varstaET.getText().toString()), Integer.parseInt(amlimET.getText().toString()));
            }
        }

        if (type == 2){
            if (mok) {
                if (varstaET.getText().toString().isEmpty() || platiPeAnET.getText().toString().isEmpty() || amlimET.getText().toString().isEmpty())
                    setTextok = false;
                else
                    doubleRes = formuleAnuitati.AVAF_2(Integer.parseInt(varstaET.getText().toString()), Integer.parseInt(amlimET.getText().toString()), Integer.parseInt(platiPeAnET.getText().toString()));

            } else if (!mok) {
                if (varstaET.getText().toString().isEmpty() || amlimET.getText().toString().isEmpty())
                    setTextok = false;
                else
                    doubleRes = formuleAnuitati.AVAI_2(Integer.parseInt(varstaET.getText().toString()) , Integer.parseInt(amlimET.getText().toString()));
            }
        }
    }
}