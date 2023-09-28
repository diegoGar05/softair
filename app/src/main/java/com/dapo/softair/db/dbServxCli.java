package com.dapo.softair.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class dbServxCli extends dbHelper{

    Context context;

    public dbServxCli(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public void guardarServxCli(String docClixServ, Integer idServxCli, String docTecServxCli, String funAir, String tipAir, String marAir, String fecha, String hora){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("docClixServ", docClixServ);
        values.put("idServxCli", idServxCli);
        values.put("docTecServxCli", docTecServxCli);
        values.put("funAir", funAir);
        values.put("tipAir", tipAir);
        values.put("marAir", marAir);
        values.put("fecha", fecha);
        values.put("hora", hora);

        db.insert("ServicioxCliente", null, values);
        db.close();
    }

}
