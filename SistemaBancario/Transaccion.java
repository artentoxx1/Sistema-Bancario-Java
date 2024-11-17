package Banco.SistemaBancario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class Transaccion implements Operaciones {
    private static final String DIRECTORIO_TRANSACCIONES = "transacciones";
    private static final AtomicInteger contadorTransacciones = new AtomicInteger(1);

    private String tipoTransaccion;
    private double cantidadTransaccion;
    private Fecha fechaTransaccion;
    private CuentaHija cuentaDestino;
    private CuentaHija cuentaOrigen;

    // Constructor con manejo de excepciones
    public Transaccion(String tipoTransaccion, double cantidadTransaccion, Fecha fechaTransaccion, CuentaHija cuentaOrigen, CuentaHija cuentaDestino) {
        try {
            if (tipoTransaccion == null || tipoTransaccion.isEmpty()) {
                throw new IllegalArgumentException("El tipo de transacción no puede ser nulo o vacío.");
            }
            if (cantidadTransaccion <= 0) {
                throw new IllegalArgumentException("La cantidad de la transacción debe ser mayor que cero.");
            }
            if (fechaTransaccion == null) {
                throw new IllegalArgumentException("La fecha de la transacción no puede ser nula.");
            }
            if (cuentaOrigen == null) {
                throw new IllegalArgumentException("La cuenta origen no puede ser null.");
            }

            this.tipoTransaccion = tipoTransaccion;
            this.cantidadTransaccion = cantidadTransaccion;
            this.fechaTransaccion = fechaTransaccion;
            this.cuentaOrigen = cuentaOrigen;
            this.cuentaDestino = cuentaDestino;
        } catch (Exception e) {
            System.err.println("Error al crear la transacción: " + e.getMessage());
            throw e; // Vuelve a lanzar la excepción para que no se cree una instancia inválida.
        }
    }

    public static void crearYEjecutar(String tipo, double monto, Fecha fecha, CuentaHija cuentaOrigen, CuentaHija cuentaDestino) {
        try {
            if (cuentaOrigen == null) {
                throw new IllegalArgumentException("La cuenta origen no puede ser null");
            }
            Transaccion transaccion = new Transaccion(tipo, monto, fecha, cuentaOrigen, cuentaDestino);
            transaccion.ejecutarTransaccion();
        } catch (Exception e) {
            System.err.println("Error al crear y ejecutar la transacción: " + e.getMessage());
        }
    }

    // Metodo para ejecutar la transacción
    public void ejecutarTransaccion() {
        try {
            if (cuentaOrigen == null) {
                throw new IllegalStateException("Cuenta origen no debe ser null al ejecutar la transacción");
            }

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
                    if (cuentaDestino != null && cuentaOrigen.getSaldoCuenta() >= cantidadTransaccion) {
                        cuentaOrigen.retirar(cantidadTransaccion);
                        cuentaDestino.depositar(cantidadTransaccion);
                        System.out.println("Transferencia realizada. Saldo actual de origen: " + cuentaOrigen.getSaldoCuenta() +
                                ", Saldo actual de destino: " + cuentaDestino.getSaldoCuenta());
                    } else {
                        System.out.println("Saldo insuficiente o cuenta de destino inválida.");
                    }
                    break;
                default:
                    System.out.println("Tipo de transacción no válido.");
                    break;
            }

            guardarTransaccionEnArchivo();
        } catch (Exception e) {
            System.err.println("Error al ejecutar la transacción: " + e.getMessage());
        }
    }

    private void guardarTransaccionEnArchivo() {
        try {
            File directorio = new File(DIRECTORIO_TRANSACCIONES);
            if (!directorio.exists()) {
                if (!directorio.mkdir()) {
                    throw new IOException("No se pudo crear el directorio para transacciones.");
                }
            }

            LocalDateTime fechaHoraActual = LocalDateTime.now();
            DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String nombreArchivo = DIRECTORIO_TRANSACCIONES + "/transaccion_" + formatoFechaHora.format(fechaHoraActual) + "_" + contadorTransacciones.getAndIncrement() + ".txt";

            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
                escritor.write("---------- SISTEMA BANCARIO EN JAVA ----------\n");
                escritor.write("Tipo de transacción: " + tipoTransaccion + "\n");
                escritor.write("Importe: " + cantidadTransaccion + "\n");
                escritor.write("Fecha de transacción: " + fechaTransaccion.toString() + "\n");
                escritor.write("Cuenta origen: " + cuentaOrigen.getNumeroCuenta() + "\n");

                if (tipoTransaccion.equalsIgnoreCase("transferencia")) {
                    escritor.write("Cuenta destino: " + cuentaDestino.getNumeroCuenta() + "\n");
                } else {
                    escritor.write("Cuenta destino: (igual a cuenta origen)\n");
                }

                escritor.write("-------------------------------------\n");
                System.out.println("Detalles de la transacción guardados en: " + nombreArchivo);
            }
        } catch (IOException e) {
            System.err.println("Error al guardar los detalles de la transacción: " + e.getMessage());
        }
    }

    public void mostrarDetalles() {
        try {
            System.out.println("-------------------------------------");
            System.out.println("Tipo de transacción: " + tipoTransaccion);
            System.out.println("Cantidad: " + cantidadTransaccion);
            System.out.println("Fecha: " + fechaTransaccion.toString());
            System.out.println("Cuenta origen: " + (cuentaOrigen != null ? cuentaOrigen.getNumeroCuenta() : "N/A"));
            if (cuentaDestino != null) {
                System.out.println("Cuenta destino: " + cuentaDestino.getNumeroCuenta());
            }
            System.out.println("-------------------------------------");
        } catch (Exception e) {
            System.err.println("Error al mostrar los detalles de la transacción: " + e.getMessage());
        }
    }
}
