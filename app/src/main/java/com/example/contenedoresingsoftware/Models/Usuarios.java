package com.example.contenedoresingsoftware.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Usuarios {
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUrlavatar() {
        return urlavatar;
    }

    public void setUrlavatar(String urlavatar) {
        this.urlavatar = urlavatar;
    }

    private String nombres;
    private String email;
    private String website;
    private String urlavatar;
    public Usuarios(JSONObject a) throws JSONException {
        nombres = a.getString("first_name").toString() + " " + a.getString("last_name").toString();
        email = a.getString("email").toString() ;
        website = a.getString("avatar").toString() ;
        urlavatar = a.getString("avatar").toString() ;
    }
    public static ArrayList<Usuarios> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            usuarios.add(new Usuarios(datos.getJSONObject(i)));
        }
        return usuarios;
    }

}

