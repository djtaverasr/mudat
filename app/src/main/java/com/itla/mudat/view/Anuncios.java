package com.itla.mudat.view;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.itla.mudat.Entity.Anuncio;
import com.itla.mudat.R;
import com.itla.mudat.dao.AnuncioDbo;
import com.itla.mudat.view.ListAdapter.AnuncioListAdapter;
import com.itla.mudat.view.mantenimiento.RegistroAnuncio;

import java.util.List;

public class Anuncios extends AppCompatActivity {
    ListView lvListaAnuncios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_anuncios);

        AnuncioDbo anuncioDbo = new AnuncioDbo(this);
        List<Anuncio> anuncios = anuncioDbo.buscar();
        Log.i("Usuarios","Cantidad de usuario " + anuncios.size());

        lvListaAnuncios = findViewById(R.id.ListaAnuncios);
        lvListaAnuncios.setAdapter(new AnuncioListAdapter(anuncios, this));

        lvListaAnuncios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent rAnuncio = new Intent (Anuncios.this, RegistroAnuncio.class);
                Anuncio u = (Anuncio) adapterView.getItemAtPosition(i);
                rAnuncio.putExtra("anuncio", u);
                startActivity(rAnuncio);
            }
        });

        FloatingActionButton fab = findViewById(R.id.Nuevo);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Anuncios.this, RegistroAnuncio.class);
                startActivity(intent);
            }
        });
    }
}
