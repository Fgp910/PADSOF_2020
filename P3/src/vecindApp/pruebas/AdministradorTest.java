package vecindApp.pruebas;

import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdministradorTest {
    Administrador a;

    @Before
    void setUp() {
        a = new Administrador("jose", "a1");
    }
}