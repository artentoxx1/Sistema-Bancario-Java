package Banco.SistemaBancario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prestamo implements Operaciones {
    private double montoPrestamo;
    private double tasaInteres;
    private int plazoPrestamo;
    private double saldoRestante;
    private CuentaHija cuentaVinculada;
    private int pagosRealizados;
    private int pagosAtrasados;
    private boolean enMora;
    private int periodoGracia;
    private boolean capitalizarIntereses;
    private double cuotaMensual;

    public Prestamo(double montoPrestamo, double tasaInteres, int plazoPrestamo, CuentaHija cuentaVinculada, int periodoGracia, boolean capitalizarIntereses) {
        if (montoPrestamo <= 0) {
            throw new IllegalArgumentException("El monto del préstamo debe ser mayor a cero.");
        }
        if (tasaInteres <= 0 || tasaInteres >= 1) {
            throw new IllegalArgumentException("La tasa de interés debe estar entre 0 y 1 (en formato decimal).");
        }
        if (plazoPrestamo <= 0) {
            throw new IllegalArgumentException("El plazo del préstamo debe ser mayor a cero.");
        }
        if (cuentaVinculada == null) {
            throw new IllegalArgumentException("La cuenta vinculada no puede ser null.");
        }
        if (periodoGracia < 0) {
            throw new IllegalArgumentException("El periodo de gracia no puede ser negativo.");
        }

        this.montoPrestamo = montoPrestamo;
        this.tasaInteres = tasaInteres;
        this.plazoPrestamo = plazoPrestamo;
        this.cuentaVinculada = cuentaVinculada;
        this.saldoRestante = montoPrestamo;
        this.pagosRealizados = 0;
        this.pagosAtrasados = 0;
        this.enMora = false;
        this.periodoGracia = periodoGracia;
        this.capitalizarIntereses = capitalizarIntereses;
        this.cuotaMensual = calcularCuotaMensual();
    }

    public static Prestamo crearPrestamo(Scanner entrada, CuentaHija cuentaVinculada) {
        try {
            System.out.print("Ingrese el monto del préstamo: ");
            double montoPrestamo = entrada.nextDouble();

            System.out.print("Ingrese la tasa de interés anual (en decimales): ");
            double tasaInteres = entrada.nextDouble();

            System.out.print("Ingrese el plazo del préstamo en meses: ");
            int plazoPrestamo = entrada.nextInt();

            System.out.print("Ingrese el periodo de gracia en meses: ");
            int periodoGracia = entrada.nextInt();

            System.out.print("¿Desea capitalizar intereses durante el periodo de gracia? (true/false): ");
            boolean capitalizarIntereses = entrada.nextBoolean();

            return new Prestamo(montoPrestamo, tasaInteres, plazoPrestamo, cuentaVinculada, periodoGracia, capitalizarIntereses);
        } catch (InputMismatchException e) {
            entrada.nextLine(); // Limpiar entrada
            throw new IllegalArgumentException("Entrada inválida. Por favor, ingrese los valores correctamente.");
        }
    }

    public double calcularCuotaMensual() {
        double tasaMensual = tasaInteres / 12;
        if (tasaMensual <= 0) {
            throw new ArithmeticException("La tasa mensual calculada no puede ser menor o igual a cero.");
        }
        return (montoPrestamo * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -plazoPrestamo));
    }

    public void realizarPago(double cantidad, double pagoAdicional) {
        if (cantidad <= 0 || pagoAdicional < 0) {
            throw new IllegalArgumentException("El pago debe ser mayor a cero y el pago adicional no puede ser negativo.");
        }
        try {
            double totalPago = cantidad + pagoAdicional;
            double intereses = saldoRestante * (tasaInteres / 12);
            double amortizacion = totalPago - intereses;

            if (amortizacion > 0) {
                saldoRestante -= amortizacion;
                pagosRealizados++;
                System.out.println("Pago realizado: S/." + totalPago + ". Saldo restante: S/." + saldoRestante);
                verificarMora();
            } else {
                System.out.println("El pago es insuficiente para cubrir los intereses.");
            }
        } catch (Exception e) {
            System.err.println("Error al realizar el pago: " + e.getMessage());
        }
    }

    public void verificarMora() {
        try {
            if (pagosRealizados < plazoPrestamo && pagosAtrasados >= 3) {
                enMora = true;
                System.out.println("El préstamo está en mora.");
            } else {
                enMora = false;
            }
        } catch (Exception e) {
            System.err.println("Error al verificar el estado de mora: " + e.getMessage());
        }
    }

    public void penalizarMora() {
        if (enMora) {
            double penalizacion = saldoRestante * 0.05;
            saldoRestante += penalizacion;
            System.out.println("Se ha aplicado una penalización por mora de: S/." + penalizacion);
        }
    }

    public void actualizarCuentaPrestamo(CuentaHija cuenta, double montoPago) {
        if (cuenta == null) {
            throw new IllegalArgumentException("La cuenta no puede ser null.");
        }
        if (montoPago <= 0) {
            throw new IllegalArgumentException("El monto del pago debe ser mayor a cero.");
        }

        try {
            if (cuenta.getSaldoCuenta() >= montoPago) {
                cuenta.retirar(montoPago);
                realizarPago(montoPago, 0);
            } else {
                System.out.println("Saldo insuficiente en la cuenta para realizar el pago.");
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar la cuenta del préstamo: " + e.getMessage());
        }
    }

    public void mostrarDetalles() {
        try {
            System.out.println("Detalles del Préstamo:");
            System.out.println("Monto del préstamo: S/." + montoPrestamo);
            System.out.println("Tasa de interés: " + tasaInteres + "% anual");
            System.out.println("Plazo del préstamo: " + plazoPrestamo + " meses");
            System.out.println("Saldo restante: S/" + saldoRestante);
            System.out.println("Cuota mensual: S/" + cuotaMensual);
            System.out.println("Periodo de gracia: " + periodoGracia + " meses");
            System.out.println("Capitalización de intereses: " + (capitalizarIntereses ? "Sí" : "No"));
            System.out.println("Pagos realizados: " + pagosRealizados);
            System.out.println("Pagos atrasados: " + pagosAtrasados);
            System.out.println("Estado del préstamo: " + (enMora ? "En mora" : "Al día"));
        } catch (Exception e) {
            System.err.println("Error al mostrar detalles del préstamo: " + e.getMessage());
        }
    }

    public String estadoPrestamo() {
        return "Saldo pendiente: S/." + saldoRestante + " | Cuota mensual: S/." + cuotaMensual + " | Pagos realizados: " + pagosRealizados;
    }

    public boolean estaPagado() {
        return saldoRestante <= 0;
    }
}
