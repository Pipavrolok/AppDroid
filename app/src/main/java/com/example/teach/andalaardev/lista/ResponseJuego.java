package com.example.teach.andalaardev.lista;

import com.example.teach.andalaardev.models.Juego;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResponseJuego {
    @SerializedName("lectura")
    private List<Juego> juego;

    public ResponseJuego(List<Juego> juego) {
        this.juego = juego;
    }

    public List<Juego> getJuego() {
        return juego;
    }

    public void setJuego(List<Juego> juego) {
        this.juego = juego;
    }
}
