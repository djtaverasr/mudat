package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.itla.mudat.Entity.Anuncio;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diony Taveras on 08/12/2017.
 */

public class AnuncioDbo {
    private DbConnection connection;

    public AnuncioDbo(Context context) {
        connection = new DbConnection(context);
    }

    public void crear(Anuncio anuncio){
        ContentValues cv = new ContentValues();
        cv.put("categoria", anuncio.getCategoria().toString());
        cv.put("usuario", anuncio.getUsuario().toString());
        cv.put("fecha", anuncio.getFecha().toString());
        cv.put("condicion", anuncio.getCondicion());
        cv.put("precio", anuncio.getPrecio());
        cv.put("titulo", anuncio.getTitulo());
        cv.put("ubicacion", anuncio.getUbicacion());
        cv.put("descripcion", anuncio.getDescripcion());

        SQLiteDatabase db = connection.getWritableDatabase();

        if (anuncio.getId() == 0){
            Long id = db.insert("anuncio", null, cv);
        } else {
            db.update("anuncio", cv, "id = " + anuncio.getId(), null);
        }
        db.close();
    }

    public List<Anuncio> buscar(){
        List<Anuncio> anuncios = new ArrayList<>();
        SQLiteDatabase db = connection.getReadableDatabase();
        String columnas[] = new String[] {"id", "categoria", "usuario", "fecha", "condicion", "precio", "titulo", "ubicacion", "descripcion"};
        Cursor cursor = db.query("anuncio", columnas, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Anuncio u = new Anuncio();
            u.setId(cursor.getInt(cursor.getColumnIndex("id")));
            //u.setCategoria(cursor.getString(cursor.getColumnIndex("categoria")));
            //u.setUsuario(cursor.getString(cursor.getColumnIndex("usuario")));
            //u.setFecha(cursor.get(cursor.getColumnIndex("fecha")));
            u.setCondicion(cursor.getString(cursor.getColumnIndex("condicion")));
            u.setPrecio(cursor.getDouble(cursor.getColumnIndex("precio")));
            u.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
            u.setUbicacion(cursor.getString(cursor.getColumnIndex("ubicacion")));
            u.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
            cursor.moveToNext();
            anuncios.add(u);
        }
        cursor.close();
        db.close();
        return anuncios;
    }
}
