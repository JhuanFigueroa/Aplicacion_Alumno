package com.example.aplicacion_alumno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.aplicacion_alumno.Interfaces.LinxcoInterface;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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