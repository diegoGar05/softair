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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class clienteActivity extends AppCompatActivity {

    EditText mailCli;
    EditText passCli;
    Button ingre;
    FirebaseAuth sfAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        mailCli = findViewById(R.id.editTextEmaTec);
        passCli = findViewById(R.id.editTextPassTec);
        ingre = findViewById(R.id.btnIniSesTec);

        sfAuth = FirebaseAuth.getInstance();

        ingre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = mailCli.getText().toString().trim();
                String password = passCli.getText().toString().trim();

                sfAuth.signInWithEmailAndPassword(email, password.toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            dbCliente cliente = new dbCliente(clienteActivity.this);
                            String[] nombreYDocumento = cliente.obtenerNombreYDocumentoCliente(email, password);

                            if (nombreYDocumento[0] != null && nombreYDocumento[1] != null) {
                                String nombreCliente = nombreYDocumento[0];
                                String numeroDocumento = nombreYDocumento[1];
                                Intent goMenu = new Intent(clienteActivity.this, MenuCliActivity.class);
                                Toast.makeText(clienteActivity.this, "Bienvenido, " + nombreCliente + ", Número de documento: " + numeroDocumento, Toast.LENGTH_SHORT).show();
                                goMenu.putExtra("nombre_cliente", nombreCliente);
                                startActivity(goMenu);
                            } else {
                                Toast.makeText(clienteActivity.this, "No se encuentra en la base de datos", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(clienteActivity.this, "Email o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }

    public void llamarMenPrinC(View view){
        Intent goMenu = new Intent(clienteActivity.this, IniSesRegActivity.class);
        startActivity(goMenu);
    }

    public void llamarRegCli(View view){
        Intent goRegCliente = new Intent(clienteActivity.this, RegCliActivity.class);
        startActivity(goRegCliente);
    }

    /*public void llamarIniCli(View view){
        Intent goIniCli = new Intent(clienteActivity.this, MenuCliActivity.class);
        startActivity(goIniCli);
    }*/
}