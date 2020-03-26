package vecindApp.pruebas;

import es.uam.eps.sadp.grants.CCGG;
import vecindApp.clases.*;

import java.util.Arrays;
import java.util.List;

public class Simulacion {
    public static void main(String[] args) {
        //Inicializacion de la aplicacion
        Administrador admin = new Administrador("admin", "password");
        Aplicacion vecindApp = new Aplicacion(admin);
        Aplicacion.minApoyos = 2;   //Lo decide el usuario administrador

        //Registro de ciudadanos
        Ciudadano[] ciudadanos = new Ciudadano[4];
        ciudadanos[0] = new Ciudadano("pepe", "c1", "12345678A");
        ciudadanos[1] = new Ciudadano("juan", "c2", "12345678B");
        ciudadanos[2] = new Ciudadano("luis", "c3", "12345678C");
        ciudadanos[3] = new Ciudadano("indeseado", "c4", "55555555X");
        for (Ciudadano c:ciudadanos) {
            vecindApp.addElemCol(c);
        }

        //Admision de ciudadanos
        List<Notificacion> pendientes = admin.getPendientes();
        for (int i = 0; i < 3; i++) {   //El usuario administrador admite a los tres primeros
            ((NotificacionReg)pendientes.get(i)).getSujeto().admitir();
        }
        vecindApp.removeElemCol(((NotificacionReg)pendientes.get(3)).getSujeto());  //y rechaza al indeseable

        //Creacion de e inscripcion a colectivos
        Colectivo colectivo = new Colectivo("Estudiantes", ciudadanos[0]);
        Colectivo subcolectivo = new Colectivo("Universitarios", colectivo);
        colectivo.addElemento(ciudadanos[1]);

        //Creacion de y apoyo a proyectos
        vecindApp.addProyecto(new ProyectoInfraestructura("prueba",
                "es una prueba",
                1100.00,
                ciudadanos[0],
                "imagen.png",
                Arrays.asList(Distrito.Hortaleza, Distrito.Chamartin)));

        //Enviar a financiacion y esperar respuesta
    }
}
