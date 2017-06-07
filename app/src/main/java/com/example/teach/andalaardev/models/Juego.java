package com.example.teach.andalaardev.models;



public class Juego {
    private String idJuego;
    private String titulo;
    private String descripcion;
    private Integer precio;
    private Boolean reservado;
    private String idVendedor;
    private String idComprador;

    public Juego(){}

    public Juego(String idJuego, String titulo,String descripcion,Integer precio, Boolean reservado,
                 String idVendedor, String idComprador) {
        this.setIdJuego(idJuego);
        this.setTitulo(titulo);
        this.setDescripcion(descripcion);
        this.setPrecio(precio);
        this.setReservado(reservado);
        this.setIdVendedor(idVendedor);
        this.setIdComprador(idComprador);
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
}
