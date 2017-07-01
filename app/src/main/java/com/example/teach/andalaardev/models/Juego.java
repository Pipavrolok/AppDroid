package com.example.teach.andalaardev.models;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Juego implements Serializable {
    @SerializedName("idJuego")
    private String idJuego;

    @SerializedName("titulo")
    private String titulo;

    @SerializedName("descripcion")
    private String descripcion;

    @SerializedName("precio")
    private Integer precio;

    @SerializedName("reservado")
    private Boolean reservado;

    @SerializedName("idVendedor")
    private String idVendedor;

    @SerializedName("idComprador")
    private String idComprador;

    @SerializedName("imgJuego")
    private String imgJuego;

    @SerializedName("categoria")
    private String categoria;

    public Juego(String agregar, String s, String s1, String s2, int i, boolean b, String s3, String s4, String s5, String prueba){}

    public Juego(String idJuego, String titulo,String descripcion,Integer precio, Boolean reservado,
                 String idVendedor, String idComprador,String imgJuego,String categoria) {
        this.setIdJuego(idJuego);
        this.setTitulo(titulo);
        this.setDescripcion(descripcion);
        this.setPrecio(precio);
        this.setReservado(reservado);
        this.setIdVendedor(idVendedor);
        this.setIdComprador(idComprador);
        this.setImgJuego(imgJuego);
        this.setCategoria(categoria);
    }


    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {return precio;}

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Boolean getReservado() {
        return reservado;
    }

    public void setReservado(Boolean reservado) {
        this.reservado = reservado;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(String idComprador) {
        this.idComprador = idComprador;
    }

    public String getImgJuego() {
        return imgJuego;
    }

    public void setImgJuego(String imgJuego) {
        this.imgJuego = imgJuego;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String imgJuego) {
        this.categoria = categoria;
    }
}
