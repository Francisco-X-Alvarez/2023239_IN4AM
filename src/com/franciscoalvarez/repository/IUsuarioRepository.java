/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franciscoalvarez.repository;

import com.franciscoalvarez.model.Usuario;
import java.util.List;

/**
 *
 * @author Francisco Franco
 */
public interface IUsuarioRepository {

    boolean registrarUsuario(Usuario usuario);

    List<Usuario> listarUsuarios();

    Usuario autenticarUsuario(String username, String password);
}
