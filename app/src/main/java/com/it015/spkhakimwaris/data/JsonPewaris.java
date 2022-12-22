package com.it015.spkhakimwaris.data;

import android.widget.Toast;

import com.it015.spkhakimwaris.objek.DataPewaris;
import com.it015.spkhakimwaris.objek.DataTerhalang;

import java.util.ArrayList;
import java.util.List;

public class JsonPewaris {

    public String [] value={
            "K3","K4","K5","K6"
    };

    public double [] bagian={
            0,0,0,0
    };
    public String [] ket={
           "Anak Laki-laki","Anak Perempuan",
            "Bapak","Ibu"
    };

    public String [] jk={
            "L","P","L","P"
    };

    public boolean [] status={
            false,false,false,false
    };
    public int [] step={
            2,2,3,3
    };

    public String [] terhalang ={
            "free","free","free","free"
    };

    public int [] nilai={
            0,0,0,0
    };

    public List<DataPewaris> getDataPewaris(String jenis_kelamin){
        List<DataPewaris> list=new ArrayList<>();
        if(jenis_kelamin.equals("P")){
            final DataPewaris dataPewaris=new DataPewaris("K1","Suami","L",0,false,2,0);
            list.add(dataPewaris);
        }
        else{
            final DataPewaris dataPewaris=new DataPewaris("K2","Istri","P",0,false,2,0);
            list.add(dataPewaris);
        }
        for(int i=0;i< value.length;i++){
            DataPewaris dataPewaris=new DataPewaris(value[i],ket[i],jk[i],nilai[i],status[i],step[i],bagian[i]);
            list.add(dataPewaris);
        }
        return  list;
    }
}
