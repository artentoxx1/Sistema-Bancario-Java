package Banco.SistemaBancario;
import java.util.Scanner;
public class CuentaBancaria {
    protected String numeroCuenta;
    protected double saldoCuenta;
    protected Transaccion[] historialCuenta;
    protected String tipoCuenta;

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
    public void depositar(double monto){
        saldoCuenta=saldoCuenta+monto;
        setSaldoCuenta(saldoCuenta);
        System.out.println("Depositado exitoso");
    }
    public void retirar(double monto){
        saldoCuenta=saldoCuenta-monto;
        setSaldoCuenta(saldoCuenta);
        System.out.println("Retiro exitoso");

    }
    public Transaccion[] obtenerHistorial(){

        return historialCuenta;
    }
    public void mostrarHistorial(){
        for(int i=0;i<historialCuenta.length;i++){
            System.out.println(historialCuenta[i]);
        }
    }
    public void mostrarSaldo(){
        System.out.println("Su saldo de cuenta es: "+ getSaldoCuenta());

    }
}
