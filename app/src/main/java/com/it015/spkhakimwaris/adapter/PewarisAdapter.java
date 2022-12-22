package com.it015.spkhakimwaris.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.it015.spkhakimwaris.R;
import com.it015.spkhakimwaris.holder.PewarisHolder;
import com.it015.spkhakimwaris.objek.DataPewaris;

import java.util.ArrayList;
import java.util.List;



public class PewarisAdapter extends RecyclerView.Adapter<PewarisHolder> {

    Context context;
    List<DataPewaris> list;
    LayoutInflater layoutInflater;
    EventAdapter event;
    List<DataPewaris> list_update;

    boolean isOnTextChanged = false;
    int ExpenseFinalTotal = 0;

    public PewarisAdapter(Context context, List<DataPewaris> list,EventAdapter eventAdapter) {
        this.context = context;
        this.list = list;
        this.event=eventAdapter;

        this.layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public com.it015.spkhakimwaris.holder.PewarisHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.list_pewaris,parent,false);
        return new PewarisHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.it015.spkhakimwaris.holder.PewarisHolder holder, int position) {
        DataPewaris dataPewaris=list.get(position);
        holder.ket_text.setText(dataPewaris.getKet());
        holder.nilai_edit.setText(String.valueOf(dataPewaris.getNilai()));
        String ket=dataPewaris.getKet();
        holder.nilai_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                boolean cek=false;
                 int anak_laki = 0;
                 int anak_perempuan=0;
                 int suami=0;
                 int istri=0;
                if(holder.nilai_edit.getText().toString().length()>0){
                    EditText txt=holder.nilai_edit;
                    int x=Integer.parseInt(String.valueOf(holder.nilai_edit.getText()));
                    list.get(holder.getAdapterPosition()).setNilai(x);
                    for(DataPewaris row:list){
                            if((row.getNilai()>0) && (row.getValue().equals("K3"))){
                                anak_laki=row.getNilai();
                            }
                            else if((row.getNilai()>0) && (row.getValue().equals("K4"))){
                                anak_perempuan=row.getNilai();
                            }
                            else if((row.getNilai()>0) && (row.getValue().equals("K1"))){
                                suami=row.getNilai();
                            }
                            else if((row.getNilai()>0) && (row.getValue().equals("K2"))){
                                istri=row.getNilai();
                            }
                    }
                    if(istri>=2){
                        Toast.makeText(context,"Istri Tidak Boleh Dari 1 "+istri,Toast.LENGTH_LONG).show();
                        list.get(0).setNilai(0);
                    }
                    else if(suami>=2){
                        Toast.makeText(context,"Istri Tidak Boleh Dari 1 "+istri,Toast.LENGTH_LONG).show();
                        list.get(0).setNilai(0);
                    }

                    if(anak_perempuan>0){
                        if(anak_laki==0){
                          if(anak_perempuan>=2){
                              list.get(2).setBagian((double)2/3);
                          }else{
                              list.get(2).setBagian((double)1/2);
                          }
                        }
                        else {
                            list.get(2).setBagian(1);
                        }
                    }
                    if(anak_laki>0 || anak_perempuan>0){
                        if(suami>0){
                            list.get(0).setBagian((double)1/4);
                        }
                        else if(istri>0){
                            list.get(0).setBagian((double)1/8);
                        }
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
    @SuppressLint("NotifyDataSetChanged")


    @Override

    public int getItemCount() {
        return list.size();
    }
    public interface EventAdapter{
        public void getData();
    }
}
