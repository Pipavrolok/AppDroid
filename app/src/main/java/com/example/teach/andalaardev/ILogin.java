package com.example.teach.andalaardev;

import com.example.teach.andalaardev.models.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ILogin {

    @GET("loginAlumno")
    Call<ResponseLogin> login(@Query("usuario") String user,
                              @Query("password") String pass);

}
