package com.it015.spkhakimwaris;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.it015.spkhakimwaris.adapter.DetailBagianAhliAdapter;
import com.it015.spkhakimwaris.data.JsonDetailBagianAhliWaris;
import com.it015.spkhakimwaris.objek.DetailbagianModel;

import java.util.List;

public class DetailBagianPage extends AppCompatActivity {

    RecyclerView rcy;
    JsonDetailBagianAhliWaris json=new JsonDetailBagianAhliWaris();
    DetailBagianAhliAdapter adapter;
    TextView detail_caption;
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_bagian_ahli_waris);
        Window window=getWindow();
        window.setStatusBarColor(getResources().getColor(android.R.color.transparent));

        new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightStatusBars(true);
        rcy=findViewById(R.id.detail_bagian_ahli_waris_rcy);
        detail_caption=findViewById(R.id.detail_caption_ahli_waris);
        rcy.setHasFixedSize(true);
        rcy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        Bundle b = getIntent().getExtras();
        String value = b.getString("value");
        detail_caption.setText(b.getString("ahli_waris"));
        List<DetailbagianModel> list=json.getDetailBagian(value);

        adapter=new DetailBagianAhliAdapter(this,list);
        rcy.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,BagianAhliWarisPage.class));
        finish();
    }
}
