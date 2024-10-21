package Banco.SistemaBancario;

public class CuentaDepositoaPlazoFijo extends CuentaBancaria{
    private int plazo;
    private double tasaInteresPlazoFijo;
    private String fechaInicio;
    public CuentaDepositoaPlazoFijo(String numeroCuenta, double saldoCuenta,Transaccion[] historialCuenta,
                                    String tipoCuenta,int plazo,double tasaInteresPlazoFijo,String fechaInicio) {
        super(numeroCuenta,saldoCuenta,historialCuenta,tipoCuenta);
        this.plazo = plazo;
        this.tasaInteresPlazoFijo = tasaInteresPlazoFijo;
        this.fechaInicio = fechaInicio;
    }
    public int getPlazo() {
        return plazo;
    }
    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }
    public double getTasaInteresPlazoFijo() {
        return tasaInteresPlazoFijo;
    }
}
