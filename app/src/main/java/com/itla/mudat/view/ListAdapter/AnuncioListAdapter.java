package com.itla.mudat.view.ListAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.itla.mudat.Entity.Anuncio;
import com.itla.mudat.R;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Diony Taveras on 02/12/2017.
 */

public class AnuncioListAdapter extends BaseAdapter {
    private List<Anuncio> anuncios;
    private Activity context;
    private static final SimpleDateFormat DF = new SimpleDateFormat("dd-MM-yyyy");

    public AnuncioListAdapter(List<Anuncio> anuncios, Activity context) {
        this.anuncios = anuncios;
        this.context = context;
    }

    @Override
    public int getCount() {
        return anuncios.size();
    }

    @Override
    public Object getItem(int i) {
        return anuncios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.list_anuncio_row, null, true);
        }

        TextView tvId = view.findViewById(R.id.aId);
        TextView tvTitulo = view.findViewById(R.id.aTitulo);
        TextView tvDescripcion = view.findViewById(R.id.aDescripcion);
        TextView tvCategoria = view.findViewById(R.id.aCategoria);
        TextView tvCondicion = view.findViewById(R.id.aCondicion);
        TextView tvFecha = view.findViewById(R.id.aFecha);
        TextView tvPrecio = view.findViewById(R.id.aPrecio);
        TextView tvUsuario = view.findViewById(R.id.aUsuario);
        TextView tvUbicacion = view.findViewById(R.id.aUbicacion);

        Anuncio anuncio = anuncios.get(i);
        tvId.setText(String.valueOf(anuncio.getId()));
        tvTitulo.setText(anuncio.getTitulo());
        tvDescripcion.setText("Descripción: " + anuncio.getDescripcion());
        tvCategoria.setText("Categoria.: " + anuncio.getCategoria().getNombre());
        tvCondicion.setText("Condición: " + anuncio.getCondicion());
        tvFecha.setText(DF.format(anuncio.getFecha()));
        tvPrecio.setText("$ " + String.valueOf(anuncio.getPrecio()));
        tvUsuario.setText("Usuario: " + anuncio.getUsuario().getNombre());
        tvUbicacion.setText("Lugar: " + anuncio.getUbicacion());

        return view;
    }
}
