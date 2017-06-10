package com.example.teach.andalaardev.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class ListaJuego implements Serializable{
    @SerializedName("lectura")
    private List<Juego> listJuego;

    public ListaJuego(List<Juego> listJuego) {
        this.listJuego = listJuego;
    }

    public ListaJuego() {
    }

    public List<Juego> getListJuego() {
        return listJuego;
    }

    public void setListJuego(List<Juego> listJuego) {
        this.listJuego = listJuego;
    }
}