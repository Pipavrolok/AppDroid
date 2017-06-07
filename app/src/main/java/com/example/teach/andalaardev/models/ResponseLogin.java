package com.example.teach.andalaardev.models;

import com.google.gson.annotations.SerializedName;


public class ResponseLogin {
    @SerializedName("data")
    private Perfil perfil;

    public ResponseLogin(Perfil perfil) {
        this.perfil = perfil;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
