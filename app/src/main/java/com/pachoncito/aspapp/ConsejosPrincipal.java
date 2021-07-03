package com.pachoncito.aspapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class ConsejosPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos_principal);

        //cambiar el color dde la barra donde está la hora, notificaciones, etc
        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));

        //cambiar fondo a blanco
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        //quitar actionbar
        getSupportActionBar().hide();

    }

    public void irAmorometros (View view){

        Intent amorometros = new Intent(this, AmorometrosPrincipal.class);
        startActivity(amorometros);

    }
    public void irCalendario (View view){

        Intent calendario = new Intent(this, CalendarioPrincipal.class);
        startActivity(calendario);

    }

    public void irCategoria1 (View view){

        Intent c1 = new Intent(this, ConsejosCategoria.class);
        c1.putExtra("Titulo", "Motivación");
        startActivity(c1);

    }

    public void irCategoria2 (View view){

        Intent c2 = new Intent(this, ConsejosCategoria.class);
        c2.putExtra("Titulo", "Hábitos");
        startActivity(c2);

    }

    public void irCategoria3 (View view){

        Intent c3 = new Intent(this, ConsejosCategoria.class);
        c3.putExtra("Titulo", "Actividades");
        startActivity(c3);

    }

    public void irCategoria4 (View view){

        Intent c4 = new Intent(this, ConsejosCategoria.class);
        c4.putExtra("Titulo", "Actitudes");
        startActivity(c4);

    }

    public void irCategoria5 (View view){

        Intent c5 = new Intent(this, ConsejosCategoria.class);
        c5.putExtra("Titulo", "Habilidades");
        startActivity(c5);

    }
}