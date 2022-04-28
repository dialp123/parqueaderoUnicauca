/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.parqueadero.negocio;

/**
 *
 * @author w
 */
public class Vehiculo {
    private String placa;
    private TipoVehiculo tipo;
    //private Conductor propietario;
    private String modelo;
    private int nroBahiaAsignada; // 0 significa que no se le ha asignado ninguna bahia

    public Vehiculo(String placa, String modelo, TipoVehiculo tipo) {
        this.placa = placa;
        this.tipo = tipo;
        this.modelo = modelo;
        nroBahiaAsignada = 0;
        //this.propietario = propietario;
    }

    public Vehiculo() {
        this.placa = "";
        this.tipo = TipoVehiculo.autoMovil;
        //this.propietario = null;
    }
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }
/*
    public Conductor getPropietario() {
        return propietario;
    }

    public void setPropietario(Conductor propietario) {
        this.propietario = propietario;
    }
*/
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNroBahiaAsignada() {
        return nroBahiaAsignada;
    }

    public void setNroBahiaAsignada(int nroBahiaAsignada) {
        this.nroBahiaAsignada = nroBahiaAsignada;
    }
}
