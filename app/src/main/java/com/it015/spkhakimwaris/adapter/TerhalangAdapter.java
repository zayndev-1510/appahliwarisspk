package com.it015.spkhakimwaris.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.it015.spkhakimwaris.R;
import com.it015.spkhakimwaris.holder.PewarisHolder;
import com.it015.spkhakimwaris.objek.DataTerhalang;

import java.util.List;

public class TerhalangAdapter extends RecyclerView.Adapter<PewarisHolder> {
    Context context;
    List<DataTerhalang> list;
    LayoutInflater layoutInflater;
    PewarisAdapter.EventAdapter event;
    List<DataTerhalang> list_update;

    public TerhalangAdapter(Context context, List<DataTerhalang> list, PewarisAdapter.EventAdapter event) {
        this.context = context;
        this.list = list;
        this.event = event;
        this.layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public PewarisHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.list_pewaris,parent,false);
        return new PewarisHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PewarisHolder holder, int position) {
        DataTerhalang data=list.get(position);
        holder.ket_text.setText(data.getKet());
        holder.nilai_edit.setText(String.valueOf(data.getNilai()));
        String ket=data.getKet();
        if(data.isStatus()){
            holder.nilai_edit.setVisibility(View.GONE);
            holder.txt_terhalang.setVisibility(View.VISIBLE);
        }else{
            holder.nilai_edit.setVisibility(View.VISIBLE);
            holder.txt_terhalang.setVisibility(View.GONE);
        }
        holder.nilai_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(holder.nilai_edit.getText().toString().length()>0){
                    int x=Integer.parseInt(String.valueOf(holder.nilai_edit.getText()));
                    list.get(holder.getAdapterPosition()).setNilai(x);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public interface EventAdapter{
        public void getData();
    }
}
