package com.dapo.softair.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;


public class dbTecnico extends dbHelper{

    Context context;


    public dbTecnico(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public void guardarTec(String docTec, String nomTec, String dirTec, String telTec, String emaTec, String conTec){

        SQLiteDatabase db=getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put("docTec", docTec);
        valores.put("nomTec", nomTec);
        valores.put("dirTec", dirTec);
        valores.put("telTec", telTec);
        valores.put("emaTec", emaTec);
        valores.put("conTec", conTec);

        db.insert("Tecnico", null, valores);
        db.close();

    }

    //Mostrar nombre del técnico en el menú

    @SuppressLint("Range")
    public String[] obtenerNombreYDocumentoTecnico(String emaTec, String conTec) {
        String[] nombreYDocumento = new String[2];

        try {
            dbHelper dbHelper = new dbHelper(context);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            // Realiza una consulta para obtener el nombre y el número de documento del cliente
            Cursor cursor = db.query(TABLA_TECNICO,
                    new String[]{"nomTec", "docTec"},
                    "emaTec = ? AND conTec = ?",
                    new String[]{emaTec, conTec},
                    null, null, null);

            if (cursor.moveToFirst()) {
                nombreYDocumento[0] = cursor.getString(cursor.getColumnIndex("nomTec"));
                nombreYDocumento[1] = cursor.getString(cursor.getColumnIndex("docTec"));
            }else {
                nombreYDocumento[0] = null;
                nombreYDocumento[1] = null;
            }

            cursor.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return nombreYDocumento;
    }

}
