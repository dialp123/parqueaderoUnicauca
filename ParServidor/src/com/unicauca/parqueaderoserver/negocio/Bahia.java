/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.parqueaderoserver.negocio;

/**
 *
 * @author w
 */
public class Bahia {
    private boolean estado; //true ocupado, false libre
    private int numero;
    private Vehiculo vehiculo;

    public Bahia(int numero) {
        
        this.numero = numero;
        estado = false;
        vehiculo = null;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getEstado() {
        return estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    } 
    
    public void asignarVehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
        estado = true;
    }
}
