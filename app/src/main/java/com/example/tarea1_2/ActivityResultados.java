package com.example.tarea1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityResultados extends AppCompatActivity {

    Button regresar;
    TextView nombre, apellido, edad, correo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        nombre = (TextView) findViewById(R.id.tnombre);
        apellido =  (TextView) findViewById(R.id.tapellido);
        edad =  (TextView) findViewById(R.id.tedad);
        correo =  (TextView) findViewById(R.id.tcorreo);
        regresar = (Button) findViewById(R.id.regresar);

        String nom = getIntent().getStringExtra("nombre");
        String ape = getIntent().getStringExtra("apellido");
        String ed = getIntent().getStringExtra("edad");
        String co = getIntent().getStringExtra("correo");

        nombre.setText(nom);
        apellido.setText(ape);
        edad.setText(ed);
        correo.setText(co);

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}