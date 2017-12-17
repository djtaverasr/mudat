package com.itla.mudat.Entity;

import java.io.Serializable;

/**
 * Created by Diony Taveras on 16/12/2017.
 */

public class Categoria implements Serializable{
    private int id;
    private String nombre;

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
