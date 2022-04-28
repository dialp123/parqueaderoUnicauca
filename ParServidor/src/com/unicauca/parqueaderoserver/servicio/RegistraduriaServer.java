package com.unicauca.parqueaderoserver.servicio;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.unicauca.parqueaderoserver.negocio.*;
import com.unicauca.parqueaderoserver.negocio.GestorVehiculos;

/**
 * Clase que abre el servicio del servidor en un puerto Luego cada solicitud que
 * le llega del cliente la procesa en un hilo
 *
 * @author libardo
 */
public class RegistraduriaServer implements Runnable {

    private final GestorConductores gestor;

    private static ServerSocket ssock;
    private static Socket socket;

    private Scanner entradaDecorada;
    private PrintStream salidaDecorada;
    private static final int PUERTO = 5100;

    /**
     * Constructor
     */
    public RegistraduriaServer() {
        gestor = new GestorConductores();
    }

    /**
     * Inicia el servidor y lo pone a trabajar en un bucle
     */
    public void iniciar() {
        abrirPuerto();

        while (true) {
            esperarAlCliente();
            lanzarHilo();
        }
    }

    /**
     * Lanza un hilo para atender una peticion
     */
    private static void lanzarHilo() {
        new Thread(new RegistraduriaServer()).start();
    }

    /**
     * Abre un sockete en un puerto específico
     */
    private static void abrirPuerto() {
        try {
            ssock = new ServerSocket(PUERTO);
            System.out.println("Servidor escuchando por el puerto " + PUERTO);
        } catch (IOException ex) {
            Logger.getLogger(RegistraduriaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Espera que el cliente se conecta y le devuelve un socket
     */
    private static void esperarAlCliente() {
        try {
            socket = ssock.accept();
            System.out.println("Cliente conectado");
        } catch (IOException ex) {
            Logger.getLogger(RegistraduriaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cuerpo del hilo. Abre y cierra el flujo para intercambiar datos entre el
     * servidor y el cliente
     */
    @Override
    public void run() {
        try {
            crearFlujos();
            leerFlujos();
            cerrarFlujos();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Crea los flujos con el socket
     *
     * @throws IOException
     */
    private void crearFlujos() throws IOException {
        salidaDecorada = new PrintStream(socket.getOutputStream());
        entradaDecorada = new Scanner(socket.getInputStream());
    }

    /**
     * Lee los flujos del socket
     */
    private void leerFlujos() {
        if (entradaDecorada.hasNextLine()) {
            // Extrae el flujo que envía el cliente
            String peticion = entradaDecorada.nextLine();
            decodificarPeticion(peticion);

        } else {
            salidaDecorada.flush();
            salidaDecorada.println("NO_ENCONTRADO");
        }
    }

    /**
     * Decodifica la petición, extrayeno la acción y los parámetros
     *
     * @param peticion petición completa al estilo
     * "consultarCiudadano,983932814"
     */
    private void decodificarPeticion(String peticion) {
        StringTokenizer tokens = new StringTokenizer(peticion, ",");
        String parametros[] = new String[10];

        int i = 0;
        while (tokens.hasMoreTokens()) {
            parametros[i++] = tokens.nextToken();
        }
        String accion = parametros[0];
        procesarAccion(accion, parametros);

    }

    /**
     * Segun el protocolo decide qué accion o servicio invocar
     *
     * @param accion acción a procesar
     * @param parametros parámetros de la acción
     */
    private void procesarAccion(String accion, String parametros[]) {
        String id = parametros[1];
        Object conductor;
        switch (accion) {
            
            case "consultarUsuario":
                
                 conductor = gestor.buscarConductor(id);
                if (id == null) {
                    salidaDecorada.println("NO_ENCONTRADO");
                } else {
                    salidaDecorada.println(parseToJSON(conductor));
                }
                break;
            case "consultarVehiculos":
                 conductor = gestor.tomarVehiculos(id);
                if (id == null) {
                    salidaDecorada.println("NO_ENCONTRADO");
                } else {
                    salidaDecorada.println(parseToJSON(conductor));
                }
                break;
            case "asignarBahia":
                conductor = gestor.asignarbahia(id);
                if (id == null) {
                    salidaDecorada.println("NO_ENCONTRADO");
                } else {
                    salidaDecorada.println(parseToJSON(conductor));
                }
                break;
            case "consultarBahiasLibres":
                conductor = gestor.tomarBahiasLibres(id);
                if (id == null) {
                    salidaDecorada.println("NO_ENCONTRADO");
                } else {
                    salidaDecorada.println(parseToJSON(conductor));
                }
                break;
            case "consultarBahiasOcupadas":
                conductor = gestor.tomarBahiasOcupadas();
                if (id == null) {
                    salidaDecorada.println("NO_ENCONTRADO");
                } else {
                    salidaDecorada.println(parseToJSON(conductor));
                }
                break;
        }
    }

    /**
     * Cierra los flujos de entrada y salida
     *
     * @throws IOException
     */
    private void cerrarFlujos() throws IOException {
        salidaDecorada.close();
        entradaDecorada.close();
        socket.close();
    }

    /**
     * Convierte el objeto Vehiculo a json
     *
     * @param vehiculo Objeto vehiculo
     * @return cadena json
     */
    private String parseToJSON(Object conductor) {
        //JsonObject jsonobj = new JsonObject();
        //jsonobj.addProperty("placa", vehiculo.getPlaca());
        //jsonobj.addProperty("tipo", vehiculo.getTipo());
        //jsonobj.addProperty("propietario", vehiculo.getPropietario());
        //return jsonobj.toString();

        String json = new Gson().toJson(conductor);
        System.out.println("Json serializado: " + json);
        return json;

    }
}
