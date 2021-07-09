package com.pachoncito.aspapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistroP2 extends AppCompatActivity {

    private Spinner listaHijos;
    private EditText nombre1, nombre2, nombre3, nombre4, nombre5;
    private ImageView texto1, texto2, texto3, texto4, texto5;
    private int cantidadHijos;
    private boolean retornarNombresCorrectos = false;
    //datos del activity anterior
    private String nombreUsuario, tipoUsuario, diaUsuario, mesUsuario, yearUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_p2);

        //cambiar el color dde la barra donde está la hora, notificaciones, etc
        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));
        //Cambiar fondo a blanco
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        //quitar Actionbar
        getSupportActionBar().hide();

        listaHijos = (Spinner)findViewById(R.id.spinnerHijos);
        nombre1 = (EditText)findViewById(R.id.edNombre1);
        nombre2 = (EditText)findViewById(R.id.edNombre2);
        nombre3 = (EditText)findViewById(R.id.edNombre3);
        nombre4 = (EditText)findViewById(R.id.edNombre4);
        nombre5 = (EditText)findViewById(R.id.edNombre5);

        texto1 = (ImageView)findViewById(R.id.textoImagen1);
        texto2 = (ImageView)findViewById(R.id.textoImagen2);
        texto3 = (ImageView)findViewById(R.id.textoImagen3);
        texto4 = (ImageView)findViewById(R.id.textoImagen4);
        texto5 = (ImageView)findViewById(R.id.textoImagen5);


        String cantidades[] = {"1", "2", "3", "4", "5"};
        ArrayAdapter <String> adaptador = new ArrayAdapter<String>(this, R.layout.spinner_item_opciones, cantidades);
        listaHijos.setAdapter(adaptador);

        //habilito o inhabilito los campos de texto y si etiqueta
        listaHijos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                cantidadHijos = Integer.parseInt(parent.getItemAtPosition(position).toString());
                switch (parent.getItemAtPosition(position).toString()){

                    case "1":

                        nombre1.setVisibility(View.VISIBLE);
                        nombre2.setVisibility(View.INVISIBLE);
                        nombre3.setVisibility(View.INVISIBLE);
                        nombre4.setVisibility(View.INVISIBLE);
                        nombre5.setVisibility(View.INVISIBLE);

                        texto1.setVisibility(View.VISIBLE);
                        texto2.setVisibility(View.INVISIBLE);
                        texto3.setVisibility(View.INVISIBLE);
                        texto4.setVisibility(View.INVISIBLE);
                        texto5.setVisibility(View.INVISIBLE);

                        break;

                    case "2":

                        nombre1.setVisibility(View.VISIBLE);
                        nombre2.setVisibility(View.VISIBLE);
                        nombre3.setVisibility(View.INVISIBLE);
                        nombre4.setVisibility(View.INVISIBLE);
                        nombre5.setVisibility(View.INVISIBLE);

                        texto1.setVisibility(View.VISIBLE);
                        texto2.setVisibility(View.VISIBLE);
                        texto3.setVisibility(View.INVISIBLE);
                        texto4.setVisibility(View.INVISIBLE);
                        texto5.setVisibility(View.INVISIBLE);

                        break;

                    case "3":

                        nombre1.setVisibility(View.VISIBLE);
                        nombre2.setVisibility(View.VISIBLE);
                        nombre3.setVisibility(View.VISIBLE);
                        nombre4.setVisibility(View.INVISIBLE);
                        nombre5.setVisibility(View.INVISIBLE);

                        texto1.setVisibility(View.VISIBLE);
                        texto2.setVisibility(View.VISIBLE);
                        texto3.setVisibility(View.VISIBLE);
                        texto4.setVisibility(View.INVISIBLE);
                        texto5.setVisibility(View.INVISIBLE);

                        break;

                    case "4":

                        nombre1.setVisibility(View.VISIBLE);
                        nombre2.setVisibility(View.VISIBLE);
                        nombre3.setVisibility(View.VISIBLE);
                        nombre4.setVisibility(View.VISIBLE);
                        nombre5.setVisibility(View.INVISIBLE);

                        texto1.setVisibility(View.VISIBLE);
                        texto2.setVisibility(View.VISIBLE);
                        texto3.setVisibility(View.VISIBLE);
                        texto4.setVisibility(View.VISIBLE);
                        texto5.setVisibility(View.INVISIBLE);

                        break;

                    case "5":

                        nombre1.setVisibility(View.VISIBLE);
                        nombre2.setVisibility(View.VISIBLE);
                        nombre3.setVisibility(View.VISIBLE);
                        nombre4.setVisibility(View.VISIBLE);
                        nombre5.setVisibility(View.VISIBLE);

                        texto1.setVisibility(View.VISIBLE);
                        texto2.setVisibility(View.VISIBLE);
                        texto3.setVisibility(View.VISIBLE);
                        texto4.setVisibility(View.VISIBLE);
                        texto5.setVisibility(View.VISIBLE);

                        break;


                }

                /*if(parent.getItemAtPosition(position).toString().equals("1")){
                    nombre1.setVisibility(View.INVISIBLE);
                }*/

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //recibo los datos del usuario principal del activity anterior y ya estan validados
        //nombreUsuario, tipoUsuario, diaUsuario, mesUsuario, yearUsuario;
        nombreUsuario = getIntent().getStringExtra("nombreUsuario");
        tipoUsuario = getIntent().getStringExtra("tipoUsuario");
        diaUsuario = getIntent().getStringExtra("diaFU");
        mesUsuario = getIntent().getStringExtra("mesFU");
        yearUsuario = getIntent().getStringExtra("yearFU");



    }

    //para boton finalizar
    public void firstAmorometros (View view){

        boolean datosCorrectos = nombresCorrectos();

        if (datosCorrectos){
            String n1, n2, n3, n4, n5;
            Intent irAmorometrosFirst = new Intent(this, AmorometrosPrincipal.class);

            APBD helperObjeto1 = new APBD(this, "BD_AsPapp1", null, 1);
            SQLiteDatabase BD1 = helperObjeto1.getWritableDatabase();

            APBD helperObjeto2 = new APBD(this, "BD_AsPapp1", null, 1);
            SQLiteDatabase BD2 = helperObjeto2.getWritableDatabase();

            //primera inserción a la base dedatos: tipo, personas, datos/preguntas

            //objeto para progenitores
            ContentValues registro1 = new ContentValues();

            //objeto para hijos/as
            ContentValues registro2 = new ContentValues();

            switch (Integer.parseInt(listaHijos.getSelectedItem().toString())){

                case 1:
                    n1 = nombre1.getText().toString();

                    //registrando papa
                    registro1.put("nombre", nombreUsuario);
                    registro1.put("tipo", tipoUsuario);

                    BD1.insert("Persona", null, registro1);
                    BD1.close();

                    registro2.put("nombre", n1);
                    registro2.put("tipo", "hijo");
                    BD2.insert("Persona", null, registro2);


                    BD2.close();
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show();

                    break;

                case 2:
                    n1 = nombre1.getText().toString();
                    n2 = nombre1.getText().toString();
                    break;

                case 3:
                    n1 = nombre1.getText().toString();
                    n2 = nombre1.getText().toString();
                    n3 = nombre1.getText().toString();
                    break;

                case 4:
                    n1 = nombre1.getText().toString();
                    n2 = nombre1.getText().toString();
                    n3 = nombre1.getText().toString();
                    n4 = nombre1.getText().toString();
                    break;

                case 5:
                    n1 = nombre1.getText().toString();
                    n2 = nombre1.getText().toString();
                    n3 = nombre1.getText().toString();
                    n4 = nombre1.getText().toString();
                    n5 = nombre1.getText().toString();
                    break;


            }

            startActivity(irAmorometrosFirst);
        }else{
            Toast.makeText(this, "Campo vacio o con números ", Toast.LENGTH_LONG).show();
        }




    }

    public boolean nombresCorrectos(){

        retornarNombresCorrectos = false;

        String n1 = nombre1.getText().toString();
        String n2 = nombre2.getText().toString();
        String n3 = nombre3.getText().toString();
        String n4 = nombre4.getText().toString();
        String n5 = nombre5.getText().toString();

        switch (Integer.parseInt(listaHijos.getSelectedItem().toString())){

            case 1:

                if (!n1.equals("") ){
                    if(soloLetrasYPuntos(n1)){
                        retornarNombresCorrectos = true;
                    }else{
                        retornarNombresCorrectos = false;
                    }
                }else{
                    retornarNombresCorrectos = false;
                }

                break;

            case 2:

                if (!n1.equals("") && !n2.equals("") ){
                    if(soloLetrasYPuntos(n1) && soloLetrasYPuntos(n2)){
                        retornarNombresCorrectos = true;
                    }else{
                        retornarNombresCorrectos = false;
                    }
                }else{
                    retornarNombresCorrectos = false;
                }

                break;

            case 3:

                if (!n1.equals("") && !n2.equals("") && !n3.equals("")  ){
                    if(soloLetrasYPuntos(n1) && soloLetrasYPuntos(n2) && soloLetrasYPuntos(n3)  ){
                        retornarNombresCorrectos = true;
                    }else{
                        retornarNombresCorrectos = false;
                    }
                }else{
                    retornarNombresCorrectos = false;
                }

                break;

            case 4:

                if (!n1.equals("") && !n2.equals("") && !n3.equals("") && !n4.equals("") ){
                    if(soloLetrasYPuntos(n1) && soloLetrasYPuntos(n2) && soloLetrasYPuntos(n3) && soloLetrasYPuntos(n4) ){
                        retornarNombresCorrectos = true;
                    }else{
                        retornarNombresCorrectos = false;
                    }
                }else{
                    retornarNombresCorrectos = false;
                }

                break;

            case 5:

                if (!n1.equals("") && !n2.equals("") && !n3.equals("") && !n4.equals("") && !n5.equals("")){
                    if(soloLetrasYPuntos(n1) && soloLetrasYPuntos(n2) && soloLetrasYPuntos(n3) && soloLetrasYPuntos(n4) && soloLetrasYPuntos(n5)){
                        retornarNombresCorrectos = true;
                    }else{
                        retornarNombresCorrectos = false;
                    }
                }else{
                    retornarNombresCorrectos = false;
                }

                break;

        }


                return retornarNombresCorrectos;
    }

    /*
    if (!n1.equals("") && !n2.equals("") && !n3.equals("") && !n4.equals("") && !n5.equals("")){
                            if(soloLetrasYPuntos(n1) && soloLetrasYPuntos(n2) && soloLetrasYPuntos(n3) && soloLetrasYPuntos(n4) && soloLetrasYPuntos(n5)){
                                retornarNombresCorrectos = true;
                            }else{
                                retornarNombresCorrectos = false;
                            }
                        }else{
                            retornarNombresCorrectos = false;
                        }
     */

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