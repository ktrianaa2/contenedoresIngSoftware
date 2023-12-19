package com.example.contenedoresingsoftware.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.contenedoresingsoftware.R;
import com.example.contenedoresingsoftware.Models.Noticias;

public class AdaptadoresNoticias extends ArrayAdapter<Noticias> {
    public AdaptadoresNoticias(Context context, Noticias[] datos) {
        super(context, R.layout.itemnoticias, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.itemnoticias, null);
        TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
        lblTitulo.setText(getItem(position).getTitulo());
        TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
        lblSubtitulo.setText(getItem(position).getSubtitulo());
        return(item);
    }
}
