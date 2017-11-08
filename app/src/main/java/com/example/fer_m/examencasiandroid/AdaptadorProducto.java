package com.example.fer_m.examencasiandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by fer_m on 08/11/2017.
 */

public class AdaptadorProducto extends BaseAdapter{
    Context contexto;
    ArrayList<Producto> listProductos;

    public AdaptadorProducto(Context contexto, ArrayList<Producto> listProductos) {
        this.contexto = contexto;
        this.listProductos = listProductos;


    }
    public void clear() {
        listProductos.clear();
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        vista =  LayoutInflater.from(contexto).inflate(R.layout.producto,null);
        TextView Nombre = (TextView) vista.findViewById(R.id.nombre);
        TextView cantidad = (TextView) vista.findViewById(R.id.cantidad);
        TextView descripcion = (TextView) vista.findViewById(R.id.descripcion);
        Nombre.setText(listProductos.get(position).getNombre().toString());
        cantidad.setText(String.valueOf(listProductos.get(position).getCantidad()));
        descripcion.setText(listProductos.get(position).getDescripcion().toString());

        return vista;
    }
}
