package com.example.teach.andalaardev.interfaces;

import com.example.teach.andalaardev.lista.ResponseUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Teach on 15-06-17.
 */

public interface IUser {

    @GET("User.php")
    Call<ResponseUser> getUser(@Query("idUsuario") String user);
}
