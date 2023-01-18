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
    EditText txtCarrera;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reincripcion);

        txtNombre=findViewById(R.id.txtnombreAlum);
        txtMatricula=findViewById(R.id.txtnumMatricula);
        txtPeriodo=findViewById(R.id.txtperiodo);
        txtPhone=findViewById(R.id.txtTel);
        txtEmail=findViewById(R.id.txtCorreo);
        txtCarrera=findViewById(R.id.txtCarrera);


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
        Call<User> res= service.getCargaData("201923158");

        res.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
              User user=response.body();
              txtNombre.setText(user.getNombre());
              txtCarrera.setText(user.getCarrera());
              txtPhone.setText(user.getTelefono());
              txtEmail.setText(user.getCorreo());
              txtPeriodo.setText("2022-1");
              txtMatricula.setText("201923158");

            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(reincripcion.this,"Error"+t,Toast.LENGTH_LONG).show();
                Log.e("Error:", String.valueOf(t));
            }
        });

    }
}