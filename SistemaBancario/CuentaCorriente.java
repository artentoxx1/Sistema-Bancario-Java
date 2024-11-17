package Banco.SistemaBancario;

import java.util.Scanner;

public class CuentaCorriente extends CuentaBancaria implements CuentaHija {
    private double limiteSobregiro;
    private double comisionPorSobregiro;

    public CuentaCorriente() {
        super();
    }

    public CuentaCorriente(String numeroCuenta, double saldoCuenta,
                           String tipoCuenta, double limiteSobregiro, double comisionPorSobregiro) {
        super(numeroCuenta, saldoCuenta, tipoCuenta);
        this.limiteSobregiro = limiteSobregiro;
        this.comisionPorSobregiro = comisionPorSobregiro;
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public void setLimiteSobregiro(double limiteSobregiro) {
        if (limiteSobregiro < 0) {
            throw new IllegalArgumentException("El límite de sobregiro no puede ser negativo.");
        }
        this.limiteSobregiro = limiteSobregiro;
    }

    public double getComisionPorSobregiro() {
        return comisionPorSobregiro;
    }

    public void setComisionPorSobregiro(double comisionPorSobregiro) {
        if (comisionPorSobregiro < 0) {
            throw new IllegalArgumentException("La comisión por sobregiro no puede ser negativa.");
        }
        this.comisionPorSobregiro = comisionPorSobregiro;
    }

    Scanner ints = new Scanner(System.in);

    public void permitirSobregiro(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }

        try {
            double comision = cobrarComisionPorSobregiro(monto);
            if (limiteSobregiro > comision) {
                if (saldoCuenta < monto && saldoCuenta > 0) {
                    retirar(saldoCuenta);
                    setLimiteSobregiro(limiteSobregiro - cobrarComisionPorSobregiro(monto - saldoCuenta));
                    System.out.println("Sobregiro permitido");
                } else {
                    setSaldoCuenta(saldoCuenta - cobrarComisionPorSobregiro(monto));
                    setLimiteSobregiro(limiteSobregiro - cobrarComisionPorSobregiro(monto - saldoCuenta));
                    System.out.println("Sobregiro permitido");
                }
            } else {
                System.out.println("Sobregiro no permitido: excede el límite.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public double cobrarComisionPorSobregiro(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero para calcular la comisión.");
        }
        return ((comisionPorSobregiro * 0.01) + 1) * monto;
    }

    public void consultarSobregiro() {
        try {
            System.out.println("Su sobregiro disponible es: " + getLimiteSobregiro());
        } catch (Exception e) {
            System.out.println("Error al consultar el sobregiro: " + e.getMessage());
        }
    }
}
