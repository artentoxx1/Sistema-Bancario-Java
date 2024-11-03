package Banco.SistemaBancario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CuentaDepositoaPlazoFijo extends CuentaBancaria{
    private int plazo;
    private double tasaInteresPlazoFijo;
    private LocalDate fechaInicio;
    private int penalizacion;
    public CuentaDepositoaPlazoFijo(){
        super();
    }
    public CuentaDepositoaPlazoFijo(String numeroCuenta, Double saldoCuenta, Transaccion[] historialCuenta,
                                    String tipoCuenta, int plazo, double tasaInteresPlazoFijo, LocalDate fechaInicio, int penalizacion) {
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
    public void setTasaInteresPlazoFijo(double tasaInteresPlazoFijo){
        this.tasaInteresPlazoFijo = tasaInteresPlazoFijo;
    }
    public int getPenalizacion(){
        return penalizacion;
    }
    public void setPenalizacion(int penalizacion){
        this.penalizacion=penalizacion;
    }
    public double calcularInteresAlVencimiento(){
        double intereses;
        intereses=saldoCuenta*tasaInteresPlazoFijo*0.01*plazo/12;
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
    public String getFechaInicio() {
        return fechaInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
