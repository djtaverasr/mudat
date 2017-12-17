package com.itla.mudat.view;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.R;
import com.itla.mudat.dao.UsuarioDbo;
import com.itla.mudat.view.ListAdapter.UsuarioListAdapter;
import com.itla.mudat.view.mantenimiento.RegistroUsuario;

import java.util.List;

public class Usuarios extends AppCompatActivity {
    ListView lvListaUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_usuarios);

        UsuarioDbo usuarioDbo = new UsuarioDbo(this);
        List<Usuario> usuarios = usuarioDbo.buscar();
        Log.i("Usuarios","Cantidad de usuario " + usuarios.size());

        lvListaUsuario = (ListView) findViewById(R.id.ListaUsuarios);
        lvListaUsuario.setAdapter(new UsuarioListAdapter(usuarios, this));

        lvListaUsuario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent rUsuario = new Intent (Usuarios.this, RegistroUsuario.class);
                Usuario u = (Usuario) adapterView.getItemAtPosition(i);
                rUsuario.putExtra("usuario", u);
                startActivity(rUsuario);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAgregarUsuario);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Usuarios.this, RegistroUsuario.class);
                startActivity(intent);
            }
        });
    }
}
