package Banco.SistemaBancario;

public class Tarjeta {
    protected String numeroTarjeta;
    protected String claveTarjeta;
    protected CuentaBancaria cuentaVinculada;
    public Tarjeta(String numeroTarjeta, String claveTarjeta, CuentaBancaria Cuenta) {
        this.numeroTarjeta = numeroTarjeta;
        this.claveTarjeta = claveTarjeta;
        this.cuentaVinculada=Cuenta;
    }
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    public String getClaveTarjeta() {
        return claveTarjeta;
    }
    public void setClaveTarjeta(String claveTarjeta) {
        this.claveTarjeta = claveTarjeta;
    }
    public CuentaBancaria getCuentaVinculada() {
        return cuentaVinculada;
    }

    public void setCuentaVinculada(CuentaBancaria cuentaVinculada) {
        this.cuentaVinculada = cuentaVinculada;
    }
}