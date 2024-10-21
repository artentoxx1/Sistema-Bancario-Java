package Banco.SistemaBancario;

public class Cliente {
    private String nombresCliente;
    private String apellidoPaternoCliente;
    private String apellidoMaternoCliente;
    private String sexoCliente;
    private String dniCliente;
    private String telefonoCliente;
    private String correoCliente;
    private String ocupacionCliente;
    private String profesionCliente;
    private String estadoCivilCliente;
    private String cargaFamiliarCliente;
    private String direccionCliente;
    private String codigoUbigeoCliente;
    private CuentaAhorro cuentaAhorros;
    private CuentaCorriente cuentaCorriente;
    private CuentaDepositoaPlazoFijo cuentaDepositoPlazoFijo;
    private double liquidezFinanciera;

    public Cliente(){
    }
    public Cliente(String nombresCliente,String apellidoMaternoCliente,String apellidoPaternoCliente,
                   String sexoCliente,String dniCliente,String telefonoCliente, String correoCliente,
                   String ocupacionCliente, String profesionCliente, String estadoCivilCliente,String cargaFamiliarClient,
                   String  direccionCliente,String codigoUbigeoCliente,CuentaAhorro cuentaAhorros,
                   CuentaCorriente cuentaCorriente, CuentaDepositoaPlazoFijo cuentaDepositoPlazoFijo,double liquidezFinanciera) {
        this.nombresCliente = nombresCliente;
        this.apellidoPaternoCliente = apellidoPaternoCliente;
        this.apellidoMaternoCliente = apellidoMaternoCliente;
        this.sexoCliente = sexoCliente;
        this.dniCliente = dniCliente;
        this.telefonoCliente = telefonoCliente;
        this.correoCliente = correoCliente;
        this.ocupacionCliente = ocupacionCliente;
        this.profesionCliente = profesionCliente;
        this.estadoCivilCliente = estadoCivilCliente;
        this.cargaFamiliarCliente = cargaFamiliarClient;
        this.direccionCliente = direccionCliente;
        this.codigoUbigeoCliente = codigoUbigeoCliente;
        this.cuentaAhorros = cuentaAhorros;
        this.cuentaCorriente = cuentaCorriente;
        this.cuentaDepositoPlazoFijo = cuentaDepositoPlazoFijo;
        this.liquidezFinanciera = liquidezFinanciera;
    }
    public String getNombresCliente() {
        return nombresCliente;
    }
    public void setNombresCliente(String nombresCliente) {
        this.nombresCliente = nombresCliente;
    }
    public String getApellidoPaternoCliente() {
        return apellidoPaternoCliente;
    }
    public void setApellidoPaternoCliente(String apellidoPaternoCliente) {
        this.apellidoPaternoCliente = apellidoPaternoCliente;
    }
    public String getApellidoMaternoCliente() {
        return apellidoMaternoCliente;
    }
    public void setApellidoMaternoCliente(String apellidoMaternoCliente) {
        this.apellidoMaternoCliente = apellidoMaternoCliente;
    }
    public String getSexoCliente() {
        return sexoCliente;
    }
    public void setSexoCliente(String sexoCliente) {
        this.sexoCliente = sexoCliente;
    }
    public String getDniCliente() {
        return dniCliente;
    }
    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }
    public String getTelefonoCliente() {
        return telefonoCliente;
    }
    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
    public String getCorreoCliente() {
        return correoCliente;
    }
    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }
    public String getOcupacionCliente() {
        return ocupacionCliente;
    }
    public void setOcupacionCliente(String ocupacionCliente) {
        this.ocupacionCliente = ocupacionCliente;
    }
    public String getProfesionCliente() {
        return profesionCliente;
    }
    public void setProfesionCliente(String profesionCliente) {
        this.profesionCliente = profesionCliente;
    }
    public String getEstadoCivilCliente() {
        return estadoCivilCliente;
    }
    public void setEstadoCivilCliente(String estadoCivilCliente) {
        this.estadoCivilCliente = estadoCivilCliente;
    }
    public String getCargaFamiliarCliente() {
        return cargaFamiliarCliente;

    }
    public void setCargaFamiliarCliente(String cargaFamiliarCliente) {
        this.cargaFamiliarCliente = cargaFamiliarCliente;

    }
    public String getDireccionCliente() {
        return direccionCliente;
    }
    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }
    public String getCodigoUbigeoCliente() {
        return codigoUbigeoCliente;
    }
    public void setCodigoUbigeoCliente(String codigoUbigeoCliente) {
        this.codigoUbigeoCliente = codigoUbigeoCliente;
    }
    public CuentaAhorro getCuentaAhorros() {
        return cuentaAhorros;
    }
    public void setCuentaAhorros(CuentaAhorro cuentaAhorros) {
        this.cuentaAhorros = cuentaAhorros;
    }
    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }
    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }
    public CuentaDepositoaPlazoFijo getCuentaDepositoPlazoFijo() {
        return cuentaDepositoPlazoFijo;
    }
    public void setCuentaDepositoPlazoFijo(CuentaDepositoaPlazoFijo cuentaDepositoPlazoFijo) {
        this.cuentaDepositoPlazoFijo = cuentaDepositoPlazoFijo;
    }
    public void depositarCuenta(int tipoCuenta,double cantidadDeposito,String numeroCuenta){
        switch(tipoCuenta){
            case 1:
                if(cuentaAhorros.numeroCuenta.equals(numeroCuenta)){
                    cuentaAhorros.saldoCuenta= cuentaAhorros.saldoCuenta + cantidadDeposito;
                    System.out.println("Saldo añadido a la cuenta " + numeroCuenta);
                    System.out.println("Nuevo saldo: "+ cuentaAhorros.saldoCuenta);
                }
                else{
                    System.out.println("Error...");
                }
                break;
            case 2:
                if(cuentaCorriente.numeroCuenta.equals(numeroCuenta)){
                    cuentaCorriente.saldoCuenta=cuentaCorriente.saldoCuenta + cantidadDeposito;
                    System.out.println("Saldo añadido a la cuenta " + numeroCuenta);
                    System.out.println("Nuevo saldo: "+ cuentaCorriente.saldoCuenta);
                }
                else{
                    System.out.println("Error...");
                }
                break;
            case 3:
                if(cuentaDepositoPlazoFijo.numeroCuenta.equals(numeroCuenta)){
                    cuentaDepositoPlazoFijo.saldoCuenta = cuentaDepositoPlazoFijo.saldoCuenta + cantidadDeposito;
                    System.out.println("Saldo añadido a la cuenta " + numeroCuenta);
                    System.out.println("Nuevo saldo: "+ cuentaCorriente.saldoCuenta);
                }
                else{
                    System.out.println("Error...");
                }
                break;
            default:
                System.out.println("Digite una opcion correcta.");
        }
    }
    public void retirarCuenta(double cantidadRetiro,String contraseniaTarjeta){

    }
    public void sacarTarjetaCredito(){

    }
    public void sacarTarjetaDebito(){

    }
    public void hacerPrestamo(){

    }
    public void hacerInversion(){

    }
    public void pagosServicios(){

    }
}
