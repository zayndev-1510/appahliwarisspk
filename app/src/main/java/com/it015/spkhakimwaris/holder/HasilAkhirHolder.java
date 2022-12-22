package com.it015.spkhakimwaris.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.it015.spkhakimwaris.R;

public class HasilAkhirHolder extends RecyclerView.ViewHolder {
    public TextView txt_ahli_waris,txt_harga;
    public HasilAkhirHolder(@NonNull View itemView) {
        super(itemView);
        txt_ahli_waris=itemView.findViewById(R.id.ahli_waris);
        txt_harga=itemView.findViewById(R.id.harta_bagian_ahli_waris);
    }
}
