package com.icicezmaths.ezmaths.Rambursari.ui.main;

import android.content.Intent;
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

import androidx.fragment.app.Fragment;

import com.icicezmaths.ezmaths.R;
import com.icicezmaths.ezmaths.Rambursari.ActivityRambursariTable;
import com.icicezmaths.ezmaths.Rambursari.AlgoritmRambursariSimplu;

import java.util.ArrayList;
import java.util.List;


public class Rambursari2Fragment extends Fragment {

    private View rootView;

    private TextView dobandaTV, nPlatiTV, numarLuniTV, sumaTV;
    private EditText dobandaET, nPlatiET, numarLuniET, sumaET;
    private CheckBox nPlatiCheckBox;
    private Button genereazaBtn;

    public static final String KRAMBURSARI_KEY = "krambursari_key";
    public static final String RKAMBURSARI_KEY = "rkrambursari_key";
    public static final String DKRAMBURSARI_KEY = "dkrambursari_key";
    public static final String QKRAMBURSARI_KEY = "qkrambursari_key";
    public static final String OMEGAKRAMBURSARI_KEY = "omegakrambursari_key";

    private AlgoritmRambursariSimplu algoritmRambursariSimplu = new AlgoritmRambursariSimplu();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_rambursari2, container, false);

        dobandaTV = rootView.findViewById(R.id.dobandaTVfond);
        dobandaET = rootView.findViewById(R.id.dobandaETfond);

        nPlatiTV = rootView.findViewById(R.id.nPlatiTVfond);
        nPlatiET = rootView.findViewById(R.id.nPlatiEtfond);
        nPlatiCheckBox = rootView.findViewById(R.id.nPlatiCheckboxfond);

        numarLuniTV = rootView.findViewById(R.id.numarLuniTVfond);
        numarLuniET= rootView.findViewById(R.id.numariLuniETfond);

        sumaTV = rootView.findViewById(R.id.SumaTVfond);
        sumaET = rootView.findViewById(R.id.SumaEtfond);

        genereazaBtn = rootView.findViewById(R.id.rCalculateBtnfond);

        nPlatiTransform();
        nPlatiCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nPlatiTransform();
            }
        });

        genereazaBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                List<String> KRambursari = null;
                List<String> RKRambursari = null;
                List<String> DKRambursari = null;
                List<String> OmegaKRambursari = null;
                List<String> QKRambursari = null;

                if(okToast())
                    Calculate();
                else if(!okToast())
                {
                    Toast toast = Toast.makeText(getActivity(), getString(R.string.ToastMessage), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 40);
                    toast.show();
                }

                Intent intent = new Intent(getActivity(), ActivityRambursariTable.class);

                if (okToast())
                {
                    KRambursari = algoritmRambursariSimplu.getK_acumulare();
                    RKRambursari = algoritmRambursariSimplu.getrk_acumulare();
                    DKRambursari = algoritmRambursariSimplu.getSinK_acumulare();
                    OmegaKRambursari = algoritmRambursariSimplu.getSfinK_acumulare();
                    QKRambursari = algoritmRambursariSimplu.getDK_acumulare();

                    intent.putStringArrayListExtra(KRAMBURSARI_KEY, (ArrayList<String>) KRambursari);
                    intent.putStringArrayListExtra(RKAMBURSARI_KEY, (ArrayList<String>) RKRambursari);
                    intent.putStringArrayListExtra(DKRAMBURSARI_KEY, (ArrayList<String>) DKRambursari);
                    intent.putStringArrayListExtra(OMEGAKRAMBURSARI_KEY, (ArrayList<String>) OmegaKRambursari);
                    intent.putStringArrayListExtra(QKRAMBURSARI_KEY, (ArrayList<String>) QKRambursari);


                    startActivity(intent);
                }



            }
        });


        return  rootView;
    }

    private void Calculate () {

        if (!nPlatiCheckBox.isChecked())
        {
            algoritmRambursariSimplu.generare_fond_acumulare(Double.parseDouble(sumaET.getText().toString()),Double.parseDouble(dobandaET.getText().toString()), Double.parseDouble(numarLuniET.getText().toString())/12,1);
        }
        else if (nPlatiCheckBox.isChecked())
        {
            algoritmRambursariSimplu.generare_fond_acumulare(Double.parseDouble(sumaET.getText().toString()),Double.parseDouble(dobandaET.getText().toString()), Double.parseDouble(numarLuniET.getText().toString())/12,Double.parseDouble(nPlatiET.getText().toString()));
        }


    }

    private Boolean okToast () {
        boolean ok;
        ok = true;

        if (!nPlatiCheckBox.isChecked())
        {
            if(dobandaET.getText().toString().isEmpty() || numarLuniET.getText().toString().isEmpty() || sumaET.getText().toString().isEmpty())
                ok = false;
        }
        else if (nPlatiCheckBox.isChecked())
        {
            if(dobandaET.getText().toString().isEmpty() || numarLuniET.getText().toString().isEmpty() || nPlatiET.getText().toString().isEmpty() || sumaET.getText().toString().isEmpty())
                ok = false;
        }


        return ok;
    }


    private void nPlatiTransform()
    {
        if (nPlatiCheckBox.isChecked())
        {
            nPlatiTV.setTextColor(getActivity().getResources().getColor(R.color.black));
            nPlatiET.setEnabled(true);
            nPlatiET.setText("");
        }
        else {
            nPlatiTV.setTextColor(getActivity().getResources().getColor(R.color.silver));
            nPlatiET.setEnabled(false);
            nPlatiET.setText("");
        }
    }
}