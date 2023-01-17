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

        new Peticion().execute();
    }

    public static class Peticion extends AsyncTask<Void,Void,Void>{
        final String url="https://linxco-backend.herokuapp.com/api/v1/";
        @Override
        protected Void doInBackground(Void... voids) {

            Retrofit retrofit= new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            LinxcoInterface service=retrofit.create(LinxcoInterface.class);
            Call<List<User>> res= service.getCargaData("201923158");

            try {
                for (User user:res.execute().body()
                     ) {
                    Log.e("Respuesta:",user.getNombre() );
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;

        }
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