package Banco.SistemaBancario;

public class Prestamo {
    private double montoPrestamo;
    private double tasaInteres;
    private int plazoPrestamo;
    private double saldoRestante;
    private CuentaBancaria cuentaVinculada;
    private int pagosRealizados;
    private int pagosAtrasados;
    private boolean enMora;
    private int periodoGracia;
    private boolean capitalizarIntereses;

    public Prestamo(double montoPrestamo, double tasaInteres, int plazoPrestamo, CuentaBancaria cuentaVinculada, int periodoGracia, boolean capitalizarIntereses) {
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

    // Metodo para calcular la cuota mensual, ajustado para manejar el periodo de gracia
    public double calcularCuotaMensual() {
        if (periodoGracia > 0 && !capitalizarIntereses) {
            return (montoPrestamo * (tasaInteres / 12 / 100)) / (1 - Math.pow(1 + (tasaInteres / 12 / 100), -(plazoPrestamo - periodoGracia)));
        }
        else {
            double tasaMensual = tasaInteres / 12 / 100;
            return (montoPrestamo * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -plazoPrestamo));
        }
    }

    // Metodo para calcular intereses durante el periodo de gracia
    public double calcularInteresesPeriodoGracia() {
        if (capitalizarIntereses) {
            double tasaMensual = tasaInteres / 12 / 100;
            double interesAcumulado = saldoRestante * Math.pow(1 + tasaMensual, periodoGracia) - saldoRestante;
            saldoRestante += interesAcumulado;
            System.out.println("Intereses capitalizados: S/." + interesAcumulado);
            return interesAcumulado;
        }
        return 0;
    }

    // Metodo para realizar un pago con la opción de incluir pagos adicionales
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

    // Metodo para aplicar pagos adicionales fuera del esquema regular
    public void realizarPagoAdicional(double cantidad) {
        if (cantidad <= saldoRestante) {
            saldoRestante -= cantidad;
            pagosRealizados++;
            System.out.println("Pago adicional realizado: S/." + cantidad + ". Saldo restante: S/." + saldoRestante);
        } else {
            System.out.println("El pago adicional excede el saldo restante del préstamo.");
        }
    }

    // Metodo para verificar el estado del prestamo
    public void verificarMora() {
        if (pagosAtrasados > 3) {
            enMora = true;
            System.out.println("El préstamo está en mora.");
        } else {
            enMora = false;
        }
    }

    // Metodo para aplicar penalización si el prestamo está en mora
    public void penalizarMora() {
        if (enMora) {
            double penalizacion = saldoRestante * 0.05; // Penalización del 5%
            saldoRestante += penalizacion;
            System.out.println("Se ha aplicado una penalización por mora de: S/." + penalizacion);
        }
    }

    // Metodo para calcular el interes total pagado durante la vida del prestamo
    public double calcularInteresTotal() {
        double cuotaMensual = calcularCuotaMensual();
        return (cuotaMensual * plazoPrestamo) - montoPrestamo;
    }

    // Metodo para verificar si el préstamo ha sido pagado completamente
    public boolean prestamoPagado() {
        return saldoRestante <= 0;
    }

    // Metodo para actualizar la cuenta bancaria tras realizar un pago
    public void actualizarCuentaPrestamo(CuentaBancaria cuenta, double montoPago) {
        if (cuenta.getSaldoCuenta() >= montoPago) {
            cuenta.retirar(montoPago);
            realizarPago(montoPago, 0);
        } else {
            System.out.println("Saldo insuficiente en la cuenta para realizar el pago.");
        }
    }

    // Metodo para mostrar los detalles completos del prestamo
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

    // Metodo para generar el estado actual del prestamo
    public String estadoPrestamo() {
        return "Saldo pendiente: S/." + saldoRestante + " | Cuota mensual: S/." + calcularCuotaMensual() + " | Pagos realizados: " + pagosRealizados;
    }

    // Simulacion de pago anticipado
    public void realizarPagoAnticipado(double cantidad) {
        if (cantidad > saldoRestante) {
            System.out.println("El pago anticipado excede el saldo restante del préstamo.");
        } else {
            saldoRestante -= cantidad;
            pagosRealizados++;
            System.out.println("Pago anticipado realizado: S/." + cantidad + ". Nuevo saldo restante: S/." + saldoRestante);
        }
    }

    // Metodo para renegociar el plazo del prestamo
    public void renegociarPlazo(int nuevoPlazo) {
        if (nuevoPlazo > plazoPrestamo) {
            System.out.println("El plazo del préstamo ha sido extendido a " + nuevoPlazo + " meses.");
            this.plazoPrestamo = nuevoPlazo;
        } else {
            System.out.println("El nuevo plazo debe ser mayor al actual.");
        }
    }
}
