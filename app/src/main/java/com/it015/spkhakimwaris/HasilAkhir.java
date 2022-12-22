package com.it015.spkhakimwaris;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.it015.spkhakimwaris.adapter.HasilAkhirAdapter;
import com.it015.spkhakimwaris.objek.DataHasil;
import com.it015.spkhakimwaris.utils.LCM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HasilAkhir extends AppCompatActivity {
    double jumlah_warisan=0;

    List<String> nama_ashobah=new ArrayList<>();
    TextView txt_jenis_masalah;
    String jenis_masalah;

    int anak_laki;
    int anak_perempuan;
    int suami;
    int istri;
    int bapak;
    int ibu;

    int cucu_laki;
    int cucu_perempuan;

    int nenek_dari_bapak;
    int nenek_dari_ibu;
    int kakek_dari_bapak;

    int saudara_laki_sekandung;
    int saudara_perempuan_sekandung;
    int saudara_laki_sebapak;
    int saudara_perempuan_sebapak;
    int saudara_laki_seibu;
    int saudara_perempuan_seibu;

    int anak_laki_saudara_laki_sekandung;
    int anak_laki_saudara_laki_sebapak;

    int paman_kandung_dari_ayah;
    int paman_sekakek_dari_ayah;

    int anak_laki_paman_kandung;
    int anak_laki_paman_sekakek;

    LCM lcm=new LCM();

    boolean status_ashabah=false;
    boolean status_goir=false;

    List<DataHasil> list_data=new ArrayList<>();
    List<DataHasil> list_hasil=new ArrayList<>();

    RecyclerView recycle_result;
    TextView btn_ulang,ashobah_txt,ashobah_bilgoir_txt,total_warisan_txt;
    TextView asal_masalah_txt,total_siham_txt;

    @SuppressLint({"NotifyDataSetChanged", "SetTextI18n"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_result);

        Window window=getWindow();
        window.setStatusBarColor(getResources().getColor(android.R.color.transparent));

        new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightStatusBars(true);

        recycle_result=findViewById(R.id.hasil_akhir_rcy);
        btn_ulang=findViewById(R.id.btn_ulang);

        ashobah_txt=findViewById(R.id.asohbah_binafsihi);
        ashobah_bilgoir_txt=findViewById(R.id.ashobah_bilgoir);
        total_warisan_txt=findViewById(R.id.total_warisan_txt);

        asal_masalah_txt=findViewById(R.id.asal_masalah_txt);
        total_siham_txt=findViewById(R.id.total_siham_txt);

        txt_jenis_masalah=findViewById(R.id.jenis_masalah);

        recycle_result.setHasFixedSize(true);
        recycle_result.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        Bundle b = getIntent().getExtras();
        String Array = b.getString("data");

        btn_ulang.setOnClickListener(v->hitungUlang());

        jumlah_warisan= Double.parseDouble(b.getString("jumlah_harta"));
        List<Integer> num = new ArrayList<>();
        DecimalFormat DF = new DecimalFormat("#,###,###");
        total_warisan_txt.setText("Rp."+DF.format(jumlah_warisan));
        try {
            JSONArray jsonArray = new JSONArray(Array);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String value = jsonObject.getString("value");
                String ahli=jsonObject.getString("ket");
                int nilai = jsonObject.getInt("nilai");
                DataHasil row=new DataHasil();
                row.setValue(value);
                row.setAhli_waris(ahli);
                row.setJumlah(nilai);
                if (value.equals("K1") && nilai > 0) {
                    suami = nilai;
                } else if (value.equals("K2")) {
                    istri = nilai;
                } else if (value.equals("K3")) {
                    anak_laki = nilai;
                } else if (value.equals("K4")) {
                    anak_perempuan = nilai;
                }
                else if (value.equals("K5")) {
                bapak = nilai;
                }
                else if(value.equals("K6")){
                    ibu=nilai;
                }
                else if(value.equals("K7")){
                    kakek_dari_bapak=nilai;
                }
                else if(value.equals("K8")){
                    nenek_dari_bapak=nilai;
                }
                else if(value.equals("K9")){
                    nenek_dari_ibu=nilai;
                }
                else if(value.equals("K10")){
                    cucu_laki=nilai;
                }
                else if(value.equals("K11")){
                    cucu_perempuan=nilai;
                }
                else if(value.equals("K12")){
                    saudara_laki_sekandung=nilai;
                }
                else if(value.equals("K13")){
                    saudara_perempuan_sekandung=nilai;
                }
                else if(value.equals("K14")){
                    saudara_laki_sebapak=nilai;
                }
                else if(value.equals("K15")){
                    saudara_perempuan_sebapak=nilai;
                }
                else if(value.equals("K16")){
                    saudara_laki_seibu=nilai;
                }
                else if(value.equals("K17")){
                    saudara_perempuan_seibu=nilai;
                }
                else if(value.equals("K18")){
                    anak_laki_saudara_laki_sekandung=nilai;
                }else if(value.equals("K19")){
                    anak_laki_saudara_laki_sebapak=nilai;
                }
                else if(value.equals("K20")){
                    paman_kandung_dari_ayah=nilai;
                }else if(value.equals("K21")){
                    paman_sekakek_dari_ayah=nilai;
                }else if(value.equals("K22")){
                    anak_laki_paman_kandung=nilai;
                }else if(value.equals("K23")){
                    anak_laki_paman_sekakek=nilai;
                }



                list_data.add(row);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // aturan suami dan istri
        if(anak_laki>0 || anak_perempuan>0 || cucu_perempuan>0 || cucu_laki>0){
            if(suami>0){
                list_data.get(0).setBagian((double) 1/4);
                list_data.get(0).setKet_bagian("1/4");
                num.add(4);
            }
            else if(istri>0){
                list_data.get(0).setBagian((double) 1/8);
                list_data.get(0).setKet_bagian("1/8");
                num.add(8);
            }
        }
        else{
            if(suami>0){
                list_data.get(0).setBagian((double) 1/2);
                list_data.get(0).setKet_bagian("1/2");
                num.add(2);
            }else if(istri>0){
                list_data.get(0).setBagian((double) 1/4);
                list_data.get(0).setKet_bagian("1/2");
                num.add(4);
            }
        }

        if(ibu>0){
            if(anak_laki>0 || anak_perempuan>0 || cucu_laki>0 || cucu_perempuan>0){
                list_data.get(4).setBagian((double)1/6);
                list_data.get(4).setKet_bagian("1/6");
                num.add(6);
            }
            else if(saudara_laki_sekandung>=2 || saudara_perempuan_sekandung>=2
                    || saudara_laki_sebapak>=2 || saudara_perempuan_sebapak>=2){
                list_data.get(4).setBagian((double)1/6);
                list_data.get(4).setKet_bagian("1/6");
                num.add(6);
            }
            else if(saudara_laki_sekandung>0 && saudara_perempuan_sekandung>0){
                list_data.get(4).setBagian((double)1/6);
                list_data.get(4).setKet_bagian("1/6");
                num.add(6);
            }
            else if(saudara_laki_sebapak>0 && saudara_perempuan_sebapak>0){
                list_data.get(4).setBagian((double)1/6);
                list_data.get(4).setKet_bagian("1/6");
                num.add(6);
            }
            else if(saudara_laki_sekandung>0 || saudara_perempuan_sekandung>0){
                if(saudara_laki_seibu>0 || saudara_perempuan_seibu>0){
                    list_data.get(4).setBagian((double)1/6);
                    list_data.get(4).setKet_bagian("1/6");
                    num.add(6);
                }
                else{
                    list_data.get(4).setBagian((double)1/6);
                    list_data.get(4).setKet_bagian("1/6");
                    num.add(6);
                }
            }
            else if(saudara_laki_sebapak>0 || saudara_perempuan_sebapak>0){
                if(saudara_laki_seibu>0 || saudara_perempuan_seibu>0){
                    list_data.get(4).setBagian((double)1/6);
                    list_data.get(4).setKet_bagian("1/6");
                    num.add(6);
                }
                else{
                    list_data.get(4).setBagian((double)1/6);
                    list_data.get(4).setKet_bagian("1/6");
                    num.add(6);
                }
            }
            else if(saudara_laki_seibu>0 && saudara_perempuan_seibu>0){
                list_data.get(4).setBagian((double)1/6);
                list_data.get(4).setKet_bagian("1/6");
                num.add(6);
            }
            else{
                list_data.get(4).setBagian((double)1/6);
                list_data.get(4).setKet_bagian("1/6");
                num.add(6);
            }
        }


        // aturan untuk nenek(ibu dan ayah)

        if((nenek_dari_bapak>0) && (nenek_dari_ibu>0)){
                double bagian_nenek=(double)1/6;
                double bagian_nenek_bapak=bagian_nenek/2;
                double bagian_nenek_ibu=bagian_nenek/2;
                list_data.get(8).setBagian(bagian_nenek_bapak);
                list_data.get(9).setBagian(bagian_nenek_ibu);
                list_data.get(8).setKet_bagian("1/6");
                list_data.get(8).setKet_bagian("1/6");
                num.add(6);
                num.add(6);
        }
        else{
            if(nenek_dari_bapak>0){
                list_data.get(8).setBagian((double) 1/6);
                list_data.get(8).setKet_bagian("1/6");
                num.add(6);
            }else if(nenek_dari_ibu>0){
                list_data.get(9).setBagian((double) 1/6);
                list_data.get(9).setKet_bagian("1/6");
                num.add(6);

            }
        }

        // aturan untuk bapak dan kakek(anak atau cucu laki-laki)
        if(bapak>0){
            if(anak_laki>0 || cucu_laki>0){
                list_data.get(3).setBagian((double) 1/6);
                list_data.get(3).setKet_bagian("1/6");
                num.add(6);
            }
            else{
                int campuran=anak_perempuan;
                if(ibu>0){
                    if(campuran>0){
                        list_data.get(3).setBagian((double) 1 / 6);
                        status_ashabah = true;
                        list_data.get(3).setStatus_ashobah(true);
                        list_data.get(3).setKet_bagian("1/6 Dan Ashobah");
                        num.add(6);
                    }
                    else{
                        if(istri>0){
                            list_data.get(3).setBagian((double) 2/4);
                            list_data.get(3).setKet_bagian("2/4");
                            num.add(4);
                        }
                        else if(suami>0){
                            list_data.get(3).setBagian((double) 2/6);
                            list_data.get(3).setKet_bagian("2/6");
                            num.add(6);
                        }
                    }


                }
                else{
                    list_data.get(3).setBagian((double) 1 / 6);
                    list_data.get(3).setKet_bagian("1/6");
                    status_ashabah = true;
                    list_data.get(3).setStatus_ashobah(true);
                    num.add(6);
                }
            }
        }
        if(kakek_dari_bapak>0){
            if(anak_laki>1 || cucu_laki>0){
                list_data.get(7).setBagian((double) 1/6);
                list_data.get(7).setKet_bagian("1/6");
                num.add(6);
            }
            else{
                list_data.get(7).setBagian((double) 1 / 6);
                list_data.get(7).setKet_bagian("1/6 Dan Sisa");
                status_ashabah = true;
                list_data.get(7).setStatus_ashobah(true);
                num.add(6);
            }
        }


        int [] ints = new int[20];
        int kpk_new;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            num.removeAll(Collections.singletonList(0));
            ints = num.stream().mapToInt(Integer::intValue).toArray();
        }
        // Aturan untuk anak laki dan perempuan
        if(anak_laki>0 && anak_perempuan>0){
            double pewaris_main=0;
            double bagian_ayah=list_data.get(3).getBagian();
            double bagian_ibu=list_data.get(4).getBagian();
            double bagian_nenek_ayah=list_data.get(8).getBagian();
            double bagian_nenek_ibu=list_data.get(9).getBagian();
            double bagian_kakek_ayah=list_data.get(7).getBagian();
            if(suami>0){
                pewaris_main=list_data.get(0).getBagian();
            }else if(istri>0){
                pewaris_main=list_data.get(0).getBagian();
            }
            kpk_new=lcm.findLCM(ints);
            double sisa=kpk_new-((pewaris_main*kpk_new)+(bagian_ayah*kpk_new)+(bagian_kakek_ayah*kpk_new)+
                    (bagian_ibu*kpk_new)+(bagian_nenek_ayah*kpk_new)+(bagian_nenek_ibu*kpk_new));

            double y=(sisa/2)/kpk_new;
            list_data.get(1).setBagian(y);
            list_data.get(2).setBagian(y);
            list_data.get(1).setStatus_bilgoir(true);
            list_data.get(2).setStatus_bilgoir(true);
            list_data.get(1).setAshobah_bil_goir_1(anak_laki*2);
            list_data.get(2).setAshobah_bil_goir_1(anak_perempuan);
            list_data.get(1).setTotal_bilgoir((anak_laki*2)+anak_perempuan);
            list_data.get(2).setTotal_bilgoir((anak_laki*2)+anak_perempuan);
            list_data.get(1).setKet_bagian("Ashobah");
            list_data.get(2).setKet_bagian("Ashobah BilGoir");
            status_goir=true;
        }
        else if(anak_perempuan>0 || anak_laki>0){
            if(anak_laki>0){
               double pewaris_main=0;
               if(suami>0){
                   pewaris_main=list_data.get(0).getBagian();
               }else if(istri>0){
                   pewaris_main=list_data.get(0).getBagian();
               }
                double bagian_ayah=list_data.get(3).getBagian();
                double bagian_ibu=list_data.get(4).getBagian();
                double bagian_nenek_bapak=list_data.get(8).getBagian();
                double bagian_nenek_ibu=list_data.get(9).getBagian();
                double bagian_kakek_ayah=list_data.get(7).getBagian();

                kpk_new=lcm.findLCM(ints);
                int sisa= (int) (kpk_new-((pewaris_main+bagian_ayah+bagian_ibu+bagian_nenek_bapak+bagian_nenek_ibu+bagian_kakek_ayah)*kpk_new));
                double ashabah_laki;
                nama_ashobah.add(list_data.get(1).getAhli_waris());
                ashabah_laki=(double)(sisa)/kpk_new*(1);
                list_data.get(1).setBagian(ashabah_laki);
                list_data.get(1).setKet_bagian("Ashobah");
            }
           else{
               if(anak_perempuan>=2){
                   list_data.get(2).setBagian((double) 2/3);
                   list_data.get(2).setKet_bagian("2/3");
                   num.add(3);
               }else{
                   list_data.get(2).setBagian((double) 1/2);
                   list_data.get(1).setKet_bagian("1/2");
                   num.add(2);
               }
           }
        }

        // aturan untuk cucu laki dan perempuan
        if(cucu_laki>0 && cucu_perempuan>0){
            double pewaris_main=0;
            double bagian_ayah=list_data.get(3).getBagian();
            double bagian_ibu=list_data.get(4).getBagian();
            double bagian_nenek_ayah=list_data.get(8).getBagian();
            double bagian_nenek_ibu=list_data.get(9).getBagian();
            double bagian_kakek_ayah=list_data.get(7).getBagian();
            double bagian_anak_perempuan=list_data.get(2).getBagian();
            if(suami>0){
                pewaris_main=list_data.get(0).getBagian();
            }else if(istri>0){
                pewaris_main=list_data.get(0).getBagian();
            }
            kpk_new=lcm.findLCM(ints);
            double sisa=kpk_new-((pewaris_main*kpk_new)+(bagian_ayah*kpk_new)+(bagian_kakek_ayah*kpk_new)+
                    (bagian_ibu*kpk_new)+(bagian_nenek_ayah*kpk_new)+(bagian_nenek_ibu*kpk_new)+(bagian_anak_perempuan*kpk_new));

            double y=(sisa/2)/kpk_new;
            list_data.get(5).setBagian(y);
            list_data.get(6).setBagian(y);
            list_data.get(5).setStatus_bilgoir(true);
            list_data.get(6).setStatus_bilgoir(true);
            list_data.get(5).setAshobah_bil_goir_1(cucu_laki*2);
            list_data.get(6).setAshobah_bil_goir_1(cucu_perempuan);
            list_data.get(5).setTotal_bilgoir((cucu_laki*2)+cucu_perempuan);
            list_data.get(6).setTotal_bilgoir((cucu_laki*2)+cucu_perempuan);
            list_data.get(5).setKet_bagian("Ashobah");
            list_data.get(6).setKet_bagian("Ashobah BilGoir");
            status_goir=true;
        }
        else if(cucu_laki>0 || cucu_perempuan>0){
            if(cucu_laki>0){
                double pewaris_main=0;
                if(suami>0){
                    pewaris_main=list_data.get(0).getBagian();
                }else if(istri>0){
                    pewaris_main=list_data.get(0).getBagian();
                }
                double bagian_ayah=list_data.get(3).getBagian();
                double bagian_ibu=list_data.get(4).getBagian();
                double bagian_nenek_bapak=list_data.get(8).getBagian();
                double bagian_nenek_ibu=list_data.get(9).getBagian();
                double bagian_kakek_ayah=list_data.get(7).getBagian();
                double bagian_anak_perempuan=list_data.get(2).getBagian();
                kpk_new=lcm.findLCM(ints);
                int sisa= (int) (kpk_new-((pewaris_main+bagian_ayah+bagian_ibu+bagian_nenek_bapak+
                        bagian_nenek_ibu+bagian_kakek_ayah+bagian_anak_perempuan)*kpk_new));
                double ashabah_laki;
                nama_ashobah.add(list_data.get(5).getAhli_waris());
                ashabah_laki=(double)(sisa)/kpk_new*(1);
                list_data.get(5).setBagian(ashabah_laki);
                list_data.get(5).setKet_bagian("Ashobah");
            }
            else{

                if(anak_perempuan==1){
                    list_data.get(6).setBagian((double)1/6);
                    list_data.get(6).setKet_bagian("1/6");
                }
                else{
                    if(cucu_perempuan>=2){
                        list_data.get(6).setBagian((double)2/3);
                        list_data.get(6).setKet_bagian("2/3");
                        num.add(3);
                    }
                    else{
                        list_data.get(6).setBagian((double)1/2);
                        list_data.get(6).setKet_bagian("1/2");
                        num.add(2);
                    }
                }

            }
        }

        // Aturan saudara laki dan perempuan seibu

        if(saudara_laki_seibu>0 && saudara_perempuan_seibu>0){
            list_data.get(14).setBagian((double)1/6);
            list_data.get(15).setBagian((double)1/6);
            list_data.get(14).setKet_bagian("1/6");
            list_data.get(15).setKet_bagian("1/6");
        }
        else if(saudara_laki_seibu>0 || saudara_perempuan_seibu>0){
            if(saudara_laki_seibu>0){
                list_data.get(14).setBagian((double)1/6);
                list_data.get(14).setKet_bagian("1/6");
            }
            else{
                list_data.get(15).setBagian((double)1/6);
                list_data.get(15).setKet_bagian("1/6");
            }
        }

        // Aturan Untuk Saudara Laki Dan Perempuan Sekandung

        if(saudara_laki_sekandung>0 && saudara_perempuan_sekandung>0){
            double pewaris_main=0;
            double bagian_ayah=list_data.get(3).getBagian();
            double bagian_ibu=list_data.get(4).getBagian();
            double bagian_nenek_ayah=list_data.get(8).getBagian();
            double bagian_nenek_ibu=list_data.get(9).getBagian();
            double bagian_kakek_ayah=list_data.get(7).getBagian();
            double bagian_anak_perempuan=list_data.get(2).getBagian();
            double bagian_cucu_perempuan=list_data.get(6).getBagian();
            double bagian_saudara_laki_seibu=list_data.get(14).getBagian();
            double bagian_saudara_perempuan_seibu=list_data.get(15).getBagian();
            if(suami>0){
                pewaris_main=list_data.get(0).getBagian();
            }else if(istri>0){
                pewaris_main=list_data.get(0).getBagian();
            }
            kpk_new=lcm.findLCM(ints);
            double sisa=kpk_new-((pewaris_main*kpk_new)+(bagian_ayah*kpk_new)+(bagian_kakek_ayah*kpk_new)+
                    (bagian_ibu*kpk_new)+(bagian_nenek_ayah*kpk_new)+(bagian_nenek_ibu*kpk_new)+
                    (bagian_anak_perempuan*kpk_new)+(bagian_cucu_perempuan*kpk_new)+
                    (bagian_saudara_laki_seibu*kpk_new)+(bagian_saudara_perempuan_seibu*kpk_new));
            double y=(sisa/2)/kpk_new;
            list_data.get(10).setBagian(y);
            list_data.get(11).setBagian(y);
            list_data.get(10).setStatus_bilgoir(true);
            list_data.get(11).setStatus_bilgoir(true);
            list_data.get(10).setAshobah_bil_goir_1(saudara_laki_sekandung*2);
            list_data.get(11).setAshobah_bil_goir_1(saudara_perempuan_sekandung);
            list_data.get(10).setTotal_bilgoir((saudara_laki_sekandung*2)+saudara_perempuan_sekandung);
            list_data.get(11).setTotal_bilgoir((saudara_laki_sekandung*2)+saudara_perempuan_sekandung);
            status_goir=true;
            list_data.get(10).setKet_bagian("Ashobah");
            list_data.get(11).setKet_bagian("Ashobah Bilgoir");
        }
        else if(saudara_laki_sekandung>0 || saudara_perempuan_sekandung>0){
            if(saudara_laki_sekandung>0){
                double pewaris_main=0;
                if(suami>0){
                    pewaris_main=list_data.get(0).getBagian();
                }else if(istri>0){
                    pewaris_main=list_data.get(0).getBagian();
                }
                double bagian_ayah=list_data.get(3).getBagian();
                double bagian_ibu=list_data.get(4).getBagian();
                double bagian_nenek_bapak=list_data.get(8).getBagian();
                double bagian_nenek_ibu=list_data.get(9).getBagian();
                double bagian_kakek_ayah=list_data.get(7).getBagian();
                double bagian_anak_perempuan=list_data.get(2).getBagian();
                double bagian_cucu_perempuan=list_data.get(6).getBagian();
                double bagian_saudara_laki_seibu=list_data.get(14).getBagian();
                double bagian_saudara_perempuan_seibu=list_data.get(15).getBagian();
                kpk_new=lcm.findLCM(ints);
                int sisa= (int) (kpk_new-((pewaris_main+bagian_ayah+bagian_ibu+bagian_nenek_bapak+
                        bagian_nenek_ibu+bagian_kakek_ayah+bagian_saudara_laki_seibu+bagian_saudara_perempuan_seibu+
                        bagian_anak_perempuan+bagian_cucu_perempuan)*kpk_new));
                double ashabah_laki;
                nama_ashobah.add(list_data.get(10).getAhli_waris());
                ashabah_laki=(double)(sisa)/kpk_new*(1);
                list_data.get(10).setBagian(ashabah_laki);
                list_data.get(10).setKet_bagian("Ashobah");
            }
            else {
                if(cucu_perempuan>0 || anak_perempuan>0){
                    double pewaris_main=0;
                    if(suami>0){
                        pewaris_main=list_data.get(0).getBagian();
                    }else if(istri>0){
                        pewaris_main=list_data.get(0).getBagian();
                    }
                    double bagian_ibu=list_data.get(4).getBagian();
                    double bagian_nenek_bapak=list_data.get(8).getBagian();
                    double bagian_nenek_ibu=list_data.get(9).getBagian();
                    double bagian_anak_perempuan=list_data.get(2).getBagian();
                    double bagian_cucu_perempuan=list_data.get(6).getBagian();
                    double bagian_saudara_laki_seibu=list_data.get(14).getBagian();
                    double bagian_saudara_perempuan_seibu=list_data.get(15).getBagian();
                    kpk_new=lcm.findLCM(ints);
                    int sisa= (int) (kpk_new-((pewaris_main+bagian_ibu+bagian_nenek_bapak+bagian_nenek_ibu+bagian_anak_perempuan+
                            bagian_cucu_perempuan+bagian_saudara_laki_seibu+bagian_saudara_perempuan_seibu)*kpk_new));
                    double ashabah_saudara_perempuan_sekandung;
                    ashabah_saudara_perempuan_sekandung=(double)(sisa)/kpk_new*(1);
                    list_data.get(11).setBagian(ashabah_saudara_perempuan_sekandung);
                    list_data.get(11).setKet_bagian("Ashobah");
                }
                else{
                    if(saudara_perempuan_sekandung>=2){
                        list_data.get(11).setBagian((double)2/3);
                        list_data.get(11).setKet_bagian("2/3");
                        num.add(3);
                    }
                    else{
                        list_data.get(11).setBagian((double)1/2);
                        list_data.get(11).setKet_bagian("1/2");
                        num.add(2);
                    }
                }
            }
        }

        // Aturan Untuk saudara Laki Dan Perempuan Sebapak

        if(saudara_laki_sebapak>0 && saudara_perempuan_sebapak>0){
            double pewaris_main=0;
            double bagian_ayah=list_data.get(3).getBagian();
            double bagian_ibu=list_data.get(4).getBagian();
            double bagian_nenek_ayah=list_data.get(8).getBagian();
            double bagian_nenek_ibu=list_data.get(9).getBagian();
            double bagian_kakek_ayah=list_data.get(7).getBagian();
            double bagian_anak_perempuan=list_data.get(2).getBagian();
            double bagian_cucu_perempuan=list_data.get(6).getBagian();
            double bagian_saudara_laki_seibu=list_data.get(14).getBagian();
            double bagian_saudara_perempuan_seibu=list_data.get(15).getBagian();
            if(suami>0){
                pewaris_main=list_data.get(0).getBagian();
            }else if(istri>0){
                pewaris_main=list_data.get(0).getBagian();
            }
            kpk_new=lcm.findLCM(ints);
            double sisa=kpk_new-((pewaris_main*kpk_new)+(bagian_ayah*kpk_new)+(bagian_kakek_ayah*kpk_new)+
                    (bagian_ibu*kpk_new)+(bagian_nenek_ayah*kpk_new)+(bagian_nenek_ibu*kpk_new)+
                    (bagian_anak_perempuan*kpk_new)+(bagian_cucu_perempuan*kpk_new)+
                    (bagian_saudara_laki_seibu*kpk_new)+(bagian_saudara_perempuan_seibu*kpk_new));
            double y=(sisa/2)/kpk_new;
            list_data.get(12).setBagian(y);
            list_data.get(13).setBagian(y);
            list_data.get(12).setStatus_bilgoir(true);
            list_data.get(13).setStatus_bilgoir(true);
            list_data.get(12).setAshobah_bil_goir_1(saudara_laki_sebapak*2);
            list_data.get(13).setAshobah_bil_goir_1(saudara_perempuan_sebapak);
            list_data.get(12).setTotal_bilgoir((saudara_laki_sebapak*2)+saudara_perempuan_sebapak);
            list_data.get(13).setTotal_bilgoir((saudara_laki_sebapak*2)+saudara_perempuan_sebapak);
            status_goir=true;
            list_data.get(12).setKet_bagian("Ashobah");
            list_data.get(13).setKet_bagian("Ashobah Bilgoir");
        }
        else if(saudara_laki_sebapak>0 || saudara_perempuan_sebapak>0){
            if(saudara_laki_sebapak>0){
                double pewaris_main=0;
                if(suami>0){
                    pewaris_main=list_data.get(0).getBagian();
                }else if(istri>0){
                    pewaris_main=list_data.get(0).getBagian();
                }
                double bagian_ayah=list_data.get(3).getBagian();
                double bagian_ibu=list_data.get(4).getBagian();
                double bagian_nenek_bapak=list_data.get(8).getBagian();
                double bagian_nenek_ibu=list_data.get(9).getBagian();
                double bagian_kakek_ayah=list_data.get(7).getBagian();
                double bagian_anak_perempuan=list_data.get(2).getBagian();
                double bagian_cucu_perempuan=list_data.get(6).getBagian();
                double bagian_saudara_laki_seibu=list_data.get(14).getBagian();
                double bagian_saudara_perempuan_seibu=list_data.get(15).getBagian();
                kpk_new=lcm.findLCM(ints);
                int sisa= (int) (kpk_new-((pewaris_main+bagian_ayah+bagian_ibu+bagian_nenek_bapak+
                        bagian_nenek_ibu+bagian_kakek_ayah+bagian_saudara_laki_seibu+bagian_saudara_perempuan_seibu+
                        bagian_anak_perempuan+bagian_cucu_perempuan)*kpk_new));
                double ashabah_laki;
                nama_ashobah.add(list_data.get(12).getAhli_waris());
                ashabah_laki=(double)(sisa)/kpk_new*(1);
                list_data.get(12).setBagian(ashabah_laki);
                list_data.get(12).setKet_bagian("Ashobah");
            }
            else {
                if(cucu_perempuan>0 || anak_perempuan>0){
                    double pewaris_main=0;
                    if(suami>0){
                        pewaris_main=list_data.get(0).getBagian();
                    }else if(istri>0){
                        pewaris_main=list_data.get(0).getBagian();
                    }
                    double bagian_ibu=list_data.get(4).getBagian();
                    double bagian_nenek_bapak=list_data.get(8).getBagian();
                    double bagian_nenek_ibu=list_data.get(9).getBagian();
                    double bagian_anak_perempuan=list_data.get(2).getBagian();
                    double bagian_cucu_perempuan=list_data.get(6).getBagian();
                    double bagian_saudara_laki_seibu=list_data.get(14).getBagian();
                    double bagian_saudara_perempuan_seibu=list_data.get(15).getBagian();
                    kpk_new=lcm.findLCM(ints);
                    int sisa= (int) (kpk_new-((pewaris_main+bagian_ibu+
                            bagian_nenek_bapak+bagian_nenek_ibu+bagian_anak_perempuan+
                            bagian_cucu_perempuan+bagian_saudara_laki_seibu+
                            bagian_saudara_perempuan_seibu)*kpk_new));

                    double ashabah_saudara_perempuan_sekandung;
                    ashabah_saudara_perempuan_sekandung=(double)(sisa)/kpk_new*(1);
                    list_data.get(13).setBagian(ashabah_saudara_perempuan_sekandung);
                    list_data.get(13).setKet_bagian("Ashobah");
                }
                else{
                    if(saudara_perempuan_sekandung>0){
                        list_data.get(13).setBagian((double)1/6);
                        list_data.get(13).setKet_bagian("1/6");
                        num.add(6);
                    }
                    else{
                        if(saudara_perempuan_sebapak>=2){
                            list_data.get(13).setBagian((double)2/3);
                            list_data.get(13).setKet_bagian("2/3");
                            num.add(3);
                        }
                        else{
                            list_data.get(13).setBagian((double)1/2);
                            list_data.get(13).setKet_bagian("1/2");
                            num.add(2);
                        }
                    }

                }
            }
        }

        // Aturan Untuk Anak Saudara Laki Sekandung Dan Sebapak

        if(anak_laki_saudara_laki_sekandung>0 || anak_laki_saudara_laki_sebapak>0){
            if(anak_laki_saudara_laki_sekandung>0){
                double bagian_ibu=list_data.get(4).getBagian();
                double bagian_nenek_dari_bapak=list_data.get(8).getBagian();
                double bagian_nenek_dari_ibu=list_data.get(9).getBagian();
                double bagian_utama=list_data.get(0).getBagian();
                double bagian_saudara_perempuan_sekandung=list_data.get(11).getBagian();
                double bagian_saudara_perempuan_sebapak=list_data.get(13).getBagian();
                double bagian_saudara_laki_seibu=list_data.get(14).getBagian();
                double bagian_saudara_perempuan_seibu=list_data.get(15).getBagian();
                kpk_new=lcm.findLCM(ints);
                int sisa= (int) (kpk_new-(bagian_ibu+bagian_nenek_dari_bapak+bagian_nenek_dari_ibu+
                        bagian_utama+bagian_saudara_perempuan_sekandung+bagian_saudara_perempuan_sebapak+
                        bagian_saudara_laki_seibu+bagian_saudara_perempuan_seibu)*(kpk_new));
                double ashabah_laki;
                ashabah_laki=(double)(sisa)/kpk_new*(1);
                nama_ashobah.add(list_data.get(16).getAhli_waris());
                list_data.get(16).setBagian(ashabah_laki);
                list_data.get(16).setKet_bagian("Ashobah");
            }else{
                double bagian_ibu=list_data.get(4).getBagian();
                double bagian_nenek_dari_bapak=list_data.get(8).getBagian();
                double bagian_nenek_dari_ibu=list_data.get(9).getBagian();
                double bagian_utama=list_data.get(0).getBagian();
                double bagian_saudara_perempuan_sekandung=list_data.get(11).getBagian();
                double bagian_saudara_perempuan_sebapak=list_data.get(13).getBagian();
                double bagian_saudara_laki_seibu=list_data.get(14).getBagian();
                double bagian_saudara_perempuan_seibu=list_data.get(15).getBagian();
                kpk_new=lcm.findLCM(ints);
                int sisa= (int) (kpk_new-(bagian_ibu+bagian_nenek_dari_bapak+bagian_nenek_dari_ibu+
                        bagian_utama+bagian_saudara_perempuan_sekandung+bagian_saudara_perempuan_sebapak+
                        bagian_saudara_laki_seibu+bagian_saudara_perempuan_seibu)*(kpk_new));
                double ashabah_laki;
                ashabah_laki=(double)(sisa)/kpk_new*(1);
                nama_ashobah.add(list_data.get(17).getAhli_waris());
                list_data.get(17).setBagian(ashabah_laki);
                list_data.get(17).setKet_bagian("Ashobah");
            }
        }

        // Aturan Untuk Paman Sekandung Dan Sebapak

        if(paman_kandung_dari_ayah>0 || paman_sekakek_dari_ayah>0){
            if(paman_kandung_dari_ayah>0){
                double bagian_ibu=list_data.get(4).getBagian();
                double bagian_nenek_dari_bapak=list_data.get(8).getBagian();
                double bagian_nenek_dari_ibu=list_data.get(9).getBagian();
                double bagian_utama=list_data.get(0).getBagian();
                double bagian_saudara_perempuan_sekandung=list_data.get(11).getBagian();
                double bagian_saudara_perempuan_sebapak=list_data.get(13).getBagian();
                double bagian_saudara_laki_seibu=list_data.get(14).getBagian();
                double bagian_saudara_perempuan_seibu=list_data.get(15).getBagian();
                kpk_new=lcm.findLCM(ints);
                int sisa= (int) (kpk_new-(bagian_ibu+bagian_nenek_dari_bapak+bagian_nenek_dari_ibu+
                        bagian_utama+bagian_saudara_perempuan_sekandung+bagian_saudara_perempuan_sebapak+
                        bagian_saudara_laki_seibu+bagian_saudara_perempuan_seibu)*(kpk_new));
                double ashabah_laki;
                ashabah_laki=(double)(sisa)/kpk_new*(1);
                nama_ashobah.add(list_data.get(18).getAhli_waris());
                list_data.get(18).setBagian(ashabah_laki);
                list_data.get(18).setKet_bagian("Ashobah");
            }else{
                double bagian_ibu=list_data.get(4).getBagian();
                double bagian_nenek_dari_bapak=list_data.get(8).getBagian();
                double bagian_nenek_dari_ibu=list_data.get(9).getBagian();
                double bagian_utama=list_data.get(0).getBagian();
                double bagian_saudara_perempuan_sekandung=list_data.get(11).getBagian();
                double bagian_saudara_perempuan_sebapak=list_data.get(13).getBagian();
                double bagian_saudara_laki_seibu=list_data.get(14).getBagian();
                double bagian_saudara_perempuan_seibu=list_data.get(15).getBagian();
                kpk_new=lcm.findLCM(ints);
                int sisa= (int) (kpk_new-(bagian_ibu+bagian_nenek_dari_bapak+bagian_nenek_dari_ibu+
                        bagian_utama+bagian_saudara_perempuan_sekandung+bagian_saudara_perempuan_sebapak+
                        bagian_saudara_laki_seibu+bagian_saudara_perempuan_seibu)*(kpk_new));
                double ashabah_laki;
                ashabah_laki=(double)(sisa)/kpk_new*(1);
                nama_ashobah.add(list_data.get(19).getAhli_waris());
                list_data.get(19).setBagian(ashabah_laki);
                list_data.get(19).setKet_bagian("Ashobah");
            }
        }

        if(anak_laki_paman_kandung>0 || anak_laki_paman_sekakek>0){
            if(anak_laki_paman_kandung>0){
                double bagian_ibu=list_data.get(4).getBagian();
                double bagian_nenek_dari_bapak=list_data.get(8).getBagian();
                double bagian_nenek_dari_ibu=list_data.get(9).getBagian();
                double bagian_utama=list_data.get(0).getBagian();
                double bagian_saudara_perempuan_sekandung=list_data.get(11).getBagian();
                double bagian_saudara_perempuan_sebapak=list_data.get(13).getBagian();
                double bagian_saudara_laki_seibu=list_data.get(14).getBagian();
                double bagian_saudara_perempuan_seibu=list_data.get(15).getBagian();
                kpk_new=lcm.findLCM(ints);
                int sisa= (int) (kpk_new-(bagian_ibu+bagian_nenek_dari_bapak+bagian_nenek_dari_ibu+
                        bagian_utama+bagian_saudara_perempuan_sekandung+bagian_saudara_perempuan_sebapak+
                        bagian_saudara_laki_seibu+bagian_saudara_perempuan_seibu)*(kpk_new));
                double ashabah_laki;
                ashabah_laki=(double)(sisa)/kpk_new*(1);
                nama_ashobah.add(list_data.get(20).getAhli_waris());
                list_data.get(20).setBagian(ashabah_laki);
                list_data.get(20).setKet_bagian("Ashobah");
            }else{
                double bagian_ibu=list_data.get(4).getBagian();
                double bagian_nenek_dari_bapak=list_data.get(8).getBagian();
                double bagian_nenek_dari_ibu=list_data.get(9).getBagian();
                double bagian_utama=list_data.get(0).getBagian();
                double bagian_saudara_perempuan_sekandung=list_data.get(11).getBagian();
                double bagian_saudara_perempuan_sebapak=list_data.get(13).getBagian();
                double bagian_saudara_laki_seibu=list_data.get(14).getBagian();
                double bagian_saudara_perempuan_seibu=list_data.get(15).getBagian();
                kpk_new=lcm.findLCM(ints);
                int sisa= (int) (kpk_new-(bagian_ibu+bagian_nenek_dari_bapak+bagian_nenek_dari_ibu+
                        bagian_utama+bagian_saudara_perempuan_sekandung+bagian_saudara_perempuan_sebapak+
                        bagian_saudara_laki_seibu+bagian_saudara_perempuan_seibu)*(kpk_new));
                double ashabah_laki;
                ashabah_laki=(double)(sisa)/kpk_new*(1);
                nama_ashobah.add(list_data.get(21).getAhli_waris());
                list_data.get(21).setBagian(ashabah_laki);
                list_data.get(21).setKet_bagian("Ashobah");
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            num.removeAll(Collections.singletonList(0));
            ints = num.stream().mapToInt(Integer::intValue).toArray();
        }
        kpk_new=lcm.findLCM(ints);

        double total_siham= 0;
        double total_shima_ashobah;

        for(DataHasil row:list_data){
            double bagian=row.getBagian();
            double saham=(bagian*kpk_new);
            if(bagian>0){
                total_siham=(total_siham+saham);
            }
        }
        total_shima_ashobah=kpk_new-total_siham;
        android.util.Log.d("Ints", Arrays.toString(ints));
        android.util.Log.d("total siham",total_siham+" "+kpk_new);
        if(status_ashabah){
            if(total_siham<kpk_new){
                total_siham=kpk_new;
            }
        }
        android.util.Log.d("total siham diperbarui",total_siham+" "+kpk_new);
        asal_masalah_txt.setText(String.valueOf(kpk_new));
        total_siham_txt.setText(String.valueOf(total_siham));
        if(kpk_new==0){
            jenis_masalah="Normal";
            if(status_goir){
                int ashobah_utama=list_data.get(1).getAshobah_bil_goir_1();
                int total_ashobah=list_data.get(1).getTotal_bilgoir();
                double siham=(double)ashobah_utama/total_ashobah;
                double harta_bagian_utama=siham*jumlah_warisan;
                list_data.get(1).setHarta_bagian(harta_bagian_utama);
                double sisa=jumlah_warisan-harta_bagian_utama;
                list_data.get(2).setHarta_bagian(sisa);
                for(DataHasil row:list_data){
                    if(row.getJumlah()>0){
                        list_hasil.add(row);
                    }
                }
            }
            else{
                for(DataHasil row:list_data) {
                    if (row.getJumlah() > 0) {
                        row.setHarta_bagian(jumlah_warisan);
                        list_hasil.add(row);
                    }
                }
            }

        }
        else{
            if(total_siham<kpk_new){
                jenis_masalah="Radd";
                double total_harta=0;
                double sisa_harta;
                int sisa_siham= (int) (total_siham-(list_data.get(0).getBagian()*kpk_new));

                if(suami>0 || istri>0){
                    double siham_main= (int) (list_data.get(0).getBagian()*kpk_new);
                    double harta_main=(siham_main/kpk_new)*jumlah_warisan;
                    list_data.get(0).setSaham(siham_main);
                    list_data.get(0).setHarta_bagian(harta_main);
                    list_hasil.add(list_data.get(0));
                    for(int i=1;i<list_data.size();i++){
                        DataHasil row=list_data.get(i);
                        if(row.getBagian()>0){
                            double siham=row.getBagian()*kpk_new;
                            double harta_bagian=(siham/kpk_new)*jumlah_warisan;
                            total_harta=total_harta+harta_bagian;
                            row.setSaham(siham);
                            row.setHarta_bagian(harta_bagian);
                        }
                    }

                    sisa_harta=jumlah_warisan-(total_harta+harta_main);
                    for(int i=1;i<list_data.size();i++){
                        DataHasil row=list_data.get(i);
                        double harta_bagian=((row.getSaham()/sisa_siham)*sisa_harta)+row.getHarta_bagian();
                        row.setHarta_bagian(harta_bagian);
                        if(row.getSaham()>0){
                            list_hasil.add(row);
                        }
                    }
                }
                else{
                    for(DataHasil row:list_data){
                        if(row.getBagian()>0){
                                double siham=row.getBagian()*(kpk_new);
                                double harta_bagian=(siham/total_siham)*jumlah_warisan;
                                row.setHarta_bagian(harta_bagian);
                                row.setSaham(siham);
                                list_hasil.add(row);
                        }
                    }
                }
            }
            else if(total_siham==kpk_new){
                jenis_masalah="Normal";
                double harta_dibagi_semua=jumlah_warisan/kpk_new;
                double sisa_utk_goir=0;
                double total_sisa_goir=0;
                int index_goir=0;
                if(status_goir){
                    for(DataHasil row:list_data){
                        if(row.getBagian()>0){
                            double bagian=row.getBagian();
                            double saham;
                            saham=bagian*kpk_new;
                            double harta_dibagi_non;
                            if(!row.isStatus_bilgoir()){
                                harta_dibagi_non=saham*harta_dibagi_semua;
                                sisa_utk_goir=sisa_utk_goir+harta_dibagi_non;
                                index_goir=index_goir+1;
                                row.setSaham(saham);
                                row.setHarta_bagian(harta_dibagi_non);
                            }
                        }

                    }
                    if(sisa_utk_goir>0){
                        total_sisa_goir=jumlah_warisan-sisa_utk_goir;
                    }

                    for(DataHasil row:list_data){
                        if(row.getBagian()>0){
                            if(row.isStatus_bilgoir()){
                                double k=(double)row.getAshobah_bil_goir_1()/row.getTotal_bilgoir();
                                double harta_bagian_ashobah=k*total_sisa_goir;
                                row.setHarta_bagian(harta_bagian_ashobah);
                            }
                            list_hasil.add(row);
                        }

                    }
                }
                else{
                    for(DataHasil row:list_data){
                        if(row.getBagian()>0){
                            double harta_dibagi;
                            double siham=row.getBagian()*kpk_new;
                            if(row.isStatus_ashobah()){
                                siham=total_shima_ashobah+(row.getBagian()*kpk_new);
                            }
                            harta_dibagi=(siham/kpk_new)*jumlah_warisan;
                            row.setSaham(siham);
                            row.setHarta_bagian(harta_dibagi);
                            list_hasil.add(row);
                        }
                    }
                }
            }
            else if(total_siham>kpk_new){
                jenis_masalah="Aul";
                for(DataHasil row:list_data){
                    double bagian=row.getBagian();
                    int saham= (int) (bagian*kpk_new);
                    if(bagian>0){
                        double harta_bagian=(double) saham/total_siham*jumlah_warisan;
                        row.setHarta_bagian(harta_bagian);
                        row.setSaham(saham);
                        list_hasil.add(row);
                    }

                }
            }
        }

        txt_jenis_masalah.setText(jenis_masalah);
        if(list_hasil.size()>0){
            for(DataHasil row:list_hasil){
                if(row.isStatus_bilgoir()){
                    nama_ashobah.add(row.getAhli_waris());
                }
                double total;
                if(row.getJumlah()>=2){
                  total=row.getHarta_bagian()/2;
                }
                else{
                    total=row.getHarta_bagian();
                }
                row.setHarta_bagian(total);
                row.setFormatRupiah("Rp."+DF.format(total));

            }
            final String s="Tidak Ada";
            if(nama_ashobah.size()==2){
                ashobah_txt.setText(nama_ashobah.get(0));
                ashobah_bilgoir_txt.setText(nama_ashobah.get(1));
            }else if(nama_ashobah.size()==1){
                ashobah_txt.setText(nama_ashobah.get(0));
                ashobah_bilgoir_txt.setText(s);
            }else{

                ashobah_txt.setText(s);
                ashobah_bilgoir_txt.setText(s);
            }
            HasilAkhirAdapter hasilAkhirAdapter;
            hasilAkhirAdapter=new HasilAkhirAdapter(this,list_hasil);
            recycle_result.setAdapter(hasilAkhirAdapter);
            hasilAkhirAdapter.notifyDataSetChanged();

        }

    }

    private void hitungUlang() {
        startActivity(new Intent(this, HitungWaris.class));
        finish();
    }


}
