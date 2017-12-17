package com.itla.mudat.dao;

/**
 * Created by Diony Taveras on 25/11/2017.
 */

public class SqlHelperSchema {
    public static final String USUARIO_TABLE = "CREATE TABLE usuario (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, nombre TEXT, tipousuario TEXT, identificacion NUMERIC, email TEXT, telefono NUMERIC, clave TEXT)";
    public static final String ANUNCIO_TABLE = "CREATE TABLE anuncio (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, categoria INTEGER, usuario INTEGER, fecha TEXT, condicion TEXT, precio REAL, titulo TEXT, ubicacion TEXT, descripcion TEXT, FOREIGN KEY(usuario) REFERENCES usuario(id), FOREIGN KEY(categoria) REFERENCES categoria(id) )";
    public static final String CATEGORIA_TABLE = "CREATE TABLE categoria (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, nombre TEXT)";
    public static final String FOTO_TABLE = "CREATE TABLE fotos (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, id_anuncio INTEGER, imagen TEXT, estatus TEXT)";

}
