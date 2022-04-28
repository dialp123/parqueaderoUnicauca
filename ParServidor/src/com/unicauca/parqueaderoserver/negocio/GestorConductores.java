/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.parqueaderoserver.negocio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author libardo
 */
public final class GestorConductores {
   private final List<Vehiculo> vehiculos;
   
   private final List<Conductor> conductores;
   private final List<Bahia> bahias;

    public GestorConductores () {
        vehiculos = new ArrayList();
        bahias = new ArrayList();
        conductores = new ArrayList();
        inicializar();
    }
   
    public void inicializar() {
        Conductor conductor1 = new Conductor("Diego Alexander", "Pantoja Chavez", "14", tipoUsuario.Administrativo);
        Vehiculo vehiculo1 = new Vehiculo("hgd", "Honda", TipoVehiculo.moto);
        Vehiculo vehiculo2 = new Vehiculo("12sd", "Yamaha",TipoVehiculo.autoMovil);
        conductor1.addVehiculos(vehiculo1);
        conductor1.addVehiculos(vehiculo2);
        conductores.add(conductor1);
        
        Conductor conductor2 = new Conductor("andres", "chavez", "15", tipoUsuario.Docente);
        Vehiculo vehiculo3 = new Vehiculo("gt5", "Yamaha",TipoVehiculo.moto);
        Vehiculo vehiculo4 = new Vehiculo("2rfg", "Zusuki",TipoVehiculo.autoMovil);
        conductor2.addVehiculos(vehiculo3);
        conductor2.addVehiculos(vehiculo4);
        conductores.add(conductor2);
        
        for(int i = 1; i < 36; i++){
            Bahia bahia = new Bahia(i);
            bahias.add(bahia);
        }
        
        Bahia bahia = new Bahia(1);
        bahia.setEstado(true);
        bahia.setVehiculo(vehiculo4);
        bahias.set(0, bahia);
    }
    /**
     * Busca un vehiculo en el sistema
     * Es temporal, luego toca usar bases de datos relacionales
     * @param placa del vehiculo
     * @return un vehiculo
     */
    public Conductor buscarConductor(String id) {

        for(Conductor con: conductores){
            if (con.getId().equals(id)){
                return con;
            }
        }
        return null;
    }
    
    public Bahia asignarbahia(String id){
        for(Conductor con: conductores){
            if (con.getId().equals(id)){
                 for(int j = 0; j<bahias.size(); j++){
                     if((con.getTipo() == tipoUsuario.Administrativo) && (j>=1 && j<10 )){
                         bahias.get(j).setEstado(true);
                         return bahias.get(j);
                     }
                 }
            }
        }
        return null;
    }
    
    public List<Bahia> tomarBahiasOcupadas(){
        List<Bahia> lis = new ArrayList();
        for(int i = 0; i < bahias.size(); i++){
            if(bahias.get(i).getEstado() == true){
                lis.add(bahias.get(i));
            }
        }
        
        if(lis.size() == 0 || lis == null){
            return null;
        }else{
           return lis;
        }
    }
    
    public List<Bahia> tomarBahiasLibres(String id){
        List<Bahia> lis = new ArrayList();
        
        for(Conductor con: conductores){
            if (con.getId().equals(id)){
                 for(int j = 0; j < bahias.size(); j++){
                     if(con.getTipo() == tipoUsuario.Administrativo && (j>=0 && j<10 && bahias.get(j).getEstado() == false)){
                         
                         lis.add(bahias.get(j));
                     }
                 }
            }
        }
        if(lis.size() == 0 || lis == null){
            return null;
       }else{
           return lis;
       }
    }
            
    
    public List<Vehiculo> tomarVehiculos(String id){
        /*List<Vehiculo> lis = new ArrayList();
        
       for (Vehiculo veh : listado) {
           if (veh.getPropietario().getId().equals(id)) {
               lis.add(veh);
           }
       }
       if(lis.size() == 0){
           return null;
       }else{
           return lis;
       }*/
        return null;
    }
}