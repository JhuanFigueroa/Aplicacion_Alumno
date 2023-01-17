package com.example.aplicacion_alumno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class bienvenida_aspirantes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_aspirantes);
    }
    public void Layout3(View Object){
        Intent accion1 = new Intent(this,datos_aspirante.class);
        startActivity(accion1);
    }
}