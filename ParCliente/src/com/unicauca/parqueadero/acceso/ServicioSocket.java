package com.unicauca.parqueadero.acceso;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.unicauca.parqueadero.negocio.*;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa los servicios con la registraduria. Para ello utiliza
 * conexiones con sockets
 *
 * @author Libardo Pantoja, Daniel Paz
 */
public class ServicioSocket implements IServidor {

    private Socket socket = null;
    private Scanner entradaDecorada;
    private PrintStream salidaDecorada;
    private final String IP_SERVIDOR = "localhost";
    private final int PUERTO = 5100;

    /**
     * Obtiene el registro de un cliente en formato Json
     *
     * @param placa placa del vehiculo
     * @return json con el registro del cliente
     */
    @Override
    public Object consultarConductor(String id, int opc) {
        String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(id, opc);
            cerrarFlujos();
            desconectar();

        } catch (IOException ex) {
            Logger.getLogger(ServicioSocket.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (respuesta.equals("NO_ENCONTRADO")) {
            return null;
        } else {
            if(opc == 1){
                return deserializarConductor(respuesta);
            }else if(opc == 2){
                return deserializarConductorArrayVehiculos(respuesta);
            }else{
                return deserializarConductorArrayBahias(respuesta);
            }         
        }
    }

    /**
     * Deserializa una cadena json
     *
     * @param json vehiculo en formato json
     * @return un objeto vehiculo
     */
    private Object deserializarConductor(String json) {
        //Gson gson = new Gson();

        Object con;
        con = new Gson().fromJson(json, Conductor.class);
        return con;

    }
    
    private List<Vehiculo> deserializarConductorArrayVehiculos(String json){
        Type con = new TypeToken<List<Vehiculo>>(){}.getType();
        
        List<Vehiculo> h = new Gson().fromJson(json, con);
        return h;
    }
    
    private List<Bahia> deserializarConductorArrayBahias(String json){
        Type con = new TypeToken<List<Bahia>>(){}.getType();
        
        List<Bahia> h = new Gson().fromJson(json, con);
        return h;
    }
            

    /**
     * Intercambia datos con el servidor mediante flujos
     *
     * @param placa
     * @return
     * @throws IOException
     */
    private String leerFlujoEntradaSalida(String id, int opc) throws IOException {
        String respuesta = "";
        entradaDecorada = new Scanner(socket.getInputStream());
        salidaDecorada = new PrintStream(socket.getOutputStream());
        salidaDecorada.flush();
        // Usando el protocolo de comunicación
        switch(opc){
            case 1:
                salidaDecorada.println("consultarUsuario," + id);
                break;
            case 2:
                salidaDecorada.println("consultarVehiculos," + id);
                break;
            case 3:
                salidaDecorada.println("asignarBahia," + id);
                break;
            case 4:
                salidaDecorada.println("consultarBahiasLibres," + id);
                break;
            case 5:
                salidaDecorada.println("consultarBahiasOcupadas," + id);
                break;
        }
            
        
        if (entradaDecorada.hasNextLine()) {
            respuesta = entradaDecorada.nextLine();
        }
        System.out.println("Respuesta: " + respuesta);
        return respuesta;
    }

    /**
     * Cierra los flujos
     */
    private void cerrarFlujos() {
        salidaDecorada.close();
        entradaDecorada.close();
    }

    /**
     * Desconecta el socket con el servidor
     */
    private void desconectar() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServicioSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void conectar(String address, int port) throws IOException {
        socket = new Socket(address, port);
        System.out.println("Conectado al servidor central");
    }
}
