package com.barahona.agendacontactos;

import android.os.Parcel;
import android.os.Parcelable;

public class Contacto implements Parcelable{
    private String nombre;
    private String telefono;
    private int thumbnail;
    private boolean fav;

    public Contacto() {
    }

    public Contacto(String nombre, String telefono, int thumbnail) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.thumbnail = thumbnail;
        fav = false;
    }

    protected Contacto(Parcel in) {
        nombre = in.readString();
        telefono = in.readString();
        thumbnail = in.readInt();
        fav = in.readByte() != 0;
    }

    public static final Creator<Contacto> CREATOR = new Creator<Contacto>() {
        @Override
        public Contacto createFromParcel(Parcel in) {
            return new Contacto(in);
        }

        @Override
        public Contacto[] newArray(int size) {
            return new Contacto[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void set(boolean fav ){
        this.fav = fav;
    }

    public boolean verificarFav(){
        return fav;
    }

    public boolean yesorno(){
        return fav;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(telefono);
        dest.writeInt(thumbnail);
        dest.writeByte((byte)(fav?1:0));
    }
}
