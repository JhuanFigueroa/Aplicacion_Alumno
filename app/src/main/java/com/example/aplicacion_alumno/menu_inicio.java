package com.example.aplicacion_alumno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class menu_inicio extends AppCompatActivity implements View.OnClickListener{
    private CardView cardHorarios, cardConstancias, cardReins;
    ViewFlipper carrusel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicio);
        cardHorarios = findViewById(R.id.cardHorarios);
        cardConstancias = findViewById(R.id.cardConstancias);
        cardReins = findViewById(R.id.cardReins);

        cardHorarios.setOnClickListener(this);
        cardConstancias.setOnClickListener(this);
        cardReins.setOnClickListener(this);

        int images[] = {R.drawable.anuncio1, R.drawable.anuncio2, R.drawable.anuncio3, R.drawable.anuncio4};

        carrusel = findViewById(R.id.carrusel);

        for (int image: images){
            flipperImages(image);
        }
    }
    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        carrusel.addView(imageView);
        carrusel.setFlipInterval(4000);
        carrusel.setAutoStart(true);

        carrusel.setInAnimation(this, android.R.anim.slide_in_left);
        carrusel.setOutAnimation(this, android.R.anim.slide_out_right);
    }
    /*public void irConstancias(View Object){
        Intent accion = new Intent(this,constancias.class);
        startActivity(accion);
    }*/

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.cardConstancias: i = new Intent(this, constancias.class ); startActivity(i); break;
            case R.id.cardHorarios: i = new Intent(this, horarios.class); startActivity(i); break;
            case R.id.cardReins: i = new Intent(this, reincripcion.class); startActivity(i); break;
        }
    }
}