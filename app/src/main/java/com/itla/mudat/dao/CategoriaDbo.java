package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diony Taveras on 25/11/2017.
 */

public class CategoriaDbo {
    private DbConnection connection;

    public CategoriaDbo(Context context) {
        connection = new DbConnection(context);
    }

    public void crear(Categoria categoria){
        ContentValues cv = new ContentValues();
        cv.put("nombre", categoria.getNombre());

        SQLiteDatabase db = connection.getWritableDatabase();

        if (categoria.getId() == 0){
            Long id = db.insert("categoria", null, cv);
        } else {
            db.update("categoria", cv, "id = " +categoria.getId(), null);
        }
        db.close();
    }

    public List<Categoria> buscar(){
        List<Categoria> categorias = new ArrayList<>();
        SQLiteDatabase db = connection.getReadableDatabase();
        String columnas[] = new String[] {"id", "nombre"};
        Cursor cursor = db.query("categoria", columnas, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Categoria u = new Categoria();
            u.setId(cursor.getInt(cursor.getColumnIndex("id")));
            u.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            cursor.moveToNext();
            categorias.add(u);
        }
        cursor.close();
        db.close();
        return categorias;
    }
}