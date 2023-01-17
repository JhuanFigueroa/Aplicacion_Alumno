package com.example.aplicacion_alumno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class datos_aspirante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_aspirante);
    }
    public void Layout4(View Object){
        Intent accion1 = new Intent(this,examen_aspirantes.class);
        startActivity(accion1);
    }
}