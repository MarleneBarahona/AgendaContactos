package com.barahona.agendacontactos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mCtx;
    private List<Contacto> mDatos;
    private boolean favi;
    private Activity activity;

    public RecyclerViewAdapter(Context mCtx, List<Contacto> mDatos) {
        this.mCtx = mCtx;
        this.mDatos = mDatos;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater Inflater = LayoutInflater.from(mCtx);
        view = Inflater.inflate(R.layout.cardview_item_contacto, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.tv_book_title.setText(mDatos.get(position).getNombre());
        holder.img_book_thumbnail.setImageResource(mDatos.get(position).getThumbnail());
        //dandole funcion a las cardview para motrar la info de cada contacto
        holder.cardViewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mCtx, info_contacto.class);
                intent.putExtra("Nombre", mDatos.get(position).getNombre());
                intent.putExtra("Telefono", mDatos.get(position).getTelefono());
                mCtx.startActivity(intent);
            }
        });

        /*holder.bttn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mCtx, agregar_contacto.class);
                mCtx.startActivity(intent);
            }
        });*/
        /*holder.bttn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mCtx, info_contacto.class);
                intent.putExtra("Nombre", mDatos.get(position).getNombre());
                intent.putExtra("Telefono", mDatos.get(position).getTelefono());
                mCtx.startActivity(intent);
            }
        });*/

        //si esta en favs pone la estrellita amarilla
        if(mDatos.get(position).yesorno()){
            holder.fav.setImageResource(R.drawable.starfav);
        }else {
            //si no, pone la estrella sin color
            holder.fav.setImageResource(R.drawable.estrella_gris);
        }
        //dandole funcion al boton de favs
        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //al dar click al boton de estrella gris cambia a amarilla y lo agrega a favs
                if (favContact(position)){
                    holder.fav.setImageResource(R.drawable.starfav);
                    ((MainActivity)mCtx).addFavs(mDatos.get(position));
                }else {
                    //al dar click al boton de estrella gris cambia a amarilla y lo elimina de favs
                    holder.fav.setImageResource(R.drawable.estrella_gris);
                    ((MainActivity)mCtx).eraseFavourite(mDatos.get(position).getNombre());
                }
            }
            }
        );
    }

    @Override
    public int getItemCount() {
        return mDatos.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageButton bttn_agregar, bttn_buscar;
        Button bttn_contacts, bttn_favorites;
        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardViewContact;
        ImageButton fav;
        CardView cardViewAgregar;

        public MyViewHolder(View itemView) {
            super(itemView);
            bttn_agregar = (ImageButton) itemView.findViewById(R.id.imgbttn_agregar_id);
            bttn_buscar = (ImageButton) itemView.findViewById(R.id.imgbttn_buscar_id);
            bttn_contacts = (Button) itemView.findViewById(R.id.bttn_contactos);
            bttn_favorites = (Button) itemView.findViewById(R.id.bttn_favs);
            tv_book_title = (TextView) itemView.findViewById(R.id.book_title_id);
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.book_img_id);
            cardViewContact = (CardView) itemView.findViewById(R.id.cardview_id);
            fav = (ImageButton) itemView.findViewById(R.id.imgbttn_fav_id);
            cardViewAgregar = (CardView) itemView.findViewById(R.id.cardview_add_id);
        }
    }

    public boolean favContact(int position){
        mDatos.get(position).set(!mDatos.get(position).verificarFav());
        return mDatos.get(position).verificarFav();
    }
    public boolean veriFavo(){
        return favi;
    }
}