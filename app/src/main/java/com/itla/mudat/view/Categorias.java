package com.itla.mudat.view;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.itla.mudat.Entity.Categoria;
import com.itla.mudat.R;
import com.itla.mudat.dao.CategoriaDbo;
import com.itla.mudat.view.ListAdapter.CategoriaListAdapter;
import com.itla.mudat.view.mantenimiento.RegistroCategoria;

import java.util.List;

public class Categorias extends AppCompatActivity {
    ListView lvListaCategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_categorias);

        CategoriaDbo categoriaDbo = new CategoriaDbo(this);
        List<Categoria> categorias = categoriaDbo.buscar();
        Log.i("Usuarios","Cantidad de usuario " + categorias.size());

        lvListaCategoria = findViewById(R.id.ListaCategoria);
        lvListaCategoria.setAdapter(new CategoriaListAdapter(categorias, this));

        lvListaCategoria.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent rCategoria = new Intent (Categorias.this, RegistroCategoria.class);
                Categoria u = (Categoria) adapterView.getItemAtPosition(i);
                rCategoria.putExtra("categoria", u);
                startActivity(rCategoria);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAgregarCategoria);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categorias.this, RegistroCategoria.class);
                startActivity(intent);
            }
        });
    }
}
