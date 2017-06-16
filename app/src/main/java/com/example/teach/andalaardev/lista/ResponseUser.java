package com.example.teach.andalaardev.lista;

import com.example.teach.andalaardev.models.Usuario;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Teach on 15-06-17.
 */

public class ResponseUser {

    @SerializedName("user")
    private List<Usuario> usuario;

    public ResponseUser(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }
}
