package Banco.SistemaBancario;

public class CuentaAhorro extends CuentaBancaria {
    private double tasaInteres;
    private int limiteRetiros;
    public CuentaAhorro(String numeroCuenta, double saldoCuenta,Transaccion[] historialCuenta,
                        String tipoCuenta,double tasaInteres,int limiteRetiros) {
        super(numeroCuenta,saldoCuenta,historialCuenta,tipoCuenta);
        this.tasaInteres = tasaInteres;
        this.limiteRetiros = limiteRetiros;
    }
    public double getTasaInteres() {
        return tasaInteres;
    }
    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
    public int getLimiteRetiros() {
        return limiteRetiros;
    }
    public void setLimiteRetiros(int limiteRetiros) {
        this.limiteRetiros = limiteRetiros;
    }

}
