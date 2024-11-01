package Banco.SistemaBancario;

public class CuentaAhorro extends CuentaBancaria {
    private double tasaInteres;
    private int limiteRetiros;

    public CuentaAhorro(){
        super();
    }
    public CuentaAhorro(String numeroCuenta, Double saldoCuenta, Transaccion[] historialCuenta,
                        String tipoCuenta, double tasaInteres, int limiteRetiros) {
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

    public double calcularIntereses(){
        double b;
        b=tasaInteres*0.01*saldoCuenta;
        return b;
    }
    public boolean permitirRetiro(){

        boolean b = false;
        if(limiteRetiros>0){
            b=true;
            limiteRetiros--;
            return b;
        }
        else{
            return b;
        }
    }

}
