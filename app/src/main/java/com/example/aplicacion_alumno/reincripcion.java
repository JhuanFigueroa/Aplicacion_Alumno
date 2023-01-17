package com.example.aplicacion_alumno;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import kotlin.jvm.internal.Intrinsics;

public class reincripcion extends AppCompatActivity {

    private final String[] opcionesCarrera = new String[]{"Seleccionar", "ISIC", "TICS", "IQUI", "ADMON"};
    private final String[] opcionesTipoFac = new String[]{"Seleccionar", "tipo 1", "tipo2", "tipo3", "tipo4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reincripcion);

        Spinner spinner = (Spinner) this.findViewById(R.id.carrera);
        @SuppressLint("ResourceType") ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, 17367049, this.opcionesCarrera);
        Intrinsics.checkNotNullExpressionValue(spinner, "spinner");
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);

        Spinner spinnerr = (Spinner) this.findViewById(R.id.factura);
        @SuppressLint("ResourceType") ArrayAdapter arrayAdapterr = new ArrayAdapter((Context) this, 17367049, this.opcionesTipoFac);
        Intrinsics.checkNotNullExpressionValue(spinnerr, "spinner");
        spinnerr.setAdapter((SpinnerAdapter) arrayAdapterr);
    }
}