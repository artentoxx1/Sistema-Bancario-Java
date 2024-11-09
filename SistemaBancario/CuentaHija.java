package Banco.SistemaBancario;

public interface CuentaHija {
    void depositar(double monto);
    void retirar(double monto);
    double getSaldoCuenta();
    String getNumeroCuenta();
}