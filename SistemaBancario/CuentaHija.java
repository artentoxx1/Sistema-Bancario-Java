package Banco.SistemaBancario;

import java.util.List;

public interface CuentaHija {
    // Metodo para depositar una cantidad en la cuenta
    void depositar(double monto);

    // Metodo para retirar una cantidad de la cuenta
    void retirar(double monto);

    // Obtener el saldo actual de la cuenta
    double getSaldoCuenta();

    // Obtener el número de cuenta
    String getNumeroCuenta();

    // Obtener el historial de transacciones como una lista
    List<Transaccion> getHistorialCuenta();

    // Mostrar el historial de transacciones
    void mostrarHistorial();
}
