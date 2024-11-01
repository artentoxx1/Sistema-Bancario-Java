package Banco.SistemaBancario;
import java.util.Scanner;
public class CuentaCorriente extends CuentaBancaria{
    private double limiteSobregiro;
    private double comisionPorSobregiro;
    public CuentaCorriente(){
        super();
    }
    public CuentaCorriente(String numeroCuenta, Double saldoCuenta, Transaccion[] historialCuenta,
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
    Scanner ints=new Scanner(System.in);
    public void permitirSobregiro(double monto){
        double d;
        d=cobrarComisionPorSobregiro(monto);
        if(limiteSobregiro>d){
            if(saldoCuenta<monto && saldoCuenta>0){
                retirar(saldoCuenta);
                setLimiteSobregiro(limiteSobregiro-cobrarComisionPorSobregiro(monto-saldoCuenta));
                System.out.println("Sobregiro permitido");
            }
            else{
                setSaldoCuenta(saldoCuenta-cobrarComisionPorSobregiro(monto));
                setLimiteSobregiro(limiteSobregiro-cobrarComisionPorSobregiro(monto-saldoCuenta));
                System.out.println("Sobregiro permitido");
            }
        }
        else {
            System.out.println("Sobregiro no permitido");
        }
    }
    public double cobrarComisionPorSobregiro(double monto){
        double b;
        b=((comisionPorSobregiro*0.01)+1)*monto;
        return b;

    }
    public void consultarSobregiro(){
        System.out.println("Su sobregiro disponible es:"+getLimiteSobregiro());

    }

}
