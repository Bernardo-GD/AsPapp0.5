package com.pachoncito.aspapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConsejosCategoria extends AppCompatActivity {

    private TextView consejo1, consejo2, consejo3, consejo4, consejo5;
    private String tituloCategoria, nombreConsejo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos_categoria);

        //cambiar el color dde la barra donde está la hora, notificaciones, etc
        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));

        //cambiar fondo a blanco
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        consejo1 = (TextView)findViewById(R.id.txtConsejo1);
        consejo2 = (TextView)findViewById(R.id.txtConsejo2);
        consejo3 = (TextView)findViewById(R.id.txtConsejo3);
        consejo4 = (TextView)findViewById(R.id.txtConsejo4);
        consejo5 = (TextView)findViewById(R.id.txtConsejo5);


        //quitar actionbar
        //getSupportActionBar().hide();

        tituloCategoria = getIntent().getStringExtra("Titulo");
        getSupportActionBar().setTitle("Consejos - " + tituloCategoria);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F6C801")));
        switch (tituloCategoria){

            case "Motivación":

                consejo1.setText("Legado");
                consejo2.setText("Amigos");
                consejo3.setText("Corazón");
                consejo4.setText("Alguien");
                consejo5.setText("Siempre");

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

    public void irConsejo1 (View view){

        Intent irConsejo = new Intent(this, ConsejoIndividual.class);
        nombreConsejo = consejo1.getText().toString();
        irConsejo.putExtra("nCategoria", tituloCategoria);
        irConsejo.putExtra("conse1", nombreConsejo);
        startActivity(irConsejo);
    }

}