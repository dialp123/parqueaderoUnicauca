package com.unicauca.parqueadero.acceso;

import com.unicauca.parqueadero.negocio.Conductor;
import com.unicauca.parqueadero.negocio.Vehiculo;
import java.util.ArrayList;

/**
 * Interface que define los servicios con el servidor Libardo Pantoja, Daniel
 * Paz
 */
public interface IServidor {

    /**
     * Consulta un vehiculo mediante la placa
     *
     * @param placa placa del vehiculo
     * @return
     */
    public Object consultarConductor(String id, int opc);
}
