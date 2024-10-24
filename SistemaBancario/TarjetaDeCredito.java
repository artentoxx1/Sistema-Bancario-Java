package Banco.SistemaBancario;

public class TarjetaDeCredito extends Tarjeta{
    private double limiteCredito;
    private double deudaActual;
    private double saldoDisponible;
    private Fecha fechaPagoDeuda;

    public TarjetaDeCredito(String numeroTarjeta, String claveTarjeta,CuentaBancaria cuentaVinculada,
                            double limiteCredito, double deudaActual, double saldoDisponible, Fecha fechaPagoDeuda) {
        super(numeroTarjeta, claveTarjeta, cuentaVinculada);
        this.limiteCredito = limiteCredito;
        this.deudaActual = deudaActual;
        this.saldoDisponible = saldoDisponible;
        this.fechaPagoDeuda = fechaPagoDeuda;
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
    public double getLimiteCredito(){
        return limiteCredito;
    }
    public void setLimiteCredito(double limiteCredito){
        this.limiteCredito = limiteCredito;
    }
    public double getDeudaActual(){
        return deudaActual;
    }
    public void setDeudaActual(double deudaActual){
        this.deudaActual = deudaActual;
    }
    public double getSaldoDisponible(){
        return saldoDisponible;
    }
    public void setSaldoDisponible(double saldoDisponible){
        this.saldoDisponible = saldoDisponible;
    }
    public Fecha getFechaPagoDeuda(){
        return fechaPagoDeuda;
    }
    public void setFechaPagoDeuda(Fecha fechaPagoDeuda){
        this.fechaPagoDeuda = fechaPagoDeuda;
    }
    public static String generarNumeroTarjeta() {
        return String.format("%016d", (long) (Math.random() * 1_000_000_000_000_000L));
    }
    public static String generarClaveTarjeta() {
        return String.format("%04d", (int) (Math.random() * 10000));
    }
}
