package Banco.SistemaBancario;

import java.util.ArrayList;
import java.util.List;

public class CuentaAhorro extends CuentaBancaria implements CuentaHija {
    private double tasaInteres;
    private int limiteRetiros;
    private List<Transaccion> historialCuenta; // Definimos el historial aquí

    // Constructor por defecto
    public CuentaAhorro() {
        super();
        this.historialCuenta = new ArrayList<>();
    }

    // Constructor parametrizado
    public CuentaAhorro(String numeroCuenta, double saldoCuenta, String tipoCuenta, double tasaInteres, int limiteRetiros) {
        super(numeroCuenta, saldoCuenta, tipoCuenta);
        this.tasaInteres = tasaInteres;
        this.limiteRetiros = limiteRetiros;
        this.historialCuenta = new ArrayList<>();
    }

    // Getters y Setters
    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public int getLimiteRetiros() {
        return limiteRetiros;
    }

    public void setLimiteRetiros(int limiteRetiros) {
        this.limiteRetiros = limiteRetiros;
    }

    // Metodo para calcular el interés acumulado
    public double calcularIntereses() {
        return tasaInteres * 0.01 * saldoCuenta;
    }

    // Verifica si el retiro es posible en base al límite de retiros
    public boolean permitirRetiro() {
        if (limiteRetiros > 0) {
            limiteRetiros--;
            return true;
        } else {
            System.out.println("Se ha alcanzado el límite de retiros permitidos.");
            return false;
        }
    }

    // Sobrescribe el metodo retirar para manejar retiros con límite
    public void retirar(double monto) {
        if (permitirRetiro()) {
            if (saldoCuenta >= monto) {
                saldoCuenta -= monto;
                registrarTransaccion(new Transaccion("Retiro", monto, new Fecha(), this, this));
                System.out.println("Retiro exitoso. Saldo actual: " + saldoCuenta);
            } else {
                System.out.println("Fondos insuficientes para realizar el retiro.");
            }
        }
    }

    // Sobrescribe el metodo depositar
    public void depositar(double monto) {
        saldoCuenta += monto;
        registrarTransaccion(new Transaccion("Depósito", monto, new Fecha(), this, this));
        System.out.println("Depósito exitoso. Saldo actual: " + saldoCuenta);
    }

    // Metodo para registrar transacciones en el historial
    public void registrarTransaccion(Transaccion transaccion) {
        historialCuenta.add(transaccion);
        System.out.println("Transacción registrada en el historial.");
    }

    // Metodo para mostrar el historial
    public void mostrarHistorial() {
        System.out.println("Historial de transacciones:");
        for (Transaccion t : historialCuenta) {
            t.mostrarDetalles();
        }
    }
}
