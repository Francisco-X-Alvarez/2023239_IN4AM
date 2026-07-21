/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franciscoalvarez.repository;

import com.franciscoalvarez.db.Conexion;
import com.franciscoalvarez.model.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Francisco Franco
 */
public class UsuarioRepository implements IUsuarioRepository {


    @Override
    public boolean registrarUsuario(Usuario usuario) {
        String sql = "{call sp_registrarusuario(?, ?, ?, ?)}";
        
        try (Connection cn = Conexion.getInstancia().getConexion();
             CallableStatement cs = cn.prepareCall(sql)) {

            cs.setString(1, usuario.getNombrecompleto());
            cs.setString(2, usuario.getUsername());
            cs.setString(3, usuario.getEmail());
            cs.setString(4, usuario.getPassword());

            return cs.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("error al registrar usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "{call sp_listarusuarios()}";

        try (Connection cn = Conexion.getInstancia().getConexion();
             CallableStatement cs = cn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdusuario(rs.getInt("idusuario"));
                usuario.setNombrecompleto(rs.getString("nombrecompleto"));
                usuario.setUsername(rs.getString("username"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("password"));
                
                lista.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("error al listar usuarios: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }


    @Override
    public Usuario autenticarUsuario(String username, String password) {
        Usuario usuario = null;
        String sql = "{call sp_autenticarusuario(?, ?)}";

        try (Connection cn = Conexion.getInstancia().getConexion();
             CallableStatement cs = cn.prepareCall(sql)) {

            cs.setString(1, username);
            cs.setString(2, password);

            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIdusuario(rs.getInt("idusuario"));
                    usuario.setNombrecompleto(rs.getString("nombrecompleto"));
                    usuario.setUsername(rs.getString("username"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setPassword(rs.getString("password"));
                }
            }

        } catch (SQLException e) {
            System.out.println("error al autenticar usuario: " + e.getMessage());
            e.printStackTrace();
        }

        return usuario;
    }
}
