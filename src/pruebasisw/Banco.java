package pruebasisw;

import java.util.HashMap;

public class Banco {
    private HashMap<Integer, Cliente> clientes;
    private HashMap<Integer, Cuenta> cuentas;
    private int idClienteCounter = 1; // Contador para IDs de clientes
    private int idCuentaCounter = 1;  // Contador para IDs de cuentas

    public Banco() {
        clientes = new HashMap<>();
        cuentas = new HashMap<>();

        Cliente cliente1 = new Cliente(1, "Juan Perez", "password123");
        Cliente cliente2 = new Cliente(2, "Maria Gomez", "securePassword");
        Cliente cliente3 = new Cliente(3, "Luis Hernández", "12345");

        
        Cuenta cuenta1 = new Cuenta(1, 1, 1000.0); // Para cliente 1
        Cuenta cuenta2 = new Cuenta(2, 2, 500.0);  // Para cliente 2
        Cuenta cuenta3 = new Cuenta(3, 3, 300.0);  // Para cliente 3

        
        clientes.put(cliente1.getNumeroCliente(), cliente1);
        clientes.put(cliente2.getNumeroCliente(), cliente2);
        clientes.put(cliente3.getNumeroCliente(), cliente3);

        cuentas.put(cuenta1.getNumeroCuenta(), cuenta1);
        cuentas.put(cuenta2.getNumeroCuenta(), cuenta2);
        cuentas.put(cuenta3.getNumeroCuenta(), cuenta3);
    }

    // Método para registrar un cliente y su cuenta
    public void registrarCliente(Cliente cliente, Cuenta cuenta) {
        clientes.put(cliente.getNumeroCliente(), cliente);
        cuentas.put(cuenta.getNumeroCuenta(), cuenta);
    }

    // Método para autenticar cliente por su número de cliente y contraseña
    public Cliente autenticar(int numeroCliente, String contrasena) {
        Cliente cliente = clientes.get(numeroCliente);
        if (cliente != null && cliente.verificarContrasena(contrasena)) {
            return cliente;
        }
        return null;
    }

    public boolean eliminarCliente(int idCliente, String contrasena) {
        Cliente cliente = obtenerCliente(idCliente);
        if (cliente != null && cliente.getContrasena().equals(contrasena)) {
            // Lógica para eliminar el cliente
            return true;  // Indica que la eliminación fue exitosa
        }
        return false;  // Indica que la eliminación falló
    }
    
    

    // Método para obtener la cuenta de un cliente específico
    public Cuenta obtenerCuenta(int numeroCliente) {
        for (Cuenta cuenta : cuentas.values()) {
            if (cuenta.getNumeroCliente() == numeroCliente) {
                return cuenta;
            }
        }
        return null;
    }

    // Genera un nuevo ID único para un cliente
    public int generarNuevoIdCliente() {
        return idClienteCounter++;
    }

    // Genera un nuevo ID único para una cuenta
    public int generarNuevoIdCuenta() {
        return idCuentaCounter++;
    }
}
