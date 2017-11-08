package com.example.fer_m.examencasiandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by fer_m on 08/11/2017.
 */

public class MuestraProductosFragment extends Fragment {
    int count=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.show_product_fragment, container, false);
        ListView listaProductos = (ListView) view.findViewById(R.id.list_product);
        MainActivity.adaptadorProducto =new AdaptadorProducto(getActivity(),MainActivity.producto);
        listaProductos.setAdapter(MainActivity.adaptadorProducto);
        count++;

        return view;

    }
    public void setMenuVisibility(final boolean ban){
        super.setMenuVisibility(ban);
        if(ban){
            if(count!=0) {
                //mi.clear();
                //mi.notifyDataSetChanged();
                // listaDatos = (ListView) listaDatos.findViewById(R.id.lstDatos);
                //Lista.add(new Datos(1, "Comida", "200",R.drawable.lasagna));
                // mi = new AdaptadorInventario(getActivity(), Lista);
                //listaDatos.setAdapter(mi);
            }
        }
    }
}
