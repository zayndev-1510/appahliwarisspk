package com.it015.spkhakimwaris;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.it015.spkhakimwaris.adapter.BagianAhliWarisAdapter;
import com.it015.spkhakimwaris.data.JsonBagianAhliWaris;
import com.it015.spkhakimwaris.objek.BagianAhliWaris;

import java.util.ArrayList;
import java.util.List;

public class BagianAhliWarisPage extends AppCompatActivity {
    RecyclerView rcy_bagian_ahli_waris;
    BagianAhliWarisAdapter adapter;
    List<BagianAhliWaris> list=new ArrayList<>();
    JsonBagianAhliWaris json=new JsonBagianAhliWaris();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bagian_ahli_waris);
        Window window=getWindow();
        window.setStatusBarColor(getResources().getColor(android.R.color.transparent));

        new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightStatusBars(true);
        rcy_bagian_ahli_waris=findViewById(R.id.rcy_bagian_ahli_waris);
        rcy_bagian_ahli_waris.setHasFixedSize(true);
        rcy_bagian_ahli_waris.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        loadData();

    }

    @SuppressLint("NotifyDataSetChanged")
    private void loadData() {
        list=json.getDataTerhalang();
        adapter=new BagianAhliWarisAdapter(this,list);
        rcy_bagian_ahli_waris.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,HomePage.class));
        finish();
    }
}
