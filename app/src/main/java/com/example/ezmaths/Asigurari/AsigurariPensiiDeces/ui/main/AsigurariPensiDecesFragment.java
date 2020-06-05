package com.example.ezmaths.Asigurari.AsigurariPensiiDeces.ui.main;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.ezmaths.Asigurari.AnuitatiViewModel;
import com.example.ezmaths.Asigurari.AsigurariViata.AsigDataSource;
import com.example.ezmaths.Asigurari.FormuleAsigurari;
import com.example.ezmaths.R;

import java.text.NumberFormat;


public class AsigurariPensiDecesFragment extends Fragment  {


    private View rootView;

    private TextView resultTV;


    private TextView nAsigurareTV;
    private EditText nAsigurareET;


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


    private FormuleAsigurari formuleAsigurari = new FormuleAsigurari();

    @RequiresApi(api = Build.VERSION_CODES.M)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_asig_pensii_deces, container, false);

        Bundle b = getArguments();

        if(b != null)
        {

            typeAsig = b.getInt("asig_type_version",0);
        }



        primaAsiguratorTV = rootView.findViewById(R.id.primaAsiguratorTVpd);
        primaAsiguratorET = rootView.findViewById(R.id.primaAsiguratorETpd);
        primaAsiguratorCheckBox = rootView.findViewById(R.id.primaAsiguratorCheckBoxTVpd);

        primaAsiguratTV = rootView.findViewById(R.id.primaAsiguratTVpd);
        primaAsiguratET = rootView.findViewById(R.id.primaAsiguratETpd);
        primaAsiguratCheckBox = rootView.findViewById(R.id.primaAsiguratCheckBoxTVpd);

        calculeazaBtn = rootView.findViewById(R.id.calculeazaAsigurareBtnpd);


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
                    primaAsiguratET.setText("");
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
                    primaAsiguratorET.setText("");
                    primaAsiguratorTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
                }
            }
        });



        return  rootView;
    }

    private double anuitate1aux,anuitate2aux,dRes;
    private int anuitate1type, anuitate2type, nAmanata1, nAmanata2;
    private boolean okAsig, okAnuitate;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        anuitate1RezTV = rootView.findViewById(R.id.anuitate1RezTV);
        anuitate1TV = rootView.findViewById(R.id.anuitate1TV);

        anuitate2RezTV = rootView.findViewById(R.id.anuitate2RezTV);
        anuitate2TV = rootView.findViewById(R.id.anuitate2TV);


        ///GetData

        anuitatiViewModel = new ViewModelProvider(requireActivity()).get(AnuitatiViewModel.class);



        anuitate1aux = 0;
        anuitate2aux = 0;


        anuitate1RezTV = rootView.findViewById(R.id.anuitate1RezTV);
        anuitate1TV = rootView.findViewById(R.id.anuitate1TV);

        anuitate2RezTV = rootView.findViewById(R.id.anuitate2RezTV);
        anuitate2TV = rootView.findViewById(R.id.anuitate2TV);

        anuitatiViewModel = new ViewModelProvider(requireActivity()).get(AnuitatiViewModel.class);


        if (typeAsig%10 == 1) {
            anuitate1TV.setText("Valoare anuitate selectata ");
            anuitatiViewModel.getAnuitateLiveData1().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                    resultTV.setVisibility(View.INVISIBLE);
                    anuitate1aux = aDouble;
                    if (aDouble == 0) {
                        anuitate1RezTV.setVisibility(View.INVISIBLE);
                        anuitate1TV.setVisibility(View.INVISIBLE);
                    } else if (aDouble != 0) {
                        anuitate1RezTV.setVisibility(View.VISIBLE);
                        anuitate1TV.setVisibility(View.VISIBLE);
                        anuitate1RezTV.setText(fmt.format(aDouble));
                    }
                }
            });
        }


        if (typeAsig %10 == 2) {

            anuitate1TV.setText("Valoare anuitate I ");
            anuitate2TV.setText("Valoare anuitate II");
            anuitatiViewModel.getAnuitateLiveData1().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                    resultTV.setVisibility(View.INVISIBLE);
                    anuitate1aux = aDouble;
                    if (anuitate1aux == 0 && anuitate2aux == 0)
                    {
                        anuitate1TV.setVisibility(View.INVISIBLE);
                        anuitate1RezTV.setVisibility(View.INVISIBLE);

                        anuitate2TV.setVisibility(View.INVISIBLE);
                        anuitate2RezTV.setVisibility(View.INVISIBLE);
                    }
                    if (anuitate1aux != 0 && anuitate2aux == 0)
                    {
                        anuitate1TV.setVisibility(View.VISIBLE);
                        anuitate1RezTV.setVisibility(View.VISIBLE);
                        anuitate1RezTV.setText(fmt.format(anuitate1aux));

                        anuitate2TV.setVisibility(View.INVISIBLE);
                        anuitate2RezTV.setVisibility(View.INVISIBLE);
                    }
                    if (anuitate1aux == 0 && anuitate2aux != 0)
                    {
                        anuitate1TV.setVisibility(View.INVISIBLE);
                        anuitate1RezTV.setVisibility(View.INVISIBLE);

                        anuitate2TV.setVisibility(View.VISIBLE);
                        anuitate2RezTV.setVisibility(View.VISIBLE);
                        anuitate2RezTV.setText(fmt.format(anuitate2aux));
                    }
                    if (anuitate1aux != 0 && anuitate2aux != 0)
                    {
                        anuitate1TV.setVisibility(View.VISIBLE);
                        anuitate1RezTV.setVisibility(View.VISIBLE);
                        anuitate1RezTV.setText(fmt.format(anuitate1aux));

                        anuitate2TV.setVisibility(View.VISIBLE);
                        anuitate2RezTV.setVisibility(View.VISIBLE);
                        anuitate2RezTV.setText(fmt.format(anuitate2aux));

                    }

                }
            });
            anuitatiViewModel.getAnuitateLiveData2().observe(getViewLifecycleOwner(), new Observer<Double>() {
                @Override
                public void onChanged(Double aDouble) {
                    resultTV.setVisibility(View.INVISIBLE);
                    anuitate2aux = aDouble;
                    if (anuitate1aux == 0 && anuitate2aux == 0)
                    {
                        anuitate1TV.setVisibility(View.INVISIBLE);
                        anuitate1RezTV.setVisibility(View.INVISIBLE);

                        anuitate2TV.setVisibility(View.INVISIBLE);
                        anuitate2RezTV.setVisibility(View.INVISIBLE);
                    }
                    if (anuitate1aux != 0 && anuitate2aux == 0)
                    {
                        anuitate1TV.setVisibility(View.VISIBLE);
                        anuitate1RezTV.setVisibility(View.VISIBLE);
                        anuitate1RezTV.setText(fmt.format(anuitate1aux));

                        anuitate2TV.setVisibility(View.INVISIBLE);
                        anuitate2RezTV.setVisibility(View.INVISIBLE);
                    }
                    if (anuitate1aux == 0 && anuitate2aux != 0)
                    {
                        anuitate1TV.setVisibility(View.INVISIBLE);
                        anuitate1RezTV.setVisibility(View.INVISIBLE);

                        anuitate2TV.setVisibility(View.VISIBLE);
                        anuitate2RezTV.setVisibility(View.VISIBLE);
                        anuitate2RezTV.setText(fmt.format(anuitate2aux));
                    }
                    if (anuitate1aux != 0 && anuitate2aux != 0)
                    {
                        anuitate1TV.setVisibility(View.VISIBLE);
                        anuitate1RezTV.setVisibility(View.VISIBLE);
                        anuitate1RezTV.setText(fmt.format(anuitate1aux));

                        anuitate2TV.setVisibility(View.VISIBLE);
                        anuitate2RezTV.setVisibility(View.VISIBLE);
                        anuitate2RezTV.setText(fmt.format(anuitate2aux));

                    }

                }
            });

        }

        anuitatiViewModel.getAnuitateLiveData1Type().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                anuitate1type = integer;
                resultTV.setVisibility(View.INVISIBLE);
            }
        });

        anuitatiViewModel.getAnuitateLiveData2Type().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                anuitate2type = integer;
                resultTV.setVisibility(View.INVISIBLE);
            }
        });

        anuitatiViewModel.getnAmanata1LiveData().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                nAmanata1 = integer;
            }
        });

        anuitatiViewModel.getnAmanata2LiveData().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                nAmanata2 = integer;
            }
        });


        ///Calculate


        primaAsiguratorTV = rootView.findViewById(R.id.primaAsiguratorTVpd);
        primaAsiguratorET = rootView.findViewById(R.id.primaAsiguratorETpd);
        primaAsiguratorCheckBox = rootView.findViewById(R.id.primaAsiguratorCheckBoxTVpd);

        primaAsiguratTV = rootView.findViewById(R.id.primaAsiguratTVpd);
        primaAsiguratET = rootView.findViewById(R.id.primaAsiguratETpd);
        primaAsiguratCheckBox = rootView.findViewById(R.id.primaAsiguratCheckBoxTVpd);

        calculeazaBtn = rootView.findViewById(R.id.calculeazaAsigurareBtnpd);
        resultTV = rootView.findViewById(R.id.resTV);
        resultTV.setVisibility(View.INVISIBLE);


        calculeazaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asigurareOK();
                anuitateOK();
                if (okAnuitate && okAsig) {
                    Calculate();
                    resultTV.setVisibility(View.VISIBLE);
                    resultTV.setText(fmt.format(dRes));
                }
                if(!okAsig)
                {
                    Toast toast = Toast.makeText(getActivity(), "Valoare nula", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 40);
                    toast.show();
                    resultTV.setVisibility(View.INVISIBLE);
                }
                else if(!okAnuitate)
                {
                    Toast toast = Toast.makeText(getActivity(), "Anuitate neselectata", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 40);
                    toast.show();
                    resultTV.setVisibility(View.INVISIBLE);
                }
            }
        });


    }

    private void asigurareOK()
    {
        if (primaAsiguratCheckBox.isChecked())
        {
            if(primaAsiguratET.getText().toString().isEmpty() )
                okAsig=false;
            else
                okAsig=true;
        }
        else if(primaAsiguratorCheckBox.isChecked())
        {
            if(primaAsiguratorET.getText().toString().isEmpty())
                okAsig=false;
            else
                okAsig=true;
        }
    }
    private void anuitateOK()
    {
        if (typeAsig%10 == 1)
        {
            if (anuitate1aux == 0)
                okAnuitate = false;
            else
                okAnuitate = true;
        }
        if (typeAsig%10 == 2)
        {
            if (anuitate1aux == 0 || anuitate2aux == 0)
                okAnuitate = false;
            else
                okAnuitate = true;
        }

    }
    private void Calculate()
    {
        if (typeAsig == 21)
        {
            if(anuitate1type == 23 || anuitate1type == 43)
            {
                if(primaAsiguratCheckBox.isChecked())
                {
                    dRes = formuleAsigurari.asigPensie_Unic_P_fractionat(Double.parseDouble(primaAsiguratET.getText().toString()), anuitate1aux, nAmanata1);
                }
                else
                    dRes = formuleAsigurari.asigPensie_Unic_S_fractionat(Double.parseDouble(primaAsiguratorET.getText().toString()), anuitate1aux, nAmanata1);
            }
            else
            {
                if(primaAsiguratCheckBox.isChecked())
                {
                    dRes = formuleAsigurari.asigPensie_Unic_P_intreg(Double.parseDouble(primaAsiguratET.getText().toString()), anuitate1aux);
                }
                else
                    dRes = formuleAsigurari.asigPensie_Unic_S_intreg(Double.parseDouble(primaAsiguratorET.getText().toString()),anuitate1aux);
            }
        }
        if (typeAsig == 22)
        {
            if(anuitate2type/10 == 2 || anuitate2type/10 == 4)
            {
                if (anuitate1type == 23 || anuitate1type == 43)
                {
                    if (primaAsiguratCheckBox.isChecked())
                        dRes = formuleAsigurari.asigPensii_fractionat_P_fractionat(Double.parseDouble(primaAsiguratET.getText().toString()),anuitate2aux,nAmanata2, anuitate1aux,nAmanata1);
                    else
                        dRes = formuleAsigurari.asigPensii_fractionat_S_fractionat(Double.parseDouble(primaAsiguratorET.getText().toString()),anuitate2aux,nAmanata2, anuitate1aux,nAmanata1);
                }
                else
                {
                    if (primaAsiguratCheckBox.isChecked())
                        dRes = formuleAsigurari.asigPensii_fractionat_P_intreg(Double.parseDouble(primaAsiguratET.getText().toString()),anuitate2aux,nAmanata2,anuitate1aux);
                    else
                        dRes = formuleAsigurari.asigPensii_fractionat_S_intreg(Double.parseDouble(primaAsiguratorET.getText().toString()),anuitate2aux,nAmanata2,anuitate1aux);
                }
            }
            else
            {
                if (anuitate1type == 23 || anuitate1type == 43)
                {
                    if (primaAsiguratCheckBox.isChecked())
                        dRes = formuleAsigurari.asigPensii_intreg_P_fractionat(Double.parseDouble(primaAsiguratET.getText().toString()),anuitate2aux, anuitate1aux,nAmanata1);
                    else
                        dRes = formuleAsigurari.asigPensii_intreg_S_fractionat(Double.parseDouble(primaAsiguratorET.getText().toString()),anuitate2aux, anuitate1aux,nAmanata1);
                }
                else
                {
                    if (primaAsiguratCheckBox.isChecked())
                        dRes = formuleAsigurari.asigPensii_intreg_P_intreg(Double.parseDouble(primaAsiguratET.getText().toString()),anuitate2aux,anuitate1aux);
                    else
                        dRes = formuleAsigurari.asigPensii_intreg_S_intreg(Double.parseDouble(primaAsiguratorET.getText().toString()),anuitate2aux,anuitate1aux);
                }
            }
        }
        if (typeAsig == 31)
        {
            if (primaAsiguratCheckBox.isChecked())
                dRes = formuleAsigurari.asigDeces_UNIC_P(Double.parseDouble(primaAsiguratET.getText().toString()), anuitate1aux);
            else
                dRes = formuleAsigurari.asigDeces_UNIC_S(Double.parseDouble(primaAsiguratorET.getText().toString()),anuitate1aux);
        }
        if (typeAsig == 32)
        {
            if (anuitate1type/10 == 4 || anuitate1type/10 == 2)
            {
                if (primaAsiguratCheckBox.isChecked())
                    dRes = formuleAsigurari.asigDeces_fractionat_P(Double.parseDouble(primaAsiguratET.getText().toString()),anuitate2aux,anuitate1aux,nAmanata1);
                else
                    dRes = formuleAsigurari.asigDeces_fractionat_S(Double.parseDouble(primaAsiguratorET.getText().toString()),anuitate2aux,anuitate1aux,nAmanata1);
            }
            else
            {
                if (primaAsiguratCheckBox.isChecked())
                    dRes = formuleAsigurari.asigDeces_intreg_P(Double.parseDouble(primaAsiguratET.getText().toString()),anuitate2aux,anuitate1aux);
                else
                    dRes = formuleAsigurari.asigDeces_intreg_S(Double.parseDouble(primaAsiguratorET.getText().toString()),anuitate2aux,anuitate1aux);
            }
        }
    }

}