package com.pachoncito.aspapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.IllegalFormatCodePointException;

public class AmorometrosPrincipal extends AppCompatActivity {

    private ImageView imagenHora;
    private Intent amorometroIndividual;
    private TextView nombre1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amorometros_principal);

        //cambiar el color dde la barra donde está la hora, notificaciones, etc
        getWindow().setStatusBarColor(Color.parseColor("#FE0000"));

        //cambiar fondo a blanco
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        //quitar actionbar
        getSupportActionBar().hide();

        /*//Cambiar fondo a blanco
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        //quitar Actionbar
        getSupportActionBar().hide();*/

        imagenHora = (ImageView)findViewById(R.id.imHora);

        Date date = new Date();
        SimpleDateFormat hora = new SimpleDateFormat("h:mm:a");
        String sHora = hora.format(date);
        char cadenaHora[] = sHora.toCharArray();
        Toast.makeText(this, sHora, Toast.LENGTH_LONG).show();
        if (cadenaHora[cadenaHora.length-5] == 'a'  ){
            Toast.makeText(this, "Mañana", Toast.LENGTH_LONG).show();
            imagenHora.setImageResource(R.drawable.tardes);
        }else{
            if (cadenaHora[cadenaHora.length-5] == 'p'){
                Toast.makeText(this, "Tardes", Toast.LENGTH_LONG).show();

            }
        }
        /*
        APBD helperObjeto = new APBD(this, "BD_AsPapp1", null, 1);
        SQLiteDatabase BD = helperObjeto.getWritableDatabase();
        int cantidad = BD.delete("Persona", "nombre="+ "Pachon", null);
        BD.close();
        if (cantidad == 1){
            Toast.makeText(this, "Eliminado exitosamente", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "El articulo no existe", Toast.LENGTH_LONG).show();
        }
        */

        //extraer los nombres de las etiquetas
        nombre1 = (TextView)findViewById(R.id.txtNombre1);

    }

    public void irCalendario (View view){

        Intent calendario = new Intent(this, CalendarioPrincipal.class);
        startActivity(calendario);

    }
    public void irConsejos (View view){

        Intent consejos = new Intent(this, ConsejosPrincipal.class);
        startActivity(consejos);

    }

    public void irAmorometroIndividual1 (View view){
        String n1 = nombre1.getText().toString();
        amorometroIndividual = new Intent (this, AmorometroIndividual.class);
        amorometroIndividual.putExtra("n1", n1);
        startActivity(amorometroIndividual);
    }

}