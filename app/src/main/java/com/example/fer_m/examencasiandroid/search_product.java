package com.example.fer_m.examencasiandroid;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class search_product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);

        Button button = (Button) findViewById(R.id.button);
        final TextInputEditText nombre = findViewById(R.id.nombre);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView listaProductos = (ListView) findViewById(R.id.listprod);
                AdaptadorProducto busqueda = new AdaptadorProducto(v.getContext(), MainActivity.
                        mdatabase.findProduct(nombre.getText().toString()));
                listaProductos.setAdapter(busqueda);
                listaProductos.deferNotifyDataSetChanged();
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
