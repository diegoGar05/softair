package com.dapo.softair;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dapo.softair.db.dbCliente;
import com.dapo.softair.db.dbTecnico;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class TecnicoActivity extends AppCompatActivity {

    EditText mailTec, conTec;
    Button login;
    FirebaseAuth sfAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecnico);

        mailTec = findViewById(R.id.editTextEmaTec);
        conTec = findViewById(R.id.editTextPassTec);
        login = findViewById(R.id.btnIniSesTec);

        sfAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = mailTec.getText().toString().trim();
                String password = conTec.getText().toString().trim();

                sfAuth.signInWithEmailAndPassword(email, password.toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            dbTecnico tecnico = new dbTecnico(TecnicoActivity.this);
                            String[] nombreYDocumento = tecnico.obtenerNombreYDocumentoTecnico(email, password);

                            if (nombreYDocumento[0] != null && nombreYDocumento[1] != null) {
                                String nombreTec = nombreYDocumento[0];
                                String numeroDocumento = nombreYDocumento[1];
                                Toast.makeText(TecnicoActivity.this, "Bienvenido, " + nombreTec + ", Número de documento: " + numeroDocumento, Toast.LENGTH_SHORT).show();
                                Intent goMenu = new Intent(TecnicoActivity.this, MenuTecActivity.class);
                                goMenu.putExtra("nombre_tecnico", nombreTec);
                                startActivity(goMenu);
                            } else {
                                Toast.makeText(TecnicoActivity.this, "No se encuentra en la base de datos", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(TecnicoActivity.this, "Email o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    public void llamarMenPrinT(View view){
        Intent goMenPrin = new Intent(TecnicoActivity.this, IniSesRegActivity.class);
        startActivity(goMenPrin);
    }

    public void llamarRegTec(View view){
        Intent goRegTec = new Intent(TecnicoActivity.this, RegTecActivity.class);
        startActivity(goRegTec);
    }
}