package com.example.teach.andalaardev;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.teach.andalaardev.lista.JuegoAdapter;
import com.example.teach.andalaardev.models.Juego;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private RecyclerView.Adapter adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        ArrayList<Juego> datosJuego = new ArrayList<Juego>();

        //Falta Incorporar DataBase
        datosJuego.add(new Juego("0","Resident Evil 7 PS4 Nuevo","Juego impecable se encuentra practicamente nuevo,uso adulto. Fue jugado y guardado en caja",25000, false,
                "0", "1"));
        datosJuego.add(new Juego("0","Mortal Kombat XL PS4 Nuevo","Juego impecable se encuentra practicamente nuevo,uso adulto. Fue jugado y guardado en caja",20000, false,
                "0", "1"));
        datosJuego.add(new Juego("0","Soul Reaver PS4","Juego impecable se encuentra practicamente nuevo,uso adulto. Fue jugado y guardado en caja",25000, false,
                "0", "1"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);


        reciclador = (RecyclerView) findViewById(R.id.recycler);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new JuegoAdapter(datosJuego);
        reciclador.setAdapter(adaptador);

    }

}
