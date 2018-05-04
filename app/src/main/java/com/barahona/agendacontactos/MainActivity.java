package com.barahona.agendacontactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contacto> listContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listContact = new ArrayList<>();
        listContact.add(new Contacto("Pedrito Mengano","77777-7777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Maria Hernandez","7888-7777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Raul Murillo","7689-7777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Equis","77777-0000", R.drawable.icono_contacto));
        listContact.add(new Contacto("Pedrito Mengano","77777-7777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Maria Hernandez","7888-7777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Raul Murillo","7689-7777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Equis","77777-0000", R.drawable.icono_contacto));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.Recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,listContact);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
    }
}
