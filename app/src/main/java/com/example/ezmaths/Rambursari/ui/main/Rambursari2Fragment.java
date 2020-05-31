package com.example.ezmaths.Rambursari.ui.main;

import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.fragment.app.Fragment;
        import androidx.lifecycle.ViewModelProviders;

        import com.example.ezmaths.R;


public class Rambursari2Fragment extends Fragment {

    private View rootView;

    private TextView dobandaTV, nPlatiTV, numarLuniTV;
    private EditText dobandaET, nPlatiET, numarLuniET;
    private CheckBox nPlatiCheckBox;

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

        nPlatiTransform();
        nPlatiCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nPlatiTransform();
            }
        });

        return  rootView;
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