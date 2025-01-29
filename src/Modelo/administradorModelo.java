/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Tiririn
 */
public class administradorModelo extends personaModelo{
   private int id;
    private Date horarioAtencion;

    public administradorModelo() {
    }

    public administradorModelo(int id, Date horarioAtencion) {
        this.id = id;
        this.horarioAtencion = horarioAtencion;
    }   

    public administradorModelo(int id, String cedula, String nombre, String apellido, int edad, String email, String contrasena, String cargo, Date horarioAtencion) {
    super(id, cedula, nombre, apellido, edad, email, contrasena);
    this.horarioAtencion = horarioAtencion;
}

    @Override
public String toString() {
    return "Administrador: { " +
           "ID: " + id +
           ", Horario de Atención: " + horarioAtencion +
           ", Detalles: " + super.toString() +
           " }";
}

}
