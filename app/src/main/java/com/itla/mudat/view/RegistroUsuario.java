package com.itla.mudat.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itla.mudat.Entity.TipoUsuario;
import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.R;

public class RegistroUsuario extends AppCompatActivity {
    private EditText etNombre;
    private EditText etIdentifiacion;
    private EditText etEmail;
    private EditText etTelefono;
    private EditText etTipoUsuario;
    private EditText etClave;
    private Button bGuardar;
    private Button bDescatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etIdentifiacion = (EditText) findViewById(R.id.etIdentificacion);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etClave = (EditText) findViewById(R.id.etClave);
        etTipoUsuario = (EditText) findViewById(R.id.etTipoUsuario);
        bGuardar = (Button) findViewById(R.id.bGuardar);
        bDescatar = (Button) findViewById(R.id.bDescatar);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario u = new Usuario();
                u.setNombre(etNombre.getText().toString().trim());
                u.setIdentificacion(etIdentifiacion.getText().toString().trim());
                u.setTipoUsuario(TipoUsuario.CLIENTE);
                u.setEmail(etEmail.getText().toString().trim());
                u.setTelefono(etTelefono.getText().toString().trim());
                u.setClave(etClave.getText().toString().trim());
                u.setEstatus(true);

                Log.i("Registro usuario ", u.toString());

                //Toast.makeText(RegistroUsuario.this, u.toString(), Toast.LENGTH_SHORT).show();
            }
        });




    }
}
