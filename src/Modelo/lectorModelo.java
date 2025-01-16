/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Tiririn
 */
public class lectorModelo extends personaModelo{
    private int id;
    private  int historiasCreadas;

    public lectorModelo() {
    
    }
    public lectorModelo(int id, String cedula, String nombre, String apellido, int edad, String email, String contrasena, int historiasCreadas) {
    super(id, cedula, nombre, apellido, edad, email, contrasena);
    this.historiasCreadas = historiasCreadas;
}

    public lectorModelo(int id, int historiasCreadas) {
        this.id = id;
        this.historiasCreadas = historiasCreadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHistoriasCreadas() {
        return historiasCreadas;
    }

    public void setHistoriasCreadas(int historiasCreadas) {
        this.historiasCreadas = historiasCreadas;
    }

   
    @Override
    public String toString() {
    return "lectorModelo{" + super.toString() + ", historiasCreadas=" + historiasCreadas + '}';
}

    
}
