package Banco.SistemaBancario;

public class Tarjeta {
    protected String numeroTarjeta;
    protected String claveTarjeta;
    protected CuentaBancaria cuentaVinculada;
    protected boolean estadoTarjeta = true;

    public Tarjeta() {
    }

    public Tarjeta(String numeroTarjeta, String claveTarjeta, CuentaBancaria cuentaVinculada, boolean estadoTarjeta) {
        if (numeroTarjeta == null || numeroTarjeta.length() != 16) {
            throw new IllegalArgumentException("El número de tarjeta debe ser válido y tener 16 dígitos.");
        }
        if (claveTarjeta == null || claveTarjeta.length() != 4) {
            throw new IllegalArgumentException("La clave de la tarjeta debe ser válida y tener 4 dígitos.");
        }
        if (cuentaVinculada == null) {
            throw new IllegalArgumentException("La cuenta vinculada no puede ser nula.");
        }

        this.numeroTarjeta = numeroTarjeta;
        this.claveTarjeta = claveTarjeta;
        this.cuentaVinculada = cuentaVinculada;
        this.estadoTarjeta = estadoTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        if (numeroTarjeta == null || numeroTarjeta.length() != 16) {
            throw new IllegalArgumentException("El número de tarjeta debe ser válido y tener 16 dígitos.");
        }
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getClaveTarjeta() {
        return claveTarjeta;
    }

    public void setClaveTarjeta(String claveTarjeta) {
        if (claveTarjeta == null || claveTarjeta.length() != 4) {
            throw new IllegalArgumentException("La clave de la tarjeta debe ser válida y tener 4 dígitos.");
        }
        this.claveTarjeta = claveTarjeta;
    }

    public CuentaBancaria getCuentaVinculada() {
        return cuentaVinculada;
    }

    public void setCuentaVinculada(CuentaBancaria cuentaVinculada) {
        if (cuentaVinculada == null) {
            throw new IllegalArgumentException("La cuenta vinculada no puede ser nula.");
        }
        this.cuentaVinculada = cuentaVinculada;
    }

    public boolean getEstadoTarjeta() {
        return estadoTarjeta;
    }

    public void setEstadoTarjeta(boolean estadoTarjeta) {
        this.estadoTarjeta = estadoTarjeta;
    }

    public static String generarNumeroTarjeta() {
        try {
            StringBuilder numeroTarjeta = new StringBuilder();
            for (int i = 0; i < 16; i++) {
                int digito = (int) (Math.random() * 10);
                numeroTarjeta.append(digito);
            }
            return numeroTarjeta.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error al generar el número de tarjeta: " + e.getMessage());
        }
    }

    public static String generarClaveTarjeta() {
        try {
            StringBuilder claveTarjeta = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                int digito = (int) (Math.random() * 10);
                claveTarjeta.append(digito);
            }
            return claveTarjeta.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error al generar la clave de la tarjeta: " + e.getMessage());
        }
    }

    public void bloquearTarjeta() {
        if (!estadoTarjeta) {
            throw new IllegalStateException("La tarjeta ya está bloqueada.");
        }
        estadoTarjeta = false;
    }
}
