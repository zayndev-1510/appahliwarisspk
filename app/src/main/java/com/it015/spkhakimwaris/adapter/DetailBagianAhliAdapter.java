package com.it015.spkhakimwaris.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.it015.spkhakimwaris.R;
import com.it015.spkhakimwaris.holder.DetailBagianAhliHolder;
import com.it015.spkhakimwaris.objek.DetailbagianModel;

import java.util.List;

public class DetailBagianAhliAdapter extends RecyclerView.Adapter<DetailBagianAhliHolder> {

    Context context;
    LayoutInflater layoutInflater;
    List<DetailbagianModel> list;

    public DetailBagianAhliAdapter(Context context, List<DetailbagianModel> list) {
        this.context = context;
        this.list = list;
        this.layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DetailBagianAhliHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=layoutInflater.inflate(R.layout.result_detail_bagian_ahli_waris,parent,false);
        return new DetailBagianAhliHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailBagianAhliHolder holder, int position) {
        DetailbagianModel row=list.get(position);
        holder.konten.setText(row.getKonten());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
