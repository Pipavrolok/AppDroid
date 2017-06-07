package com.example.teach.andalaardev.models;

import com.google.gson.annotations.SerializedName;


public class Perfil {

    @SerializedName("email_duoc")
    private String emailDuoc;
    @SerializedName("email_personal")
    private String emailPersonal;
    @SerializedName("codigo_sap")
    private String codigoSap;
    @SerializedName("rut")
    private String rut;
    @SerializedName("telefono")
    private String telefono;
    @SerializedName("sexo")
    private String sexo;
    @SerializedName("fecha_nacimiento")
    private String fechaNacimiento;
    @SerializedName("celular")
    private String celular;
    @SerializedName("nombre_completo")
    private String nombreCompleto;

    public Perfil(String emailDuoc, String emailPersonal, String codigoSap, String rut, String telefono, String sexo, String fechaNacimiento, String celular, String nombreCompleto) {
        this.emailDuoc = emailDuoc;
        this.emailPersonal = emailPersonal;
        this.codigoSap = codigoSap;
        this.rut = rut;
        this.telefono = telefono;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmailDuoc() {
        return emailDuoc;
    }

    public void setEmailDuoc(String emailDuoc) {
        this.emailDuoc = emailDuoc;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getCodigoSap() {
        return codigoSap;
    }

    public void setCodigoSap(String codigoSap) {
        this.codigoSap = codigoSap;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
