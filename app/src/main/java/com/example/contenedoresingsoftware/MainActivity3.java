package com.example.contenedoresingsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.contenedoresingsoftware.Adaptadores.AdaptadoresUsuarios;
import com.example.contenedoresingsoftware.Models.Usuarios;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import WebServices.WebService;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ListView lstOpciones = (ListView) findViewById(R.id.listUsuario);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://reqres.in/api/users",
                datos,
                MainActivity.this, MainActivity.this);
        ws.execute("GET");

        JSONObject JSONlista = new JSONObject(result);
        JSONArray JSONlistaUsuarios= JSONlista.getJSONArray("data");
        Object lstUsuarios = Usuarios.JsonObjectsBuild(JSONlistaUsuarios);
        AdaptadoresUsuarios adapatorUsuario = new AdaptadoresUsuarios(this, lstUsuarios);
        lstOpciones.setAdapter(adapatorUsuario);
    }
}