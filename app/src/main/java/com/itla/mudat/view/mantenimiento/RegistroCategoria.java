package com.itla.mudat.view.mantenimiento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.itla.mudat.Entity.Categoria;
import com.itla.mudat.R;
import com.itla.mudat.dao.CategoriaDbo;
import com.itla.mudat.view.Categorias;
import com.itla.mudat.view.mudaT;

public class RegistroCategoria extends AppCompatActivity {
    Button bGuardar;
    CategoriaDbo categoriaDbo;
    Categoria categoria;
    EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_registro_categoria);

        bGuardar = findViewById(R.id.cGuardar);
        etNombre = findViewById(R.id.cNombre);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarCategoria();
            }
        });

        //Importar
        Bundle parametros = getIntent().getExtras();
        if (parametros != null && parametros.getSerializable("categoria") != null) {
            categoria = (Categoria) parametros.getSerializable("categoria");
            etNombre.setText(categoria.getNombre());
        }
    }
    public void registrarCategoria(){
        categoriaDbo = new CategoriaDbo(this);

        //registro
        if (categoria == null) {
            categoria = new Categoria();
        }
        categoria.setNombre(etNombre.getText().toString().trim());

        Log.i("Registro de categoria ", categoria.toString());
        categoriaDbo.crear(categoria);

        Toast.makeText(this, "Categoria " + etNombre.getText().toString() + " Guardada.", Toast.LENGTH_LONG).show();
        finish();
        Intent intent = new Intent(RegistroCategoria.this, Categorias.class);
        startActivity(intent);
    }
}
