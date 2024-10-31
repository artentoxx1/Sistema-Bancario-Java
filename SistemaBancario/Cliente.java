package Banco.SistemaBancario;

public class Cliente {
    private String nombresCliente;
    private String apellidoPaternoCliente;
    private String apellidoMaternoCliente;
    private String sexoCliente;
    private String dniCliente;
    private String telefonoCliente;
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
        nombresCliente = "";
        apellidoPaternoCliente = "";
        apellidoMaternoCliente = "";
        sexoCliente = "";
        dniCliente = "";
        telefonoCliente = "";
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

    public Cliente(String nombresCliente, String apellidoMaternoCliente, String apellidoPaternoCliente,
                   String sexoCliente, String dniCliente, String telefonoCliente, String correoCliente,
                   String profesionCliente, String cargaFamiliarClient,
                   String direccionCliente, CuentaAhorro cuentaAhorros,
                   CuentaCorriente cuentaCorriente, CuentaDepositoaPlazoFijo cuentaDepositoPlazoFijo,
                   TarjetaDeDebito tarjetaDeDebito, TarjetaDeCredito tarjetaDeCredito, double liquidezFinanciera) {
        this.nombresCliente = nombresCliente;
        this.apellidoPaternoCliente = apellidoPaternoCliente;
        this.apellidoMaternoCliente = apellidoMaternoCliente;
        this.sexoCliente = sexoCliente;
        this.dniCliente = dniCliente;
        this.telefonoCliente = telefonoCliente;
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
                        cuentaAhorros.saldoCuenta = cuentaAhorros.saldoCuenta + cantidadDeposito;
                        System.out.println("Saldo añadido a la cuenta " + numeroCuenta);
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
                        cuentaCorriente.saldoCuenta = cuentaCorriente.saldoCuenta + cantidadDeposito;
                        System.out.println("Saldo añadido a la cuenta " + numeroCuenta);
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
                        cuentaAhorros.saldoCuenta -= cantidadRetiro;
                        System.out.println("Cantidad a retirar de la cuenta: " + cantidadRetiro);
                        System.out.println("Saldo restante: " + cuentaAhorros.saldoCuenta);
                    } else {
                        System.out.println("Cantidad insuficiente dentro de la cuenta.");
                        System.out.println("Saldo disponible: " + cuentaAhorros.saldoCuenta);
                    }
                } else {
                    System.out.println("Error...");
                }
                break;
            case 2:
                //cuenta corriente
                if (tarjetaDeDebito.claveTarjeta.equals(contraseniaTarjeta)) {
                    if (cuentaCorriente.saldoCuenta > 0 && cuentaCorriente.saldoCuenta >= cantidadRetiro) {
                        cuentaCorriente.saldoCuenta = cuentaCorriente.saldoCuenta - cantidadRetiro;
                        System.out.println("Cantidad a retirar de la cuenta: " + cantidadRetiro);
                        System.out.println("Saldo restante: " + cuentaCorriente.saldoCuenta);
                    } else {
                        System.out.println("Cantidad insuficiente dentro de la tarjeta.");
                        System.out.println("Saldo disponible: " + cuentaCorriente.saldoCuenta);
                    }
                } else {
                    System.out.println("Error...");
                }
                break;
            default:
                System.out.println("Digite una opcion correcta.");
        }
    }

    public void sacarTarjetaCredito(Fecha fechaActual) {
        double liquidezMinimaRequerida = 5000.00;
        double limiteCreditoInicial = 10000.00;
        double deudaInicial = 0.0;
        Fecha fechaDePago;
        boolean puedeOtorgarTarjeta = true;
        int dia = fechaActual.getDia();
        int mes = fechaActual.getMes();
        int anio = fechaActual.getAnio();
        int[] diasEnMes = new int[12];
        diasEnMes[0] = 31;
        diasEnMes[1] = 28;
        diasEnMes[2] = 31;
        diasEnMes[3] = 30;
        diasEnMes[4] = 31;
        diasEnMes[5] = 30;
        diasEnMes[6] = 31;
        diasEnMes[7] = 31;
        diasEnMes[8] = 30;
        diasEnMes[9] = 31;
        diasEnMes[10] = 30;
        diasEnMes[11] = 31;
        if ((fechaActual.getAnio() % 4 == 0 && fechaActual.getAnio() % 100 != 0) || (fechaActual.getAnio() % 400 == 0)) {
            diasEnMes[1] = 29;
        }
        dia += 60;
        while (dia > diasEnMes[mes - 1]) {
            dia -= diasEnMes[mes - 1];
            mes++;
            if (mes > 12) {
                mes = 1;
                anio++;
            }
        }
        fechaDePago = new Fecha(dia, mes, anio);
        if (tarjetaDeCredito != null) {
            System.out.println("Error: El cliente ya tiene una tarjeta de crédito activa.");
            puedeOtorgarTarjeta = false;
        }

        if (liquidezFinanciera < liquidezMinimaRequerida) {
            System.out.println("Error: No se puede otorgar una tarjeta de crédito. La liquidez financiera del cliente es insuficiente.");
            puedeOtorgarTarjeta = false;
        }

        if (puedeOtorgarTarjeta) {

            String numeroTarjetaGenerado = Tarjeta.generarNumeroTarjeta();
            String claveTarjetaGenerada = Tarjeta.generarClaveTarjeta();

            tarjetaDeCredito = new TarjetaDeCredito(
                    numeroTarjetaGenerado,
                    claveTarjetaGenerada,
                    limiteCreditoInicial,
                    deudaInicial,
                    limiteCreditoInicial,
                    fechaDePago,
                    cuentaCorriente
            );

            System.out.println("Tarjeta de crédito otorgada exitosamente al cliente.");
            System.out.println("Número de tarjeta: " + numeroTarjetaGenerado);
            System.out.println("Límite de crédito inicial: " + limiteCreditoInicial);
            System.out.println("Fecha de pago de la tarjeta: " + fechaDePago);
        }
    }

    public void sacarTarjetaDebito() {
        boolean puedeOtorgarTarjeta = true;
        if (tarjetaDeDebito != null) {
            System.out.println("Error: El cliente ya tiene una tarjeta de debito.");
            puedeOtorgarTarjeta = false;
        }

        if (cuentaAhorros == null) {
            System.out.println("Error: No se puede otorgar una tarjeta de debito. El cliente no tiene una cuenta " +
                    "de ahorros disponible.");
            puedeOtorgarTarjeta = false;
        }

        if (puedeOtorgarTarjeta) {
            String numeroTarjetaGenerado ;
            numeroTarjetaGenerado= Tarjeta.generarNumeroTarjeta();
            String claveTarjetaGenerada = Tarjeta.generarClaveTarjeta();

            tarjetaDeDebito = new TarjetaDeDebito(
                    numeroTarjetaGenerado,
                    claveTarjetaGenerada,
                    cuentaAhorros
            );

            System.out.println("Tarjeta de crédito otorgada exitosamente al cliente.");
            System.out.println("Número de tarjeta: " + numeroTarjetaGenerado);
        }
    }
}