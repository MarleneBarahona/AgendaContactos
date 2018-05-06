package com.barahona.agendacontactos;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView myrv;
    RecyclerViewAdapter myAdapter;
    List<Contacto> listContact, favos;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listContact = new ArrayList<>();
        favos = new ArrayList<>();

        listContact.add(new Contacto("Pedrito Mengano","77777-7777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Maria Hernandez","7888-7777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Raul Murillo","7689-7777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Equis","77777-0000", R.drawable.icono_contacto));
        listContact.add(new Contacto("Pedrito Mengano","77777-7777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Maria Hernandez","7888-7777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Raul Murillo","7689-7777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Equis","77777-0000", R.drawable.icono_contacto));

        myrv = (RecyclerView) findViewById(R.id.Recyclerview_id);
        myAdapter = new RecyclerViewAdapter(this,listContact);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
    }

    public void addFavs(Contacto favo){
        favos.add(favo);
    }

    public void eraseFavourite(String name) {
        int contador = 0;
        for (Contacto contacts : favos){
            if (contacts.getNombre()== name){
                break;
            }
            contador++;
        }

        favos.remove(contador);

        if (myAdapter.veriFavo()){
            myAdapter = new RecyclerViewAdapter((Context) favos, listContact);
            myrv.setAdapter(myAdapter);

        }
    }

    //Para muestrar todos los contactos
    public void homebtn(View v){

        myAdapter = new RecyclerViewAdapter(v.getContext(), listContact);
        myrv.setAdapter(myAdapter);
    }

    //Para muestrar solo los favs
    public void favbtn(View v){

        myAdapter = new RecyclerViewAdapter(v.getContext(), favos);
        myrv.setAdapter(myAdapter);
    }

    public void addbtn(View v){

    }
    /*private void Meto(){
        c = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.Contacts.DISPLAY_NAME + "ASC");
        //listContact = new ArrayList<String>();
        while (c.moveToNext()){
            String nombre = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String telefono = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

           // listContact.add("Nombre "+ nombre + "Telefono "+ telefono);
        }

    }*/


}
