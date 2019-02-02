package com.example.marta.exoplayer;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PreMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_main);
        getSupportActionBar().hide();
    }

    public void ver (View view) {

        TextInputEditText enlace = (TextInputEditText) findViewById(R.id.enlace);

        String texto = enlace.getText().toString();

        if(enlace.getText().toString().equals(texto)){
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("parametro", texto);
            startActivity(intent);
        }




    }



}
