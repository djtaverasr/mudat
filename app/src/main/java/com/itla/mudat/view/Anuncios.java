package com.itla.mudat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itla.mudat.Entity.Anuncio;
import com.itla.mudat.R;

public class Anuncios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_anuncios);
        Button bNuevo = (Button) findViewById(R.id.Nuevo);

        bNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Anuncios.this, RegistrarAnuncio.class);
                startActivity(intent);
            }
        });
    }
}
