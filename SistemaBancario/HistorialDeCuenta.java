package Banco.SistemaBancario;

public class HistorialDeCuenta {
    private Transaccion[] transacciones;
    private CuentaBancaria cuentaBancaria;
    private int indiceTransaccion; // Para controlar el índice de las transacciones

    public HistorialDeCuenta(Transaccion[] transacciones, CuentaBancaria cuentaBancaria) {
        this.transacciones = transacciones;
        this.cuentaBancaria = cuentaBancaria;
        this.indiceTransaccion = 0; // Inicializamos el índice en 0
    }

    public Transaccion[] getTransaccion() {
        return transacciones;
    }

    public void setTransaccion(Transaccion[] transaccion) {
        this.transacciones = transaccion;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    // Registrar una nueva transacción
    public void registrarTransaccion(Transaccion transaccion) {
        if (indiceTransaccion < transacciones.length) {
            transacciones[indiceTransaccion] = transaccion;
            indiceTransaccion++;
        } else {
            System.out.println("No hay espacio para más transacciones.");
        }
    }

    public void obtenerHistorial() {
        System.out.println("Historial de Transacciones de la cuenta: " + cuentaBancaria.getNumeroCuenta());
        for (int i = 0; i < indiceTransaccion; i++) {
            transacciones[i].mostrarDetallesTransaccion();
        }
    }
}