package com.it015.spkhakimwaris.data;

import com.it015.spkhakimwaris.objek.BagianAhliWaris;
import com.it015.spkhakimwaris.objek.DetailbagianModel;

import java.util.ArrayList;
import java.util.List;

public class JsonDetailBagianAhliWaris {

    public String [] value={
            "K1",
            "K1",
            "K2",
            "K2",
            "K2",
            "K3",
            "K3",
            "K4",
            "K4",
            "K4",
            "K5",
            "K5",
            "K5",
            "K5",
            "K6",
            "K6",
            "K6",
            "K6",
            "K6",
            "K6"
    };

    public String []data={
           "1. Suami atau duda yang ditinggal mati istri mendapat 1/2 (setengah)" +
                   " apabila istri tidak punya keturunan yang mewarisi yaitu anak laki- laki dan perempuan, cucu lak-laki dan kebawah, " +
                   "sedang cucu perempuan tidak menerima warisan.",
                           "2. Suami mendapat 1/4 apabila ada keturunan yang mewarisi, baik mereka berasal dari " +
                                   "hubungan dengan suami yang sekarang atau suami yang lain.",
           "1. Istri atau janda yang ditinggal mati suami mendapata 1/4 bagian apabila tidak ada keturunan yang" +
                   "yaitu anak laki dan perempuan,cucu laki-laki dan kebawah.",
           "2. Istri mendapat 1/8 bagian apabila suami punya keturunan yang mewarisi" +
                   "baik dari istri sekarang atau istri yang lain.",
            "3. Istri yang lebih dari harus berbagi dari bagian 1/4 atau 1/8 tersebut",

            "1. Anak Laki-laki selalu mendapat ashobah atau sisa harta " +
                    "setelah dibagikan pada ahli waris yang lain",
            "2. Dalam ilmu faraidh, anak laki-laki disebut ahli waris ashobah binfasih",
            "1. Anak Perempuan mendapat 1/2 harta apabila sendirian (anak tunggal) dan tidak ada anak laki-laki",
            "2. Anak perempuan mendapat 2/3 harta apabila lebih dari satu dan tidak ada anak laki-laki",
            "3. Anak perempuan mendapat bagian ashobah apabila ada anak-lakilaki.Dalam keadaan ini maka" +
                    "4. anak perempuan mendapat setengah atau separuh bagian anak laki-laki.(QS: An-Nisa' 4:11)",
            "1. Ayah Mendapat 1/3 bagian bila pewaris tidak meninggalkan anak",
            "2. Ayah Mendapat bagian 1/6 apabila ada keturunan pewaris anak yang laki-laki seperti anak atau cucu laki-laki dan kebawah.",
            "3. Ayah Mendapat bagian ashobah dan bagian pasti sekaligus apabila ada keturunan pewaris yang perempuan yaitu" +
                    "anak perempuan atau cucu perempuan dan kebawah. Maka ayah mendapat 1/6 dan ashobah.",
            "4. Yang terhalang karna ayah adalah saudara laki-laki kandung, saudara laki-laki sebapak," +
                    "saudara laki-laki seibu. Semua tidak mendapat warisan karna adanya ayah atau kakek.",
            "1. Ibu mendapat 1/3 warisan dengan syarat tidak ada keturunan pewaris yaitu anak,cucu,dst; tidak berkumpulnya " +
                    "beberapa saudara laki-laki dan sudara perempuan; tidak adanya salah satu dari dua masalah umroh.",
            "2. Ibu mendapat 1/6 apabila pewaris punya keturunan yaitu anak,cucu,kebawah; atau adanya 2 saudara anak laki-laki " +
                    "dan perempuan atau lebih.",
            "3. Ibu mendapat 1/3 sisanya dalam masalah umaritain (umar dua).",
            "4. Ibu mendapat 1/3 dari sisa agar supaya tidak melibihi bagian bapak karna keduanya sederajat " +
                    "dari awal dan supaya laki-laki mendapat bagian 2 kali lipat dari perempuan. (QS An-nisa' 4:11)",
    };

    public List<DetailbagianModel> getDetailBagian(String str_filter){
        List<DetailbagianModel> list=new ArrayList<>();
        for(int i=0;i< data.length;i++){
            DetailbagianModel row=new DetailbagianModel(value[i],data[i]);
            if(row.getValue().equals(str_filter)){
                list.add(row);
            }
             }
        return  list;
    }

}
