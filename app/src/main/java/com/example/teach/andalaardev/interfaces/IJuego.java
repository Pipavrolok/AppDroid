package com.example.teach.andalaardev.interfaces;

import com.example.teach.andalaardev.lista.ResponseJuego;
import com.example.teach.andalaardev.models.Juego;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IJuego {

    @GET("Juegos.php")
     Call<ResponseJuego> getAllDataJuego();

    @POST("Agregar.php")
    Call<Juego> agregarJuego(@Body Juego juego);

}
