/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.parqueadero.negocio;

import com.unicauca.parqueadero.acceso.IServidor;
import com.unicauca.parqueadero.acceso.ServicioSocket;
import java.util.List;

public class GestorConductores {
    public Object consultarConductor(String id, int opc){
        
        IServidor servidor = new ServicioSocket();
        Object cond = servidor.consultarConductor(id, opc);
        return cond;
    }
    
}
