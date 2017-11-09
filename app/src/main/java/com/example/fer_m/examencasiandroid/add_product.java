package com.example.fer_m.examencasiandroid;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
                /*MainActivity.producto.add(new Producto(0,nombre.getText().toString(), descripcion.getText().toString(),
                        Integer.parseInt(cantidad.getText().toString())));
                MainActivity.adaptadorProducto.notifyDataSetChanged();*/
                MainActivity.mdatabase.addProduct(new Producto(0,nombre.getText().toString(), descripcion.getText().toString(),
                        Integer.parseInt(cantidad.getText().toString())));
                MainActivity.adaptadorProducto.notifyDataSetChanged();
                Snackbar.make(v, "El registro se agrego a la base de datos.", Snackbar.LENGTH_LONG)
                        .show();
                nombre.setText("");
                descripcion.setText("");
                cantidad.setText("");
            }
        });

    }


    public void startmain(){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
        finish();
    }

    @Override
    public void onBackPressed() {
        startmain();
    }

}
