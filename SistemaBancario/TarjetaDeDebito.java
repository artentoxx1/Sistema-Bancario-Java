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
}
