package com.itla.mudat;

import android.app.usage.NetworkStats;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText  txtnombre = (EditText) findViewById(R.id.etLectura);
        Button boton = (Button) findViewById(R.id.bMensaje);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hola: " + txtnombre.getText().toString(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, visualizar.class);
                String parametro = txtnombre.getText().toString();
                intent.putExtra("parametro", parametro);
                startActivity(intent);


            }
        });

    }
}
