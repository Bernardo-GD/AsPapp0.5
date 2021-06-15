package com.pachoncito.aspapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class APBD extends SQLiteOpenHelper{


    public APBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatosAsPapp) {
        BaseDeDatosAsPapp.execSQL("CREATE TABLE Persona (nombre TEXT PRIMARY KEY, tipo TEXT)");
        BaseDeDatosAsPapp.execSQL("CREATE TABLE Preguntas(idPregunta INT PRIMARY KEY, pregunta TEXT, respuesta TEXT, nombrePersona TEXT, FOREIGN KEY(nombrePersona) REFERENCES Persona(nombre))");
        BaseDeDatosAsPapp.execSQL("CREATE TABLE Actividad (idActividad INT PRIMARY KEY, nombreActividad TEXT, fecha_inicio DATETIME, fecha_fin DATETIME, descripcion TEXT, estado BOOLEAN, puntaje NUMERIC, nombrePersona TEXT, FOREIGN KEY (nombrePersona) REFERENCES Persona(nombre))");

        //Pendiente la tabla de rondas y posiblemente crear una de puntajes, pero está en análisis 

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
