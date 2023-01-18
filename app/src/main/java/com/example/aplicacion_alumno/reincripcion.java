package com.example.aplicacion_alumno;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplicacion_alumno.Interfaces.LinxcoInterface;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;
import java.util.List;

import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class reincripcion extends AppCompatActivity {

    private final String[] opcionesCarrera = new String[]{"Seleccionar", "ISIC", "TICS", "IQUI", "ADMON"};
    private final String[] opcionesTipoFac = new String[]{"Seleccionar", "tipo 1", "tipo2", "tipo3", "tipo4"};

     EditText txtNombre;
    EditText txtMatricula;
    EditText txtPeriodo;
    EditText txtPhone;
    EditText txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reincripcion);

        txtNombre=findViewById(R.id.txtnombreAlum);
        txtMatricula=findViewById(R.id.txtnumMatricula);
        txtPeriodo=findViewById(R.id.txtperiodo);
        txtPhone=findViewById(R.id.txtTel);
        txtEmail=findViewById(R.id.txtCorreo);

        Spinner spinner = (Spinner) this.findViewById(R.id.carrera);
        @SuppressLint("ResourceType") ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, 17367049, this.opcionesCarrera);
        Intrinsics.checkNotNullExpressionValue(spinner, "spinner");
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);

        Spinner spinnerr = (Spinner) this.findViewById(R.id.factura);
        @SuppressLint("ResourceType") ArrayAdapter arrayAdapterr = new ArrayAdapter((Context) this, 17367049, this.opcionesTipoFac);
        Intrinsics.checkNotNullExpressionValue(spinnerr, "spinner");
        spinnerr.setAdapter((SpinnerAdapter) arrayAdapterr);
        getCarga();
    }


    public void getCarga(){
        final String url="https://linxco-backend.herokuapp.com/api/v1/";
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LinxcoInterface service=retrofit.create(LinxcoInterface.class);
        Call<List<User>> res= service.getCargaData("201923158");

        res.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Toast.makeText(reincripcion.this,response.body().toString(),Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(reincripcion.this,"Error"+t,Toast.LENGTH_LONG).show();
                Log.e("Error:", String.valueOf(t));
            }
        });

    }
}