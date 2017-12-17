package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.itla.mudat.Entity.Anuncio;
import com.itla.mudat.Entity.Categoria;
import com.itla.mudat.Entity.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diony Taveras on 08/12/2017.
 */

public class AnuncioDbo {
    private DbConnection connection;
    private static final SimpleDateFormat DF = new SimpleDateFormat("dd-MM-yyyy");

    public AnuncioDbo(Context context) {
        connection = new DbConnection(context);
    }

    public void crear(Anuncio anuncio){
        ContentValues cv = new ContentValues();
        cv.put("categoria", anuncio.getCategoria().getId());
        cv.put("usuario", anuncio.getUsuario().getId());
        cv.put("fecha", DF.format(anuncio.getFecha()));
        cv.put("condicion", anuncio.getCondicion());
        cv.put("precio", anuncio.getPrecio());
        cv.put("titulo", anuncio.getTitulo());
        cv.put("ubicacion", anuncio.getUbicacion());
        cv.put("descripcion", anuncio.getDescripcion());

        SQLiteDatabase db = connection.getWritableDatabase();

        if (anuncio.getId() == 0){
            Long id = db.insert("anuncio", null, cv);
            anuncio.setId(id.intValue());
        } else {
            db.update("anuncio", cv, "id = " + anuncio.getId(), null);
        }
        db.close();
        Log.i(" Registro anuncio", "creado  = " +anuncio.getId());
    }

    public List<Anuncio> buscar(){
        List<Anuncio> anuncios = new ArrayList<>();
        SQLiteDatabase db = connection.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT a.*, u.nombre AS u_nombre, c.nombre as c_nombre FROM anuncio a, usuario u, categoria c  WHERE a.usuario = u.id and a.categoria = c.id", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Anuncio anuncio = new Anuncio();
            Usuario usuario = new Usuario();
            Categoria categoria = new Categoria();

            usuario.setId(cursor.getInt(cursor.getColumnIndex("usuario")));
            usuario.setNombre(cursor.getString(cursor.getColumnIndex("u_nombre")));

            categoria.setId(cursor.getInt((cursor.getColumnIndex("categoria"))));
            categoria.setNombre(cursor.getString(cursor.getColumnIndex("c_nombre")));

            anuncio.setId(cursor.getInt(cursor.getColumnIndex("id")));
            anuncio.setCategoria(categoria);
            anuncio.setUsuario(usuario);
            try {
                anuncio.setFecha(DF.parse(cursor.getString(cursor.getColumnIndex("fecha"))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            anuncio.setCondicion(cursor.getString(cursor.getColumnIndex("condicion")));
            anuncio.setPrecio(cursor.getDouble(cursor.getColumnIndex("precio")));
            anuncio.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
            anuncio.setUbicacion(cursor.getString(cursor.getColumnIndex("ubicacion")));
            anuncio.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
            cursor.moveToNext();
            anuncios.add(anuncio);
        }
        cursor.close();
        db.close();
        return anuncios;
    }
}
