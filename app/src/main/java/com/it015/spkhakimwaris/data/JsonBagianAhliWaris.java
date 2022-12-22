package com.it015.spkhakimwaris.data;

import com.it015.spkhakimwaris.objek.BagianAhliWaris;
import com.it015.spkhakimwaris.objek.DataTerhalang;

import java.util.ArrayList;
import java.util.List;

public class JsonBagianAhliWaris {
    public String [] value={
            "K1","K2","K3","K4","K5","K6",
            "K7","K8","K9",
            "K10","K11",
            "K12","K13",
            "K14","K15","K16","K17",
            "K18","K19",
            "K20","K21",
            "K22","K23"
    };

   public String [] ahli_waris={
           "Suami","Istri","Anak Laki-laki","Anak Perempuan","Bapak","Ibu",
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

    public List<BagianAhliWaris> getDataTerhalang(){
        List<BagianAhliWaris> list=new ArrayList<>();
        for(int i=0;i< value.length;i++){
            BagianAhliWaris bagianAhliWaris=new BagianAhliWaris(ahli_waris[i],value[i]);
            list.add(bagianAhliWaris);
        }
        return  list;
    }
}
