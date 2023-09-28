package com.dapo.softair;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class Inicio extends Fragment {

    TextView txtMosNomTecn;
    Button btnLogOutTec;
    MenuTecActivity tecnico = new MenuTecActivity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_inicio, container, false);

        txtMosNomTecn = root.findViewById(R.id.txtMosNomTec);

        return  root;

    }

    /*public void mostrarNomTec(){

        // Mostrar el nombre del tecnico en el TextView

        String nombreTecnico = getIntent().getStringExtra("nombre_tecnico");

        if (nombreTecnico != null) {
            txtMosNomTecn.setText("Bienvenido, " + nombreTecnico);
        } else {
            txtMosNomTecn.setText("Error al obtener el nombre del cliente");
        }

    }*/

}