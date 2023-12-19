package com.example.contenedoresingsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    private TextView txtSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] datos =
                new String[]{"Mika",
                        "Luis",
                        "Rafael",
                        "Josselyn",
                        "Jose",
                        "Jean"};

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos);

        Spinner cbOpciones = (Spinner) findViewById(R.id.cbOpciones);
        adaptador.setDropDownViewResource(

                android.R.layout.simple_spinner_dropdown_item
        );
        cbOpciones.setAdapter(adaptador);

        txtSelected = findViewById(R.id.txtItemSeleccionado);
        cbOpciones.setOnItemSelectedListener(this);


        ArrayAdapter<String> adaptador2 =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        datos);
        ListView lstOpciones =
                (ListView)findViewById(R.id.lstLista);
        lstOpciones.setAdapter(adaptador2);

        lstOpciones.setOnItemClickListener(this);


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        txtSelected.setText("Item Seleccionado: " + parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        txtSelected.setText("");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this.getApplicationContext(),
                parent.getItemAtPosition(position).toString(),
                Toast.LENGTH_SHORT).show();
        /* Snackbar.make(this.getApplicationContext(), view,
                parent.getItemAtPosition(position).toString(),
                Snackbar.LENGTH_LONG).show(); */
    }
}