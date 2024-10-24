package Banco.SistemaBancario;

public class TarjetaDeDebito extends  Tarjeta{
    public TarjetaDeDebito(String numeroTarjeta, String claveTarjeta,CuentaBancaria cuentaVinculada){
        super(numeroTarjeta, claveTarjeta, cuentaVinculada);
    }
    public String getNumeroTarjeta(){
        return numeroTarjeta;
    }
    public String getClaveTarjeta(){
        return claveTarjeta;
    }
    public CuentaBancaria getCuentaVinculada(){
        return cuentaVinculada;
    }
    public void setNumeroTarjeta(String numeroTarjeta){
        this.numeroTarjeta = numeroTarjeta;
    }
    public void setClaveTarjeta(String claveTarjeta){
        this.claveTarjeta = claveTarjeta;
    }
    public void setCuentaVinculada(CuentaBancaria cuentaVinculada){
        this.cuentaVinculada = cuentaVinculada;
    }
    public static String generarNumeroTarjeta() {
        return String.format("%016d", (long) (Math.random() * 1_000_000_000_000_000L));
    }
    public static String generarClaveTarjeta() {
        return String.format("%04d", (int) (Math.random() * 10000));
    }
}
