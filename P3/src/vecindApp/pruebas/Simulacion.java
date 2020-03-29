package vecindApp.pruebas;

import es.uam.eps.sadp.grants.CCGG;
import vecindApp.clases.*;

import java.util.Arrays;
import java.util.List;

public class Simulacion {
    public static void main(String[] args) throws Exception {
        /*Inicializacion de la aplicacion*/
        Administrador admin = new Administrador("admin", "password");
        Aplicacion vecindApp = new Aplicacion(admin);
        Aplicacion.minApoyos = 2;   //Lo decide el usuario administrador

        /*Registro de ciudadanos*/
        Ciudadano[] ciudadanos = new Ciudadano[4];
        ciudadanos[0] = new Ciudadano("pepe", "c1", "12345678A");
        ciudadanos[1] = new Ciudadano("juan", "c2", "12345678B");
        ciudadanos[2] = new Ciudadano("luis", "c3", "12345678C");
        ciudadanos[3] = new Ciudadano("indeseable", "c4", "55555555X");
        for (Ciudadano c:ciudadanos) {
            vecindApp.addElemCol(c);
        }

        /*Admision de ciudadanos*/
        List<Notificacion> pendientes = admin.getPendientes();
        for (int i = 0; i < 3; i++) {   //El usuario administrador admite a los tres primeros
            System.out.println(pendientes.get(0));
            ((NotificacionReg)pendientes.get(0)).getSujeto().admitir();
            pendientes.remove(pendientes.get(0));   //(Una vez se atiende una notificacion, se elimina)
        }
        vecindApp.removeElemCol(((NotificacionReg)pendientes.get(0)).getSujeto());  //y rechaza al indeseable
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
                "imagen.png",
                Arrays.asList(Distrito.Hortaleza, Distrito.Chamartin));
        vecindApp.addProyecto(proyecto); //Proyecto individual

        pendientes = admin.getPendientes();
        System.out.println(pendientes.get(0));
        ((NotificacionProy)pendientes.get(0)).getSujeto().aceptar(); //Admite al proyecto
        pendientes.remove(pendientes.get(0));

        proyecto.recibirApoyo(ciudadanos[1]);   //recibe un apoyo individual
        System.out.println("Numero de apoyos:" + proyecto.getNApoyos()); //2
        proyecto.recibirApoyo(subcolectivo);    //recibe un apoyo colectivo
        System.out.println("Numero de apoyos:" + proyecto.getNApoyos()); //2
        subcolectivo.addElemento(ciudadanos[2]);    //luis se apunta al subcolectivo, se actualizan los apoyos
        System.out.println("Numero de apoyos:" + proyecto.getNApoyos()); //3

        pendientes = ciudadanos[0].getPendientes();
        System.out.println(pendientes.get(0));  //El proyecto esta listo para enviar
        pendientes.remove(pendientes.get(0));

        /*Enviar a financiacion y esperar respuesta*/
        CCGG proxy = CCGG.getGateway();
        proxy.setDate(FechaSimulada.getHoy());
        proyecto.enviarFinanciacion();
        FechaSimulada.avanzar(30);  //pasa un mes
        proxy.setDate(FechaSimulada.getHoy());
        proyecto.consultarFinanciacion();

        pendientes = ciudadanos[0].getPendientes();
        System.out.println(pendientes.get(0));  //El proyecto (con suerte) fue financiado
        pendientes.remove(pendientes.get(0));

        System.out.println(proyecto.getTitulo() + ". Importe concedido: " + proyecto.getImporteConcedido());
    }
}
