package com.dapo.softair;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dapo.softair.db.dbTecnico;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegTecActivity extends AppCompatActivity {

    //Declaración de campos y botón

    Button btn_RegTec;

    EditText docTec, nomTec, dirTec, telTec, emaTec, conTec;

    FirebaseAuth sfAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_tec);

        //dbSoftair = FirebaseFirestore.getInstance();
        sfAuth = FirebaseAuth.getInstance();

        btn_RegTec = findViewById(R.id.btnRegTec);
        docTec = findViewById(R.id.txtDocTec);
        nomTec = findViewById(R.id.txtNomTec);
        dirTec = findViewById(R.id.txtDirTec);
        telTec = findViewById(R.id.txtTelTec);
        emaTec = findViewById(R.id.txtEmaTec);
        conTec = findViewById(R.id.txtConTec);

        //Enviar datos a la base de datos

        dbTecnico dbtecnico = new dbTecnico(RegTecActivity.this);

        btn_RegTec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String doctecni = docTec.getText().toString();
                String nomtecni = nomTec.getText().toString();
                String dirtecni = dirTec.getText().toString();
                String teltecni = telTec.getText().toString();
                String ematecni = emaTec.getText().toString();
                String contecni = conTec.getText().toString();

                if (doctecni.isEmpty() || nomtecni.isEmpty() || dirtecni.isEmpty() || teltecni.isEmpty() || ematecni.isEmpty() || contecni.isEmpty()){
                    validarCampos();
                }
                else{
                    dbtecnico.guardarTec(docTec.getText().toString(),nomTec.getText().toString(), dirTec.getText().toString(), telTec.getText().toString(), emaTec.getText().toString(), conTec.getText().toString());
                    Toast.makeText(RegTecActivity.this, "Técnico registrado con éxito", Toast.LENGTH_SHORT).show();
                    limpiar();

                    sfAuth.createUserWithEmailAndPassword(ematecni, contecni).addOnCompleteListener(new OnCompleteListener<AuthResult>(){

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                            }
                            else{
                                Toast.makeText(RegTecActivity.this, "Error al registrar: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                }
            });
    }

    public void goIniSesTec(View view){
        startActivity(new Intent(RegTecActivity.this, RegTecActivity.class));
    }


    public void validarCampos(){

        //Variables a usar - Campos

        String doctecni = docTec.getText().toString();
        String nomtecni = nomTec.getText().toString();
        String dirtecni = dirTec.getText().toString();
        String teltecni = telTec.getText().toString();
        String ematecni = emaTec.getText().toString();
        String contecni = conTec.getText().toString();


        if(doctecni.equals("")){
            docTec.setError("Campo obligatorio");
        }
        else if (nomtecni.equals("")){
            nomTec.setError("Campo obligatorio");
        }
        else if (dirtecni.equals("")){
            dirTec.setError("Campo obligatorio");
        }
        else if (teltecni.equals("")){
            telTec.setError("Campo obligatorio");
        }
        else if (ematecni.equals("")){
            emaTec.setError("Campo obligatorio");
        }
        else if (contecni.equals("")){
            conTec.setError("Campo obligatorio");
        }

    }

    private void limpiar(){
        docTec.setText("");
        nomTec.setText("");
        dirTec.setText("");
        telTec.setText("");
        emaTec.setText("");
        conTec.setText("");
    }
}