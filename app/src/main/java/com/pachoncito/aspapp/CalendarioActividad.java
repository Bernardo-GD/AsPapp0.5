package com.pachoncito.aspapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Toast;

public class CalendarioActividad extends AppCompatActivity {

    private String fechaRecibida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario_actividad);
        //exportar la imagen de adobe xd, y agregar los atributos para quitar la tool bar y agrega la imagen
        //correspondiente
        //cambiar el color dde la barra donde está la hora, notificaciones, etc
        getWindow().setStatusBarColor(Color.parseColor("#01AAFF"));

        //cambiar fondo a blanco
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        //quitar actionbar
        getSupportActionBar().hide();

        //agregar el intent para recibir la fecha y mostrar en un toast

        fechaRecibida = getIntent().getStringExtra("fechaRegistro");
        Toast.makeText(this, fechaRecibida, Toast.LENGTH_LONG).show();

    }
}