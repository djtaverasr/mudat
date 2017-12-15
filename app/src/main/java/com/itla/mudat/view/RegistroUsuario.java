package com.itla.mudat.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.itla.mudat.Entity.TipoUsuario;
import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.R;
import com.itla.mudat.dao.UsuarioDbo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroUsuario extends AppCompatActivity {
    UsuarioDbo usuarioDbo;
    final private String LOG_T = " registro usuario";
    private EditText etNombre;
    private EditText etIdentifiacion;
    private EditText etEmail;
    private EditText etTelefono;
    private EditText etTipoUsuario;
    private EditText etClave;
    private Button bGuardar, bCambiar;
    private TextView tvTipoUsuario;
    private RadioGroup rgTipoUsuario;
    private RadioButton rbCliente, rbPublicador;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_registro_usuario);

        //mapeo
        etNombre = (EditText) findViewById(R.id.etNombre);
        etIdentifiacion = (EditText) findViewById(R.id.etIdentificacion);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etClave = (EditText) findViewById(R.id.etClave);
        rbCliente = (RadioButton) findViewById(R.id.rbCliente);
        rbPublicador = (RadioButton) findViewById(R.id.rbPublicador);
        rgTipoUsuario = (RadioGroup) findViewById(R.id.rgTipoUsuario);
        tvTipoUsuario = (TextView) findViewById(R.id.tvTipoUsuario);
        bGuardar = (Button) findViewById(R.id.ruGuardar);
        bCambiar = (Button) findViewById(R.id.ruCambiar);

        //Listener Guardar
        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registroUsuario();
            }
        });

        //Listener Guardar
        bCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usuario!=null && usuario.getId()>0){
                    UsuarioActual.setUsuario(usuario);
                } else {
                    Toast.makeText(RegistroUsuario.this, "Usuario no permitido o no existe", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Importar
        Bundle parametros = getIntent().getExtras();
        if (parametros != null && parametros.getSerializable("usuario") != null) {
            Usuario usuario = (Usuario) parametros.getSerializable("usuario");
            etNombre.setText(usuario.getNombre());
            etIdentifiacion.setText(usuario.getIdentificacion());
            if (usuario.getTipoUsuario().equals(TipoUsuario.CLIENTE)){
                rbCliente.setChecked(true);
            } else if (usuario.getTipoUsuario().equals(TipoUsuario.PUBLICADOR)){
                rbPublicador.setChecked(true);
            }
            etEmail.setText(usuario.getEmail());
            etTelefono.setText(usuario.getTelefono());
            etClave.setText(usuario.getClave());
        }
    }

    private void registroUsuario() {
        usuarioDbo = new UsuarioDbo(this);
        boolean verEmail = isEmailValid(etEmail.getText().toString());

        //Control de radio button
        TipoUsuario tipoUsuario = null;
        if (rbCliente.isChecked()) {
            tipoUsuario = TipoUsuario.CLIENTE;
        } else if (rbPublicador.isChecked()) {
            tipoUsuario = TipoUsuario.PUBLICADOR;
        }

        //Control de registro
        if (etNombre.getText().toString().isEmpty()) {
            etNombre.setError("Campo requerido");
        } else if (etNombre.getText().toString().length() < 4) {
            etNombre.setError("Nombre muy corto");
        } else if (etIdentifiacion.getText().toString().isEmpty()) {
            etIdentifiacion.setError("Campo requerido");
        } else if (etIdentifiacion.getText().toString().length() != 11) {
            etIdentifiacion.setError("Identificación corta");
        } else if (etTelefono.getText().toString().isEmpty()) {
            etTelefono.setError("Campo requerido");
        } else if (etTelefono.getText().toString().length() != 10) {
            etTelefono.setError("Teléfono no válido");
        } else if (tipoUsuario == null) {
            Toast.makeText(this, "Marque un tipo de Usuario.", Toast.LENGTH_SHORT).show();
        } else if (etEmail.getText().toString().isEmpty()) {
            etEmail.setError("Campo requerido");
        } else if (!verEmail) {
            etEmail.setError("Email no válido");
        } else if (etClave.getText().toString().isEmpty()) {
            etClave.setError("Campo requerido");
        } else {

            //registro
            if (usuario == null) {
                usuario = new Usuario();
            }
            usuario.setNombre(etNombre.getText().toString().trim());
            usuario.setIdentificacion(etIdentifiacion.getText().toString().trim());
            usuario.setEmail(etEmail.getText().toString().trim());
            usuario.setTelefono(etTelefono.getText().toString().trim());
            usuario.setClave(etClave.getText().toString().trim());
            usuario.setEstatus(true);
            usuario.setTipoUsuario(tipoUsuario);

            Log.i(LOG_T, usuario.toString());
            usuarioDbo.crear(usuario);

            Toast.makeText(this, "Usuario " + etNombre.getText().toString() + " Creado.", Toast.LENGTH_LONG).show();
            limpiarCampos();
        }
    }

    public void limpiarCampos(){
        etNombre.setText("");
        etIdentifiacion.setText("");
        etEmail.setText("");
        etTelefono.setText("");
        etClave.setText("");
        rbCliente.setChecked(false);
        rbPublicador.setChecked(false);
    }
    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
}
