package com.pachoncito.aspapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class CalendarioActividad extends AppCompatActivity {

    private String fechaRecibida;
    private Spinner horaInicio, horaFin, api, apf;
    private CheckBox checkHijo1;

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

        //Recibo la fecha del activity anterior
        fechaRecibida = getIntent().getStringExtra("fechaRegistro");
        //pruebo que se recibió
        Toast.makeText(this, fechaRecibida, Toast.LENGTH_LONG).show();
        //---------------------------------------------------------------------

        //Recibiendo la hora de inicio y de fin en la variable interna
        horaInicio = (Spinner)findViewById(R.id.spHoraI);
        horaFin = (Spinner)findViewById(R.id.spHoraF);
        api = (Spinner)findViewById(R.id.spAPI);
        apf = (Spinner)findViewById(R.id.spAPF);

        //Declaro los arreglos que mandaré a los spinner
        String hora[] = {"1:00", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00", "4:30", "5:00", "5:30", "6:00", "6:30", "7:00", "7:30", "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00"};
        String aopm[] = {"a. m.", "p. m."};
        //adaptadores para spinners de hora inicio y fin
        ArrayAdapter <String> adaptadorHora = new ArrayAdapter<String>(this, R.layout.spinner_item_opciones, hora);
        ArrayAdapter <String> adaptadorAP = new ArrayAdapter<String>(this, R.layout.spinner_item_opciones, aopm);

        horaInicio.setAdapter(adaptadorHora);
        horaFin.setAdapter(adaptadorHora);
        api.setAdapter(adaptadorAP);
        apf.setAdapter(adaptadorAP);

        checkHijo1 = (CheckBox)findViewById(R.id.checkHijo1);

        APBD helperObjeto = new APBD(this, "BD_AsPapp1", null, 1);
        SQLiteDatabase BD = helperObjeto.getWritableDatabase();
        @SuppressLint("Recycle") Cursor fila = BD.rawQuery("SELECT nombre FROM Persona", null);
        String nombres[] = new String[6];
        int it = 0;
        if (fila.moveToFirst()){

            do{
                nombres[it] = fila.getString(0);
                it++;
            }while(fila.moveToNext());

        }
        //Toast.makeText(this, nombres[0] + "-" + nombres[1], Toast.LENGTH_LONG).show();
        checkHijo1.setText(nombres[1]);
        checkHijo1.setVisibility(View.VISIBLE);
        BD.close();


    }


    public void regresar(View view){

        Intent regresarC = new Intent(this, CalendarioPrincipal.class);
        startActivity(regresarC);

    }
}