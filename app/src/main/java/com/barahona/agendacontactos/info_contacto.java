package com.barahona.agendacontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class info_contacto extends AppCompatActivity {

    TextView tv_nombre, tv_telefono;
    ImageButton bttncall;
    String numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_contacto);

        tv_nombre = (TextView) findViewById(R.id.tv_nombre_id);
        tv_telefono = (TextView) findViewById(R.id.tv_telefono_id);
        bttncall = (ImageButton) findViewById(R.id.imgbttn_llamar_id);

        Intent intent = getIntent();
        final String nombre = intent.getExtras().getString("Nombre");
        final String telefono = intent.getExtras().getString("Telefono");

        tv_nombre.setText(nombre);
        tv_telefono.setText(telefono);
        //numero = "22521722";

        bttncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Llamar(telefono);
                //Intent callintent = new Intent(Intent.ACTION_DIAL);
                /*callintent.setData(Uri.parse("tel:22521722"));
                if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    return;
                }*/
                //startActivity(callintent);
            }
        });
    }
    public void Llamar(String numero){
        Intent callintent = new Intent(Intent.ACTION_CALL);
        callintent.setData(Uri.parse("tel:"+numero));
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        startActivity(callintent);
    }
}
