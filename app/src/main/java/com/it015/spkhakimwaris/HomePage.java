package com.it015.spkhakimwaris;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsControllerCompat;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class HomePage extends AppCompatActivity {

    GoogleSignInOptions signInOptions;
    GoogleSignInClient signInClient;
    TextView username_txt,hukum_waris_btn,syarat_warisan_btn;
    TextView rukun_warisan_islam_btn,kelompok_ahli_waris_btn;
    TextView bagian_ahli_waris_btn,hitung_waris_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        Window window=getWindow();
        window.setStatusBarColor(getResources().getColor(android.R.color.transparent));

        new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightStatusBars(true);
        username_txt=findViewById(R.id.txt_username);
        hukum_waris_btn=findViewById(R.id.hukum_waris_btn);
        syarat_warisan_btn=findViewById(R.id.syarat_warisan_btn);
        rukun_warisan_islam_btn=findViewById(R.id.rukun_waris_btn);
        kelompok_ahli_waris_btn=findViewById(R.id.kelompok_ahli_waris_btn);
        bagian_ahli_waris_btn=findViewById(R.id.bagian_ahli_waris_btn);
        hitung_waris_btn=findViewById(R.id.hitung_waris_btn);

        hukum_waris_btn.setOnClickListener(v->{
            startActivity(new Intent(this,HukumWarisanPage.class));
            finish();
        });

        syarat_warisan_btn.setOnClickListener(v->{
            startActivity(new Intent(this,SyaratWarisanPage.class));
            finish();
        });

        rukun_warisan_islam_btn.setOnClickListener(v->{
            startActivity(new Intent(this,RukunWarisanPage.class));
            finish();
        });

        kelompok_ahli_waris_btn.setOnClickListener(v->{
            startActivity(new Intent(this,KelompokAhliWaris.class));
            finish();
        });

        bagian_ahli_waris_btn.setOnClickListener(v->{
            startActivity(new Intent(this,BagianAhliWarisPage.class));
            finish();
        });

        hitung_waris_btn.setOnClickListener(v->{
            startActivity(new Intent(this, HitungWaris.class));
            finish();
        });


        signInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        signInClient= GoogleSignIn.getClient(this,signInOptions);

        GoogleSignInAccount acc= GoogleSignIn.getLastSignedInAccount(this);
        if(acc !=null){
            String username="Hai "+acc.getDisplayName();
            username_txt.setText(username);
        }

    }
}
