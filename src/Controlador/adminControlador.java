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
    String sql = "SELECT * FROM persona WHERE email = ? AND contraseña = ?";
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
    public String buscarPorCedula(String cedula) {
        String sql = "SELECT * FROM persona WHERE cedula = ?";
        String resultado = "";

        try (PreparedStatement stmt = conectado.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                resultado = "Cédula: " + rs.getString("cedula") + "\n"
                          + "Nombre: " + rs.getString("nombre") + "\n"
                          + "Apellido: " + rs.getString("apellido") + "\n"
                          + "Edad: " + rs.getInt("edad") + "\n"
                          + "Email: " + rs.getString("email")+ "\n"
                          + "Contraseña: " + rs.getString("contraseña");
            } else {
                resultado = "No se encontró ningún registro con la cédula: " + cedula;
            }
        } catch (SQLException e) {
            resultado = "Error al buscar: " + e.getMessage();
        }
        return resultado;
    }
  public boolean guardarDatos(String cedula, String nombre, String apellido, int edad, String email, String contraseña) {
        String sql = "UPDATE persona SET nombre = ?, apellido = ?, edad = ?, email = ?, contraseña = ? WHERE cedula = ?";
        try (PreparedStatement stmt = conectado.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setInt(3, edad);
            stmt.setString(4, email);
            stmt.setString(5, contraseña);
            stmt.setString(6, cedula);
            
            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar los datos: " + e.getMessage());
            return false;
        }
    }
public boolean eliminarPorCedula(String cedula) {
        String sql = "DELETE FROM persona WHERE cedula = ?";
        try (PreparedStatement stmt = conectado.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            int filasEliminadas = stmt.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar el registro: " + e.getMessage());
            return false;
        }
    }
public boolean agregarLector(String cedula, String nombre, String apellido, int edad, String email, String contraseña) {
    String sql = "INSERT INTO persona (cedula, nombre, apellido, edad, email, contraseña) VALUES (?, ?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = conectado.prepareStatement(sql)) {
        stmt.setString(1, cedula);
        stmt.setString(2, nombre);
        stmt.setString(3, apellido);
        stmt.setInt(4, edad);
        stmt.setString(5, email);
        stmt.setString(6, contraseña);
        
        int filasInsertadas = stmt.executeUpdate();
        return filasInsertadas > 0;
    } catch (SQLException e) {
        System.err.println("Error al agregar el elector: " + e.getMessage());
        return false;
    }
}


}

