package com.itla.mudat.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.itla.mudat.Entity.TipoUsuario;
import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.R;
import com.itla.mudat.dao.UsuarioDbo;

public class RegistroUsuario extends AppCompatActivity {
    UsuarioDbo usuarioDbo;
    final private String LOG_T = "Registro usuario";
    private EditText etNombre;
    private EditText etIdentifiacion;
    private EditText etEmail;
    private EditText etTelefono;
    private EditText etTipoUsuario;
    private EditText etClave;
    private Button bGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_registro_usuario);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etIdentifiacion = (EditText) findViewById(R.id.etIdentificacion);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etClave = (EditText) findViewById(R.id.etClave);
        etTipoUsuario = (EditText) findViewById(R.id.etTipoUsuario);
        bGuardar = (Button) findViewById(R.id.bGuardar);

        Bundle parametros = getIntent().getExtras();

        if (parametros.getSerializable("usuario") != null){
            Usuario usuario = (Usuario) parametros.getSerializable("usuario");
        }

        usuarioDbo = new UsuarioDbo(this);
        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Usuario usuario = new Usuario();
                usuario.setNombre(etNombre.getText().toString().trim());
                usuario.setIdentificacion(etIdentifiacion.getText().toString().trim());
                usuario.setTipoUsuario(TipoUsuario.CLIENTE);
                usuario.setEmail(etEmail.getText().toString().trim());
                usuario.setTelefono(etTelefono.getText().toString().trim());
                usuario.setClave(etClave.getText().toString().trim());
                usuario.setEstatus(true);

                Log.i(LOG_T, usuario.toString());
                usuarioDbo.crear(usuario);
            }
        });
    }
}
