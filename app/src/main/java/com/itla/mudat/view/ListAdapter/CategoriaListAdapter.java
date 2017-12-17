package com.itla.mudat.view.ListAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.itla.mudat.Entity.Categoria;
import com.itla.mudat.R;
import java.util.List;

/**
 * Created by Diony Taveras on 02/12/2017.
 */

public class CategoriaListAdapter extends BaseAdapter {
    private List<Categoria> categorias;
    private Activity context;

    public CategoriaListAdapter(List<Categoria> categorias, Activity context) {
        this.categorias = categorias;
        this.context = context;
    }

    @Override
    public int getCount() {
        return categorias.size();
    }

    @Override
    public Object getItem(int i) {
        return categorias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.list_categoria_row, null, true);
        }

        TextView tvNombre = view.findViewById(R.id.cNombre);
        TextView tvId = view.findViewById(R.id.cId);

        Categoria c = categorias.get(i);
        tvNombre.setText(c.getNombre());
        tvId.setText(String.valueOf(c.getId()));

        return view;
    }
}
