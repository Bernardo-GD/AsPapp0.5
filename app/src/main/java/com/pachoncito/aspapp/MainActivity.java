package com.pachoncito.aspapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        APBD helperObjeto = new APBD(this, "BD_AsPapp1", null, 1);
        SQLiteDatabase BD = helperObjeto.getWritableDatabase();
        @SuppressLint("Recycle")Cursor fila = BD.rawQuery("SELECT nombre FROM Persona", null);


        if  (fila.moveToFirst()){
            Toast.makeText(this, "Entro: " + fila.getString(0), Toast.LENGTH_LONG).show();
            
        }else{
            Toast.makeText(this, "No", Toast.LENGTH_LONG).show();
        }

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {

                if (fila.moveToFirst()){
                    BD.close();
                    Intent enviarAmorometros = new Intent(MainActivity.this, AmorometrosPrincipal.class);
                    startActivity(enviarAmorometros);

                    finish();

                }else{
                    BD.close();
                    Intent enviarARegistro1 = new Intent(MainActivity.this, RegistroP1.class);
                    startActivity(enviarARegistro1);
                    finish();
                }


            }
        };
        BD.close();

        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 5000);
    }
}