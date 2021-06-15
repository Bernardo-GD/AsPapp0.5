package com.pachoncito.aspapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class CalendarioPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario_principal);

        //cambiar el color dde la barra donde está la hora, notificaciones, etc
        getWindow().setStatusBarColor(Color.parseColor("#01AAFF"));

        //cambiar fondo a blanco
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        //quitar actionbar
        getSupportActionBar().hide();

    }

    public void irAmorometros (View view){

        Intent amorometros = new Intent(this, AmorometrosPrincipal.class);
        startActivity(amorometros);

    }
    public void irConsejos (View view){

        Intent consejos = new Intent(this, ConsejosPrincipal.class);
        startActivity(consejos);

    }

}