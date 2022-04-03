package com.iud.app_grupo_40;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class RegistroUsuario extends AppCompatActivity {

    EditText userID, userName, password;
    Button btnRegresar, limpiarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        userID = findViewById(R.id.txtDocRegist);
        userName = findViewById(R.id.txtUserName);
        password = findViewById(R.id.txtPassword);

        btnRegresar = findViewById(R.id.btnRegisBack);
        limpiarPantalla = findViewById(R.id.btnClean);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void Registrar(View view) {

        // Obtener datos de las cajas de texto
        String doc = userID.getText().toString();
        String user = userName.getText().toString();
        String pass = password.getText().toString();

        if (!doc.isEmpty() && !user.isEmpty() && !pass.isEmpty()) {
            try {
                // Crear intancia de la clase para almacenar datos
                Usuarios users = new Usuarios(doc, user, pass);
                users.save();

                // Limpiar  pantalla.
                userID.setText("");
                userName.setText("");
                password.setText("");

                // Imprimir datos en pantalla.
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(this, "Error inesperado", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Llene todos los campos a registrar", Toast.LENGTH_SHORT).show();
        }

    }


    public void Consultar(View view) {

        // Obtener datos de las cajas de texto.
        String doc = userID.getText().toString();

        if (!doc.isEmpty()) {
            try {
                // Crear lista para almacenar los registros consultados.
                List<Usuarios> registros = Usuarios.find(Usuarios.class, "documento=" + doc);

                // Obtener el primer indice de la lista de registro.
                Usuarios registro = registros.get(0);

                // Imprimir datos en pantalla.
                userID.setText(registro.documento);
                userName.setText(registro.nombre);
                password.setText(registro.password);

            } catch (Exception e) {
                Toast.makeText(this, "Usuario no existe", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Ingresar documento valido a consultar", Toast.LENGTH_SHORT).show();
        }
    }

    public void Actualizar(View view) {

        // Obtener datos de las cajas de texto.
        String doc = userID.getText().toString();
        String user = userName.getText().toString();
        String pass = password.getText().toString();

        if (!doc.isEmpty()) {
            try {
                // Crear lista para almacenar los registros consultados.
                List<Usuarios> registros = Usuarios.find(Usuarios.class, "documento=" + doc);

                // Obtener el primer indice de la lista de registro.
                Usuarios registro = registros.get(0);

                // Actualizar informacion.
                registro.nombre = user;
                registro.password = pass;
                registro.save();

                // Mensaje de respuesta.
                Toast.makeText(this, "Usuario actualizado con exito", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(this, "Usuario no existe", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Ingresar documento valido a actualizar", Toast.LENGTH_SHORT).show();
        }

    }

    public void Eliminar(View view) {

        // Obtener datos de las cajas de texto.
        String doc = userID.getText().toString();

        if (!doc.isEmpty()) {
            try {
                // Crear lista para almacenar los registros consultados.
                List<Usuarios> registros = Usuarios.find(Usuarios.class, "documento=" + doc);

                // Obtener el primer indice de la lista de registro.
                Usuarios registro = registros.get(0);

                // Enviar id para eliminar
                Usuarios.deleteAll(Usuarios.class, "documento=" + doc);

                // Mensaje de respuesta.
                Toast.makeText(this, "Usuario eliminado con exito", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(this, "Usuario no existe", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Ingresar documento valido a actualizar", Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpiar(View view) {
        userID.setText("");
        userName.setText("");
        password.setText("");
    }
}