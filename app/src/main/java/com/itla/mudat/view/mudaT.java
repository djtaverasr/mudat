package com.itla.mudat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.R;

public class mudaT extends AppCompatActivity {
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_mudat);

        TextView tvUsuario = (TextView) findViewById(R.id.mUsuarioActual);
        Button bUsuarios = (Button) findViewById(R.id.bUsuarios);
        Button bAnuncios = (Button) findViewById(R.id.bAnuncios);
        Button bCategorias = (Button) findViewById(R.id.bCategorias);

        if (UsuarioActual.getUsuario() == null){
            finish();
            startActivity(new Intent(this, Usuarios.class));
            return;
        }

        tvUsuario.setText("Usuario: " + UsuarioActual.getUsuario().getNombre());

        bUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mudaT.this, Usuarios.class);
                startActivity(intent);
            }
        });

        bAnuncios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mudaT.this, Anuncios.class);
                startActivity(intent);
            }
        });

        bCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mudaT.this, Categorias.class);
                startActivity(intent);
            }
        });
    }
}
