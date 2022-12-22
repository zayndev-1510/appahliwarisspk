package com.it015.spkhakimwaris.holder;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.it015.spkhakimwaris.R;

public class PewarisHolder extends RecyclerView.ViewHolder {
    public TextView ket_text,txt_terhalang,check_txt;
    public EditText nilai_edit;
    public PewarisHolder(@NonNull View itemView) {
        super(itemView);
        ket_text=itemView.findViewById(R.id.ket);
        nilai_edit=itemView.findViewById(R.id.nilai);
        txt_terhalang=itemView.findViewById(R.id.txt_terhalang);

    }
}
