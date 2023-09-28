package com.dapo.softair;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dapo.softair.db.dbServxCli;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class soliServActivity extends AppCompatActivity {
    TextView fec;
    TextView Dir;
    RadioButton indus;
    RadioButton domes;
    Spinner tipo;
    Spinner marca;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soli_serv);
        fec = findViewById(R.id.dt);
        indus= findViewById(R.id.rdbIndusServ);
        domes=findViewById(R.id.rdbDomesServ);
        tipo=findViewById(R.id.cboTipAirSer);
        radioGroup = findViewById(R.id.radioGroup2);

        final List<String> domesti = new ArrayList<>();
        domesti.add("Seleccione...");
        domesti.add("Fan Coil");
        domesti.add("Mono Split");
        domesti.add("Portatil");
        domesti.add("Sistema Multi Split");
        domesti.add("Sistema por Conductos");

        final List<String> industr = new ArrayList<>();
        industr.add("Seleccione...");
        industr.add("Sistema VRF");
        industr.add("Rooftop");
        industr.add("Multi Split Suelo-Techo");

        setSpinnerData(industr);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == indus.getId()) {
                    setSpinnerData(industr);
                } else if (checkedId == domes.getId()) {
                    setSpinnerData(domesti);
                }
            }
        });



    }

    private void setSpinnerData(List<String> data) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, data);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo.setAdapter(adapter);
    }


    public void verCalendario(View view) {
        Calendar cal = Calendar.getInstance();
        int anio = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(soliServActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                String fecha = dayOfMonth + "/" + month + "/" + year;
                fec.setText(fecha);
            }
        }, anio, mes, dia);
        dpd.getDatePicker().setMinDate(System.currentTimeMillis());
        dpd.show();
    }

    public void llamarMenu(View view){
        Intent intent = new Intent(soliServActivity.this, MenuCliActivity.class);
        startActivity(intent);
    }



}