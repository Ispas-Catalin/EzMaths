package com.example.ezmaths.Asigurari.AsigurariViata.MaiMultePlati.ui.main;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ezmaths.Asigurari.AnuitatiViewModel;
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
                    primaAsiguratTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
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
                    primaAsiguratorTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
                }
            }
        });

        return  rootView;
    }


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
                if (aDouble == 0)
                {
                    anuitateRezTV.setVisibility(View.INVISIBLE);
                    anuitateTV.setVisibility(View.INVISIBLE);
                }
                else if (aDouble!=0)
                {
                    anuitateRezTV.setVisibility(View.VISIBLE);
                    anuitateTV.setVisibility(View.VISIBLE);
                    anuitateRezTV.setText(fmt.format(aDouble));
                }
            }
        });


    }

}
