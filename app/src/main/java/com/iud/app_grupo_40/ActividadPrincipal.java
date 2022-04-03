package com.iud.app_grupo_40;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.orm.StringUtil;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;


public class ActividadPrincipal extends AppCompatActivity {

    Button registrar, ingresar;
    EditText user, clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        // Botonrd
        registrar = findViewById(R.id.btnRegistrar);
        ingresar = findViewById(R.id.btnLogin);

        // Capturar datos
        user = findViewById(R.id.txtLoginName);
        clave = findViewById(R.id.txtLoginPass);

        // Metodo para el boton ingresar
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(ActividadPrincipal.this, IngresarUsuario.class);
                //intent.putExtra("dato", user.getText().toString());
                //startActivity(intent);

                // Obtener datos de las cajas de texto.
                String usuario = user.getText().toString();
                String pass = clave.getText().toString();

                // Obtener datos de las cajas de texto.

                if (!usuario.isEmpty() && !pass.isEmpty()) {
                    try {
                        // Crear lista para almacenar los registros consultados.
                        List<Usuarios> registros = Usuarios.listAll(Usuarios.class);

                        for (Usuarios element : registros) {
                            if (element.getNombre().equals(usuario) && element.getPassword().equals(pass)) {
                                // Acceder a la otra pantalla.
                                Intent intent = new Intent(ActividadPrincipal.this, IngresarUsuario.class);
                                startActivity(intent);
                                // Limpiar pantalla.
                                user.setText("");
                                clave.setText("");
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Datos no validos", Toast.LENGTH_SHORT).show();
                                // Limpiar pantalla.
                                user.setText("");
                                clave.setText("");
                            }
                        }
                        // Obtener el primer indice de la lista de registro.
                        // Usuarios registro = registros.get(0);
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Error inesperado", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Ingrese los datos correctos", Toast.LENGTH_SHORT).show();
                }

            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActividadPrincipal.this, RegistroUsuario.class);
                startActivity(intent);
            }
        });
    }
}