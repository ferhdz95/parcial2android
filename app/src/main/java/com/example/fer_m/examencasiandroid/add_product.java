package com.example.fer_m.examencasiandroid;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class add_product extends AppCompatActivity {
    /*private String nombre;
    private String descripcion;
    private int cantidad;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        final TextInputEditText nombre = (TextInputEditText) findViewById(R.id.inputnombre);
        final TextInputEditText descripcion = (TextInputEditText) findViewById(R.id.descripcioninput);
        final TextInputEditText cantidad = (TextInputEditText) findViewById(R.id.cantidadinput);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.producto.add(new Producto(0,nombre.getText().toString(), descripcion.getText().toString(),
                        Integer.parseInt(cantidad.getText().toString())));
                MainActivity.adaptadorProducto.notifyDataSetChanged();
            }
        });

    }
}
