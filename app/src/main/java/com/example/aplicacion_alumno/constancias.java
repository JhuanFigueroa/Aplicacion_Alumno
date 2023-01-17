package com.example.aplicacion_alumno;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

import kotlin.jvm.internal.Intrinsics;

public class constancias extends AppCompatActivity{

    private final String[] opciones = new String[]{"Seleccionar", "Estudios", "Conducta", "Semestre", "Materias Cursando", "Egresado Simple"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constancias);

        Spinner spinner = (Spinner)this.findViewById(R.id.tipoConstancia);
        @SuppressLint("ResourceType") ArrayAdapter arrayAdapter = new ArrayAdapter((Context)this, 17367049, this.opciones);
        Intrinsics.checkNotNullExpressionValue(spinner, "spinner");
        spinner.setAdapter((SpinnerAdapter)arrayAdapter);
    }
}