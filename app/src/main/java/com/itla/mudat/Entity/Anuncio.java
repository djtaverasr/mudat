package com.itla.mudat.Entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Diony Taveras on 18/11/2017.
 */

public class Anuncio implements Serializable {
    private int id;
    private Categoria categoria;
    private Usuario id_usuario;
    private Date fecha;
    private String condicion;
    private double precio;
    private String titulo;
    private String ubicacion;
    private String descripcion;

    @Override
    public String toString() {
        return "Anuncio{" +
                "id=" + id +
                ", categoria=" + categoria +
                ", usuario=" + id_usuario +
                ", fecha=" + fecha +
                ", condicion='" + condicion + '\'' +
                ", precio=" + precio +
                ", titulo='" + titulo + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return id_usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.id_usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
