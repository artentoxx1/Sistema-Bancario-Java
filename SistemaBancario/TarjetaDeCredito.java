package Banco.SistemaBancario;

import java.time.LocalDate;

public class TarjetaDeCredito extends Tarjeta {
    private String numeroTarjeta;
    private String claveTarjeta;
    private double limiteTarjeta;
    private double deudaActual;
    private double saldoDisponible;
    private LocalDate fechaPagoDeuda;

    public TarjetaDeCredito() {
        super();
    }

    public TarjetaDeCredito(String numeroTarjeta, String claveTarjeta, double limiteTarjeta, double deudaActual,
                            double saldoDisponible, LocalDate fechaPagoDeuda, CuentaBancaria cuentaVinculada, boolean estadoTarjeta) {
        super(numeroTarjeta, claveTarjeta, cuentaVinculada, estadoTarjeta);

        if (numeroTarjeta == null || numeroTarjeta.isEmpty()) {
            throw new IllegalArgumentException("El número de tarjeta no puede ser nulo o vacío.");
        }
        if (claveTarjeta == null || claveTarjeta.isEmpty()) {
            throw new IllegalArgumentException("La clave de la tarjeta no puede ser nula o vacía.");
        }
        if (limiteTarjeta <= 0) {
            throw new IllegalArgumentException("El límite de crédito debe ser mayor que cero.");
        }
        if (deudaActual < 0) {
            throw new IllegalArgumentException("La deuda actual no puede ser negativa.");
        }
        if (saldoDisponible < 0) {
            throw new IllegalArgumentException("El saldo disponible no puede ser negativo.");
        }
        if (fechaPagoDeuda == null) {
            throw new IllegalArgumentException("La fecha de pago no puede ser nula.");
        }

        this.numeroTarjeta = numeroTarjeta;
        this.claveTarjeta = claveTarjeta;
        this.limiteTarjeta = limiteTarjeta;
        this.deudaActual = deudaActual;
        this.saldoDisponible = saldoDisponible;
        this.fechaPagoDeuda = fechaPagoDeuda;
    }

    public void pagarTarjeta(double monto, CuentaBancaria cuenta) {
        if (!estadoTarjeta) {
            throw new IllegalStateException("La tarjeta está inactiva. No se pueden realizar pagos.");
        }
        if (cuenta == null) {
            throw new IllegalArgumentException("La cuenta asociada no puede ser nula.");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a pagar debe ser mayor que cero.");
        }
        if (monto > cuenta.getSaldoCuenta()) {
            throw new IllegalStateException("Saldo insuficiente en la cuenta para realizar el pago.");
        }

        try {
            if ((deudaActual - monto) <= 0) {
                double vuelto = monto - deudaActual;
                deudaActual = 0;
                System.out.println("Devolviendo el vuelto: S/." + vuelto);
            } else {
                deudaActual -= monto;
                System.out.println("Deuda faltante: S/." + deudaActual);
            }
        } catch (Exception e) {
            System.err.println("Error al realizar el pago: " + e.getMessage());
        }
    }

    public void mostrarEstadoCuenta() {
        if (!estadoTarjeta) {
            throw new IllegalStateException("La tarjeta está inactiva. No se puede mostrar el estado de la cuenta.");
        }

        try {
            System.out.println("Limite de crédito: S/." + limiteTarjeta);
            System.out.println("Deuda: S/." + deudaActual);
            System.out.println("Saldo disponible: S/." + saldoDisponible);
            System.out.println("Fecha de pago: " + fechaPagoDeuda);
            System.out.println("Cuenta Vinculada: " + cuentaVinculada);
        } catch (Exception e) {
            System.err.println("Error al mostrar el estado de la cuenta: " + e.getMessage());
        }
    }

    public void aumentarLimiteCredito(double nuevoLimite) {
        if (nuevoLimite <= 0) {
            throw new IllegalArgumentException("El nuevo límite debe ser mayor que cero.");
        }
        try {
            limiteTarjeta += nuevoLimite;
            System.out.println("Nuevo límite de crédito: S/." + limiteTarjeta);
        } catch (Exception e) {
            System.err.println("Error al aumentar el límite de crédito: " + e.getMessage());
        }
    }
}
