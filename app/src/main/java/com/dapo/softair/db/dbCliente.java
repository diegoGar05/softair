package com.dapo.softair.db;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class dbCliente extends dbHelper {

    Context context;

    public dbCliente(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public void guardarCli(String docCli, String tipDocCli, String nomCli, String dirCli, String telCli, String emaCli, String conCli){
        SQLiteDatabase db=getWritableDatabase();

        if (db!=null){
            db.execSQL("INSERT INTO Cliente VALUES('"+docCli+"', '"+tipDocCli+"',  '"+nomCli+"', '"+dirCli+"', '"+telCli+"', '"+emaCli+"', '"+conCli+"')");
            db.close();
        }

    }

    public Cursor mostrarCli(){

        SQLiteDatabase db =getWritableDatabase();

        Cursor cursor = db.rawQuery("Select docCli, nomCli, emaCli from Cliente", null);

        return cursor;
    }


    //Mostrar nombre del cliente en el menú

    @SuppressLint("Range")
    public String[] obtenerNombreYDocumentoCliente(String correoCli, String conCli) {
        String[] nombreYDocumento = new String[2];

        try {
            dbHelper dbHelper = new dbHelper(context);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            // Realiza una consulta para obtener el nombre y el número de documento del cliente
            Cursor cursor = db.query(TABLA_CLIENTE,
                    new String[]{"nomCli", "docCli"},
                    "emaCli = ? AND conCli = ?",
                    new String[]{correoCli, conCli},
                    null, null, null);

            if (cursor.moveToFirst()) {
                nombreYDocumento[0] = cursor.getString(cursor.getColumnIndex("nomCli"));
                nombreYDocumento[1] = cursor.getString(cursor.getColumnIndex("docCli"));
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

