package com.dapo.softair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ServiciosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);
    }

    public void llamarSelecMan(View view){
        Intent intent = new Intent(ServiciosActivity.this, selecManActivity.class);
        startActivity(intent);
    }

    public void llamarServis(View view){
        Intent intent = new Intent(ServiciosActivity.this, soliServActivity.class);
        startActivity(intent);
    }

    public void goMenu(View view){
        startActivity(new Intent(ServiciosActivity.this, MenuCliActivity.class));
    }
}