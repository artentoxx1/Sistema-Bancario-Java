package Banco.SistemaBancario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Transaccion implements Operaciones {
    private static final String DIRECTORIO_TRANSACCIONES = "transacciones";
    private static final AtomicInteger contadorTransacciones = new AtomicInteger(1);

    private String tipoTransaccion;
    private double cantidadTransaccion;
    private Fecha fechaTransaccion;
    private CuentaHija cuentaDestino;

    public Transaccion(String tipoTransaccion, double cantidadTransaccion, Fecha fechaTransaccion, CuentaHija cuentaDestino) {
        this.tipoTransaccion = tipoTransaccion;
        this.cantidadTransaccion = cantidadTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.cuentaDestino = cuentaDestino;
        guardarTransaccionEnArchivo();
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

    public CuentaHija getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(CuentaHija cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public void ejecutarTransaccion(CuentaHija cuentaOrigen) {
        switch (tipoTransaccion.toLowerCase()) {
            case "deposito":
                cuentaOrigen.depositar(cantidadTransaccion);
                System.out.println("Depósito realizado. Saldo actual: " + cuentaOrigen.getSaldoCuenta());
                break;
            case "retiro":
                cuentaOrigen.retirar(cantidadTransaccion);
                System.out.println("Retiro realizado. Saldo actual: " + cuentaOrigen.getSaldoCuenta());
                break;
            case "transferencia":
                if (cuentaOrigen.getSaldoCuenta() >= cantidadTransaccion && cuentaDestino != null) {
                    cuentaOrigen.retirar(cantidadTransaccion);
                    cuentaDestino.depositar(cantidadTransaccion);
                    System.out.println("Transferencia realizada. Saldo actual de origen: " + cuentaOrigen.getSaldoCuenta() +
                            ", Saldo actual de destino: " + cuentaDestino.getSaldoCuenta());
                } else {
                    System.out.println("Saldo insuficiente o cuenta de destino inválida para realizar la transferencia.");
                }
                break;
            default:
                System.out.println("Tipo de transacción no válido.");
        }
    }

    private void guardarTransaccionEnArchivo() {
        // Crear el directorio si no existe
        File directorio = new File(DIRECTORIO_TRANSACCIONES);
        if (!directorio.exists()) {
            directorio.mkdir();
        }

        // Crear y escribir en el archivo
        String nombreArchivo = DIRECTORIO_TRANSACCIONES + "/transaccion_" + contadorTransacciones.getAndIncrement() + ".txt";
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            escritor.write("Tipo de transacción: " + tipoTransaccion + "\n");
            escritor.write("Cantidad: " + cantidadTransaccion + "\n");
            escritor.write("Fecha: " + fechaTransaccion.toString() + "\n");
            if (cuentaDestino != null) {
                escritor.write("Cuenta destino: " + cuentaDestino.getNumeroCuenta() + "\n");
            }
            escritor.write("-------------------------------------\n");
            System.out.println("Detalles de la transacción guardados en: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los detalles de la transacción: " + e.getMessage());
        }
    }

    public static void crearYEjecutar(String tipo, double monto, Fecha fecha, CuentaHija cuentaOrigen, CuentaHija cuentaDestino) {
        Transaccion transaccion = new Transaccion(tipo, monto, fecha, cuentaDestino);
        transaccion.ejecutarTransaccion(cuentaOrigen);
    }

    public void mostrarDetalles() {
        System.out.println("-------------------------------------");
        System.out.println("Tipo de transacción: " + tipoTransaccion);
        System.out.println("Cantidad: " + cantidadTransaccion);
        System.out.println("Fecha: " + fechaTransaccion.toString());
        if (cuentaDestino != null) {
            System.out.println("Cuenta destino: " + cuentaDestino.getNumeroCuenta());
        }
        System.out.println("-------------------------------------");
    }
}
