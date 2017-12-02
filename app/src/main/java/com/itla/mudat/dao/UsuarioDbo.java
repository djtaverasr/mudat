package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.Entity.TipoUsuario;
import com.itla.mudat.Entity.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diony Taveras on 25/11/2017.
 */

public class UsuarioDbo {
    private DbConnection connection;

    public UsuarioDbo(Context context) {
        connection = new DbConnection(context);
    }

    public void crear(Usuario usuario){
        SQLiteDatabase db = connection.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nombre", usuario.getNombre());
        cv.put("tipoUsuario", usuario.getTipoUsuario().toString());
        cv.put("identificacion", usuario.getIdentificacion());
        cv.put("email", usuario.getEmail());
        cv.put("telefono", usuario.getTelefono());
        cv.put("clave", usuario.getClave());
        //cv.put("estatus", usuario.isEstatus());

        db.insert("usuario", null, cv);
        db.close();
    }

    public List<Usuario> buscar(){
        List<Usuario> usuarios = new ArrayList<>();
        SQLiteDatabase db = connection.getReadableDatabase();
        String columnas[] = new String[] {"id", "nombre","identificacion","email","telefono","clave"};
        Cursor cursor = db.query("usuario", columnas, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Usuario u = new Usuario();
            u.setId(cursor.getInt(cursor.getColumnIndex("id")));
            u.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
//            u.setTipoUsuario(TipoUsuario.valueOf(cursor.getString(cursor.getColumnIndex("tipoUsuario"))));
            u.setIdentificacion(cursor.getString(cursor.getColumnIndex("identificacion")));
            u.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            u.setTelefono(cursor.getString(cursor.getColumnIndex("telefono")));
            u.setClave(cursor.getString(cursor.getColumnIndex("clave")));
            //u.setEstatus(cursor.getString(cursor.getColumnIndex("estatus")));
            cursor.moveToNext();
            usuarios.add(u);
        }
        cursor.close();
        db.close();
        return usuarios;
    }
}