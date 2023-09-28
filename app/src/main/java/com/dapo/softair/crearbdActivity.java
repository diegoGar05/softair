package com.dapo.softair;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dapo.softair.db.dbHelper;

public class crearbdActivity extends AppCompatActivity {

    Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearbd);

        btnCrear = findViewById(R.id.btnCrearBD);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper dbhelper = new dbHelper(crearbdActivity.this);
                SQLiteDatabase db = dbhelper.getWritableDatabase();

                if(db!=null){
                    Toast.makeText(crearbdActivity.this, "Base creada con éxito", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(crearbdActivity.this, "¡Error al crear!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
