package com.itla.mudat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class visualizar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_visualizar);

        Bundle b = getIntent().getExtras();
        String nom = b.getString("parametro");

        TextView textView = (TextView) findViewById(R.id.parame);

        textView.setText(nom);
     }
}
