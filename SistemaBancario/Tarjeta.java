package Banco.SistemaBancario;

public class Tarjeta {
    protected String numeroTarjeta;
    protected String claveTarjeta;
    protected CuentaBancaria cuentaVinculada;
    public Tarjeta(String numeroTarjeta, String claveTarjeta,CuentaBancaria cuentaVinculada) {
        this.numeroTarjeta = numeroTarjeta;
        this.claveTarjeta = claveTarjeta;
        this.cuentaVinculada = null;
    }
}
