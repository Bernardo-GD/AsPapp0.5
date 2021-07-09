package com.pachoncito.aspapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ConsejoIndividual extends AppCompatActivity {

    private String tituloCategoria, nombreConsejo;
    private EditText areaDeTexto;
    private TextView tituloTexto;

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
        tituloTexto = (TextView)findViewById(R.id.txt_TituloTema);
        tituloTexto.setText(nombreConsejo);
        switch(nombreConsejo){

            case "Legado":
                areaDeTexto.setText("Ninguna herencia es comparable a la de los recuerdos de los momentos vividos juntos y el saber que ha estado a tu lado.");
                break;

            case "Amigos":
                areaDeTexto.setText("Es hermoso que los padres lleguen a ser amigos de sus hijos, desvaneciéndoles todo temor, pero inspirándoles un gran respeto.\n" +
                        "El temor a la figura del padre se pierde con el tiempo, pero siempre quedará el respeto. \n");
                break;

            case "Corazón":
                areaDeTexto.setText("No es la carne y la sangre, sino el corazón, lo que nos hace padres e hijos.\n" +
                        "Según esta frase Schiller no todos los padres son de sangre, pues otras personas pueden representar también esa figura para alguien si es de corazón.\n");
                break;

            case "Alguien":
                areaDeTexto.setText("Un padre es alguien que te apoya cuando lloras, que te regaña cuando rompes las reglas, que brilla de orgullo cuando tienes éxito y tiene fe en ti, aun cuando tú no lo hagas.");
                break;

            case "Siempre":
                areaDeTexto.setText("Cuando un recién nacido aprieta con su pequeño puño, por primera vez, el dedo de su padre, lo tiene atrapado para siempre. ");
                break;

        }

    }

    public void regrearCategoria (View view){

        Intent regresar = new Intent(this, ConsejosCategoria.class);
        startActivity(regresar);
    }
}