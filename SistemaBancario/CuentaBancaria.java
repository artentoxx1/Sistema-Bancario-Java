package Banco.SistemaBancario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CuentaBancaria implements CuentaHija {
    protected String numeroCuenta;
    protected double saldoCuenta;
    protected List<Transaccion> historialCuenta;
    protected String tipoCuenta;

    // Constructor por defecto
    public CuentaBancaria() {
        this.historialCuenta = new ArrayList<>();
    }

    // Constructor parametrizado
    public CuentaBancaria(String numeroCuenta, double saldoCuenta, String tipoCuenta) {
        if (saldoCuenta < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        this.numeroCuenta = numeroCuenta;
        this.saldoCuenta = saldoCuenta;
        this.historialCuenta = new ArrayList<>();
        this.tipoCuenta = tipoCuenta;
    }

    // Getters y Setters con validaciones
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        if (numeroCuenta == null || numeroCuenta.isEmpty()) {
            throw new IllegalArgumentException("El número de cuenta no puede estar vacío.");
        }
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        if (saldoCuenta < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo.");
        }
        this.saldoCuenta = saldoCuenta;
    }

    public List<Transaccion> getHistorialCuenta() {
        return historialCuenta;
    }

    public void setHistorialCuenta(List<Transaccion> historialCuenta) {
        if (historialCuenta == null) {
            throw new IllegalArgumentException("El historial no puede ser nulo.");
        }
        this.historialCuenta = historialCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        if (tipoCuenta == null || tipoCuenta.isEmpty()) {
            throw new IllegalArgumentException("El tipo de cuenta no puede estar vacío.");
        }
        this.tipoCuenta = tipoCuenta;
    }

    Scanner sc = new Scanner(System.in);

    // Metodo para registrar una transacción
    public void registrarTransaccion(Transaccion transaccion) {
        if (transaccion == null) {
            throw new IllegalArgumentException("La transacción no puede ser nula.");
        }
        historialCuenta.add(transaccion);
        System.out.println("Transacción registrada exitosamente.");
    }

    // Metodo para depositar
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor a cero.");
        }
        saldoCuenta += monto;
        registrarTransaccion(new Transaccion("Depósito", monto, this, this));
        System.out.println("Depósito exitoso. Nuevo saldo: S/. " + saldoCuenta);
    }

    // Metodo para retirar
    public void retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a cero.");
        }
        if (saldoCuenta >= monto) {
            saldoCuenta -= monto;
            registrarTransaccion(new Transaccion("Retiro", monto, this, this));
            System.out.println("Retiro exitoso. Nuevo saldo: S/. " + saldoCuenta);
        } else {
            System.out.println("Fondos insuficientes para realizar el retiro.");
        }
    }

    // Metodo para mostrar el saldo
    public void mostrarSaldo() {
        System.out.println("El saldo actual de la cuenta es: S/. " + saldoCuenta);
    }

    // Metodo para mostrar el historial de transacciones
    public void mostrarHistorial() {
        if (historialCuenta.isEmpty()) {
            System.out.println("No hay transacciones en el historial.");
        } else {
            for (Transaccion transaccion : historialCuenta) {
                transaccion.mostrarDetalles();
            }
        }
    }

    // Metodo para generar un número de cuenta aleatorio
    public static String generarNumeroCuenta() {
        StringBuilder numeroCuenta = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int digito = (int) (Math.random() * 10);
            numeroCuenta.append(digito);
        }
        return numeroCuenta.toString();
    }
}
