package pruebasisw;

import org.junit.Assert;
import org.junit.Test;

public class TestverificarContrasena {

    @Test
    public void contrasenaCorrecta() {
        Cliente cliente = new Cliente(1, "Juan Perez", "password123");
        boolean resultado = cliente.verificarContrasena("password123");
        Assert.assertTrue("La contraseña debería ser correcta", resultado);
    }

    @Test
    public void contrasenaIncorrecta() {
        Cliente cliente = new Cliente(1, "Juan Perez", "password123");
        boolean resultado = cliente.verificarContrasena("wrongPassword");
        Assert.assertFalse("La contraseña debería ser incorrecta", resultado);
    }

    @Test
    public void contrasenaNula() {
        Cliente cliente = new Cliente(1, "Juan Perez", "password123");
        boolean resultado = cliente.verificarContrasena(null);
        Assert.assertFalse("La contraseña no debería coincidir con un valor nulo", resultado);
    }
}
