package com.dapo.softair;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dapo.softair.Utilidades.CustomAdapater;
import com.dapo.softair.db.dbCliente;

import java.util.ArrayList;
import java.util.Calendar;


public class Cronograma extends Fragment {


    TextView fecSel;
    RecyclerView recyclerView;
    ArrayList<String> document, nombre, correo;
    dbCliente db;
    CustomAdapater adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_cronograma, container, false);

        db = new dbCliente(getContext());

        document = new ArrayList<>();
        nombre = new ArrayList<>();
        correo = new ArrayList<>();

        recyclerView = root.findViewById(R.id.RecyclerViewSer);

        adapter = new CustomAdapater(getContext(), document, nombre, correo);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mostrarDatos();

        TextView fecSel = root.findViewById(R.id.txtFechaSel);

        ImageView calendar = root.findViewById(R.id.btnCalen);

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int anio = cal.get(Calendar.YEAR);
                int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        String fecha = dayOfMonth + "/" + (month+1) + "/" + year;
                        fecSel.setText(fecha);
                    }
                }, anio, mes, dia);
                dpd.getDatePicker().setMinDate(System.currentTimeMillis());
                dpd.show();
            }

        });

        return root;

    }

    private void mostrarDatos() {

        Cursor cursor = db.mostrarCli();

        if(cursor.getCount()==0){
            Toast.makeText(getContext(), "No hay registros", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                document.add(cursor.getString(0));
                nombre.add(cursor.getString(1));
                correo.add(cursor.getString(2));
            }
        }

    }

}