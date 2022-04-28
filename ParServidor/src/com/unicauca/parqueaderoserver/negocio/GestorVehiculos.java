
package com.unicauca.parqueaderoserver.negocio;

import java.util.ArrayList;
import java.util.List;

/**
 * Logica de negocio de los vehiculos
 * Debe interactuar con la base de datos
 * @author libardo
 */
public class GestorVehiculos {

    private List<Vehiculo> listado;

    public GestorVehiculos() {
        listado = new ArrayList();
        inicializar();
    }
    /**
     * Este método es temporal, mientras se trabaja bases de datos
     */
    public void inicializar() {
       //listado.add(new Vehiculo("QET-680", "Carro", new Docente("98393281", "Libardo", "Pantoja", "FIET")));
       //listado.add(new Vehiculo("EMX-646", "Moto", new Estudiante("98393282", "Juan Alberto", "Perez Sanchez", "10461901100", "Ingenieria sistemas")));
       //listado.add(new Vehiculo("EMX-647", "Moto", new Estudiante("98393283", "Maria Ines", "Soto Cardenas", "10461901101", "Ingenieria cividl")));
       //listado.add(new Vehiculo("EMX-647", "Moto", new Administrativo("98393284", "Federico Alex", "Vidal Hurtado", "Cecav")));       
    }
    /**
     * Busca un vehiculo en el sistema
     * Es temporal, luego toca usar bases de datos relacionales
     * @param placa del vehiculo
     * @return un vehiculo
     */
    public Vehiculo buscarVehiculo(String placa) {
        for(Vehiculo veh: listado){
            if (veh.getPlaca().equals(placa)){
                return veh;
            }
        }
        return null;
    }

}
