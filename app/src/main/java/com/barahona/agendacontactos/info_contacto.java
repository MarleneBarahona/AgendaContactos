package com.barahona.agendacontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class info_contacto extends AppCompatActivity {

    TextView tv_nombre, tv_telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_contacto);

        tv_nombre = (TextView) findViewById(R.id.tv_nombre_id);
        tv_telefono = (TextView) findViewById(R.id.tv_telefono_id);
        Intent intent = getIntent();
        String nombre = intent.getExtras().getString("Nombre");
        String telefono = intent.getExtras().getString("Telefono");

        tv_nombre.setText(nombre);
        tv_telefono.setText(telefono);
    }
}
