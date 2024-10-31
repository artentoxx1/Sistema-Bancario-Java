package Banco.SistemaBancario;
import java.util.Scanner;
public class CuentaBancaria {
    protected String numeroCuenta;
    protected double saldoCuenta;
    protected Transaccion[] historialCuenta;
    protected String tipoCuenta;
    private int indiceTransaccion = 0;

    public CuentaBancaria() {

    }
    public CuentaBancaria(String numeroCuenta, double saldoCuenta,Transaccion[] historialCuenta,
                          String tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldoCuenta = saldoCuenta;
        this.historialCuenta = historialCuenta;
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
    public Transaccion[] getHistorialCuenta() {
        return historialCuenta;
    }
    public void setHistorialCuenta(Transaccion[] historialCuenta) {
        this.historialCuenta = historialCuenta;
    }
    public String getTipoCuenta() {
        return tipoCuenta;
    }
    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    Scanner sc = new Scanner(System.in);
    private void registrarTransaccion(Transaccion transaccion) {
        if (indiceTransaccion >= historialCuenta.length) {
            // Duplicar el tamaño del arreglo si se llena
            Transaccion[] nuevoHistorial = new Transaccion[historialCuenta.length * 2];
            System.arraycopy(historialCuenta, 0, nuevoHistorial, 0, historialCuenta.length);
            historialCuenta = nuevoHistorial;
        }
        historialCuenta[indiceTransaccion] = transaccion;
        indiceTransaccion++;
    }

    public void depositar(double monto) {
        saldoCuenta += monto;
        setSaldoCuenta(saldoCuenta);
        Transaccion transaccion = new Transaccion("Depósito", monto, new Fecha(), null);
        registrarTransaccion(transaccion);
        System.out.println("Depósito exitoso");
    }

    public void retirar(double monto) {
        if (saldoCuenta >= monto) {
            saldoCuenta -= monto;
            setSaldoCuenta(saldoCuenta);
            Transaccion transaccion = new Transaccion("Retiro", monto, new Fecha(), null);
            registrarTransaccion(transaccion);
            System.out.println("Retiro exitoso");
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }

    public void mostrarSaldo(){
        System.out.println("El saldo de la cuenta es S/. " + saldoCuenta);
    }

    // Mostrar el historial de transacciones usando el metodo de detalle de la clase Transaccion
    public void mostrarHistorial() {
        if (indiceTransaccion == 0) {
            System.out.println("No hay transacciones en el historial.");
        } else {
            for (int i = 0; i < indiceTransaccion; i++) {
                historialCuenta[i].mostrarDetalles();
            }
        }
    }
}
