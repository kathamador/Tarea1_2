package com.example.tarea1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button enviar;
    EditText nombre, apellido, edad, correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.txtnombre);
        apellido = (EditText) findViewById(R.id.txtapellido);
        edad = (EditText) findViewById(R.id.txtedad);
        correo = (EditText) findViewById(R.id.txtcorreo);
        enviar = (Button) findViewById(R.id.btnenviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nombre.getText().toString().isEmpty() || apellido.getText().toString().isEmpty() || edad.getText().toString().isEmpty() || correo.getText().toString().isEmpty()){
                    validaciones();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(),ActivityResultados.class);
                    intent.putExtra("nombre", nombre.getText()+"");
                    intent.putExtra("apellido", apellido.getText()+"");
                    intent.putExtra("edad", edad.getText()+"");
                    intent.putExtra("correo", correo.getText()+"");
                    startActivity(intent);
                    limpiar();
                }
            }
        });

    }

    public void limpiar(){
        nombre.setText("");
        apellido.setText("");
        edad.setText("");
        correo.setText("");
    }

    public void validaciones(){
        if(nombre.getText().toString().isEmpty() && apellido.getText().toString().isEmpty() && edad.getText().toString().isEmpty() && correo.getText().toString().isEmpty()){
            Toast.makeText(this, "Todos los campos estan vacios, llenelos.", Toast.LENGTH_SHORT).show();
        }
        else if (nombre.getText().toString().isEmpty()) {
            Toast.makeText(this, "Campo nombre esta vacio, llenelo.", Toast.LENGTH_SHORT).show();
        }
        else if (apellido.getText().toString().isEmpty()) {
            Toast.makeText(this, "Campo apellido esta vacio, llenelo.", Toast.LENGTH_SHORT).show();
        }else if (edad.getText().toString().isEmpty()) {
            Toast.makeText(this, "Campo edad esta vacio, llenelo.", Toast.LENGTH_SHORT).show();
        }else if (correo.getText().toString().isEmpty()) {
            Toast.makeText(this, "Campo correo esta vacio, llenelo.", Toast.LENGTH_SHORT).show();
        }

    }
}