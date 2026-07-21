/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franciscoalvarez.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Francisco Franco
 */
public class Conexion {

    private Connection conexion;
    private static Conexion instancia;

    // configuracion local
    private final String url = "jdbc:mysql://localhost:3306/proyecto_taller_in4am?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private final String user = "root";
    private final String password = "@adm007";

    private Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("conexion exitosa a proyecto_taller_in4am");
        } catch (ClassNotFoundException e) {
            System.out.println("error: no se encontro el driver de mysql.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("error: no se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
    }

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        } else {
            try {
                if (instancia.getConexion().isClosed()) {
                    instancia = new Conexion();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
}
