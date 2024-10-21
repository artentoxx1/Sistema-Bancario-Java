package Banco.SistemaBancario;

public class CuentaCorriente extends CuentaBancaria{
    private double limiteSobregiro;
    private double comisionPorSobregiro;
    public CuentaCorriente(String numeroCuenta, double saldoCuenta,Transaccion[] historialCuenta,
                           String tipoCuenta, double limiteSobregiro, double comisionPorSobregiro) {
        super(numeroCuenta, saldoCuenta, historialCuenta, tipoCuenta);
        this.limiteSobregiro = limiteSobregiro;
        this.comisionPorSobregiro = comisionPorSobregiro;
    }
    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }
    public void setLimiteSobregiro(double limiteSobregiro) {
        this.limiteSobregiro = limiteSobregiro;
    }
    public double getComisionPorSobregiro() {
        return comisionPorSobregiro;
    }
    public void setComisionPorSobregiro(double comisionPorSobregiro) {
        this.comisionPorSobregiro = comisionPorSobregiro;
    }
}
