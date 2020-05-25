package com.example.ezmaths.Asigurari.AsigurariPensiiDeces.ui.main;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ezmaths.R;


public class AsigurariPensiDecesFragment extends Fragment {


    private View rootView;

    private TextView titleTV;
    private TextView resultTV;


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


    @RequiresApi(api = Build.VERSION_CODES.M)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_asig_pensii_deces, container, false);

        resultTV = rootView.findViewById(R.id.resultAsigTVpd);


        xAsigurareTV = rootView.findViewById(R.id.xAsigurareTVpd);
        xAsigurareET = rootView.findViewById(R.id.xAsigurareETpd);

        primaAsiguratorTV = rootView.findViewById(R.id.primaAsiguratorTVpd);
        primaAsiguratorET = rootView.findViewById(R.id.primaAsiguratorETpd);
        primaAsiguratorCheckBox = rootView.findViewById(R.id.primaAsiguratorCheckBoxTVpd);

        primaAsiguratTV = rootView.findViewById(R.id.primaAsiguratTVpd);
        primaAsiguratET = rootView.findViewById(R.id.primaAsiguratETpd);
        primaAsiguratCheckBox = rootView.findViewById(R.id.primaAsiguratCheckBoxTVpd);

        calculeazaBtn = rootView.findViewById(R.id.calculeazaAsigurareBtnpd);

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
}