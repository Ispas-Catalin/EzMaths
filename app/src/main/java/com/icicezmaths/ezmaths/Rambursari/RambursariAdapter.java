package com.icicezmaths.ezmaths.Rambursari;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.icicezmaths.ezmaths.R;

import java.util.List;

public class RambursariAdapter extends RecyclerView.Adapter<RambursariAdapter.ViewHolder> {

    private Context context;
    private List<String> KRambursari;
    private List<String> RKRambursari;
    private List<String> DKRambursari;
    private List<String> QKRambursari;
    private List<String> OmegaKRambursari;

    public RambursariAdapter(List<String> KRambursari, List<String> RKRambursari, List<String> DKRambursari, List<String> QKRambursari, List<String> OmegaKRambursari, Context context){
        this.context = context;
        this.KRambursari = KRambursari;
        this.RKRambursari = RKRambursari;
        this.DKRambursari = DKRambursari;
        this.QKRambursari = QKRambursari;
        this.OmegaKRambursari = OmegaKRambursari;
    }

    @NonNull
    @Override
    public RambursariAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rambursari_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RambursariAdapter.ViewHolder holder, int position) {

        final String kr = KRambursari.get(position);
        final String rkr = RKRambursari.get(position);
        final String dkr = DKRambursari.get(position);
        final String qkr = QKRambursari.get(position);
        final String omegakr = OmegaKRambursari.get(position);

        holder.kTVrambursari.setText(kr);
        holder.rkTVrambursari.setText(rkr);
        holder.dkTVrambursari.setText(dkr);
        holder.qkTVrambursari.setText(qkr);
        holder.omegakTVrambursari.setText(omegakr);

    }

    @Override
    public int getItemCount() {
        return KRambursari.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView kTVrambursari;
        TextView rkTVrambursari;
        TextView dkTVrambursari;
        TextView qkTVrambursari;
        TextView omegakTVrambursari;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            kTVrambursari = itemView.findViewById(R.id.kTVramburs);
            rkTVrambursari = itemView.findViewById(R.id.rkTVramburs);
            dkTVrambursari = itemView.findViewById(R.id.dkTVramburs);
            qkTVrambursari = itemView.findViewById(R.id.qkTVramburs);
            omegakTVrambursari = itemView.findViewById(R.id.omegakTVramburs);
        }
    }
}
