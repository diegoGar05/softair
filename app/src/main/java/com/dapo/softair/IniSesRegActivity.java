package com.dapo.softair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IniSesRegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ini_ses_reg);
    }

    public void llamarCli(View view){
        Intent goCliente = new Intent(IniSesRegActivity.this, clienteActivity.class);
        startActivity(goCliente);
    }

    public void llamarRegCliIni(View view){
        Intent goRegCliente = new Intent(IniSesRegActivity.this, RegCliActivity.class);
        startActivity(goRegCliente);
    }

    public void llamarTec(View view){
        Intent goTecnico = new Intent(IniSesRegActivity.this, TecnicoActivity.class);
        startActivity(goTecnico);
    }

     public void llamarRegTecIni(View view){
        Intent goRegTecnico = new Intent(IniSesRegActivity.this, RegTecActivity.class);
        startActivity(goRegTecnico);
     }
}