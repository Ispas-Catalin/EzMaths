package com.icicezmaths.ezmaths.Anuitati.AntiPost.ui.main;

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

import com.icicezmaths.ezmaths.Anuitati.formuleAnuitati;
import com.icicezmaths.ezmaths.R;

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
    private NumberFormat resfmt;

    private CheckBox sumaCheckBox;
    private double resAux;

    private boolean lessThan100ok;

    com.icicezmaths.ezmaths.Anuitati.formuleAnuitati formuleAnuitati = new formuleAnuitati();

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
        sumaCheckBox = rootView.findViewById(R.id.sumaCheckBoxIL);

        sumaCheckBox.setChecked(false);
        sumatTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
        sumaET.setEnabled(false);

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
                if (!platiPeAnCheckbox.isChecked())
                    platiPeAnET.setText("");
            }
        });

        sumaCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sumaCheckBox.isChecked())
                {
                    sumatTV.setTextColor(getActivity().getResources().getColor(R.color.black));
                    sumaET.setEnabled(true);
                }
                else
                {
                    sumatTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
                    sumaET.setEnabled(false);
                    sumaET.setText("");
                }
            }
        });

        resfmt = NumberFormat.getInstance();
        resfmt.setMaximumFractionDigits(4);

        calculeazaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lessThan100ok = true;
                lessThan100();
                if (lessThan100ok)
                    Calculeaza(platiPeAnCheckbox.isChecked());
                else
                    setTextok =true;

                if(setTextok && lessThan100ok){
                    if (!sumaCheckBox.isChecked()) {
                        rezultatTV.setVisibility(View.VISIBLE);
                        rezultatTV.setText(resfmt.format(doubleRes));}
                    else if (sumaCheckBox.isChecked() && okSuma())
                    {
                        rezultatTV.setVisibility(View.VISIBLE);
                        resAux = doubleRes*Double.parseDouble(sumaET.getText().toString());
                        rezultatTV.setText(resfmt.format(resAux));
                    }
                    else if(sumaCheckBox.isChecked() && !okSuma())
                    {
                        rezultatTV.setVisibility(View.INVISIBLE);
                        Toast toast = Toast.makeText(getActivity(), getString(R.string.ToastMessage), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.BOTTOM, 0, 40);
                        toast.show();
                    }
                }
                else
                {
                    if(setTextok && !lessThan100ok)
                    {
                        rezultatTV.setVisibility(View.INVISIBLE);
                        Toast toast = Toast.makeText(getActivity(), "Limita de varsta depasita", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.BOTTOM, 0, 40);
                        toast.show();
                    }
                    else if(!setTextok){
                        rezultatTV.setVisibility(View.INVISIBLE);
                        Toast toast = Toast.makeText(getActivity(), getString(R.string.ToastMessage), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.BOTTOM, 0, 40);
                        toast.show();}
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

    private boolean okSuma()
    {
        return !sumaET.getText().toString().isEmpty();
    }

    private void lessThan100()
    {
        if(!amlimET.getText().toString().isEmpty() && !varstaET.getText().toString().isEmpty() && (Integer.parseInt(amlimET.getText().toString()) + Integer.parseInt(varstaET.getText().toString())) >99)
            lessThan100ok = false;
    }
}