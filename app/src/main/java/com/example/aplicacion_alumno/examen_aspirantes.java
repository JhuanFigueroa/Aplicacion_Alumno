package com.example.aplicacion_alumno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class examen_aspirantes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen_aspirantes);
    }
    public void Layout5(View Object){
        Intent accion1 = new Intent(this,no_examen.class);
        startActivity(accion1);
    }
}