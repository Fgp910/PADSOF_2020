package vecindApp.clases.proyecto;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Define la enumeracion Distrito que codifica los distintos
 * distritos de Madrid.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public enum Distrito implements Serializable {
    Desconocido ("Desconocido"),
    Arganzuela ("Arganzuela"),
    Barajas ("Barajas"),
    Carabanchel ("Carabanchel"),
    Centro ("Centro"),
    Chamartin ("Chamartin"),
    Chamberi ("Chamberi"),
    CiudadLineal ("CiudadLineal"),
    FuencarralElPardo ("FuencarralElPardo"),
    Hortaleza ("Hortaleza"),
    Latina ("Latina"),
    MoncloaAravaca ("MoncloaAravaca"),
    Moratalaz ("Moratalaz"),
    PuenteDeVallecas ("PuenteDeVallecas"),
    Retiro ("Retiro"),
    Salamanca ("Salamanca"),
    SanBlasCanillejas ("SanBlasCanillejas"),
    Tetuan ("Tetuan"),
    Usera ("Usera"),
    Vicalvaro ("Vicalvaro"),
    VillaDeVallecas ("VillaDeVallecas"),
    Villaverde ("Villaverde");

    private final String str;
    Distrito(String str) {
        this.str = str;
    }

    public static Distrito parse(String str) {
        return Arrays.stream(Distrito.values()).filter(d -> d.str.equals(str)).findFirst().orElse(Desconocido);
    }

    @Override
    public String toString() {
        return str;
    }
}