package com.barahona.agendacontactos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class agregar_contacto extends AppCompatActivity {

    EditText et_nombre, et_telefono;
    ImageView img;
    Button boton;
    Contacto contacto;
    public static final String PIYU="PIYU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);

        et_nombre = (EditText) findViewById(R.id.et_nombre_id);
        et_telefono = (EditText) findViewById(R.id.et_telefono_id);
        img = (ImageView) findViewById(R.id.img_addcontacto_id);
        boton = (Button) findViewById(R.id.bttn_agregarcont_id);

        Intent intent = getIntent();
        contacto = intent.hasExtra(PIYU)? (Contacto)intent.getParcelableExtra(PIYU): (new Contacto());
        et_nombre.setText(contacto.getNombre());
        et_telefono.setText(contacto.getTelefono());

    }

    public void guardarContacto(View view){
        contacto.setNombre(et_nombre.getText().toString());
        contacto.setTelefono(et_telefono.getText().toString());
        contacto.setThumbnail(R.drawable.icono_contacto);
        Intent returnIntent = new Intent();
        returnIntent.putExtra(PIYU, contacto);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
