package Banco.SistemaBancario;

public class TarjetaDeDebito extends Tarjeta {

    public TarjetaDeDebito() {
        super();
    }

    public TarjetaDeDebito(String numeroTarjetaGenerado, String claveTarjetaGenerada, CuentaAhorro cuentaAhorro, boolean estadoTarjeta) {
        super(numeroTarjetaGenerado, claveTarjetaGenerada, cuentaAhorro, estadoTarjeta);

        if (numeroTarjetaGenerado == null || numeroTarjetaGenerado.isEmpty()) {
            throw new IllegalArgumentException("El número de tarjeta no puede ser nulo o vacío.");
        }
        if (claveTarjetaGenerada == null || claveTarjetaGenerada.isEmpty()) {
            throw new IllegalArgumentException("La clave de la tarjeta no puede ser nula o vacía.");
        }
        if (cuentaAhorro == null) {
            throw new IllegalArgumentException("La cuenta vinculada no puede ser null.");
        }

        this.numeroTarjeta = numeroTarjetaGenerado;
        this.claveTarjeta = claveTarjetaGenerada;
        this.cuentaVinculada = cuentaAhorro;
    }

    public void retirarDineros(double montoR) {
        if (!estadoTarjeta) {
            throw new IllegalStateException("La tarjeta está inactiva. No se pueden realizar retiros.");
        }
        if (montoR <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a cero.");
        }
        if (cuentaVinculada == null) {
            throw new IllegalStateException("No hay una cuenta vinculada para realizar el retiro.");
        }
        try {
            cuentaVinculada.retirar(montoR);
            System.out.println("Retiro realizado con éxito: S/." + montoR);
        } catch (IllegalArgumentException e) {
            System.err.println("Error al realizar el retiro: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado al realizar el retiro: " + e.getMessage());
        }
    }

    public void mostrarSaldos() {
        if (!estadoTarjeta) {
            throw new IllegalStateException("La tarjeta está inactiva. No se puede mostrar el saldo.");
        }
        if (cuentaVinculada == null) {
            throw new IllegalStateException("No hay una cuenta vinculada para mostrar el saldo.");
        }
        try {
            cuentaVinculada.mostrarSaldo();
        } catch (Exception e) {
            System.err.println("Error al mostrar el saldo: " + e.getMessage());
        }
    }

    public void mostrarEstadoCuenta() {
        if (!estadoTarjeta) {
            throw new IllegalStateException("La tarjeta está inactiva. No se puede mostrar el estado de la cuenta.");
        }
        if (cuentaVinculada == null) {
            throw new IllegalStateException("No hay una cuenta vinculada para mostrar el estado.");
        }
        try {
            System.out.println("Numero de tarjeta: " + numeroTarjeta);
            System.out.println("Clave: " + claveTarjeta);
            System.out.println("Saldo: " + cuentaVinculada.getSaldoCuenta());
            System.out.println("Numero de cuenta: " + cuentaVinculada.getNumeroCuenta());
            System.out.println("Cuenta Vinculada: " + cuentaVinculada);
        } catch (Exception e) {
            System.err.println("Error al mostrar el estado de la cuenta: " + e.getMessage());
        }
    }
}
