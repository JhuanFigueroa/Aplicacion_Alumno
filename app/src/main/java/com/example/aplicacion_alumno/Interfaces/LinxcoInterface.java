package com.example.aplicacion_alumno.Interfaces;
import com.example.aplicacion_alumno.User;
import com.google.gson.JsonArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import  retrofit2.http.Query;

public interface LinxcoInterface {
  //Traer datos del usuario
    @GET("alumnos/datosCarga/{matricula}")
    Call<List<User>> getCargaData(@Path("matricula") String matricula);
}
