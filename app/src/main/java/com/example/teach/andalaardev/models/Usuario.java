package com.example.teach.andalaardev.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Teach on 15-06-17.
 */

public class Usuario implements Serializable {

    @SerializedName("rut")
    private String rut;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("telefono")
    private String telefono;

    @SerializedName("email")
    private String email;

    public Usuario(){}

    public Usuario(String rut, String nombre, String telefono, String email) {
        this.setRut(rut);
        this.setNombre(nombre);
        this.setTelefono(telefono);
        this.setEmail(email);
    }


    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
