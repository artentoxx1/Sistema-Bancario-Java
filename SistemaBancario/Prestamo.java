package Banco.SistemaBancario;

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
    }

    public double calcularCuotaMensual() {
        double tasaMensual = tasaInteres / 12;
        return (montoPrestamo * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -plazoPrestamo));
    }

    public void realizarPago(double cantidad, double pagoAdicional) {
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
    }

    public void verificarMora() {
        if (pagosRealizados < plazoPrestamo && pagosAtrasados >= 3) {
            enMora = true;
            System.out.println("El préstamo está en mora.");
        } else {
            enMora = false;
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
        if (cuenta.getSaldoCuenta() >= montoPago) {
            cuenta.retirar(montoPago);
            realizarPago(montoPago, 0);
        } else {
            System.out.println("Saldo insuficiente en la cuenta para realizar el pago.");
        }
    }

    public void mostrarDetalles() {
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
    }

    public String estadoPrestamo() {
        return "Saldo pendiente: S/." + saldoRestante + " | Cuota mensual: S/." + cuotaMensual + " | Pagos realizados: " + pagosRealizados;
    }
}