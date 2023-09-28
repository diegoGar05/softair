package com.dapo.softair;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.dapo.softair.db.dbCliente;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegCliActivity extends AppCompatActivity {

    //Declaración de campos y botón

    Button btnRegCli;

    EditText docCli, nomCli, dirCli, telCli, emaCli, conCli;

    Spinner spinDocCli;

    //Conexión base de datos
    //private FirebaseFirestore dbSoftair;

    //Conexión Autenticación
    FirebaseAuth sfAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_cli);

        //dbSoftair = FirebaseFirestore.getInstance();
        sfAuth = FirebaseAuth.getInstance();

        spinDocCli = findViewById(R.id.spnTipDocCli);
        docCli = findViewById(R.id.txtDocCli);
        nomCli = findViewById(R.id.txtNomCli);
        dirCli = findViewById(R.id.txtDirCli);
        telCli = findViewById(R.id.txtTelCli);
        emaCli = findViewById(R.id.txtEmaCli);
        conCli = findViewById(R.id.txtConCli);
        btnRegCli = findViewById(R.id.btnRegCli);

        //Enviar datos a la base de datos

        dbCliente dbcliente = new dbCliente(RegCliActivity.this);

        btnRegCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tipdocclie = spinDocCli.getSelectedItem().toString();
                String docclie = docCli.getText().toString();
                String nomclie = nomCli.getText().toString();
                String dirclie = dirCli.getText().toString();
                String telclie = telCli.getText().toString();
                String emaclie = emaCli.getText().toString();
                String conclie = conCli.getText().toString();


                if (spinDocCli.getSelectedItem().equals("Seleccione...") ||docclie.isEmpty() ||nomclie.isEmpty() || dirclie.isEmpty() || telclie.isEmpty() || emaclie.isEmpty() || conclie.isEmpty()){
                    validarCampos();
                }
                else{

                    dbcliente.guardarCli(docCli.getText().toString(), spinDocCli.getSelectedItem().toString(), nomCli.getText().toString(), dirCli.getText().toString(), telCli.getText().toString(), emaCli.getText().toString(), conCli.getText().toString());
                    Toast.makeText(RegCliActivity.this, "Cliente registrado con éxito", Toast.LENGTH_SHORT).show();
                    limpiar();

                    sfAuth.createUserWithEmailAndPassword(emaclie, conclie).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                            }
                            else {
                                Toast.makeText(RegCliActivity.this, "Error al registrar: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }

            }
        });
    }


    public void validarCampos(){

        //Variables a usar - Campos

        String tipdocclie = spinDocCli.getSelectedItem().toString();
        String docclie = docCli.getText().toString();
        String nomclie = nomCli.getText().toString();
        String dirclie = dirCli.getText().toString();
        String telclie = telCli.getText().toString();
        String emaclie = emaCli.getText().toString();
        String conclie = conCli.getText().toString();

        if (spinDocCli.getSelectedItem().equals("Seleccione...")){
            spinDocCli.getSelectedItem().equals("Seleccione...");
            Toast.makeText(this, "Debe seleccionar un tipo de documento", Toast.LENGTH_SHORT).show();
        }
        else if (docclie.equals("")){
            docCli.setError("Campo obligatorio");
        }
        else if (nomclie.equals("")){
            nomCli.setError("Campo obligatorio");
        }
        else if (dirclie.equals("")){
            dirCli.setError("Campo obligatorio");
        }
        else if (telclie.equals("")){
            telCli.setError("Campo obligatorio");
        }
        else if (emaclie.equals("")){
            emaCli.setError("Campo obligatorio");
        }
        else if (conclie.equals("")){
            conCli.setError("Campo obligatorio");
        }
    }

    public void llamarMenuPrin(View view){
        Intent goMenPrin = new Intent(RegCliActivity.this, IniSesRegActivity.class);
        startActivity(goMenPrin);
    }

    public void goIniSesCli(View view){
        startActivity(new Intent(RegCliActivity.this, IniSesRegActivity.class));
    }

    private void limpiar(){
        spinDocCli.equals("Seleccione...");
        docCli.setText("");
        nomCli.setText("");
        dirCli.setText("");
        telCli.setText("");
        emaCli.setText("");
        conCli.setText("");
    }

}