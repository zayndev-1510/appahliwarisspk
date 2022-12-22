package com.it015.spkhakimwaris.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.it015.spkhakimwaris.R;
import com.it015.spkhakimwaris.holder.HasilAkhirHolder;
import com.it015.spkhakimwaris.objek.DataHasil;

import java.util.List;

public class HasilAkhirAdapter extends RecyclerView.Adapter<HasilAkhirHolder> {
    Context context;
    List<DataHasil> list;
    LayoutInflater layoutInflater;

    public HasilAkhirAdapter(Context context, List<DataHasil> list) {
        this.context = context;
        this.list = list;
        this.layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HasilAkhirHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=layoutInflater.inflate(R.layout.result_akhir,parent,false);
        return new HasilAkhirHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HasilAkhirHolder holder, int position) {
        DataHasil dataHasil=list.get(position);
        TextView txt_ahli_waris=holder.txt_ahli_waris;
        TextView txt_harga=holder.txt_harga;
        String ket=dataHasil.getAhli_waris()+"("+dataHasil.getKet_bagian()+")";
        txt_ahli_waris.setText(ket);
        txt_harga.setText(dataHasil.getFormatRupiah());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
