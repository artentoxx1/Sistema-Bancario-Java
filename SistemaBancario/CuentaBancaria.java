package Banco.SistemaBancario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CuentaBancaria implements CuentaHija{
    protected String numeroCuenta;
    protected double saldoCuenta;
    protected List<Transaccion> historialCuenta; // Cambiado a List para mejor gestión
    protected String tipoCuenta;

    // Constructor por defecto
    public CuentaBancaria() {
        this.historialCuenta = new ArrayList<>(); // Inicializar la lista
    }

    // Constructor parametrizado
    public CuentaBancaria(String numeroCuenta, double saldoCuenta, String tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldoCuenta = saldoCuenta;
        this.historialCuenta = new ArrayList<>(); // Inicializar la lista
        this.tipoCuenta = tipoCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public List<Transaccion> getHistorialCuenta() {
        return historialCuenta;
    }

    public void setHistorialCuenta(List<Transaccion> historialCuenta) {
        this.historialCuenta = historialCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    Scanner sc = new Scanner(System.in);

    // Metodo para registrar una transacción
    public void registrarTransaccion(Transaccion transaccion) {
        historialCuenta.add(transaccion); // Añadir la transacción a la lista
    }

    // Metodo para depositar
    public void depositar(double monto) {
        saldoCuenta += monto;
        setSaldoCuenta(saldoCuenta);
        Transaccion transaccion = new Transaccion("Depósito", monto, new Fecha(), this, this);
        registrarTransaccion(transaccion);
        System.out.println("Depósito exitoso");
    }

    // Metodo para retirar
    public void retirar(double monto) {
        if (saldoCuenta >= monto) {
            saldoCuenta -= monto;
            setSaldoCuenta(saldoCuenta);
            Transaccion transaccion = new Transaccion("Retiro", monto, new Fecha(), this, this);
            registrarTransaccion(transaccion);
            System.out.println("Retiro exitoso");
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }

    // Metodo para mostrar el saldo
    public void mostrarSaldo() {
        System.out.println("El saldo de la cuenta es S/. " + saldoCuenta);
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
