package com.it015.spkhakimwaris.data;

import com.it015.spkhakimwaris.objek.AturanWaris;
import com.it015.spkhakimwaris.objek.DataTerhalang;

import java.util.ArrayList;
import java.util.List;

public class JsonAturan {

    public String [] aturan={
           "K2,K3,K4"
    };
    public String[] bagian ={
            "1/8,7/24,7/12"
    };
    public double[] kpk ={
            8
    };

    public List<AturanWaris> getDataAturan(){
        List<AturanWaris> list=new ArrayList<>();
        for(int i=0;i< aturan.length;i++){
           AturanWaris row=new AturanWaris();
           row.setAturan(aturan[i]);
           row.setBagian(bagian[i]);
           row.setKpk(kpk[i]);
           list.add(row);
        }
        return  list;
    }

}
