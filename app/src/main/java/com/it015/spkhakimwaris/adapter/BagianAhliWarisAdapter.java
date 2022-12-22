package com.it015.spkhakimwaris.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.it015.spkhakimwaris.DetailBagianPage;
import com.it015.spkhakimwaris.HasilAkhir;
import com.it015.spkhakimwaris.R;
import com.it015.spkhakimwaris.holder.BagianAhliWarisHolder;
import com.it015.spkhakimwaris.objek.BagianAhliWaris;

import java.util.List;

public class BagianAhliWarisAdapter extends RecyclerView.Adapter<BagianAhliWarisHolder> {

    Context context;
    List<BagianAhliWaris> list;
    LayoutInflater layoutInflater;

    public BagianAhliWarisAdapter(Context context, List<BagianAhliWaris> list) {
        this.context = context;
        this.list = list;
        this.layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BagianAhliWarisHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=layoutInflater.inflate(R.layout.result_bagian_ahli_waris,parent,false);
        return new BagianAhliWarisHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BagianAhliWarisHolder holder, int position) {
        TextView txt_ahli_waris_bagian,btn_arrow;
        txt_ahli_waris_bagian=holder.ahli_waris_bagian;
        btn_arrow=holder.arrow_btn;
        BagianAhliWaris row=list.get(position);
        txt_ahli_waris_bagian.setText(row.getAhli_waris());
        btn_arrow.setOnClickListener(v->{
            Intent new_intent=new Intent(context.getApplicationContext(), DetailBagianPage.class);
            Bundle b = new Bundle();
            b.putString("value",row.getValue());
            b.putString("ahli_waris",row.getAhli_waris());
            new_intent.putExtras(b);
            context.startActivity(new_intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
