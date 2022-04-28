
package com.unicauca.parqueadero.negocio;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una abstracccion de una persona que usará los servicios del
 * parqueadero
 *
 * @author Libardo
 */
public class Conductor {
    protected String nombres;
    protected String apellidos;
    protected String id;
    protected int multas;
    protected tipoUsuario tipo;
    protected List<Vehiculo> vehiculos;
    
    //public abstract String mostrarDatos();     

    public Conductor(String nombres, String apellidos, String id, tipoUsuario tipo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.id = id;
        vehiculos = new ArrayList<>();
        multas = 0;
        this.tipo = tipo;
    }

    public Conductor(){
        this.nombres = "";
        this.apellidos = "";
        this.id = "";
        vehiculos = null;
    }
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    public void addVehiculos(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMultas() {
        return multas;
    }

    public void setMultas(int multas) {
        this.multas = multas;
    }

    public tipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(tipoUsuario tipo) {
        this.tipo = tipo;
    }
}