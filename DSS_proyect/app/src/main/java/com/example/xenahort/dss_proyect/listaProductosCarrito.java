/*
 * *
 *  * Created by Juan Carlos Serrano Pérez on 29/12/18 22:06
 *  * Any question send an email to juan.carlos.wow.95@gmail.com
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 29/12/18 22:06
 *
 */

package com.example.xenahort.dss_proyect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class listaProductosCarrito extends AppCompatActivity {

    private Carrito carrito;

    private ListView lst;

    private Button btnVolver;
    private Button btnComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos_carrito);

        carrito= (Carrito) getIntent().getSerializableExtra("Carrito");
        Log.d("caro lista protos carro", this.carrito.toString());

        String productos[]=new String[carrito.getProductos().size()];
        for(int i=0;i<carrito.getProductos().size();i++){
            productos[i]=carrito.getProductos().get(i).getName()+" X "+carrito.getProductos().get(i).getUnidad()+"u     "+(carrito.getProductos().get(i).getUnidad()*Integer.valueOf(carrito.getProductos().get(i).getPrice())+"€");
        }

        lst = findViewById(R.id.listacarro);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, productos);
        lst.setAdapter(adapter);

        btnVolver = (Button) findViewById(R.id.btnvolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listaProductosCarrito.this, MapsActivity.class);
                intent.putExtra("Carrito", carrito);
                startActivityForResult(intent, 0);
            }
        });
        btnComprar = (Button) findViewById(R.id.btncomprar);
        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(listaProductosCarrito.this, ListaFarmaciasActivity.class);
                //intent.putExtra("Carrito", carrito);
                //startActivityForResult(intent, 0);
            }
        });
        if(carrito.getProductos().isEmpty()){
            btnComprar.setEnabled(false);
        }
    }
}
