package Banco.SistemaBancario;
import java.util.Scanner;
import java.time.LocalDate;

public class Cajero extends Empleado{
    private String usuario;
    private String clave;
    static Scanner entrada = new Scanner(System.in);
    public Cajero(){
        super();
        usuario="";
        clave="";
    }
    public Cajero(String nombreEmpleado, String apellidoPaternoEmpleado,String apellidoMaternoEmpleado, String sexoEmpleado, String
                  telefonoEmpleado, int edadEmpleado, String dniEmpleado, double salarioEmpleado,
                  String puestoEmpleado, String sucursalEmpleado, String clave, String usuario) {
        super(nombreEmpleado, apellidoPaternoEmpleado,apellidoMaternoEmpleado, sexoEmpleado, telefonoEmpleado,
                edadEmpleado, dniEmpleado,salarioEmpleado, puestoEmpleado,sucursalEmpleado);
        this.clave=clave;
        this.usuario=usuario;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getClave(){
        return clave;
    }
    public void setClave(String clave){
        this.clave=clave;
    }
    public void AniadirCliente(Cliente[] clientes){
        System.out.println("Ingrese el nombre del cliente: ");
        String nombresCliente = entrada.nextLine();
        System.out.println("Ingrese el apellido paterno del cliente: ");
        String apellidoPaternoCliente = entrada.nextLine();
        System.out.println("Ingrese el apellido materno del cliente: ");
        String apellidoMaternoCliente = entrada.nextLine();
        System.out.println("Ingrese el sexo del cliente: ");
        String sexoCliente = entrada.nextLine();
        System.out.println("Ingrese el DNI del cliente: ");
        String dniCliente = entrada.nextLine();
        System.out.println("Ingrese el teléfono del cliente: ");
        String telefonoCliente = entrada.nextLine();
        System.out.println("Ingrese el correo electrónico del cliente: ");
        String correoCliente = entrada.nextLine();
        System.out.println("Ingrese la profesión del cliente: ");
        String profesionCliente = entrada.nextLine();
        System.out.println("Ingrese la carga familiar del cliente: ");
        String cargaFamiliarCliente = entrada.nextLine();
        System.out.println("Ingrese la dirección del cliente: ");
        String direccionCliente = entrada.nextLine();
        System.out.println("Ingrese la liquidez financiera del cliente: ");
        double liquidezFinanciera = entrada.nextDouble();
        entrada.nextLine();

        CuentaAhorro cuentaAhorros = new CuentaAhorro();
        CuentaCorriente cuentaCorriente = new CuentaCorriente();
        CuentaDepositoaPlazoFijo cuentaDepositoPlazoFijo = new CuentaDepositoaPlazoFijo();
        TarjetaDeDebito tarjetaDeDebito = new TarjetaDeDebito();
        TarjetaDeCredito tarjetaDeCredito = new TarjetaDeCredito();

        Cliente nuevoCliente = new Cliente(
                nombresCliente,
                apellidoPaternoCliente,
                apellidoMaternoCliente,
                sexoCliente,
                dniCliente,
                telefonoCliente,
                correoCliente,
                profesionCliente,
                cargaFamiliarCliente,
                direccionCliente,
                cuentaAhorros,
                cuentaCorriente,
                cuentaDepositoPlazoFijo,
                tarjetaDeDebito,
                tarjetaDeCredito,
                liquidezFinanciera
        );
    }
    /*
    public void añadirCajero(String user, String clave,String dni){
        Empleado[] empleados;
            empleados = new Empleado[100];
        Administrador admin=new Administrador("Andre",
                "Salas","Echenique","Masculino","923826161",
                19,"71345893",0.10,
                "Administrador","Av. Óscar R. Benavides 5483, Callao 07006");

        admin.AniadirEmpleado(empleados);
        Cajero cajero=new Cajero(null,null,null,null,
                null,0,null,0.0,null,null,null,null);
        for(int i=0;i<empleados.length;i++){
            if(empleados[i].getDni().equals(dni)){
                cajero.setNombres(empleados[i].getNombres());
                cajero.setApellidoMaterno(empleados[i].getApellidoMaterno());
                cajero.setApellidoPaterno(empleados[i].getApellidoPaterno());
                cajero.setDni(empleados[i].getDni());
                cajero.setSexo(empleados[i].getSexo());
                cajero.setEdadEmpleado(empleados[i].getEdadEmpleado());
                cajero.setTelefono(empleados[i].getTelefono());
                cajero.setSalarioEmpleado(empleados[i].getSalarioEmpleado());
                cajero.setPuestoEmpleado(empleados[i].getPuestoEmpleado());
                cajero.setSucursalEmpleado(empleados[i].getSucursalEmpleado());
                cajero.setUsuario(user);
                cajero.setClave(clave);

            }

        }
    }
    */
    public void actualizarDatosCliente(Cliente[] cliente, String dni){
        for (int i=0; i<cliente.length; i++){
            if(cliente[i].getDni().equals(dni)){
                System.out.println("Seleccione una opcion: ");
                System.out.println("1.Modificar direccion. ");
                System.out.println("2.Modificar telefono. ");
                System.out.println("3.Modificar correo. ");
            }
            int opcion2 = entrada.nextInt();
            switch (opcion2){
                case 1:{
                    System.out.println("Digite la nueva direccion: ");
                    String nuevadireccion=entrada.next();
                    cliente[i].setDni(nuevadireccion);
                };break;
                case 2:{
                    System.out.println("Digite el nuevo telefono: ");
                    String nuevotelefono=entrada.next();
                    cliente[i].setTelefono(nuevotelefono);
                };break;
                case 3:{
                    System.out.println("Digite el nuevo correo: ");
                    String nuevocorreo=entrada.next();
                    cliente[i].setCorreoCliente(nuevocorreo);
                };break;

            }
        }

    }
    public void eliminarCliente(Cliente[] clientes, String dni){
        boolean flag = false;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].getDni().equals(dni)) {
                for (int j=i;j<clientes.length-1;j++){
                    clientes[j]=clientes[j+1];
                }
                flag=true;
            }
        }
        System.out.println("Empleado eliminado correctamente");
        if (flag==false){System.out.println("No existe cliente, que esta asociado al dni proporcionado");}
    }
    public void mostrarCliente(Cliente[] clientes,String dni){
        int existencia=0;
        for(int i = 0; i < clientes.length; i++) {
            if (clientes[i].getDni().equals(dni)) {
                System.out.println("Nombres: " + clientes[i].getNombres());
                System.out.println("Apellido Paterno: " + clientes[i].getApellidoPaterno());
                System.out.println("Apellido Materno: " + clientes[i].getApellidoMaterno());
                System.out.println("Sexo: " + clientes[i].getSexo());
                System.out.println("Dni: " + clientes[i].getDni());
                System.out.println("Telefono: " + clientes[i].getTelefono());
                System.out.println("Correo: " + clientes[i].getCorreoCliente());
                System.out.println("Direccion: " + clientes[i].getDireccionCliente());
                existencia=1;
            }
        }
        if (existencia==0){System.out.println("No existe cliente, que esta asociado al dni proporcionado");}

    }
    public Cliente buscarCliente(Cliente[] clientes, String dni) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].getDni().equals(dni)) {
                return clientes[i]; // Devuelve el cliente si lo encuentra

            }

        }
       System.out.println("No existe cliente, que esta asociado al dni proporcionado");
        return null; // Retorna null si no encuentra al cliente
    }
    public  void agregarCuentaCorriente (Cliente[] clientes, String dni){
        System.out.println("Ingrese el numero de cuenta : ");
        String numCuenta = entrada.nextLine();
        double saldo = 0;
        Transaccion[] historialCuenta;
        historialCuenta= new Transaccion[100];
        System.out.println("Ingrese el tipo de cuenta: ");
        String tipoCuenta = entrada.nextLine();
        System.out.println("Ingrese limite de sobregiro: ");
        double limite = entrada.nextDouble();
        System.out.println("Ingrese comision por sobregiro: ");
        double comision = entrada.nextDouble();
       CuentaCorriente CuentaC= new CuentaCorriente(numCuenta,saldo,tipoCuenta,limite,comision);
        for(int i=0;i< clientes.length ;i++){
            if(clientes[i].getDni().equals(dni)){
                clientes[i].setCuentaCorriente(CuentaC);
            }
        }
    }
    public  void eliminaCuentaCorriente (Cliente[] clientes,String dni){
        CuentaCorriente CuentaC=new CuentaCorriente(null,0,
                null,0,0);
        for(int i=0;i< clientes.length ;i++){
            if(clientes[i].getDni().equals(dni)){
                clientes[i].setCuentaCorriente(CuentaC);
            }
        }
    }
    public  void agregarCuentaAhorro (Cliente[] clientes,String dni){
        System.out.println("Ingrese el numero de cuenta : ");
        String numCuenta = entrada.nextLine();
        double saldo = 0;
        Transaccion[] historialCuenta;
        historialCuenta= new Transaccion[100];
        System.out.println("Ingrese el tipo de cuenta: ");
        String tipoCuenta = entrada.nextLine();
        System.out.println("Ingrese limite de retiros: ");
        int limite = entrada.nextInt();
        System.out.println("Ingrese tasa de interes : ");
        double interes = entrada.nextDouble();
        CuentaAhorro CuentaC= new CuentaAhorro(numCuenta,saldo,tipoCuenta,interes,limite);
        for(int i=0;i< clientes.length ;i++){
            if(clientes[i].getDni().equals(dni)){
                clientes[i].setCuentaAhorros(CuentaC);
            }
        }
    }
    public  void eliminaCuentaAhorro (Cliente[] clientes,String dni){
        CuentaAhorro CuentaC=new CuentaAhorro(null,null,
                null,0,0);
        for(int i=0;i< clientes.length ;i++){
            if(clientes[i].getDni().equals(dni)){
                clientes[i].setCuentaAhorros(CuentaC);
            }
        }
    }
    public  void agregarCuentaPlazoFijo (Cliente[] clientes,String dni){
        System.out.println("Ingrese el numero de cuenta : ");
        String numCuenta = entrada.nextLine();
        double saldo = 0;
        Transaccion[] historialCuenta;
        historialCuenta= new Transaccion[100];
        System.out.println("Ingrese el tipo de cuenta: ");
        String tipoCuenta = entrada.nextLine();
        System.out.println("Ingrese el plazo: ");
        int plazo = entrada.nextInt();
        System.out.println("Ingrese tasa de intereses a plazo fijo : ");
        double interes = entrada.nextDouble();
        System.out.println("Ingrese la fecha de inicio : ");
        LocalDate inicio = LocalDate.parse(entrada.nextLine());
        System.out.println("Ingrese la penalizacion: ");
        int penalizacion = entrada.nextInt();
        CuentaDepositoaPlazoFijo CuentaC= new CuentaDepositoaPlazoFijo(numCuenta,saldo,historialCuenta,tipoCuenta,plazo,interes,inicio,penalizacion);
        for(int i=0;i< clientes.length ;i++){
            if(clientes[i].getDni().equals(dni)){
                clientes[i].setCuentaDepositoPlazoFijo(CuentaC);
            }
        }
        //(String numeroCuenta, double saldoCuenta,Transaccion[] historialCuenta,
          //      String tipoCuenta,int plazo,double tasaInteresPlazoFijo,LocalDate fechaInicio, int penalizacion)
    }
    public  void eliminaCuentaPlazoFijo (Cliente[] clientes,String dni){
        CuentaDepositoaPlazoFijo CuentaC= new CuentaDepositoaPlazoFijo(null,null,null,
                null,0,0,null,0);
        for(int i=0;i< clientes.length ;i++){
            if(clientes[i].getDni().equals(dni)){
                clientes[i].setCuentaDepositoPlazoFijo(CuentaC);
            }
        }
    }
    public void generarTarjetaCredito(Cliente cliente,int plazo) {
        double liquidezMinimaRequerida = 5000.00;
        double limiteCreditoInicial = 10000.00;
        double deudaInicial = 0.0;
        boolean puedeOtorgarTarjeta = true;
        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaPago = fechaInicio.plusMonths(plazo);

        if (cliente.getTarjetaDeCredito() != null) {
            System.out.println("Error: El cliente ya tiene una tarjeta de crédito activa.");
            puedeOtorgarTarjeta = false;
        }

        if (cliente.getLiquidezFinanciera() < liquidezMinimaRequerida) {
            System.out.println("Error: No se puede otorgar una tarjeta de crédito. La liquidez financiera del cliente es insuficiente.");
            puedeOtorgarTarjeta = false;
        }

        if (puedeOtorgarTarjeta) {

            String numeroTarjetaGenerado = Tarjeta.generarNumeroTarjeta();
            String claveTarjetaGenerada = Tarjeta.generarClaveTarjeta();
            boolean estadoTarjeta = true;
            TarjetaDeCredito tarjeta = new TarjetaDeCredito(
                    numeroTarjetaGenerado,
                    claveTarjetaGenerada,
                    limiteCreditoInicial,
                    deudaInicial,
                    0,
                    fechaPago,
                    cliente.getCuentaCorriente(),
                    estadoTarjeta
            );

            cliente.setTarjetaDeCredito(tarjeta);

            System.out.println("Tarjeta de crédito otorgada exitosamente al cliente.");
            System.out.println("Número de tarjeta: " + numeroTarjetaGenerado);
            System.out.println("Límite de crédito inicial: " + limiteCreditoInicial);
            System.out.println("Fecha de pago de la tarjeta: " + fechaPago);
        }
    }
    public void generarTarjetaDebito(Cliente cliente) {
        boolean puedeOtorgarTarjeta = true;
        if (cliente.getTarjetaDeDebito() != null) {
            System.out.println("Error: El cliente ya tiene una tarjeta de debito.");
            puedeOtorgarTarjeta = false;
        }

        if (cliente.getCuentaAhorros() == null) {
            System.out.println("Error: No se puede otorgar una tarjeta de debito. El cliente no tiene una cuenta " +
                    "de ahorros disponible.");
            puedeOtorgarTarjeta = false;
        }

        if (puedeOtorgarTarjeta) {
            String numeroTarjetaGenerado ;
            numeroTarjetaGenerado= Tarjeta.generarNumeroTarjeta();
            String claveTarjetaGenerada = Tarjeta.generarClaveTarjeta();
            boolean estadoTarjeta = true;

            TarjetaDeDebito tarjeta = new TarjetaDeDebito(
                    numeroTarjetaGenerado,
                    claveTarjetaGenerada,
                    cliente.getCuentaAhorros(),
                    estadoTarjeta
            );

            cliente.setTarjetaDeDebito(tarjeta);

            System.out.println("Tarjeta de crédito otorgada exitosamente al cliente.");
            System.out.println("Número de tarjeta: " + numeroTarjetaGenerado);
        }
    }
    public void bloquearTarjetaDebito(Cliente[] clientes, String dni) {
        Cliente cliente = buscarCliente(clientes, dni);
        if (cliente != null) {
            cliente.getTarjetaDeDebito().bloquearTarjeta();
            System.out.println("La tarjeta de débito del cliente con DNI " + dni + " ha sido bloqueada.");
        }
    }
    public void bloquearTarjetaCredito(Cliente[] clientes, String dni) {
        Cliente cliente = buscarCliente(clientes, dni);
        if (cliente != null) {
            cliente.getTarjetaDeCredito().bloquearTarjeta();
            System.out.println("La tarjeta de credito del cliente con DNI " + dni + " ha sido bloqueada.");
        }
    }
    public void mostrarInformacionTarjeta(String claveTarjeta,String dni, Cliente[] clientes) {
        Cliente cliente= buscarCliente(clientes ,dni);
        if(cliente.getTarjetaDeDebito().getClaveTarjeta().equals(claveTarjeta)){

            cliente.getTarjetaDeDebito().mostrarEstadoCuenta();
        }
        else if(cliente.getTarjetaDeCredito().getClaveTarjeta().equals(claveTarjeta)){

        }
        else{
            System.out.println("La clave quer puso no conincide con ninguna tarjeta de crediot o debito");
        }
    }
}