package com.example.aplicacion_alumno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void irMenu(View Object){
        Intent accion = new Intent(this,menu_inicio.class);
        startActivity(accion);
    }
    public void Layout2(View Object){
        Intent accion1 = new Intent(this,datos_aspirante.class);
        startActivity(accion1);
    }


}