package com.example.ezmaths;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivityRambursari extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rambursari);


        Context MainActivityRambursariContext = this;

        Button backbtn = findViewById(R.id.backbtn);

        DataSource dataSource = new DataSource();
        List<String> KRambursari = dataSource.getKRambursari();
        List<String> RKRambursari = dataSource.getRKRambursari();
        List<String> DKRambursari = dataSource.getDKRambursari();
        List<String> QKRambursari = dataSource.getQKRambursari();
        List<String> OmegaKRambursari = dataSource.getOmegaKRambursari();

        RecyclerView recyclerView = findViewById(R.id.rambursariRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RambursariAdapter(KRambursari,RKRambursari,DKRambursari,QKRambursari,OmegaKRambursari,this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
