package com.dapo.softair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.dapo.softair.Utilidades.CustomAdapater;
import com.dapo.softair.db.dbCliente;
import com.dapo.softair.db.dbHelper;

import java.util.ArrayList;
import java.util.Calendar;

public class CronoTecActivity extends AppCompatActivity {

    TextView fecSel;
    RecyclerView recyclerView;
    ArrayList<String> document, nombre, correo;
    dbCliente db;
    CustomAdapater adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crono_tec);

        db = new dbCliente(this);

        document = new ArrayList<>();
        nombre = new ArrayList<>();
        correo = new ArrayList<>();

        recyclerView = findViewById(R.id.RecyclerViewSer);

        adapter = new CustomAdapater(this, document, nombre, correo);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mostrarDatos();

        fecSel = findViewById(R.id.txtFecSel);
    }

    private void mostrarDatos() {

        Cursor cursor = db.mostrarCli();

        if(cursor.getCount()==0){
            Toast.makeText(CronoTecActivity.this, "No hay registros", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                document.add(cursor.getString(0));
                nombre.add(cursor.getString(1));
                correo.add(cursor.getString(2));
            }
        }

    }

    public void verCalendar(View view) {
        Calendar cal = Calendar.getInstance();
        int anio = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(CronoTecActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                String fecha = dayOfMonth + "/" + month + "/" + year;
                fecSel.setText(fecha);
            }
        }, anio, mes, dia);
        dpd.getDatePicker().setMinDate(System.currentTimeMillis());
        dpd.show();
    }

}