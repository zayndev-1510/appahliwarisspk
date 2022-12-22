package com.it015.spkhakimwaris.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.it015.spkhakimwaris.R;

public class BagianAhliWarisHolder extends RecyclerView.ViewHolder {
    public TextView ahli_waris_bagian,arrow_btn;
    public BagianAhliWarisHolder(@NonNull View itemView) {
        super(itemView);
        ahli_waris_bagian=itemView.findViewById(R.id.ahli_waris_bagian);
        arrow_btn=itemView.findViewById(R.id.arrow_btn);
    }
}
