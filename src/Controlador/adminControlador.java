/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author Tiririn
 */
public class adminControlador {
    private ConexionBDD conexion;
    private Connection conectado;

    public adminControlador() {
        conexion = new ConexionBDD();
        conectado = conexion.conectar();
    }

    public boolean verificarCredenciales(String email, String contraseña) {
    String sql = "SELECT * FROM persona WHERE emaill = ? AND contraseña = ?";
    try (PreparedStatement stmt = conectado.prepareStatement(sql)) {
        stmt.setString(1, email);
        stmt.setString(2, contraseña);
        ResultSet rs = stmt.executeQuery();
        
        return rs.next(); 
    } catch (SQLException e) {
        System.err.println("Error al verificar credenciales: " + e.getMessage());
        return false;
    }
    
}

}

