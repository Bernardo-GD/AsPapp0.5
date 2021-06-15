package com.pachoncito.aspapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistroP1 extends AppCompatActivity {

    private Spinner diasSpin, mesesSpin, yearsSpin;
    private RadioButton otro, madre, padre;
    private EditText campoOtro, nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_p1);

        diasSpin = (Spinner)findViewById(R.id.spinnerDias);
        mesesSpin = (Spinner)findViewById(R.id.spinnerMeses);
        yearsSpin = (Spinner)findViewById(R.id.spinnerYears);

        madre = (RadioButton)findViewById(R.id.rb_madre);
        padre = (RadioButton)findViewById(R.id.rb_padre);

        otro = (RadioButton)findViewById(R.id.rb_otro);
        campoOtro = (EditText)findViewById(R.id.ed_campoOtro);

        nombre = (EditText)findViewById(R.id.ed_nombre);

        //Este método es para cambiar la barrita de arriba donde viene la hora
        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));

        //Este método me va a funcionar para cambiar el color de la ActionBar
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#CA0000")));
        //Este metodo es para cambiar el color del fondo que quiero que sesa blanco
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        getSupportActionBar().hide();
        //Declarando los Spinnerpar la fecha;

        String dias31[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String years[] = new String [50];
        int y_comienzo = 1950;
        for (int i = 0; i<50; i++){
            years[i] = String.valueOf(y_comienzo);
            y_comienzo++;
        }

        ArrayAdapter <String> adaptadorDias = new ArrayAdapter<String>(this, R.layout.spinner_item_opciones, dias31);
        diasSpin.setAdapter(adaptadorDias);

        ArrayAdapter <String> adaptadorMeses = new ArrayAdapter<String>(this, R.layout.spinner_item_opciones, meses);
        mesesSpin.setAdapter(adaptadorMeses);

        ArrayAdapter <String> adaptadoresYears = new ArrayAdapter<String>(this, R.layout.spinner_item_opciones, years);
        yearsSpin.setAdapter(adaptadoresYears);


    }

    public void irRegistro2 (View view){


        boolean datosCorrectos = confirmarDatos();

        if  (datosCorrectos == true){
            Intent irARegistro2 = new Intent(this, RegistroP2.class);
            /*
            APBD helperObjeto = new APBD(this, "BD_AsPapp", null, 1);
            SQLiteDatabase BD = helperObjeto.getWritableDatabase();

            String nombreUsuario = nombre.getText().toString();
            String tipoUsuario = "";
            if  (madre.isChecked()){
                tipoUsuario = "Madre";
            }else{
                if  (padre.isChecked()){
                    tipoUsuario = "Padre";
                }else{
                    if  (otro.isChecked()){
                        tipoUsuario = campoOtro.getText().toString();
                    }
                }
            }

            ContentValues registro = new ContentValues();
            registro.put("nombre", nombreUsuario);
            registro.put("tipo", tipoUsuario);

            BD.insert("Persona", null, registro);
            BD.close();
            */
            //envio al siguiente activity el nombre del usuario
            irARegistro2.putExtra("nombreUsuario", nombre.getText().toString());

            String tipo = "";
            if  (madre.isChecked()){
                 tipo = "Madre";
            }else{
                if  (padre.isChecked()){
                    tipo = "Padre";
                }else{
                    if  (otro.isChecked()){
                        tipo = campoOtro.getText().toString();
                    }
                }
            }
            //envio el tipo de usuario al siguiente activity
            irARegistro2.putExtra("tipoUsuario", tipo);
            //envio la fecha por partes al siguiente activity
            irARegistro2.putExtra("diaFU", diasSpin.getSelectedItem().toString());
            irARegistro2.putExtra("mesFU", mesesSpin.getSelectedItem().toString());
            irARegistro2.putExtra("yearFU", yearsSpin.getSelectedItem().toString());

            startActivity(irARegistro2);
        }else{
            Toast.makeText(this, "Campo vacio o con números ", Toast.LENGTH_LONG).show();
        }


    }

    public void habilitarCampoOtros (View view){

        if(otro.isChecked()){
            campoOtro.setVisibility(View.VISIBLE);
        }

    }

    public void inHabilitarCampoOtros (View view){

        campoOtro.setVisibility(View.INVISIBLE);

    }

    public boolean confirmarDatos (){

        boolean retorno = false;

        String tipo = "";
        String nombre = "";
        String dia = diasSpin.getSelectedItem().toString();
        String mes = mesesSpin.getSelectedItem().toString();
        String year = yearsSpin.getSelectedItem().toString();
        if  (otro.isChecked()){

            if  (!campoOtro.getText().toString().equals("")){
                tipo = campoOtro.getText().toString();
            }


        }else{
            if (madre.isChecked()){
                tipo = "Madre";
            }else{
                if (padre.isChecked()){
                    tipo = "Padre";
                }
            }
        }

        if (!this.nombre.getText().toString().equals("")){
            nombre = this.nombre.getText().toString();
        }

        if (!tipo.equals("") && !nombre.equals("") && !dia.equals("") && !mes.equals("") && !year.equals("")){

            if (soloLetrasYPuntos(tipo) && soloLetrasYPuntos(nombre)){
                retorno = true;
            }else{
                retorno = false;
            }
        }

        return retorno;
    }

    //método para comprobar si una cadena solo tiene letras y puntos
    public boolean soloLetrasYPuntos (String cadena){
        boolean aceptada = true;
        char cc[] = cadena.toCharArray();

        for (int i = 0; i<cc.length; i++){

            if ( (cc[i] >= 'a' && cc[i] <= 'z') || (cc[i] >= 'A' && cc[i] <= 'Z') || ( cc[i] == '.') || (cc[i] == ' ') || (cc[i] == 'á') || (cc[i] == 'é') || (cc[i] == 'í') || (cc[i] == 'ó') || (cc[i] == 'ú') || (cc[i] == 'Á') || (cc[i] == 'É') || (cc[i] == 'Í') || (cc[i] == 'Ó') || (cc[i] == 'Ú')){

                aceptada = true;

            }else{
                aceptada = false;
                break;
            }

        }

        return aceptada;
    }


}