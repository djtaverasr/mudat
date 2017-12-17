package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.mudat.Entity.Categoria;
import com.itla.mudat.Entity.TipoUsuario;
import com.itla.mudat.Entity.Usuario;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diony Taveras on 08/12/2017.
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
            categoria.setId(id.intValue());
        } else {
            db.update("categoria", cv, "id = " + categoria.getId(), null);
        }
        db.close();
        Log.i(" Registro categoria", "creado  = " +categoria.getId());
    }

    public List<Categoria> buscar(){
        List<Categoria> categorias = new ArrayList<>();
        SQLiteDatabase db = connection.getReadableDatabase();
        String columnas[] = new String[]{"id", "nombre"};
        Cursor cursor = db.query("categoria", columnas, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Categoria categoria = new Categoria();
            categoria.setId(cursor.getInt(cursor.getColumnIndex("id")));
            categoria.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            cursor.moveToNext();
            categorias.add(categoria);
        }
        cursor.close();
        db.close();
        return categorias;
    }
}
