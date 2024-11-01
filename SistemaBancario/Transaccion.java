package Banco.SistemaBancario;

public class Transaccion implements Operaciones{
    private String tipoTransaccion;
    private double cantidadTransaccion;
    private Fecha fechaTransaccion;
    private CuentaBancaria cuentaDestino;

    public Transaccion(String tipoTransaccion, double cantidadTransaccion, Fecha fechaTransaccion, CuentaBancaria cuentaDestino) {
        this.tipoTransaccion = tipoTransaccion;
        this.cantidadTransaccion = cantidadTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.cuentaDestino = cuentaDestino;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public double getCantidadTransaccion() {
        return cantidadTransaccion;
    }

    public void setCantidadTransaccion(double cantidadTransaccion) {
        this.cantidadTransaccion = cantidadTransaccion;
    }

    public Fecha getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Fecha fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public CuentaBancaria getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(CuentaBancaria cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    // Ejecutar la transacción dependiendo del tipo (depósito, retiro, transferencia)
    public void ejecutarTransaccion(CuentaBancaria c) {
        if (tipoTransaccion.equalsIgnoreCase("deposito")) {
            c.depositar(cantidadTransaccion);
        } else if (tipoTransaccion.equalsIgnoreCase("retiro")) {
            c.retirar(cantidadTransaccion);
        } else if (tipoTransaccion.equalsIgnoreCase("transferencia") && cuentaDestino != null) {
            c.retirar(cantidadTransaccion);
            cuentaDestino.depositar(cantidadTransaccion);
        } else {
            System.out.println("Transacción no válida.");
        }
    }

    // Mostrar los detalles de la transacción
    public void mostrarDetalles() {
        System.out.println("Tipo de transacción: " + tipoTransaccion);
        System.out.println("Cantidad: " + cantidadTransaccion);
        System.out.println("Fecha: " + fechaTransaccion.toString());
        if (cuentaDestino != null) {
            System.out.println("Cuenta destino: " + cuentaDestino.getNumeroCuenta());
        }
    }
}
