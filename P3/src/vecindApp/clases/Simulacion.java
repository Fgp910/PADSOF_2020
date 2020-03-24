package vecindApp.clases;

import es.uam.eps.sadp.grants.CCGG;

public class Simulacion {
    public static void main(String[] args) {
        //Inicializacion de la aplicacion
        Administrador admin = new Administrador("admin", "password");
        Aplicacion vecindApp = new Aplicacion(admin);

        //Insercion de ciudadanos
        Ciudadano[] ciudadanos = new Ciudadano[3];
        ciudadanos[0] = new Ciudadano("pepe", "c1", "12345678A");
        ciudadanos[1] = new Ciudadano("juan", "c2", "12345678B");
        ciudadanos[2] = new Ciudadano("luis", "c3", "12345678C");
        for (Ciudadano c:ciudadanos) {
            vecindApp.addElemCol(c);
        }

        /*Admision de ciudadanos*/
    }
}
