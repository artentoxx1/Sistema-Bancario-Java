package Banco.SistemaBancario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public class CuentaDepositoaPlazoFijo extends CuentaBancaria{
    private int plazo;
    private double tasaInteresPlazoFijo;
    private LocalDate fechaInicio;
    private int penalizacion;
    public CuentaDepositoaPlazoFijo(String numeroCuenta, double saldoCuenta,Transaccion[] historialCuenta,
                                    String tipoCuenta,int plazo,double tasaInteresPlazoFijo,LocalDate fechaInicio, int penalizacion) {
        super(numeroCuenta,saldoCuenta,historialCuenta,tipoCuenta);
        this.plazo = plazo;
        this.tasaInteresPlazoFijo = tasaInteresPlazoFijo;
        this.fechaInicio = fechaInicio;
        this.penalizacion=penalizacion;
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

    public double calcularInteresAlVencimiento(){
        double intereses;
        intereses=saldoCuenta*tasaInteresPlazoFijo*plazo*0.01*(1/12);
        return intereses;
    }
    public LocalDate calcularFechaVencimiento() {
        return fechaInicio.plusMonths(plazo);
    }

    public boolean haVencido() {
        LocalDate fechaVencimiento = calcularFechaVencimiento();
        LocalDate fechaActual = LocalDate.now();
        // Compara la fecha actual con la fecha de vencimiento
        return !fechaActual.isBefore(fechaVencimiento);  // Si ya pasó la fecha de vencimiento, retorna true
    }

    public boolean permitirRetiroAnticipado() {
        return !haVencido();  // Solo permitimos retiros anticipados si aún no ha vencido el plazo
    }

    public double aplicarPenalizacion(double monto) {
        if (permitirRetiroAnticipado()) {
            return monto * penalizacion;
        }
        return 0;  // Sin penalización si no es retiro anticipado
    }

    public String obtenerFechaInicio() {
        return fechaInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }


}
