package Banco.SistemaBancario;

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
    }

    public double getMontoPrestamo() {
        return montoPrestamo;
    }

    public void setMontoPrestamo(double montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public int getPlazoPrestamo() {
        return plazoPrestamo;
    }

    public void setPlazoPrestamo(int plazoPrestamo) {
        this.plazoPrestamo = plazoPrestamo;
    }

    public double getSaldoRestante() {
        return saldoRestante;
    }

    public int getPagosAtrasados() {
        return pagosAtrasados;
    }

    public void setPagosAtrasados(int pagosAtrasados) {
        this.pagosAtrasados = pagosAtrasados;
    }

    public int getPeriodoGracia() {
        return periodoGracia;
    }

    public void setPeriodoGracia(int periodoGracia) {
        this.periodoGracia = periodoGracia;
    }

    public boolean getCapitalizarIntereses() {
        return capitalizarIntereses;
    }

    public void setCapitalizarIntereses(boolean capitalizarIntereses) {
        this.capitalizarIntereses = capitalizarIntereses;
    }

    public double calcularCuotaMensual() {
        double tasaMensual = tasaInteres / 12;
        if (periodoGracia > 0 && !capitalizarIntereses) {
            return (montoPrestamo * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -(plazoPrestamo - periodoGracia)));
        } else {
            return (montoPrestamo * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -plazoPrestamo));
        }
    }

    public double calcularInteresesPeriodoGracia() {
        if (capitalizarIntereses) {
            double tasaMensual = tasaInteres / 12;
            double interesAcumulado = saldoRestante * Math.pow(1 + tasaMensual, periodoGracia) - saldoRestante;
            saldoRestante += interesAcumulado;
            System.out.println("Intereses capitalizados: S/." + interesAcumulado);
            return interesAcumulado;
        }
        return 0;
    }

    public void realizarPago(double cantidad, double pagoAdicional) {
        double totalPago = cantidad + pagoAdicional;
        if (totalPago <= saldoRestante) {
            saldoRestante -= totalPago;
            pagosRealizados++;
            System.out.println("Pago realizado: S/." + totalPago + ". Saldo restante: S/." + saldoRestante);
            verificarMora();
        } else {
            System.out.println("El pago excede el saldo restante del préstamo.");
        }
    }

    public void realizarPagoAdicional(double cantidad) {
        if (cantidad <= saldoRestante) {
            saldoRestante -= cantidad;
            pagosRealizados++;
            System.out.println("Pago adicional realizado: S/." + cantidad + ". Saldo restante: S/." + saldoRestante);
        } else {
            System.out.println("El pago adicional excede el saldo restante del préstamo.");
        }
    }

    public void verificarMora() {
        if (pagosAtrasados > 3) {
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

    public double calcularInteresTotal() {
        double cuotaMensual = calcularCuotaMensual();
        return (cuotaMensual * plazoPrestamo) - montoPrestamo;
    }

    public boolean prestamoPagado() {
        return saldoRestante <= 0;
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
        System.out.println("Monto del préstamo: $" + montoPrestamo);
        System.out.println("Tasa de interés: " + tasaInteres + "% anual");
        System.out.println("Plazo del préstamo: " + plazoPrestamo + " meses");
        System.out.println("Saldo restante: $" + saldoRestante);
        System.out.println("Cuota mensual: $" + calcularCuotaMensual());
        System.out.println("Periodo de gracia: " + periodoGracia + " meses");
        System.out.println("Capitalización de intereses: " + (capitalizarIntereses ? "Sí" : "No"));
        System.out.println("Pagos realizados: " + pagosRealizados);
        System.out.println("Pagos atrasados: " + pagosAtrasados);
        System.out.println("Estado del préstamo: " + (enMora ? "En mora" : "Al día"));
    }

    public String estadoPrestamo() {
        return "Saldo pendiente: S/." + saldoRestante + " | Cuota mensual: S/." + calcularCuotaMensual() + " | Pagos realizados: " + pagosRealizados;
    }

    public void renegociarPlazo(int nuevoPlazo) {
        if (nuevoPlazo > plazoPrestamo) {
            System.out.println("El plazo del préstamo ha sido extendido a " + nuevoPlazo + " meses.");
            this.plazoPrestamo = nuevoPlazo;
        } else {
            System.out.println("El nuevo plazo debe ser mayor al actual.");
        }
    }
}