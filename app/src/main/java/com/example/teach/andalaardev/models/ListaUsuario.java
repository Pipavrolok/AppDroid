package com.example.teach.andalaardev.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Teach on 15-06-17.
 */

public class ListaUsuario implements Serializable {
    @SerializedName("user")
    private List<Usuario> listUser;

    public ListaUsuario(List<Usuario> listUser) {
        this.listUser = listUser;
    }

    public ListaUsuario() {
    }

    public List<Usuario> getListaUsuario() {
        return listUser;
    }

    public void setListaUsuario(List<Usuario> listUser) {
        this.listUser = listUser;
    }
}
