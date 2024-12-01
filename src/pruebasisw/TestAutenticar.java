package pruebasisw;

import org.junit.Assert;
import org.junit.Test;

public class TestAutenticar {

    @Test
    public void autenticarClienteValido() {
        Banco banco = new Banco();
        Cliente resultado = banco.autenticar(1, "password123");
        Assert.assertNotNull("El cliente debería ser autenticado correctamente", resultado);
        Assert.assertEquals("El número de cliente no coincide", 1, resultado.getNumeroCliente());
        Assert.assertEquals("El nombre del cliente no coincide", "Juan Perez", resultado.getNombre());
    }

    @Test
    public void autenticarClienteInvalido() {
        Banco banco = new Banco();
        Cliente resultado = banco.autenticar(99, "password123");
        Assert.assertNull("La autenticación debería fallar para un cliente inexistente", resultado);
    }

    @Test
    public void autenticarContrasenaIncorrecta() {
        Banco banco = new Banco();
        Cliente resultado = banco.autenticar(2, "wrongPassword");
        Assert.assertNull("La autenticación debería fallar si la contraseña es incorrecta", resultado);
    }

    @Test
    public void autenticarOtroClienteValido() {
        Banco banco = new Banco();
        Cliente resultado = banco.autenticar(3, "12345");
        Assert.assertNotNull("El cliente debería ser autenticado correctamente", resultado);
        Assert.assertEquals("El número de cliente no coincide", 3, resultado.getNumeroCliente());
        Assert.assertEquals("El nombre del cliente no coincide", "Luis Hernández", resultado.getNombre());
    }
}
