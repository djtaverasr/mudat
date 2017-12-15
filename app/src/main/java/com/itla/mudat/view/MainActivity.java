package com.itla.mudat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itla.mudat.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        Button bUsuarios = (Button) findViewById(R.id.bUsuarios);
        Button bAnuncios = (Button) findViewById(R.id.bAnuncios);
        Button bCategoria = (Button) findViewById(R.id.bCategoria);

        bUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListaUsuario.class);
                startActivity(intent);
            }
        });

        bAnuncios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Anuncios.class);
                startActivity(intent);
            }
        });

//        bCategoria.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Categorias.class);
//                startActivity(intent);
//            }
//        });


    }
}
