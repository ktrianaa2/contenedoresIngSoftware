package com.example.contenedoresingsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.contenedoresingsoftware.Adaptadores.AdaptadoresUsuarios;
import com.example.contenedoresingsoftware.Models.Usuarios;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class MainActivity3 extends AppCompatActivity implements Asynchtask {

    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        lstOpciones = (ListView) findViewById(R.id.listUsuario);

        View header = getLayoutInflater().inflate(R.layout.ly_itemusuario, null);
        lstOpciones.addHeaderView(header);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("https://reqres.in/api/users",
                datos, MainActivity3.this, MainActivity3.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject JSONlista = new JSONObject(result);
        JSONArray JSONlistaUsuarios = JSONlista.getJSONArray("data");
        ArrayList<Usuarios> lstUsuarios = Usuarios.JsonObjectsBuild(JSONlistaUsuarios);

        AdaptadoresUsuarios adaptadorUsuario = new AdaptadoresUsuarios(this, lstUsuarios);
        lstOpciones.setAdapter(adaptadorUsuario);
    }
}