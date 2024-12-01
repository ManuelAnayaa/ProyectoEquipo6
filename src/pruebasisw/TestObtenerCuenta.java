package pruebasisw;

import org.junit.Assert;
import org.junit.Test;

public class TestObtenerCuenta {

    @Test
    public void obtenerCuentaExistente() {
        Banco banco = new Banco();
        Cuenta cuenta = banco.obtenerCuenta(1); 
        Assert.assertNotNull("La cuenta debería existir", cuenta);
        Assert.assertEquals("El número de cuenta no coincide", 1, cuenta.getNumeroCuenta());
        Assert.assertEquals("El número de cliente no coincide", 1, cuenta.getNumeroCliente());
        Assert.assertEquals("El saldo inicial no coincide", 1000.0, cuenta.getSaldo(), 0.01);
    }
    @Test
    public void obtenerCuentaInexistente() {
        Banco banco = new Banco();
        Cuenta cuenta = banco.obtenerCuenta(99);
        Assert.assertNull("No debería haber una cuenta para este cliente", cuenta);
    }
}
