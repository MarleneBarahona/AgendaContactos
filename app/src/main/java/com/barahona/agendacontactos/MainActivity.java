package com.barahona.agendacontactos;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView myrv;
    RecyclerViewAdapter myAdapter;
    List<Contacto> listContact, favos, buscados;
    Cursor c;
    Contacto addedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listContact = new ArrayList<>();
        favos = new ArrayList<>();
        buscados = new ArrayList<>();

        listContact.add(new Contacto("Isabel Barahona","79676777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Marlene Barahona","77886819",R.drawable.icono_contacto));
        listContact.add(new Contacto("Alam Brito","77777-0000", R.drawable.icono_contacto));
        listContact.add(new Contacto("Maria Hernandez","7888-7777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Raul Murillo","7689-7777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Equis","77777-0000", R.drawable.icono_contacto));
        listContact.add(new Contacto("Jose Martinez","77777-7777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Temperance Brennan","7888-7777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Pedrito Mengano","7689-7777",R.drawable.icono_contacto));
        listContact.add(new Contacto("Pompai","77777-0000", R.drawable.icono_contacto));


        myrv = (RecyclerView) findViewById(R.id.Recyclerview_id);
        myAdapter = new RecyclerViewAdapter(this,listContact);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
        EditText filter = (EditText) findViewById(R.id.filter);
        filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });
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

        favos.remove(contador );

        if (myAdapter.veriFavo()){
            myAdapter = new RecyclerViewAdapter((Context) favos, listContact);
            myrv.setAdapter(myAdapter);
        }
    }

    private void filter(String text){
        ArrayList<Contacto> filteredList = new ArrayList<>();
        for(Contacto item : listContact){
            if(item.getNombre().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        myAdapter.filterList(filteredList);
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
        //myAdapter = new RecyclerViewAdapter(v.getContext(), favos);
        //myrv.setAdapter(myAdapter);
        Intent intent = new Intent(this, agregar_contacto.class);
        addedit = new Contacto();
        startActivityForResult(intent, 1);
        //this.startActivity(intent);
    }

    public void buscarbtn(View v){
        EditText barra = (EditText) findViewById(R.id.filter);
        barra.setEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if (resultCode == Activity.RESULT_OK){
                Contacto nuevocontacto = data.getParcelableExtra(agregar_contacto.PIYU);
                listContact.add(nuevocontacto);
            }

        }
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
