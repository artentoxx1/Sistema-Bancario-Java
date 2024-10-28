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
    public static String generarNumeroTarjeta() {
        return String.format("%016d", (long) (Math.random() * 1_000_000_000_000_000L));
    }
    public static String generarClaveTarjeta() {
        return String.format("%04d", (int) (Math.random() * 10000));
    }
}
