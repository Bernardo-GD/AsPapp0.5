package com.pachoncito.aspapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

public class CalendarioPrincipal extends AppCompatActivity {

    private CalendarView calendario;
    private String fecha;
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

        calendario = (CalendarView)findViewById(R.id.cvPrincipal);

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                fecha = dayOfMonth + "/" + month + "/" + year;
                Toast.makeText(CalendarioPrincipal.this, fecha, Toast.LENGTH_LONG).show();

            }
        });

    }

    public void irActividad (View view){

        Intent irRegistrarActividad = new Intent(this, CalendarioActividad.class);
        irRegistrarActividad.putExtra("fechaRegistro", fecha);
        startActivity(irRegistrarActividad);
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