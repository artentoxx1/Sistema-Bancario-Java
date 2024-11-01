package Banco.SistemaBancario;

public class Tarjeta {
    protected String numeroTarjeta;
    protected String claveTarjeta;
    protected CuentaBancaria cuentaVinculada;
    protected boolean estadoTarjeta = true;

    public Tarjeta(){

    }

    public Tarjeta(String numeroTarjeta, String claveTarjeta, CuentaBancaria Cuenta, boolean estadoTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
        this.claveTarjeta = claveTarjeta;
        this.cuentaVinculada=Cuenta;
        this.estadoTarjeta =estadoTarjeta;
    }
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    public String getClaveTarjeta() {
        return claveTarjeta;
    }
    public void setClaveTarjeta(String claveTarjeta) {
        this.claveTarjeta = claveTarjeta;
    }
    public CuentaBancaria getCuentaVinculada() {
        return cuentaVinculada;
    }
    public void setCuentaVinculada(CuentaBancaria cuentaVinculada) {
        this.cuentaVinculada = cuentaVinculada;
    }
    public boolean getEstadoTarjeta() {
        return estadoTarjeta;
    }
    public void setEstadoTarjeta(boolean estadoTarjeta) {
        this.estadoTarjeta = estadoTarjeta;
    }
    public static String generarNumeroTarjeta(){
        String numeroTarjeta = "";

        // Generar 16 dígitos y concatenarlos
        for (int i = 0; i < 16; i++) {
            int digito = (int) (Math.random() * 10); // Genera un número entre 0 y 9
            numeroTarjeta += digito; // Concatenar el dígito a la cadena
        }

        return numeroTarjeta;
    }
    public static String generarClaveTarjeta(){
        String claveTarjeta = "";

        // Generar 4 dígitos y concatenarlos
        for (int i = 0; i < 4; i++) {
            int digito = (int) (Math.random() * 10); // Genera un número entre 0 y 9
            claveTarjeta += digito; // Concatenar el dígito a la cadena
        }
        return claveTarjeta;
    }
    public void bloquearTarjeta(){
        estadoTarjeta = false;
    }
}