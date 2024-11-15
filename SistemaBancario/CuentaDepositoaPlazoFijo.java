package Banco.SistemaBancario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CuentaDepositoaPlazoFijo extends CuentaBancaria implements CuentaHija {
    private int plazo; // Plazo en meses
    private double tasaInteresPlazoFijo;
    private LocalDate fechaInicio;
    private double penalizacion; // Penalización en porcentaje (0.1 significa 10%)
    private List<Transaccion> historialCuenta; // Manejo del historial de transacciones

    // Constructor por defecto
    public CuentaDepositoaPlazoFijo() {
        super();
        this.historialCuenta = new ArrayList<>();
    }

    // Constructor parametrizado
    public CuentaDepositoaPlazoFijo(String numeroCuenta, double saldoCuenta, String tipoCuenta,
                                    int plazo, double tasaInteresPlazoFijo, LocalDate fechaInicio, double penalizacion) {
        super(numeroCuenta, saldoCuenta, tipoCuenta);
        this.plazo = plazo;
        this.tasaInteresPlazoFijo = tasaInteresPlazoFijo;
        this.fechaInicio = fechaInicio;
        this.penalizacion = penalizacion;
        this.historialCuenta = new ArrayList<>();
    }

    // Getters y Setters
    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double getTasaInteresPlazoFijo() {
        return tasaInteresPlazoFijo;
    }

    public void setTasaInteresPlazoFijo(double tasaInteresPlazoFijo) {
        this.tasaInteresPlazoFijo = tasaInteresPlazoFijo;
    }

    public double getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(double penalizacion) {
        this.penalizacion = penalizacion;
    }

    public String getFechaInicio() {
        return fechaInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    // Métodos específicos
    public double calcularInteresAlVencimiento() {
        return saldoCuenta * (tasaInteresPlazoFijo / 100) * (plazo / 12.0);
    }

    public LocalDate calcularFechaVencimiento() {
        return fechaInicio.plusMonths(plazo);
    }

    public boolean haVencido() {
        return !LocalDate.now().isBefore(calcularFechaVencimiento());
    }

    public boolean permitirRetiroAnticipado() {
        return !haVencido();
    }

    public double aplicarPenalizacion(double monto) {
        return permitirRetiroAnticipado() ? monto * penalizacion : 0;
    }

    @Override
    public void retirar(double monto) {
        double penalizacionAplicada = aplicarPenalizacion(monto);
        double montoFinal = monto - penalizacionAplicada;

        if (saldoCuenta >= montoFinal) {
            saldoCuenta -= montoFinal;
            registrarTransaccion(new Transaccion("Retiro", montoFinal, new Fecha(), this, this));

            if (penalizacionAplicada > 0) {
                System.out.println("Se aplicó una penalización de: " + penalizacionAplicada);
            }

            System.out.println("Retiro exitoso. Saldo actual: " + saldoCuenta);
        } else {
            System.out.println("Fondos insuficientes para realizar el retiro.");
        }
    }

    public void depositar(double monto) {
        System.out.println("No se permiten depósitos adicionales en una cuenta a plazo fijo.");
    }

    public void registrarTransaccion(Transaccion transaccion) {
        historialCuenta.add(transaccion);
        System.out.println("Transacción registrada.");
    }

    public void mostrarHistorial() {
        for (Transaccion t : historialCuenta) {
            t.mostrarDetalles();
        }
    }
}
