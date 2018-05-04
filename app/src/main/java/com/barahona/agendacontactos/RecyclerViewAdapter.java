package com.barahona.agendacontactos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mCtx;
    private List<Contacto> mDatos;

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
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_book_title.setText(mDatos.get(position).getNombre());
        holder.img_book_thumbnail.setImageResource(mDatos.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mCtx, info_contacto.class);
                intent.putExtra("Nombre", mDatos.get(position).getNombre());
                intent.putExtra("Telefono", mDatos.get(position).getTelefono());
                mCtx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatos.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_book_title = (TextView) itemView.findViewById(R.id.book_title_id);
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.book_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }
}
