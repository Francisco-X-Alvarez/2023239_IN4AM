/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franciscoalvarez.model;

/**
 *
 * @author Francisco Franco
 */
public class Usuario {

    private int idusuario;
    private String nombrecompleto;
    private String username;
    private String email;
    private String password;

    public Usuario() {
    }

    public Usuario(int idusuario, String nombrecompleto, String username, String email, String password) {
        this.idusuario = idusuario;
        this.nombrecompleto = nombrecompleto;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Usuario(String nombrecompleto, String username, String email, String password) {
        this.nombrecompleto = nombrecompleto;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return nombrecompleto + " (" + username + ")";
    }
}
