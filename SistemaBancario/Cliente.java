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
    private CuentaBancaria cuentaCliente;
    private double liquidezFinanciera;

    public Cliente(){
    }
    public Cliente(String nombresCliente,String apellidoMaternoCliente,String apellidoPaternoCliente,
                   String sexoCliente,String dniCliente,String telefonoCliente, String correoCliente,
                   String ocupacionCliente, String profesionCliente, String estadoCivilCliente,String cargaFamiliarClient,
                   String  direccionCliente,String codigoUbigeoCliente,CuentaBancaria cuentaCliente,double liquidezFinanciera) {
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
        this.cuentaCliente = cuentaCliente;
        this.liquidezFinanciera = liquidezFinanciera;

    }
    public void buscarCliente(String dato){

    }
    public void depositarCuenta(String dni,double cantidadDeposito,String numeroCuenta){

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
