package com.icicezmaths.ezmaths.Rambursari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.icicezmaths.ezmaths.Rambursari.ui.main.Rambursari1Fragment;
import com.icicezmaths.ezmaths.R;

import java.util.List;

public class ActivityRambursariTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabel_rambursari);



        Button backbtn = findViewById(R.id.backbtn);

        Bundle bundle = getIntent().getExtras();

        List<String> KRambursari = null;
        List<String> RKRambursari = null;
        List<String> QKRambursari = null;
        List<String> OmegaKRambursari = null;
        List<String> DKRambursari = null;

        if (bundle != null) {
            KRambursari = bundle.getStringArrayList(Rambursari1Fragment.KRAMBURSARI_KEY);
            RKRambursari = bundle.getStringArrayList(Rambursari1Fragment.RKAMBURSARI_KEY);
            DKRambursari = bundle.getStringArrayList(Rambursari1Fragment.DKRAMBURSARI_KEY);
            QKRambursari = bundle.getStringArrayList(Rambursari1Fragment.QKRAMBURSARI_KEY);
            OmegaKRambursari = bundle.getStringArrayList(Rambursari1Fragment.OMEGAKRAMBURSARI_KEY);
        }


        RecyclerView recyclerView = findViewById(R.id.rambursariRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RambursariAdapter(KRambursari, RKRambursari, DKRambursari, QKRambursari, OmegaKRambursari, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
