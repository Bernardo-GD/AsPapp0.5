package com.pachoncito.aspapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class ConsejosCategoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos_categoria);

        //cambiar el color dde la barra donde está la hora, notificaciones, etc
        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));

        //cambiar fondo a blanco
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        //quitar actionbar
        getSupportActionBar().hide();

        String tituloCategoria = getIntent().getStringExtra("Titulo");

        switch (tituloCategoria){

            case "Motivación":

                break;

            case "Hábitos":

                break;

            case "Actividades":

                break;

            case "Actitudes":

                break;

            case "Habilidades":

                break;

        }

    }
}