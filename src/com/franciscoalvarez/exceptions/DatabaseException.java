/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franciscoalvarez.exceptions;

/**
 *
 * @author Francisco Franco
 */
public class DatabaseException extends Exception {

    // guarda el mensaje personalizado
    private String mensaje;

    // constructor que recibe el texto del error
    public DatabaseException(String mensaje) {
        this.mensaje = mensaje;
    }

    // metodo para obtener el mensaje cuando necesitemos mostrarlo
    @Override
    public String getMessage() {
        return mensaje;
    }
}
