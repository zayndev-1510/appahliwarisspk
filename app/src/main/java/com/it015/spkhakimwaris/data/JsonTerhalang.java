package com.it015.spkhakimwaris.data;

import com.it015.spkhakimwaris.objek.DataPewaris;
import com.it015.spkhakimwaris.objek.DataTerhalang;

import java.util.ArrayList;
import java.util.List;

public class JsonTerhalang {

    public String [] value={
            "K7","K8","K9",
            "K10","K11",
            "K12","K13",
            "K14","K15","K16","K17",
            "K18","K19",
            "K20","K21",
            "K22","K23"
    };

    public String [] ket={
            "Kakek " +
                    "(Dari Bapak)","Nenek " +
            "(Dari Bapak)","Nenek Dari Ibu",
            "Cucu Laki-Laki","Cucu Perempuan",
            "Saudara Laki-laki Sekandung","Saudara Perempuan Sekandung",
            "Saudara Laki-Laki Seayah","Saudara Perempuan Seayah","Saudara Laki-laki Seibu","Saudara Perempaun Seibu",
            "Anak Saudara Laki-laki (kandung)","Anak Laki-laki saudara (seayah)",
            "Paman Kandung (Dari Ayah)", "Paman Sekakek (Dari Ayah)",
            "Anak Laki-Laki (Paman Sekandung)", "Anak Laki-laki (Paman Sekakek)",
    };

    public String [] jk={
            "L","P","P",
            "L","P",
            "L","P",
            "L","P","L","P",
            "L","L",
            "L","L",
            "L","L"
    };

    public boolean [] status={
            false,false,false,
            false,false,
            false,false,
            false,false,false,false,
            false,false,
            false,false,
            false,false
    };
    public int [] step={
            3,3,3,
            2,2,
            4,4,
            5,5,5,5,
            6,6,
            7,7,
            8,8
    };

    public String [] terhalang ={
            "K5","K6","K6",
            "K3","K4",
            "free","free",
            "K12","K13","free","free",
            "free","free",
            "free","free",
            "free","free"
    };

    public int [] nilai={
            0,0,0,
            0,0,
            0,0,
            0,0,0,0,
            0,0,
            0,0,
            0,0
    };

    public List<DataTerhalang> getDataTerhalang(){
        List<DataTerhalang> list=new ArrayList<>();
        for(int i=0;i< value.length;i++){
            DataTerhalang dataTerhalang=new DataTerhalang();
            dataTerhalang.setValue(value[i]);
            dataTerhalang.setKet(ket[i]);
            dataTerhalang.setStatus(status[i]);
            dataTerhalang.setNilai(nilai[i]);
            dataTerhalang.setStep(step[i]);
            dataTerhalang.setAturan(terhalang[i]);
            dataTerhalang.setJenis_kelamin(jk[i]);
            list.add(dataTerhalang);
        }
        return  list;
    }
}
