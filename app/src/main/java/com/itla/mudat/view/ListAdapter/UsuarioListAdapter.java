package com.itla.mudat.view.ListAdapter;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.Entity.TipoUsuario;
import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.R;

import java.util.List;

/**
 * Created by Diony Taveras on 02/12/2017.
 */

public class UsuarioListAdapter extends BaseAdapter {
    private List<Usuario> usuarios;
    private Activity context;

    public UsuarioListAdapter(List<Usuario> usuarios, Activity context) {
        this.usuarios = usuarios;
        this.context = context;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int i) {
        return usuarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.list_usuario_row, null, true);
        }

        TextView tvNombre = view.findViewById(R.id.lvNombre);
        TextView tvEmail = view.findViewById(R.id.lvEmail);

        Usuario u = usuarios.get(i);
        tvNombre.setText(u.getNombre());
        //tvEmail.setText(u.getEmail());
        //TODO
        tvEmail.setText(String.valueOf(u.getTipoUsuario()));

        return view;
    }
}
