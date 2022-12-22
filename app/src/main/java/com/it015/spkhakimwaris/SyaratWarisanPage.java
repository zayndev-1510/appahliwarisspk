package com.it015.spkhakimwaris;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsControllerCompat;

public class SyaratWarisanPage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syarat_warisan);
        Window window=getWindow();
        window.setStatusBarColor(getResources().getColor(android.R.color.transparent));

        new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightStatusBars(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,HomePage.class));
        finish();
    }
}
