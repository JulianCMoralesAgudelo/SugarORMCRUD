package com.iud.app_grupo_40;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class IngresarUsuario extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView usuario;
    Button regresar;
    Spinner spinner;
    ListView lst;
    String[] idiomas = {"Ingles", "Frances", "Italiano", "Aleman", "Portugues", "Español"};
    String[] lenguajes = {"C", "JAVA", "JS", "NODE.JS", "PYTHON"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar);

        usuario = findViewById(R.id.txtNameIngresar);
        String dato = getIntent().getStringExtra("dato");
        usuario.setText(dato);
        spinner = findViewById(R.id.spnIdiomas);
        lst = findViewById(R.id.lista);


        // Llenar el spiner
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, idiomas);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        // Llenar la lista
        ArrayAdapter listadapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lenguajes);
        lst.setAdapter(listadapter);

        regresar = findViewById(R.id.btnRegresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        // Capturar dato de la lista
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemList = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(IngresarUsuario.this, "Usted pulso: " + itemList, Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String item = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(this, "Usted selecciono: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}




