package com.example.teach.andalaardev.interfaces;

import com.example.teach.andalaardev.lista.ResponseJuego;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IJuego {

    @GET("Juegos.php")
     Call<ResponseJuego> getAllDataJuego();
}
