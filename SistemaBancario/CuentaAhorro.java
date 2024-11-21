package Banco.SistemaBancario;

import java.util.ArrayList;
import java.util.List;

public class CuentaAhorro extends CuentaBancaria implements CuentaHija {
    private double tasaInteres;
    private int limiteRetiros;
    private List<Transaccion> historialCuenta;

    // Constructor por defecto
    public CuentaAhorro() {
        super();
        this.historialCuenta = new ArrayList<>();
    }

    // Constructor parametrizado
    public CuentaAhorro(String numeroCuenta, double saldoCuenta, String tipoCuenta, double tasaInteres, int limiteRetiros) {
        super(numeroCuenta, saldoCuenta, tipoCuenta);
        if (tasaInteres < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa.");
        }
        if (limiteRetiros < 0) {
            throw new IllegalArgumentException("El límite de retiros no puede ser negativo.");
        }
        this.tasaInteres = tasaInteres;
        this.limiteRetiros = limiteRetiros;
        this.historialCuenta = new ArrayList<>();
    }

    // Getters y Setters con validaciones
    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        if (tasaInteres < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa.");
        }
        this.tasaInteres = tasaInteres;
    }

    public int getLimiteRetiros() {
        return limiteRetiros;
    }

    public void setLimiteRetiros(int limiteRetiros) {
        if (limiteRetiros < 0) {
            throw new IllegalArgumentException("El límite de retiros no puede ser negativo.");
        }
        this.limiteRetiros = limiteRetiros;
    }

    // Metodo para calcular el interés acumulado
    public double calcularIntereses() {
        return tasaInteres * 0.01 * saldoCuenta;
    }

    // Verifica si el retiro es posible en base al límite de retiros
    private boolean permitirRetiro() {
        if (limiteRetiros > 0) {
            limiteRetiros--;
            return true;
        } else {
            System.out.println("Se ha alcanzado el límite de retiros permitidos.");
            return false;
        }
    }

    // Sobrescribe el metodo retirar con validaciones adicionales
    public void retirar(double monto) {
        String fecha = new String();
        fecha = Fecha.obtenerFechaActual();
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a cero.");
        }
        if (permitirRetiro()) {
            if (saldoCuenta >= monto) {
                saldoCuenta -= monto;
                registrarTransaccion(new Transaccion("Retiro", monto, this, this));
                System.out.println("Retiro exitoso. Saldo actual: S/. " + saldoCuenta);
            } else {
                System.out.println("Fondos insuficientes para realizar el retiro.");
            }
        }
    }

    // Sobrescribe el metodo depositar con validaciones
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor a cero.");
        }
        saldoCuenta += monto;
        registrarTransaccion(new Transaccion("Depósito", monto, this, this));
        System.out.println("Depósito exitoso. Saldo actual: S/. " + saldoCuenta);
    }

    // Metodo para registrar transacciones en el historial
    public void registrarTransaccion(Transaccion transaccion) {
        if (transaccion == null) {
            throw new IllegalArgumentException("La transacción no puede ser nula.");
        }
        historialCuenta.add(transaccion);
        System.out.println("Transacción registrada en el historial.");
    }

    // Metodo para mostrar el historial
    public void mostrarHistorial() {
        if (historialCuenta.isEmpty()) {
            System.out.println("No hay transacciones en el historial.");
        } else {
            System.out.println("Historial de transacciones:");
            for (Transaccion t : historialCuenta) {
                t.mostrarDetalles();
            }
        }
    }
}
