package com.pachoncito.aspapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AmorometroIndividual extends AppCompatActivity {

    private String nombreHijo;
    private TextView hijo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amorometro_individual);

        //cambiar el color dde la barra donde está la hora, notificaciones, etc
        getWindow().setStatusBarColor(Color.parseColor("#741A8A"));

        //cambiar fondo a blanco
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        getSupportActionBar().hide();
        //quitar actionbar
        //getSupportActionBar().setTitle("Amorometro individual");

        //con este nombre podre hacer la consulta a la base de datos sin importa que hijo sea
        nombreHijo = getIntent().getStringExtra("n");
        hijo = (TextView)findViewById(R.id.txtNombreHijo);
        hijo.setText(nombreHijo);


    }

    public void regresarAmorometros(View view){

        Intent regresar = new Intent(this, AmorometrosPrincipal.class);
        startActivity(regresar);

    }

}