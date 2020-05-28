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
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.ezmaths.Asigurari.AnuitatiViewModel;
import com.example.ezmaths.Asigurari.AsigurariViata.AsigDataSource;
import com.example.ezmaths.R;

import java.text.NumberFormat;


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

    public TextView anuitate1TV;
    public TextView anuitate1RezTV;
    public TextView anuitate2TV;
    public TextView anuitate2RezTV;
    private int typeAsig;

    AsigDataSource asigDataSource = new AsigDataSource();

    private NumberFormat fmt;


    private AnuitatiViewModel anuitatiViewModel;

    @RequiresApi(api = Build.VERSION_CODES.M)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_asig_pensii_deces, container, false);

        Bundle b = getArguments();

        if(b != null)
        {

            typeAsig = b.getInt("asig_type_version",0);
        }
        if (b == null)
            typeAsig = 69;


        xAsigurareTV = rootView.findViewById(R.id.xAsigurareTVpd);
        xAsigurareET = rootView.findViewById(R.id.xAsigurareETpd);

        primaAsiguratorTV = rootView.findViewById(R.id.primaAsiguratorTVpd);
        primaAsiguratorET = rootView.findViewById(R.id.primaAsiguratorETpd);
        primaAsiguratorCheckBox = rootView.findViewById(R.id.primaAsiguratorCheckBoxTVpd);

        primaAsiguratTV = rootView.findViewById(R.id.primaAsiguratTVpd);
        primaAsiguratET = rootView.findViewById(R.id.primaAsiguratETpd);
        primaAsiguratCheckBox = rootView.findViewById(R.id.primaAsiguratCheckBoxTVpd);

        calculeazaBtn = rootView.findViewById(R.id.calculeazaAsigurareBtnpd);


       anuitate1TV = rootView.findViewById(R.id.anuitate1TV);
       anuitate1RezTV = rootView.findViewById(R.id.anuitate1RezTV);
       anuitate2TV = rootView.findViewById(R.id.anuitate2TV);
       anuitate2RezTV = rootView.findViewById(R.id.anuitate2RezTV);

        fmt = NumberFormat.getInstance();
        fmt.setMaximumFractionDigits(4);

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

    private double anuitate1aux;
    private double anuitate2aux;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        anuitate1RezTV = rootView.findViewById(R.id.anuitate1RezTV);
        anuitate1TV = rootView.findViewById(R.id.anuitate1TV);

        anuitate2RezTV = rootView.findViewById(R.id.anuitate2RezTV);
        anuitate2TV = rootView.findViewById(R.id.anuitate2TV);


        anuitatiViewModel = new ViewModelProvider(requireActivity()).get(AnuitatiViewModel.class);


        anuitate1RezTV.setVisibility(View.VISIBLE);
        anuitate1RezTV.setText(Integer.toString(typeAsig));

        anuitate1aux = 0;
        anuitate2aux = 0;


            anuitatiViewModel.getAnuitateLiveData1().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {

                        anuitate1RezTV.setText(fmt.format(aDouble));
                }
            });


    }
}