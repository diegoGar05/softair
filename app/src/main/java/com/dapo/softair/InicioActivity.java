package com.dapo.softair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class InicioActivity extends AppCompatActivity {

    //Duración de la pantalla
    public static final long SPLASH_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //Temporizador pasar siguiente activty

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goIni = new Intent(InicioActivity.this, IniSesRegActivity.class);
                startActivity(goIni);
                
                finish();
            }
        }, SPLASH_DELAY);
    }
    public void llamarIniSesReg(View view){
        Intent goIniSesReg = new Intent(InicioActivity.this, IniSesRegActivity.class);
        startActivity(goIniSesReg);
    }
}