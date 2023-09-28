package com.dapo.softair.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 3;
    private static final String DB_NOMBRE = "SoftAir.db";

    public static final String TABLA_CLIENTE = "Cliente";

    public static final String TABLA_TECNICO = "Tecnico";

    public static final String TABLA_SERVICIO = "Servicio";

    public static final String TABLA_SERVxCLI = "ServicioxCliente";


    public dbHelper(@Nullable Context context) {

        super(context, DB_NOMBRE, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_CLIENTE + "(" +
                "docCli TEXT PRIMARY KEY NOT NULL, " +
                "tipDocCli TEXT NOT NULL, "+
                "nomCli TEXT NOT NULL, " +
                "dirCli TEXT NOT NULL, " +
                "telCli TEXT NOT NULL, " +
                "emaCli TEXT NOT NULL, " +
                "conCli TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_TECNICO + "(" +
                "docTec TEXT PRIMARY KEY NOT NULL, "+
                "nomTec TEXT NOT NULL, " +
                "dirTec TEXT NOT NULL, " +
                "telTec TEXT NOT NULL, " +
                "emaTec TEXT NOT NULL, " +
                "conTec TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_SERVICIO + "(" +
                "idServ INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomServ TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_SERVxCLI + "(" +
                "codServxCli INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "docClixServ TEXT NOT NULL, " +
                "idServxCli INTEGER NOT NULL, " +
                "docTecSerxCli TEXT NOT NULL, " +
                "funAir TEXT NOT NULL, " +
                "tipAir TEXT NOT NULL, " +
                "marAir TEXT NOT NULL, " +
                "fecha TEXT NOT NULL, " +
                "hora TEXT NOT NULL, " +
                "FOREIGN KEY (docClixServ) REFERENCES Cliente (docCli), " +
                "FOREIGN KEY (idServxCli) REFERENCES Servicio (idServ), " +
                "FOREIGN KEY (docTecSerxCli) REFERENCES Tecnico (docTec))");

        /*sqLiteDatabase.execSQL("INSERT INTO " + TABLA_CLIENTE +
                "(docCli, tipDocCli, nomCli, dirCli, telCli, emaCli, conCli)" + "VALUES" +
                "('1056')," +
                "('Cédula de ciudadanía')," +
                "('Carlos')," +
                "('Calle 9BN')," +
                "('312')," +
                "('carlitos@gmail.com')," +
                "('carlos123456')");
*/
        sqLiteDatabase.execSQL("INSERT INTO " + TABLA_SERVICIO +
                " (nomServ) " + "VALUES" +
                "('Mantenimiento preventivo')," +
                "('Mantenimiento correctivo')," +
                "('Mantenimiento predictivo')," +
                "('Higienización')," +
                "('Instalación')," +
                "('Revisión técnica')," +
                "('Radiación ultravioleta')");

        /*sqLiteDatabase.execSQL("INSERT INTO " + TABLA_TECNICO +
                "(docTec, nomTec, dirTec, telTec, emaTec, conTec)" + "VALUES" +
                "('1095')," +
                "('Cédula de ciudadanía')," +
                "('Carlos')," +
                "('Calle 9BN')," +
                "('312')," +
                "('carlitos@gmail.com')," +
                "('carlos123456')");*/

        /*sqLiteDatabase.execSQL("INSERT INTO " + TABLA_SERVxCLI +
                "(docClixServ, idServxCli, docTecSerxCli, funAir, tipAir, marAir, fecha, hora)" + "VALUES" +
                "('1056')," +
                "(1)," +
                "('1095')," +
                "('Doméstico')," +
                "('Split')," +
                "('Samsung')," +
                "('2023-09-30')," +
                "('1:00 pm')");*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLA_CLIENTE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLA_TECNICO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLA_SERVICIO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLA_SERVxCLI);
        onCreate(sqLiteDatabase);
    }



}
