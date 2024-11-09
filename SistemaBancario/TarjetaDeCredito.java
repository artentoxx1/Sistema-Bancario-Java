package Banco.SistemaBancario;
import java.time.LocalDate;
public class TarjetaDeCredito extends Tarjeta{
    private String numeroTarjeta;
    private String claveTarjeta;
    private double limiteTarjeta;
    private double deudaActual;
    private double saldoDisponible;
    private LocalDate fechaPagoDeuda;

    public TarjetaDeCredito(){
        super();
    }
    public TarjetaDeCredito(String numeroTarjeta,String claveTarjeta, double limiteTarjeta, double deudaActual,
                            double saldoDisponible, LocalDate fechaPagoDeuda, CuentaBancaria cuentaVinculada, boolean estadoTarjeta) {
        super(numeroTarjeta,claveTarjeta, cuentaVinculada, estadoTarjeta);
        this.numeroTarjeta = numeroTarjeta;
        this.claveTarjeta = claveTarjeta;
        this.limiteTarjeta = limiteTarjeta;
        this.deudaActual = deudaActual;
        this.saldoDisponible = saldoDisponible;
        this.fechaPagoDeuda = fechaPagoDeuda;

    }
    public void pagarTarjeta(double monto,CuentaBancaria cuenta) {
        if ((deudaActual-monto)<=0){
            System.out.println("Devolviendo el vuelto: ");
            System.out.println("Vuelto: "+(monto-deudaActual));
            deudaActual = 0;
        }else{
            System.out.println("Deuda faltante: " + (deudaActual-monto));
            deudaActual = deudaActual-monto;
        }
    }
    public void mostrarEstadoCuenta(){
        System.out.println("Limite de credito: " + limiteTarjeta);
        System.out.println("Deuda: " + deudaActual);
        System.out.println("Saldo: " + saldoDisponible);
        System.out.println("Fecha: " + fechaPagoDeuda);
        System.out.println("Cuenta Vinculada: " + cuentaVinculada);
    }
    public void aumentarLimiteCredito(double nuevoLimite){
        limiteTarjeta = limiteTarjeta+nuevoLimite;
        System.out.println("Limite de credito: " + limiteTarjeta);
    }
}
