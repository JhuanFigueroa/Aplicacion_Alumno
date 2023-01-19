package com.example.aplicacion_alumno;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicacion_alumno.Interfaces.LinxcoInterface;
import com.google.gson.JsonArray;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class reincripcion extends AppCompatActivity {

    private final String[] opcionesCarrera = new String[]{"Seleccionar", "ISIC", "TICS", "IQUI", "ADMON"};
    private final String[] opcionesTipoFac = new String[]{"Seleccionar", "tipo 1", "tipo2", "tipo3", "tipo4"};
    ArrayList<String> materias = new ArrayList<>();
    EditText txtNombre;
    EditText txtMatricula;
    EditText txtPeriodo;
    EditText txtPhone;
    EditText txtEmail;
    EditText txtCarrera;
    RadioGroup contMaterias;
    Button btnAddMaterias,btnGuardarCarga;

    RadioButton inscripcion,reinscripcion,cursoVerano;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reincripcion);

        txtNombre = findViewById(R.id.txtnombreAlum);
        txtMatricula = findViewById(R.id.txtnumMatricula);
        txtPeriodo = findViewById(R.id.txtperiodo);
        txtPhone = findViewById(R.id.txtTel);
        txtEmail = findViewById(R.id.txtCorreo);
        txtCarrera = findViewById(R.id.txtCarrera);

        btnAddMaterias = findViewById(R.id.btnAddMaterias);
        btnGuardarCarga=findViewById(R.id.btGuardar);

        contMaterias = findViewById(R.id.groupmateria);

        inscripcion=findViewById(R.id.rbInscripcion);
        reinscripcion=findViewById(R.id.rbReinscripcion);
        cursoVerano=findViewById(R.id.rbCursoVerano);

        Spinner spinnerr = (Spinner) this.findViewById(R.id.factura);
        @SuppressLint("ResourceType") ArrayAdapter arrayAdapterr = new ArrayAdapter((Context) this, 17367049, this.opcionesTipoFac);
        Intrinsics.checkNotNullExpressionValue(spinnerr, "spinner");
        spinnerr.setAdapter((SpinnerAdapter) arrayAdapterr);
        getCarga();
        getMaterias();

        btnAddMaterias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (String materia : materias
                ) {
                    Log.e("Materias seleccionadas:", materia);
                }
            }
        });
        btnGuardarCarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCargaAcademica();
            }
        });
    }


    public void getCarga() {
        final String url = "https://linxco-backend.herokuapp.com/api/v1/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LinxcoInterface service = retrofit.create(LinxcoInterface.class);
        Call<User> res = service.getCargaData("201923158");

        res.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                txtNombre.setText(user.getNombre());
                txtCarrera.setText(user.getCarrera());
                txtPhone.setText(user.getTelefono());
                txtEmail.setText(user.getCorreo());
                txtPeriodo.setText("2022-1");
                txtMatricula.setText("201923158");

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(reincripcion.this, "Error" + t, Toast.LENGTH_LONG).show();
                Log.e("Error:", String.valueOf(t));
            }
        });

    }

    public void getMaterias() {
        final String url = "https://linxco-backend.herokuapp.com/api/v1/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LinxcoInterface service = retrofit.create(LinxcoInterface.class);
        Call<List<Materia>> res = service.getMAterias();
        res.enqueue(new Callback<List<Materia>>() {
            @Override
            public void onResponse(Call<List<Materia>> call, Response<List<Materia>> response) {
                for (Materia materia : response.body()
                ) {
                    CheckBox checkBox = new CheckBox(getApplicationContext());
                    checkBox.setText(materia.getClave() + "-" + materia.getNombre());

                    contMaterias.addView(checkBox);
                    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                            String claveMateria = compoundButton.getText().toString().substring(0, 8);
                            materias.add(claveMateria);
                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<List<Materia>> call, Throwable t) {
                Log.e("Error:", String.valueOf(t));
            }
        });
    }

    public void addCargaAcademica() {
        final int[] idCarga = {0};

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();

        String fecha = dateFormat.format(date);

        String tipoCarga="";

        if (inscripcion.isChecked()){
            tipoCarga="INS-1";
        }
        if (reinscripcion.isChecked()){
            tipoCarga="RES-2";
        }
        if (cursoVerano.isChecked()){
            tipoCarga="CUR-3";
        }

        CargaAcademica carga = new CargaAcademica();
        carga.setFecha(fecha);
        carga.setMatriculaAlumno("201823203");
        carga.setIdPeriodo(2);
        carga.setTipoCarga(tipoCarga);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://linxco-backend.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LinxcoInterface service = retrofit.create(LinxcoInterface.class);
        Call<Integer> res=service.addCarga(carga,"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGF2ZSI6IjIwMTkyMzE1OCIsIm5vbWJyZSI6Ikp1YW4gRmlndWVyb2EgVHJlam8iLCJyb2wiOjQsImlhdCI6MTY3NDA4MzIzOH0.hpZfnY22TXFUHnkLX-9-53zgraIK-Ws-VGlAW4vzAuE");

        res.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                 idCarga[0] =response.body();
                Log.e("Id:",String.valueOf(idCarga[0]));
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Toast.makeText(reincripcion.this, "Error" + t, Toast.LENGTH_LONG).show();
                Log.e("Error:", String.valueOf(t));
            }


        });

        //Materia Carga



    }

}