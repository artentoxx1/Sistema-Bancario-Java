package Banco.SistemaBancario;

public class Cliente extends Persona {

    private String correoCliente;
    private String profesionCliente;
    private String cargaFamiliarCliente;
    private String direccionCliente;
    private CuentaAhorro cuentaAhorros;
    private CuentaCorriente cuentaCorriente;
    private CuentaDepositoaPlazoFijo cuentaDepositoPlazoFijo;
    private TarjetaDeDebito tarjetaDeDebito;
    private TarjetaDeCredito tarjetaDeCredito;
    private double liquidezFinanciera;

    public Cliente() {
        super();
        correoCliente = "";
        profesionCliente = "";
        cargaFamiliarCliente = "";
        direccionCliente = "";
        cuentaAhorros = null;
        cuentaCorriente = null;
        cuentaDepositoPlazoFijo = null;
        tarjetaDeDebito = null;
        tarjetaDeCredito = null;
        liquidezFinanciera = 0;
    }

    public Cliente(String nombres, String apellidoMaterno, String apellidoPaterno,
                   String sexo, String dni, String telefono, String correoCliente,
                   String profesionCliente, String cargaFamiliarClient,
                   String direccionCliente, CuentaAhorro cuentaAhorros,
                   CuentaCorriente cuentaCorriente, CuentaDepositoaPlazoFijo cuentaDepositoPlazoFijo,
                   TarjetaDeDebito tarjetaDeDebito, TarjetaDeCredito tarjetaDeCredito, double liquidezFinanciera){
        super(nombres, apellidoPaterno,apellidoMaterno,sexo,dni,telefono);
        this.correoCliente = correoCliente;
        this.profesionCliente = profesionCliente;
        this.cargaFamiliarCliente = cargaFamiliarClient;
        this.direccionCliente = direccionCliente;
        this.cuentaAhorros = cuentaAhorros;
        this.cuentaCorriente = cuentaCorriente;
        this.cuentaDepositoPlazoFijo = cuentaDepositoPlazoFijo;
        this.tarjetaDeDebito = tarjetaDeDebito;
        this.tarjetaDeCredito = tarjetaDeCredito;
        this.liquidezFinanciera = liquidezFinanciera;
    }

    public String getNombres(){
        return nombres;
    }
    public void setNombres(String nombres){
        this.nombres=nombres;
    }
    public String getApellidoPaterno(){
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno){
        this.apellidoPaterno=apellidoPaterno;
    }
    public String getApellidoMaterno(){
        return apellidoMaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno){
        this.apellidoPaterno=apellidoMaterno;
    }
    public String getSexo(){
        return sexo;
    }
    public void setSexo(String sexo){
        this.sexo=sexo;
    }
    public String getDni(){
        return dni;
    }
    public void setDni(String dni){
        this.dni=dni;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    public String getCorreoCliente() {
        return correoCliente;
    }
    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }
    public String getProfesionCliente() {
        return profesionCliente;
    }
    public void setProfesionCliente(String profesionCliente) {
        this.profesionCliente = profesionCliente;
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
    public TarjetaDeDebito getTarjetaDeDebito() {
        return tarjetaDeDebito;
    }
    public void setTarjetaDeDebito(TarjetaDeDebito tarjetaDeDebito) {
        this.tarjetaDeDebito = tarjetaDeDebito;
    }
    public TarjetaDeCredito getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }
    public void setTarjetaDeCredito(TarjetaDeCredito tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
    }
    public double getLiquidezFinanciera() {
        return liquidezFinanciera;
    }
    public void setLiquidezFinanciera(double liquidezFinanciera) {
        this.liquidezFinanciera = liquidezFinanciera;
    }
    public void depositarCuenta(int tipoCuenta, double cantidadDeposito, String numeroCuenta) {
        switch (tipoCuenta) {
            case 1:
                //Cuenta Ahorro
                if (cuentaAhorros.numeroCuenta.equals(numeroCuenta)) {
                    if (cantidadDeposito > 0) {
                        cuentaAhorros.depositar(cantidadDeposito);
                        System.out.println("Nuevo saldo: " + cuentaAhorros.saldoCuenta);
                    } else {
                        System.out.println("Cantidad a depositar inválida. Por favor coloque otra cantidad.");
                    }
                } else {
                    System.out.println("Error. Numero de cuenta incorrecto");
                }
                break;
            case 2:
                //Cuenta Corriente
                if (cuentaCorriente.numeroCuenta.equals(numeroCuenta)) {
                    if (cantidadDeposito > 0) {
                        cuentaCorriente.depositar(cantidadDeposito);
                        System.out.println("Nuevo saldo: " + cuentaCorriente.saldoCuenta);
                    } else {
                        System.out.println("Cantidad insuficiente.");
                    }
                } else {
                    System.out.println("Error. Numero de cuenta incorrecto");
                }
                break;
            default:
                System.out.println("Digite una opcion correcta.");
        }
    }
    public void retirarCuenta(int tipoCuenta, double cantidadRetiro, String contraseniaTarjeta) {
        switch (tipoCuenta) {
            case 1:
                //cuenta ahorro
                if (tarjetaDeDebito.claveTarjeta.equals(contraseniaTarjeta)) {
                    if (cuentaAhorros.saldoCuenta > 0 && cuentaAhorros.saldoCuenta >= cantidadRetiro) {
                        cuentaAhorros.retirar(cantidadRetiro);
                        System.out.println("Saldo restante: " + cuentaAhorros.saldoCuenta);
                    } else {
                        System.out.println("Cantidad insuficiente dentro de la cuenta.");
                        System.out.println("Saldo disponible: " + cuentaAhorros.saldoCuenta);
                    }
                } else {
                    System.out.println("Error en la clave.");
                }
                break;
            case 2:
                //cuenta corriente
                if (tarjetaDeDebito.claveTarjeta.equals(contraseniaTarjeta)) {
                    if (cantidadRetiro <= cuentaCorriente.saldoCuenta) {
                        cuentaCorriente.retirar(cantidadRetiro);
                        System.out.println("Cantidad a retirar: " + cantidadRetiro);
                        System.out.println("Saldo restante: " + cuentaCorriente.saldoCuenta);
                    } else {
                        double diferencia = cantidadRetiro - cuentaCorriente.saldoCuenta;
                        double montoConComision = cuentaCorriente.cobrarComisionPorSobregiro(diferencia);

                        if (cuentaCorriente.getLimiteSobregiro() >= montoConComision) {
                            cuentaCorriente.retirar(cuentaCorriente.saldoCuenta); // Agota el saldo de la cuenta
                            cuentaCorriente.permitirSobregiro(diferencia); // Utiliza el sobregiro
                            System.out.println("Retiro exitoso usando sobregiro. Saldo restante: " + cuentaCorriente.saldoCuenta);
                            System.out.println("Sobregiro restante: " + cuentaCorriente.getLimiteSobregiro());
                        } else {
                            System.out.println("Fondos insuficientes. Sobregiro no permitido.");
                            System.out.println("Saldo disponible: " + cuentaCorriente.saldoCuenta);
                            System.out.println("Límite de sobregiro disponible: " + cuentaCorriente.getLimiteSobregiro());
                        }
                    }
                } else {
                    System.out.println("Error en la clave");
                }
                break;
            default:
                System.out.println("Digite una opcion correcta.");
        }
    }
}