package com.example.contenedoresingsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.contenedoresingsoftware.Adaptadores.AdaptadoresNoticias;
import com.example.contenedoresingsoftware.Models.Noticias;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Noticias[] noticias =
                new Noticias[]{
                        new Noticias("Noticia 1", "SubNoticia Contenido Contenido Contenido Contenido 1"),
                        new Noticias("Noticia 2", "SubNoticia Contenido Contenido Contenido Contenido 2"),
                        new Noticias("Noticia 3", "SubNoticia Contenido Contenido Contenido Contenido 3"),
                        new Noticias("Noticia 4", "SubNoticia Contenido Contenido Contenido Contenido 4")};

        AdaptadoresNoticias adaptadornoticias = new AdaptadoresNoticias(this, noticias);
        ListView lstOpciones = (ListView)findViewById(R.id.listNoticias);
        lstOpciones.setAdapter(adaptadornoticias);
    }
}