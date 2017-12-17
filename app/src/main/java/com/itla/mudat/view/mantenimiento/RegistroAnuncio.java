package com.itla.mudat.view.mantenimiento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.itla.mudat.Entity.Anuncio;
import com.itla.mudat.Entity.Categoria;
import com.itla.mudat.R;
import com.itla.mudat.dao.AnuncioDbo;
import com.itla.mudat.view.Anuncios;
import com.itla.mudat.view.UsuarioActual;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RegistroAnuncio extends AppCompatActivity {
    AnuncioDbo anuncioDbo;
    Anuncio anuncio;
    EditText etCategoria;
    EditText etFecha;
    EditText etCondicion;
    EditText etPrecio;
    EditText etTitulo;
    EditText etUbicacion;
    EditText etDescripcion;
    Button bGuardar;
    private static final SimpleDateFormat DF = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_registrar_anuncio);

        etCategoria = findViewById(R.id.etCategoria);
        etFecha = findViewById(R.id.etFecha);
        etCondicion = findViewById(R.id.etCondicion);
        etPrecio = findViewById(R.id.etPrecio);
        etTitulo = findViewById(R.id.etTitulo);
        etUbicacion = findViewById(R.id.etUbicacion);
        etDescripcion = findViewById(R.id.etDescripcion);
        bGuardar = findViewById(R.id.raGuardar);

        anuncioDbo = new AnuncioDbo(this);
        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarAnuncio();
            }
        });

        //Importar
        Bundle parametros = getIntent().getExtras();
        if (parametros != null && parametros.getSerializable("anuncio") != null) {
            anuncio = (Anuncio) parametros.getSerializable("anuncio");

            etTitulo.setText(anuncio.getTitulo());
            etDescripcion.setText(anuncio.getDescripcion());
            etCategoria.setText("1");
            etFecha.setText(DF.format(anuncio.getFecha()));
            etCondicion.setText(anuncio.getCondicion());
            etPrecio.setText(String.valueOf(anuncio.getPrecio()));
            etUbicacion.setText(anuncio.getUbicacion());
        }
    }

    public void registrarAnuncio() {
        Categoria c=new Categoria();
        c.setId(1);

        if (anuncio == null){
            anuncio = new Anuncio();
        }

        anuncio.setCategoria(c);
        anuncio.setUsuario(UsuarioActual.getUsuario());
        try {
            //todo picker
            anuncio.setFecha(DF.parse(etFecha.getText().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //todo
        anuncio.setCondicion(etCondicion.getText().toString().trim());
        anuncio.setPrecio(Double.parseDouble(etPrecio.getText().toString()));
        anuncio.setTitulo(etTitulo.getText().toString().trim());
        anuncio.setUbicacion(etUbicacion.getText().toString().trim());
        anuncio.setDescripcion(etDescripcion.getText().toString().trim());

        Log.i(" Registro anuncio", anuncio.toString());
        anuncioDbo.crear(anuncio);

        Toast.makeText(this, "Anuncio guardado.", Toast.LENGTH_SHORT).show();
        finish();
        Intent intent = new Intent(RegistroAnuncio.this, Anuncios.class);
        startActivity(intent);
    }
}

