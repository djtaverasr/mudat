package com.itla.mudat.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.itla.mudat.Entity.Anuncio;
import com.itla.mudat.Entity.Categoria;
import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.R;
import com.itla.mudat.dao.AnuncioDbo;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RegistrarAnuncio extends AppCompatActivity {
    AnuncioDbo anuncioDbo;
    Anuncio anuncio;
    EditText etCategoria;
    EditText etUsuario;
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
        etUsuario = findViewById(R.id.etUsuario);
        etFecha = findViewById(R.id.etFecha);
        etCondicion = findViewById(R.id.etCondicion);
        etPrecio = findViewById(R.id.etPrecio);
        etTitulo = findViewById(R.id.etTitulo);
        etUbicacion = findViewById(R.id.etUbicacion);
        etDescripcion = findViewById(R.id.etDescripcion);
        bGuardar = findViewById(R.id.raGuardar);

        Bundle parametros = getIntent().getExtras();

        if (parametros!= null && parametros.getSerializable("anuncio") != null){
            Anuncio anuncio = (Anuncio) parametros.getSerializable("anuncio");
            etCategoria.setText(anuncio.getCategoria().toString());
            etUsuario.setText(anuncio.getUsuario().toString());
            etFecha.setText(DF.format(anuncio.getFecha()));
            etCondicion.setText(anuncio.getCondicion());
            etPrecio.setText(String.valueOf(anuncio.getPrecio()));
            etTitulo.setText(anuncio.getTitulo());
            etUbicacion.setText(anuncio.getUbicacion());
            etDescripcion.setText(anuncio.getDescripcion());
        }

        anuncioDbo = new AnuncioDbo(this);
        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Categoria categoria = null;
                categoria = Categoria.APARTAMENTO;
                if (anuncio == null){
                    anuncio = new Anuncio();
                }

                anuncio.setCategoria(categoria);

                //TODO REVISAR
                anuncio.setUsuario(etUsuario.getText().toString());
                try {
                    anuncio.setFecha(DF.parse(etFecha.getText().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                anuncio.setCondicion(etCondicion.getText().toString().trim());
                anuncio.setPrecio(Double.parseDouble(etPrecio.getText().toString()));
                anuncio.setTitulo(etTitulo.getText().toString().trim());
                anuncio.setUbicacion(etUbicacion.getText().toString().trim());
                anuncio.setDescripcion(etDescripcion.getText().toString().trim());

                Log.i(" Registro anuncio", anuncio.toString());
                anuncioDbo.crear(anuncio);
            }
        });
    }
}
