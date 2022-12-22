package com.it015.spkhakimwaris.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.it015.spkhakimwaris.R;

public class DetailBagianAhliHolder extends RecyclerView.ViewHolder {
    public TextView konten;
    public DetailBagianAhliHolder(@NonNull View itemView) {
        super(itemView);
        konten=itemView.findViewById(R.id.konten_bagian_ahli_waris);
    }
}
