package com.example.ezmaths.Asigurari.AsigurariViata.MaiMultePlati.ui.main;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ezmaths.Asigurari.AnuitatiViewModel;
import com.example.ezmaths.Asigurari.FormuleAsigurari;
import com.example.ezmaths.R;

import java.text.NumberFormat;


public class AsigViataMultePlatiFragment extends Fragment {

    private View rootView;


    private TextView nAsigurareTV;
    private EditText nAsigurareET;

    private TextView xAsigurareTV;
    private TextView xAsigurareET;

    private TextView primaAsiguratorTV;
    private EditText primaAsiguratorET;
    private CheckBox primaAsiguratorCheckBox;

    private TextView primaAsiguratTV;
    private EditText primaAsiguratET;
    private CheckBox primaAsiguratCheckBox;

    private Button calculeazaBtn;

    private TextView anuitateTV;
    private TextView anuitateRezTV;
    private AnuitatiViewModel anuitatiViewModel;

    private NumberFormat fmt;
    private TextView resTV;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_asig_viata_multe_plati, container, false);


        nAsigurareTV = rootView.findViewById(R.id.nAsigurareTVmv);
        nAsigurareET = rootView.findViewById(R.id.nAsigurareETmv);

        xAsigurareTV = rootView.findViewById(R.id.xAsigurareTVmv);
        xAsigurareET = rootView.findViewById(R.id.xAsigurareETmv);

        primaAsiguratorTV = rootView.findViewById(R.id.primaAsiguratorTVmv);
        primaAsiguratorET = rootView.findViewById(R.id.primaAsiguratorETmv);
        primaAsiguratorCheckBox = rootView.findViewById(R.id.primaAsiguratorCheckBoxTVmv);

        primaAsiguratTV = rootView.findViewById(R.id.primaAsiguratTVmv);
        primaAsiguratET = rootView.findViewById(R.id.primaAsiguratETmv);
        primaAsiguratCheckBox = rootView.findViewById(R.id.primaAsiguratCheckBoxTVmv);

        calculeazaBtn = rootView.findViewById(R.id.calculeazaAsigurareBtnmv);

        primaAsiguratorCheckBox.setChecked(true);
        primaAsiguratCheckBox.setChecked(false);
        primaAsiguratET.setEnabled(false);
        primaAsiguratTV.setTextColor(getActivity().getResources().getColor(R.color.silver));


        resTV = rootView.findViewById(R.id.resultTVAV);

        primaAsiguratorCheckBox.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (primaAsiguratorCheckBox.isChecked())
                {
                    primaAsiguratorET.setEnabled(true);
                    primaAsiguratorTV.setTextColor(getActivity().getResources().getColor(R.color.black));
                    primaAsiguratCheckBox.setChecked(false);
                    primaAsiguratET.setEnabled(false);
                    primaAsiguratET.setText("");
                    primaAsiguratTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
                    resTV.setVisibility(View.INVISIBLE);
                }

            }
        });

        primaAsiguratCheckBox.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (primaAsiguratCheckBox.isChecked())
                {
                    primaAsiguratET.setEnabled(true);
                    primaAsiguratTV.setTextColor(getActivity().getResources().getColor(R.color.black));
                    primaAsiguratorCheckBox.setChecked(false);
                    primaAsiguratorET.setEnabled(false);
                    primaAsiguratorET.setText("");
                    primaAsiguratorTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
                    resTV.setVisibility(View.INVISIBLE);
                }
            }
        });

        return  rootView;
    }

    private boolean OK;
    private double anuitate,dRes, mPlati;
    private int anuitateType;


    private FormuleAsigurari formuleAsigurari = new FormuleAsigurari();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        anuitateRezTV = rootView.findViewById(R.id.anuitateRezTV);
        anuitateTV = rootView.findViewById(R.id.anuitateTV);

        fmt = NumberFormat.getInstance();
        fmt.setMaximumFractionDigits(4);

        anuitatiViewModel = new ViewModelProvider(requireActivity()).get(AnuitatiViewModel.class);


        anuitatiViewModel.getAnuitateLiveData1().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                anuitate = aDouble;
                if (aDouble == 0)
                {
                    anuitateRezTV.setVisibility(View.INVISIBLE);
                    anuitateTV.setVisibility(View.INVISIBLE);
                    resTV.setVisibility(View.INVISIBLE);
                }
                else if (aDouble!=0)
                {
                    anuitateRezTV.setVisibility(View.VISIBLE);
                    anuitateTV.setVisibility(View.VISIBLE);
                    anuitateRezTV.setText(fmt.format(aDouble));
                }
            }
        });

        anuitatiViewModel.getnAmanata1LiveData().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
               mPlati = integer;
            }
        });

        anuitatiViewModel.getAnuitateLiveData1Type().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                anuitateType = integer;
                resTV.setVisibility(View.INVISIBLE);
            }
        });

        nAsigurareET = rootView.findViewById(R.id.nAsigurareETmv);
        xAsigurareET = rootView.findViewById(R.id.xAsigurareETmv);

        primaAsiguratorET = rootView.findViewById(R.id.primaAsiguratorETmv);
        primaAsiguratorCheckBox = rootView.findViewById(R.id.primaAsiguratorCheckBoxTVmv);

        primaAsiguratET = rootView.findViewById(R.id.primaAsiguratETmv);
        primaAsiguratCheckBox = rootView.findViewById(R.id.primaAsiguratCheckBoxTVmv);

        calculeazaBtn = rootView.findViewById(R.id.calculeazaAsigurareBtnmv);
        resTV = rootView.findViewById(R.id.resultTVAV);
        resTV.setVisibility(View.INVISIBLE);

        calculeazaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastOK();
                if (!OK)
                {
                    Toast toast = Toast.makeText(getActivity(), "Valoare nula", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 40);
                    toast.show();
                    resTV.setVisibility(View.INVISIBLE);
                }
                if (anuitate == 0)
                {
                    Toast toast = Toast.makeText(getActivity(), "Anuitate neselectata", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 40);
                    toast.show();
                    resTV.setVisibility(View.INVISIBLE);
                }
                else if (OK && anuitate != 0)
                {
                    calculate();
                    resTV.setText(fmt.format(dRes));
                    resTV.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    private void toastOK()
    {
        if(primaAsiguratCheckBox.isChecked()) {
            if (primaAsiguratET.getText().toString().isEmpty() || xAsigurareET.getText().toString().isEmpty() || nAsigurareET.getText().toString().isEmpty())
                OK = false;
            else OK = true;
        }

        else {
            if (primaAsiguratorET.getText().toString().isEmpty() || xAsigurareET.getText().toString().isEmpty() || nAsigurareET.getText().toString().isEmpty())
                OK = false;
            else OK = true;
        }

    }

    private void calculate()
    {
        if (anuitateType == 22 || anuitateType == 42)
        {
            if (primaAsiguratCheckBox.isChecked())
                dRes = formuleAsigurari.asigViata_MaiMulte_P(Double.parseDouble(primaAsiguratET.getText().toString()), Integer.parseInt(nAsigurareET.getText().toString()), Integer.parseInt(xAsigurareET.getText().toString()),anuitate,mPlati);
            else
                dRes = formuleAsigurari.asigViata_MaiMulte_S(Double.parseDouble(primaAsiguratorET.getText().toString()), Integer.parseInt(nAsigurareET.getText().toString()), Integer.parseInt(xAsigurareET.getText().toString()),anuitate,mPlati);
        }
        else
        {
            if (primaAsiguratCheckBox.isChecked())
                dRes = formuleAsigurari.asigViata_MaiMulte_P(Double.parseDouble(primaAsiguratET.getText().toString()), Integer.parseInt(nAsigurareET.getText().toString()), Integer.parseInt(xAsigurareET.getText().toString()),anuitate,1);
            else
                dRes = formuleAsigurari.asigViata_MaiMulte_S(Double.parseDouble(primaAsiguratorET.getText().toString()), Integer.parseInt(nAsigurareET.getText().toString()), Integer.parseInt(xAsigurareET.getText().toString()),anuitate,1);
        }

    }
}
