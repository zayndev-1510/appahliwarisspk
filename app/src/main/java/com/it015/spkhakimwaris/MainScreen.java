package com.it015.spkhakimwaris;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;

public class MainScreen extends AppCompatActivity {
    TextView txt;
    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        Window window=getWindow();
        window.setStatusBarColor(Color.parseColor("#11366A"));
        txt=findViewById(R.id.judul_app);
        lottieAnimationView=findViewById(R.id.my_lottie);
        lottieAnimationView.playAnimation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                GoogleSignInAccount cek_akun= GoogleSignIn.getLastSignedInAccount(MainScreen.this);
                if(cek_akun !=null){
                    startActivity(new Intent(MainScreen.this,HomePage.class));
                    finish();
                }else{
                    startActivity(new Intent(MainScreen.this, LoginPage.class));
                    finish();
                }
            }
        },5000);

    }
}
