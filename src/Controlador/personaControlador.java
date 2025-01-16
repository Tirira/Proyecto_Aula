/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;

/**
 *
 * @author Tiririn
 */
public class personaControlador {
        private ConexionBDD conexion;
    private Connection conectado;

    public personaControlador() {
        conexion = new ConexionBDD();
        conectado = conexion.conectar();
    }
    
}
