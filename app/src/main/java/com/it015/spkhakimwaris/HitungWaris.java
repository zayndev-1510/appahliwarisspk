package com.it015.spkhakimwaris;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.it015.spkhakimwaris.adapter.PewarisAdapter;
import com.it015.spkhakimwaris.adapter.TerhalangAdapter;
import com.it015.spkhakimwaris.data.JsonPewaris;
import com.it015.spkhakimwaris.data.JsonTerhalang;
import com.it015.spkhakimwaris.objek.DataPewaris;
import com.it015.spkhakimwaris.objek.DataTerhalang;
import com.it015.spkhakimwaris.utils.CurrenyMoney;
import com.it015.spkhakimwaris.utils.EventEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class HitungWaris extends AppCompatActivity {

    List<DataPewaris> list_pewaris;
    List<DataTerhalang> list_terhalang;
    List<DataTerhalang> list_temp=new ArrayList<>();
    List<DataPewaris> list_penampung;
    List<DataTerhalang> list_new;

    List<JSONObject> last_data=new ArrayList<>();

    int counter=1;
    int k=0;

    boolean cek_btn=false;
    boolean status=true;

    String jenis_kelamin=null;
    JsonPewaris json_pewaris=new JsonPewaris();
    JsonTerhalang jsonTerhalang=new JsonTerhalang();


    RecyclerView recyclerViewPewaris,recycterhalang;
    PewarisAdapter.EventAdapter eventAdapter;
    PewarisAdapter pewarisAdapter;
    TerhalangAdapter terhalangAdapter;
    TextView next,back;
    TextView ket_pewaris,btn_jk_l,btn_jk_p;
    String ket_name="Jumlah Harta Warisan";
    LinearLayout linear_jk;
    LinearLayout linear_harta;
    String caption_btn;
    EditText jumlah_harta_edit;
    EditText jumlah_biaya_jenazah;
    EditText jumlah_hutang;
    TextView harta_dibagi;

    Double valueharta=0.0;
    Double valuejenazah=0.0;
    Double valuehutang=0.0;
    Double totaldibagi=0.0;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        Window window=getWindow();
        window.setStatusBarColor(getResources().getColor(android.R.color.transparent));

        new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightStatusBars(true);


        recyclerViewPewaris=findViewById(R.id.loadPewaris);
        recycterhalang=findViewById(R.id.loadTerhalang);
        ket_pewaris=findViewById(R.id.ket_pewaris);
        jumlah_harta_edit=findViewById(R.id.jumlah_harta);
        jumlah_biaya_jenazah=findViewById(R.id.jumlah_biaya_jenazah);
        jumlah_hutang=findViewById(R.id.jumlah_biaya_utang);
        linear_jk=findViewById(R.id.linear_jk);
        btn_jk_l=findViewById(R.id.btn_jk_l);
        btn_jk_p=findViewById(R.id.btn_jk_p);
        harta_dibagi=findViewById(R.id.harta_dibagi);
        linear_harta=findViewById(R.id.linear_harta_warisan);

        next=findViewById(R.id.next);
        back=findViewById(R.id.back);

        list_pewaris=new ArrayList<>();

        recyclerViewPewaris.setHasFixedSize(true);
        recyclerViewPewaris.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recycterhalang.setHasFixedSize(true);
        recycterhalang.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        linear_harta.setVisibility(View.VISIBLE);
        jumlah_harta_edit.addTextChangedListener(new CurrenyMoney(jumlah_harta_edit));
        jumlah_harta_edit.setText("0");

        jumlah_biaya_jenazah.addTextChangedListener(new CurrenyMoney(jumlah_biaya_jenazah));
        jumlah_biaya_jenazah.setText("0");

        jumlah_hutang.addTextChangedListener(new CurrenyMoney(jumlah_hutang));
        jumlah_hutang.setText("0");


        jumlah_harta_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                   if(jumlah_harta_edit.getText().toString().length()>0){
                       BigDecimal value = CurrenyMoney.parseCurrencyValue(jumlah_harta_edit.getText().toString());
                        valueharta=value.doubleValue();

                        if(valueharta>0 || valuehutang>0 || valuejenazah>0){
                            totaldibagi=valueharta-valuehutang-valuejenazah;

                            DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
                            DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

                            formatRp.setCurrencySymbol("Rp. ");
                            formatRp.setMonetaryDecimalSeparator(',');
                            formatRp.setGroupingSeparator('.');

                            kursIndonesia.setDecimalFormatSymbols(formatRp);
                            harta_dibagi.setText(kursIndonesia.format(totaldibagi));
                        }


                   }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
    });
        jumlah_hutang.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (jumlah_hutang.getText().toString().length() > 0) {
                    BigDecimal value = CurrenyMoney.parseCurrencyValue(jumlah_hutang.getText().toString());
                    valuehutang=value.doubleValue();
                    totaldibagi=valueharta-valuehutang-valuejenazah;

                    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
                    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

                    formatRp.setCurrencySymbol("Rp. ");
                    formatRp.setMonetaryDecimalSeparator(',');
                    formatRp.setGroupingSeparator('.');

                    kursIndonesia.setDecimalFormatSymbols(formatRp);
                    harta_dibagi.setText(kursIndonesia.format(totaldibagi));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        jumlah_biaya_jenazah.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (jumlah_biaya_jenazah.getText().toString().length() > 0) {
                    BigDecimal value = CurrenyMoney.parseCurrencyValue(jumlah_biaya_jenazah.getText().toString());
                    valuejenazah=value.doubleValue();
                    totaldibagi=valueharta-valuehutang-valuejenazah;
                    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
                    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

                    formatRp.setCurrencySymbol("Rp. ");
                    formatRp.setMonetaryDecimalSeparator(',');
                    formatRp.setGroupingSeparator('.');

                    kursIndonesia.setDecimalFormatSymbols(formatRp);
                    harta_dibagi.setText(kursIndonesia.format(totaldibagi));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ket_pewaris.setText(ket_name);

        btn_jk_l.setOnClickListener(v->{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                btn_jk_l.setBackgroundResource(R.drawable.btn_border_color);
                btn_jk_p.setBackgroundResource(R.drawable.btn_border);
                jenis_kelamin="L";
            }
        });
        btn_jk_p.setOnClickListener(v->{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                btn_jk_p.setBackgroundResource(R.drawable.btn_border_color);
                btn_jk_l.setBackgroundResource(R.drawable.btn_border);
                jenis_kelamin="P";
            }
        });

        next.setOnClickListener(view -> {
            if(totaldibagi<=1500000){
                Toast.makeText(getApplicationContext(),"Harta Warisan Minimal 1500000",Toast.LENGTH_LONG).show();

            }else{
                moveNext();
            }
        });

          back.setOnClickListener(v->moveBack());
    }

    private void moveBack() {
        status=false;
        caption_btn="Lanjut";
        cek_btn=false;
        if(counter==2){
            counter=1;
            ket_name="Berapakah jumlah warisan yg ditinggalkan?";
            linear_harta.setVisibility(View.VISIBLE);
            linear_jk.setVisibility(View.GONE);
        }
        else if(counter==3){
            ket_name="Siapakah Pewaris Yang Meninggalkan Warisan?";
            linear_harta.setVisibility(View.GONE);
            linear_jk.setVisibility(View.VISIBLE);
            recycterhalang.setVisibility(View.GONE);
            recyclerViewPewaris.setVisibility(View.GONE);
        }
        else if(counter==4){
            ket_name="Data Keluarga";
            linear_harta.setVisibility(View.GONE);
            recyclerViewPewaris.setVisibility(View.VISIBLE);
            recycterhalang.setVisibility(View.GONE);
            linear_jk.setVisibility(View.GONE);
            loadListDataPewaris();
        }
        else if(counter==5){
            ket_name="Anak Cucu";
            loadlistDown();
        }
        else if(counter==6){
            ket_name="Kakek Nenek";
            loadlistDown();

        }
        else if(counter==7){
            ket_name="Saudara Kandung";
            loadlistDown();

        }
        else if(counter==8){
            ket_name="Saudara Tiri";
            loadlistDown();

        }
        else if(counter==9){
            ket_name="Anak Saudara";
            loadlistDown();

        }
        else if(counter==10){
            ket_name="Paman";
            loadlistDown();

        }
        else if(counter==11){
            ket_name="Anak Paman";
            loadlistDown();
        }


        next.setText(caption_btn);
        ket_pewaris.setText(ket_name);


        if(counter>1){
            counter--;
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    private void loadlistDown() {
        int x;
        list_new=new ArrayList<>();
        x=counter-3;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            list_temp.removeIf(i ->i.getStep()>x);
        }
        for(DataTerhalang row:list_temp){
            if(row.getStep()==x){
                list_new.add(row);
            }
        }
        terhalangAdapter=new TerhalangAdapter(this,list_new,eventAdapter);
        recycterhalang.setAdapter(terhalangAdapter);
        terhalangAdapter.notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void moveNext() {
        status=true;
        list_penampung=new ArrayList<>();
        list_new=new ArrayList<>();

        if(counter==1){
            back.setVisibility(View.VISIBLE);
            ket_name="Siapakah Pewaris Yang Meninggalkan Warisan?";
            linear_harta.setVisibility(View.GONE);
            linear_jk.setVisibility(View.VISIBLE);
        }
        else if(counter==2){
            ket_name="Data Keluarga";
            linear_harta.setVisibility(View.GONE);
            recyclerViewPewaris.setVisibility(View.VISIBLE);
            recycterhalang.setVisibility(View.GONE);
            linear_jk.setVisibility(View.GONE);
            loadListDataPewaris();
        }
        else if(counter==3){
            ket_name="Anak Cucu";
            loadListTerhalang();
        }
        else if(counter==4){
            ket_name="Kakek Nenek";
            loadListTerhalang();
        }
        else if(counter==5){
            ket_name="Saudara Kandung";
            loadListTerhalangAkhir();
        }
        else if(counter==6){
            ket_name="Saudara Tiri";
            loadListTerhalangAkhir();
        }
        else if(counter==7){
            ket_name="Anak Saudara";
            loadListTerhalangAkhir();
        }
        else if(counter==8){
            ket_name="Paman";
            loadListTerhalangAkhir();
        }
        else if(counter==9){
            ket_name="Anak Paman";
            loadListTerhalangAkhir();
            caption_btn="Selesai";
            next.setText(caption_btn);
            cek_btn=true;
        }
        else if(cek_btn){
           for(DataPewaris row:list_pewaris){
                    JSONObject jsonObject=new JSONObject();
                try {
                    jsonObject.put("value",row.getValue());
                    jsonObject.put("step",row.getStep());
                    jsonObject.put("nilai",row.getNilai());
                    jsonObject.put("ket",row.getKet());
                    jsonObject.put("status",row.isStatus());
                    jsonObject.put("aturan","free");
                    jsonObject.put("jk",row.getJenis_kelamin());
                    last_data.add(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            for(DataTerhalang row:list_temp){
                JSONObject jsonObject=new JSONObject();
                try {
                    jsonObject.put("value",row.getValue());
                    jsonObject.put("step",row.getStep());
                    jsonObject.put("nilai",row.getNilai());
                    jsonObject.put("ket",row.getKet());
                    jsonObject.put("status",row.isStatus());
                    jsonObject.put("aturan",row.getAturan());
                    jsonObject.put("jk",row.getJenis_kelamin());
                    last_data.add(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            Intent new_intent=new Intent(this, HasilAkhir.class);
            Bundle b = new Bundle();
            b.putString("data",last_data.toString());
            b.putString("jumlah_harta", String.valueOf(totaldibagi));
            new_intent.putExtras(b);
            startActivity(new_intent);




        }

        ket_pewaris.setText(ket_name);
        counter++;


    }

    @SuppressLint({"NewApi", "NotifyDataSetChanged"})
    private void loadListTerhalangAkhir() {
            int y=0;
            int x=counter-1;
            int z=counter-2;
            int check_condition=0;
            int check_row=0;
        if(counter==5){
              for (DataPewaris row:list_pewaris){
                if (row.getJenis_kelamin().equals("L") && row.getNilai() > 0) {
                    k = 1;
                    break;
                }
            }
            for(DataTerhalang row:list_temp){
                int nilai=row.getNilai();
                String jk=row.getJenis_kelamin();
                if(jk.equals("L") && nilai>0){
                    y=1;
                    break;
                }
            }
            if(y==0 && k==0) {
                for (DataTerhalang row : list_terhalang) {
                    int step_data = row.getStep();
                    if (step_data == x) {
                        row.setStatus(false);
                        list_new.add(row);
                    }
                }
            }
            else if(y>0 && k==0){
                for (DataTerhalang row : list_terhalang) {
                    int step_data = row.getStep();
                    if (step_data == x) {
                        row.setStatus(true);
                        list_new.add(row);
                    }
                }
            }
            else if(y==0 && k>0){
                for (DataTerhalang row : list_terhalang) {
                    int step_data = row.getStep();
                    if (step_data == x) {
                        row.setStatus(true);
                        list_new.add(row);
                    }
                }
            }
            else{
                for (DataTerhalang row : list_terhalang) {
                    int step_data = row.getStep();
                    if (step_data == x) {
                        row.setStatus(true);
                        list_new.add(row);
                    }
                }
            }
        }
        else if(counter==6){
            for(DataTerhalang row:list_temp){
                    String value=row.getValue();
                    int nilai=row.getNilai();

                    if(row.getStep()==z) {
                        if(value.equals("K12") && nilai==0){
                            check_row=check_row+1;
                        }
                        else if(value.equals("K13") && nilai==0){
                            check_row=check_row+1;
                        }
                        else if(value.equals("K12") && nilai>0 ){
                            check_condition=1;
                            for(DataTerhalang respon:list_terhalang){
                                int step=respon.getStep();
                                if(step==x){
                                    respon.setStatus(true);
                                    list_new.add(respon);
                                }

                            }
                        }
                        else if(value.equals("K13") && nilai>0){
                            if(check_condition==0){
                                if(nilai>=2){
                                    for(DataTerhalang res:list_terhalang){
                                        String aturan=res.getAturan();
                                        if(aturan.equals("K13")){
                                            res.setStatus(true);
                                        }
                                        if(res.getStep()==x){
                                            list_new.add(res);
                                        }
                                    }
                                }
                                else {
                                    for(DataTerhalang res:list_terhalang){
                                        int step=res.getStep();
                                        if(step==x){
                                            list_new.add(res);

                                        }
                                    }
                                }
                            }
                        }
                    }
            }
            if(k>0){
                for(DataTerhalang row:list_terhalang){
                    if(row.getStep()==x){
                        row.setStatus(true);
                        list_new.add(row);
                    }
                }
            }
            else{
                if(check_row==2){
                    for(DataTerhalang row:list_terhalang){
                        if(row.getStep()==x){
                            list_new.add(row);
                        }
                    }
                }

            }

        }
        else if(counter==7){
            int k14=0;
            int k15=0;
            for(DataTerhalang row:list_temp){
                String value=row.getValue();
                int nilai=row.getNilai();

                if(row.getStep()==z) {
                    if(value.equals("K14") && nilai==0){
                        check_row=check_row+1;
                    }
                    else if(value.equals("K15") && nilai==0){
                        check_row=check_row+1;
                    }
                    else if(value.equals("K14") && nilai>0 ){
                        k14=nilai;
                    }
                    else if(value.equals("K15") && nilai>0){
                        k15=nilai;
                    }

                }
            }

            if(k14>0){
                for(DataTerhalang row:list_terhalang){
                    if(row.getStep()==x){
                        row.setStatus(true);
                        list_new.add(row);
                    }
                }
            }
            else if(k15>0){
                for(DataTerhalang row:list_terhalang){
                    if(row.getStep()==x){
                        row.setStatus(false);
                        list_new.add(row);
                    }
                }
            }
            else{
                for(DataTerhalang row:list_terhalang){
                    if(row.getStep()==x){
                        row.setStatus(false);
                        list_new.add(row);
                    }
                }

            }

            if(k>0){
                for(DataTerhalang row:list_terhalang){
                    if(row.getStep()==x){
                        row.setStatus(true);
                        list_new.add(row);
                    }
                }
            }

        }
        else if(counter==8){

            for(DataTerhalang row:list_temp){
                if(row.getStep()==z){
                    if(row.getNilai()>0){
                        check_row=check_row+1;
                        for(DataTerhalang res:list_terhalang){
                            if(res.getStep()==x){
                                res.setStatus(true);
                                list_new.add(res);
                            }
                        }
                    }
                }
            }
            if(k>0){
                for(DataTerhalang res:list_terhalang){
                    if(res.getStep()==x){
                        res.setStatus(true);
                        list_new.add(res);
                    }
                }
            }
            else{
                if(check_row==0){
                    for(DataTerhalang res:list_terhalang){
                        if(res.getStep()==x){
                            list_new.add(res);
                        }
                    }
                }
            }

        }
        else if(counter==9){

            for(DataTerhalang row:list_temp){
                if(row.getStep()==z){
                    if(row.getNilai()>0){
                        check_row=check_row+1;
                    }
                }
            }
            if(k>0){
                for(DataTerhalang res:list_terhalang){
                    if(res.getStep()==x){
                        res.setStatus(true);
                        list_new.add(res);
                    }
                }
            }
            else{
                if(check_row==0){
                    for(DataTerhalang res:list_terhalang){
                        if(res.getStep()==x){
                            res.setStatus(false);
                            list_new.add(res);
                        }
                    }
                }
                else{
                    for(DataTerhalang res:list_terhalang){
                        if(res.getStep()==x){
                            res.setStatus(true);
                            list_new.add(res);
                        }
                    }
                }
            }


        }


        terhalangAdapter=new TerhalangAdapter(this,list_new,eventAdapter);
        recycterhalang.setAdapter(terhalangAdapter);
        terhalangAdapter.notifyDataSetChanged();
        list_temp.addAll(list_new);


    }

    @SuppressLint("NotifyDataSetChanged")
    private void loadListDataPewaris() {
        list_pewaris=json_pewaris.getDataPewaris(jenis_kelamin);

        pewarisAdapter=new PewarisAdapter(this,list_pewaris,eventAdapter);
        recyclerViewPewaris.setAdapter(pewarisAdapter);
        pewarisAdapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void loadListTerhalang() {

        recyclerViewPewaris.setVisibility(View.GONE);
        recycterhalang.setVisibility(View.VISIBLE);
        list_terhalang=jsonTerhalang.getDataTerhalang();

        int x=counter-1;
        int anak_laki=0;
        int anak_perempuan=0;
        int suami=0;
        int istri=0;
        int ibu=0;
        int ayah=0;

        for(DataPewaris row:list_pewaris){
            if(row.getStep()==x){
               String value=row.getValue();
               int nilai=row.getNilai();

                if(row.getNilai()>0){
                    switch (value) {
                        case "K3":
                            anak_laki = nilai;
                            break;
                        case "K4":
                            anak_perempuan = nilai;
                            break;
                        case "K1":
                            suami = nilai;
                            break;
                        case "K2":
                            istri = nilai;
                            break;
                        case "K5":
                            ayah = nilai;
                            break;
                        case "K6":
                            ibu = nilai;
                            break;
                    }

                    list_penampung.add(row);
                }
            }

        }

        if(list_penampung.size()==0){
            for(DataTerhalang row:list_terhalang){
                if(row.getStep()==x){
                    list_new.add(row);
                }
            }
        }
        else{
            if(counter==3){
                if(suami>0 || istri>0){
                    if (anak_laki > 0 || anak_perempuan > 0)
                    {
                        if(anak_laki>0){
                            for(DataTerhalang respon:list_terhalang){
                                if(respon.getStep()==x){
                                    respon.setStatus(true);
                                    list_new.add(respon);
                                }
                            }
                        }else if(anak_perempuan>=2){
                            for(int i=0;i<list_terhalang.size();i++){
                                if(list_terhalang.get(i).getStep()==x){
                                    DataTerhalang res=list_terhalang.get(i);
                                    if(res.getAturan().equals("K4")){
                                        res.setStatus(true);
                                    }
                                    list_new.add(res);
                                }
                            }
                        }
                        else{
                            for(DataTerhalang respon:list_terhalang){
                                if(respon.getStep()==x){
                                    list_new.add(respon);
                                }
                            }
                        }

                    }
                    else{
                        android.util.Log.d("kondisi 5","terpenuhi");
                        for(DataTerhalang row:list_terhalang){
                            if(row.getStep()==x){
                                list_new.add(row);
                            }
                        }
                    }

                }
                else if(suami==0 || istri==0){
                    if (anak_laki > 0 && anak_perempuan > 0)
                    {
                        for(DataTerhalang respon:list_terhalang){
                            if(respon.getStep()==x){
                                respon.setStatus(true);
                                list_new.add(respon);
                            }
                        }
                    }
                    else if(anak_laki>0 || anak_perempuan>0){
                        if(anak_laki>0){

                            for(DataTerhalang respon:list_terhalang){
                                if(respon.getStep()==x){
                                    respon.setStatus(true);
                                    list_new.add(respon);
                                }
                            }
                        }
                        else if(anak_perempuan>=2){
                            for(int i=0;i<list_terhalang.size();i++){
                                if(list_terhalang.get(i).getStep()==x){
                                    DataTerhalang res=list_terhalang.get(i);
                                    if(res.getAturan().equals("K4")){
                                        res.setStatus(true);
                                    }
                                    list_new.add(res);
                                }
                            }
                        }
                        else {
                            for(DataTerhalang respon:list_terhalang){
                                if(respon.getStep()==x){
                                    respon.setStatus(false);
                                    list_new.add(respon);
                                }
                            }
                        }
                    }
                }
            }


            else if(counter==4){

                if(ayah>0 && ibu>0){
                    for(DataTerhalang row:list_terhalang){
                        if(row.getStep()==x){
                            row.setStatus(true);
                            list_new.add(row);
                        }
                    }
                }

                else if(ayah>0 || ibu>0){
                    if(ayah>0){
                        for(DataTerhalang row:list_terhalang){
                            if(row.getStep()==x){
                                for(int i=0;i<2;i++) {
                                    list_terhalang.get(i).setStatus(true);
                                }
                                    list_new.add(row);
                            }
                        }
                    }
                    else{
                        for(DataTerhalang row:list_terhalang){
                            if(row.getStep()==x){
                                list_terhalang.get(0).setStatus(true);
                                list_new.add(row);
                            }
                        }
                    }
                }
            }
        }

        recyclerViewPewaris.setVisibility(View.GONE);
        recycterhalang.setVisibility(View.VISIBLE);

        terhalangAdapter=new TerhalangAdapter(this,list_new,eventAdapter);
        recycterhalang.setAdapter(terhalangAdapter);
        terhalangAdapter.notifyDataSetChanged();
        list_temp.addAll(list_new);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,HomePage.class));
        finish();
    }
}