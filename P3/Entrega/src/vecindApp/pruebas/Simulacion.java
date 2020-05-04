package vecindApp.pruebas;

import es.uam.eps.sadp.grants.CCGG;
import es.uam.eps.sadp.grants.InvalidIDException;
import es.uam.eps.sadp.grants.InvalidRequestException;
import vecindApp.clases.aplicacion.*;
import vecindApp.clases.colectivo.*;
import vecindApp.clases.excepciones.CCGGException;
import vecindApp.clases.excepciones.ConexionFallida;
import vecindApp.clases.notificacion.*;
import vecindApp.clases.proyecto.*;
import vecindApp.clases.usuario.*;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Implementa un simulador basico del uso del sistema
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class Simulacion {
    public static void main(String[] args) throws Exception {
        /*Inicializacion de la aplicacion*/
        Administrador admin = Aplicacion.VecindApp.getAdmin();
        Aplicacion.setMinApoyos(2);   //Lo decide el usuario administrador

        /*Registro de ciudadanos*/
        Ciudadano[] ciudadanos = new Ciudadano[4];
        ciudadanos[0] = new Ciudadano("pepe", "c1", "12345678A");
        ciudadanos[1] = new Ciudadano("juan", "c2", "12345678B");
        ciudadanos[2] = new Ciudadano("luis", "c3", "12345678C");
        ciudadanos[3] = new Ciudadano("indeseable", "c4", "55555555X");
        for (Ciudadano c:ciudadanos) {
            Aplicacion.VecindApp.addElemCol(c);
        }

        /*Admision de ciudadanos*/
        List<Notificacion> pendientes = new ArrayList<>(admin.getPendientes());
        for (int i = 0; i < 3; i++) {   //El usuario administrador admite a los tres primeros
            System.out.println(pendientes.get(0).descripcion());
            ((NotificacionReg)pendientes.get(0)).getSujeto().admitir();
            pendientes.remove(pendientes.get(0));   //(Una vez se atiende una notificacion, se elimina)
        }
        Aplicacion.VecindApp.removeElemCol(((NotificacionReg)pendientes.get(0)).getSujeto());  //y rechaza al indeseable
        pendientes.remove(pendientes.get(0));

        /*Creacion de e inscripcion a colectivos*/
        Colectivo colectivo = new Colectivo("Estudiantes", ciudadanos[0]);
        Colectivo subcolectivo = new Colectivo("Universitarios", colectivo);
        colectivo.addElemento(ciudadanos[1]);

        /*Creacion, admision y apoyo a proyectos*/
        Proyecto proyecto = new ProyectoInfraestructura("prueba",
                "es una prueba",
                1100.00,
                ciudadanos[0],
                "imagen.jpg",
                Arrays.asList(Distrito.Hortaleza, Distrito.Chamartin));
        Aplicacion.VecindApp.addProyecto(proyecto); //Proyecto individual

        pendientes = new ArrayList<>(admin.getPendientes());
        System.out.println(pendientes.get(0).descripcion());
        ((NotificacionProy)pendientes.get(0)).getSujeto().aceptar(); //Admite al proyecto
        pendientes.remove(pendientes.get(0).descripcion());

        proyecto.recibirApoyo(ciudadanos[1]);   //recibe un apoyo individual
        System.out.println("Numero de apoyos:" + proyecto.getNApoyos()); //2
        proyecto.recibirApoyo(subcolectivo);    //recibe un apoyo colectivo
        System.out.println("Numero de apoyos:" + proyecto.getNApoyos()); //2
        subcolectivo.addElemento(ciudadanos[2]);    //luis se apunta al subcolectivo, se actualizan los apoyos
        System.out.println("Numero de apoyos:" + proyecto.getNApoyos()); //3

        pendientes = new ArrayList<>(ciudadanos[0].getPendientes());
        System.out.println(pendientes.get(0).descripcion());  //El proyecto esta listo para enviar
        pendientes.remove(pendientes.get(0));

        /*Guardar y cargar aplicacion*/
        Aplicacion.VecindApp.guardar("prueba_simulador.txt");
        try {
            Aplicacion.cargar("prueba_simulador.txt");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
            return;
        }
        //Veamos que cargo bien
        System.out.println("Luis tiene NIF " + Aplicacion.VecindApp.findCiudadano("luis").getNif());

        /*Enviar a financiacion y esperar respuesta*/
        CCGG proxy = CCGG.getGateway();
        proxy.setDate(FechaSimulada.getHoy());
        try {
            proyecto.enviarFinanciacion();

            pendientes = new ArrayList<>(ciudadanos[0].getPendientes());
            System.out.println(pendientes.get(0).descripcion());  //El proyecto fue enviado a financiacion
            pendientes.remove(pendientes.get(0));

            FechaSimulada.avanzar(30);  //pasa un mes
            proxy.setDate(FechaSimulada.getHoy());

            proyecto.consultarFinanciacion();

            pendientes = new ArrayList<>(ciudadanos[0].getPendientes());
            System.out.println(pendientes.get(0).descripcion());  //El proyecto fue resuelto (con suerte financiado)
            pendientes.remove(pendientes.get(0));
        } catch (CCGGException | ConexionFallida ex) {
            System.out.println(ex);
            return; //En este simulador, la interaccion termina si hay excepciones. En general, se manejara la excepcion
        }

        System.out.printf("%s. Importe concedido: %.2f", proyecto.getTitulo(), proyecto.getImporteConcedido());
    }
}
