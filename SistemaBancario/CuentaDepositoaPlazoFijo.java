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
        if (plazo <= 0) {
            throw new IllegalArgumentException("El plazo debe ser mayor a 0 meses.");
        }
        this.plazo = plazo;
    }

    public double getTasaInteresPlazoFijo() {
        return tasaInteresPlazoFijo;
    }

    public void setTasaInteresPlazoFijo(double tasaInteresPlazoFijo) {
        if (tasaInteresPlazoFijo < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa.");
        }
        this.tasaInteresPlazoFijo = tasaInteresPlazoFijo;
    }

    public double getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(double penalizacion) {
        if (penalizacion < 0 || penalizacion > 1) {
            throw new IllegalArgumentException("La penalización debe estar entre 0 y 1.");
        }
        this.penalizacion = penalizacion;
    }

    public String getFechaInicio() {
        if (fechaInicio == null) {
            throw new IllegalStateException("La fecha de inicio no está definida.");
        }
        return fechaInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        if (fechaInicio == null) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser nula.");
        }
        this.fechaInicio = fechaInicio;
    }

    // Métodos específicos
    public double calcularInteresAlVencimiento() {
        if (plazo <= 0 || tasaInteresPlazoFijo < 0) {
            throw new IllegalStateException("Los datos del plazo o tasa de interés no son válidos.");
        }
        return saldoCuenta * (tasaInteresPlazoFijo / 100) * (plazo / 12.0);
    }

    public LocalDate calcularFechaVencimiento() {
        if (fechaInicio == null) {
            throw new IllegalStateException("La fecha de inicio no está definida.");
        }
        return fechaInicio.plusMonths(plazo);
    }

    public boolean haVencido() {
        return !LocalDate.now().isBefore(calcularFechaVencimiento());
    }

    public boolean permitirRetiroAnticipado() {
        return !haVencido();
    }

    public double aplicarPenalizacion(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto para calcular la penalización debe ser mayor a 0.");
        }
        return permitirRetiroAnticipado() ? monto * penalizacion : 0;
    }

    @Override
    public void retirar(double monto) {
        try {
            if (monto <= 0) {
                throw new IllegalArgumentException("El monto a retirar debe ser mayor a 0.");
            }

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
                throw new IllegalStateException("Fondos insuficientes para realizar el retiro.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void depositar(double monto) {
        try {
            throw new UnsupportedOperationException("No se permiten depósitos adicionales en una cuenta a plazo fijo.");
        } catch (UnsupportedOperationException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void registrarTransaccion(Transaccion transaccion) {
        if (transaccion == null) {
            throw new IllegalArgumentException("La transacción no puede ser nula.");
        }
        historialCuenta.add(transaccion);
        System.out.println("Transacción registrada.");
    }

    public void mostrarHistorial() {
        if (historialCuenta.isEmpty()) {
            System.out.println("No hay transacciones en el historial.");
            return;
        }
        for (Transaccion t : historialCuenta) {
            t.mostrarDetalles();
        }
    }
}
