package com.iud.app_grupo_40;

import com.orm.SugarRecord;

public class Usuarios extends SugarRecord<Usuarios> {

    // Atributos
    String documento;
    String nombre;
    String password;

    // Constructores
    public Usuarios() {

    }

    public Usuarios(String cc, String name, String email) {
        this.documento = cc;
        this.nombre = name;
        this.password = email;
    }

    // Metodos
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

