package com.pachoncito.aspapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.EditText;

public class ConsejoIndividual extends AppCompatActivity {

    private String tituloCategoria, nombreConsejo;
    private EditText areaDeTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejo_individual);


        //cambiar el color dde la barra donde está la hora, notificaciones, etc
        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));

        //cambiar fondo a blanco
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        tituloCategoria = getIntent().getStringExtra("nCategoria");
        nombreConsejo = getIntent().getStringExtra("conse1");

        getSupportActionBar().setTitle("Consejos - " + tituloCategoria);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F6C801")));

        areaDeTexto = (EditText)findViewById(R.id.textoConsejo);
        areaDeTexto.setText("Ninguna herencia es comparable a la de los recuerdos de los momentos vividos juntos y el saber que ha estado a tu lado.");

    }
}