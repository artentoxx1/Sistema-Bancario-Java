package Banco.SistemaBancario;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Transaccion implements Operaciones {
    private static final String DIRECTORIO_TRANSACCIONES = "transacciones";
    private static final Map<String, Integer> contadoresPorCuenta = cargarContadores();

    private String tipoTransaccion;
    private double cantidadTransaccion;
    private String fechaTransaccion;
    private CuentaHija cuentaDestino;
    private CuentaHija cuentaOrigen;

    public Transaccion(String tipoTransaccion, double cantidadTransaccion, CuentaHija cuentaOrigen, CuentaHija cuentaDestino) {
        if (tipoTransaccion == null || tipoTransaccion.isEmpty()) {
            throw new IllegalArgumentException("El tipo de transacción no puede ser nulo o vacío.");
        }
        if (cantidadTransaccion <= 0) {
            throw new IllegalArgumentException("La cantidad de la transacción debe ser mayor que cero.");
        }
        if (cuentaOrigen == null) {
            throw new IllegalArgumentException("La cuenta origen no puede ser null.");
        }

        this.tipoTransaccion = tipoTransaccion;
        this.cantidadTransaccion = cantidadTransaccion;
        this.fechaTransaccion = Fecha.obtenerFechaActual();
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
    }

    public static void crearYEjecutar(String tipo, double monto, CuentaHija cuentaOrigen, CuentaHija cuentaDestino) {
        try {
            Transaccion transaccion = new Transaccion(tipo, monto, cuentaOrigen, cuentaDestino);
            transaccion.ejecutarTransaccion();
        } catch (Exception e) {
            System.err.println("Error al crear y ejecutar la transacción: " + e.getMessage());
        }
    }

    public void ejecutarTransaccion() {
        try {
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
                        return;
                    }
                    break;
                default:
                    System.out.println("Tipo de transacción no válido.");
                    return;
            }

            guardarTransaccionEnArchivo();
        } catch (Exception e) {
            System.err.println("Error al ejecutar la transacción: " + e.getMessage());
        }
    }

    private void guardarTransaccionEnArchivo() {
        try {
            File directorio = new File(DIRECTORIO_TRANSACCIONES);
            if (!directorio.exists() && !directorio.mkdir()) {
                throw new IOException("No se pudo crear el directorio para transacciones.");
            }

            String numeroCuentaOrigen = cuentaOrigen.getNumeroCuenta();
            int contadorActual = contadoresPorCuenta.getOrDefault(numeroCuentaOrigen, 0) + 1;
            contadoresPorCuenta.put(numeroCuentaOrigen, contadorActual);
            guardarContadores();

            String idTransaccion = String.format("%04d", contadorActual);
            String nombreArchivo = String.format("%s/transaccion_%s_%s.txt", DIRECTORIO_TRANSACCIONES, numeroCuentaOrigen, idTransaccion);

            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
                escritor.write("---------- SISTEMA BANCARIO EN JAVA ----------\n");
                escritor.write("Tipo de transacción: " + tipoTransaccion + "\n");
                escritor.write("Importe: " + cantidadTransaccion + "\n");
                escritor.write("Fecha de transacción: " + fechaTransaccion + "\n");
                escritor.write("Cuenta origen: " + cuentaOrigen.getNumeroCuenta() + "\n");

                if (tipoTransaccion.equalsIgnoreCase("transferencia")) {
                    escritor.write("Cuenta destino: " + (cuentaDestino != null ? cuentaDestino.getNumeroCuenta() : "N/A") + "\n");
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

    public static void buscarYMostrarTransaccion(String numeroCuenta, String idTransaccion) {
        String nombreArchivo = String.format("%s/transaccion_%s_%s.txt", DIRECTORIO_TRANSACCIONES, numeroCuenta, idTransaccion);
        File archivo = new File(nombreArchivo);

        if (archivo.exists()) {
            try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
                String linea;
                System.out.println("---------- DETALLES DE LA TRANSACCIÓN ----------");
                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                }
                System.out.println("-----------------------------------------------");
            } catch (IOException e) {
                System.err.println("Error al leer el archivo de la transacción: " + e.getMessage());
            }
        } else {
            System.out.println("No se encontró una transacción con los datos especificados.");
        }
    }

    private static Map<String, Integer> cargarContadores() {
        File archivo = new File(DIRECTORIO_TRANSACCIONES + "/contadores.txt");
        Map<String, Integer> contadores = new HashMap<>();
        if (archivo.exists()) {
            try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = lector.readLine()) != null) {
                    String[] partes = linea.split(":");
                    contadores.put(partes[0], Integer.parseInt(partes[1]));
                }
            } catch (IOException e) {
                System.err.println("Error al cargar los contadores: " + e.getMessage());
            }
        }
        return contadores;
    }

    private static void guardarContadores() {
        File archivo = new File(DIRECTORIO_TRANSACCIONES + "/contadores.txt");
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
            for (Map.Entry<String, Integer> entrada : contadoresPorCuenta.entrySet()) {
                escritor.write(entrada.getKey() + ":" + entrada.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al guardar los contadores: " + e.getMessage());
        }
    }

    public void mostrarDetalles() {
        try {
            System.out.println("-------------------------------------");
            System.out.println("Tipo de transacción: " + tipoTransaccion);
            System.out.println("Cantidad: " + cantidadTransaccion);
            System.out.println("Fecha: " + fechaTransaccion);
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
