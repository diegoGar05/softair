package com.dapo.softair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MenuCliActivity extends AppCompatActivity {

    Button btnLogOutClie;
    TextView txtNombreMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cli);

        btnLogOutClie = findViewById(R.id.btnLogOutCli);
        txtNombreMenu = findViewById(R.id.txtNombreMenu);

        String nombreCliente = getIntent().getStringExtra("nombre_cliente");

        // Mostrar el nombre del cliente en el TextView
        if (nombreCliente != null) {
            txtNombreMenu.setText("Bienvenido, " + nombreCliente);
        } else {
            txtNombreMenu.setText("Error al obtener el nombre del cliente");
        }

        btnLogOutClie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent goCli = new Intent(MenuCliActivity.this, IniSesRegActivity.class);
                startActivity(goCli);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cliente,menu);
        return super.onCreateOptionsMenu(menu);

    }

    public void llamarHisto(View view){
        Intent intent = new Intent(MenuCliActivity.this, histActivity.class);
        startActivity(intent);
    }
    public void llamarserv(View view){
        Intent intent = new Intent(MenuCliActivity.this, ServiciosActivity.class);
        startActivity(intent);
    }


}