package Banco.SistemaBancario;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.LocalDate;
import java.io.FileWriter;
import java.io.IOException;

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

    public void AniadirCliente(Cliente[] clientes) {
        String nombresCliente = "", apellidoPaternoCliente = "", apellidoMaternoCliente = "",
                sexoCliente = "", dniCliente = "", telefonoCliente = "", correoCliente = "",
                profesionCliente = "", cargaFamiliarCliente = "", direccionCliente = "";
        double liquidezFinanciera = 0;
        boolean datosValidos = true; // Bandera para controlar errores

        try {
            System.out.println("Ingrese el nombre del cliente: ");
            nombresCliente = entrada.nextLine();

            System.out.println("Ingrese el apellido paterno del cliente: ");
            apellidoPaternoCliente = entrada.nextLine();

            System.out.println("Ingrese el apellido materno del cliente: ");
            apellidoMaternoCliente = entrada.nextLine();

            System.out.println("Ingrese el sexo del cliente: ");
            sexoCliente = entrada.nextLine();

            System.out.println("Ingrese el DNI del cliente: ");
            dniCliente = entrada.nextLine();
            if (dniCliente.length() != 8 || !dniCliente.matches("\\d+")) { //Para verificar la extension del dni, que sean numeros y no este vacío
                System.out.println("DNI inválido. Debe tener 8 dígitos numéricos.");
                datosValidos = false;
            }

            System.out.println("Ingrese el teléfono del cliente: ");
            telefonoCliente = entrada.nextLine();

            System.out.println("Ingrese el correo electrónico del cliente: ");
            correoCliente = entrada.nextLine();
            if (!correoCliente.contains("@")) {
                System.out.println("Correo electrónico inválido.");
                datosValidos = false;
            }

            System.out.println("Ingrese la profesión del cliente: ");
            profesionCliente = entrada.nextLine();

            System.out.println("Ingrese la carga familiar del cliente: ");
            cargaFamiliarCliente = entrada.nextLine();

            System.out.println("Ingrese la dirección del cliente: ");
            direccionCliente = entrada.nextLine();

            System.out.println("Ingrese la liquidez financiera del cliente: ");
            liquidezFinanciera = entrada.nextDouble();
            if (liquidezFinanciera < 0) {
                System.out.println("La liquidez financiera no puede ser negativa.");
                datosValidos = false;
            }
            entrada.nextLine();

        } catch (InputMismatchException e) {
            System.out.println("Error: tipo de dato no válido.");
            entrada.nextLine();
            datosValidos = false;
        }

        if (datosValidos) {
            CuentaAhorro cuentaAhorros = new CuentaAhorro();
            CuentaCorriente cuentaCorriente = new CuentaCorriente();
            CuentaDepositoaPlazoFijo cuentaDepositoPlazoFijo = new CuentaDepositoaPlazoFijo();
            TarjetaDeDebito tarjetaDeDebito = new TarjetaDeDebito();
            TarjetaDeCredito tarjetaDeCredito = new TarjetaDeCredito();

            Cliente nuevoCliente = new Cliente(
                    nombresCliente, apellidoPaternoCliente, apellidoMaternoCliente,
                    sexoCliente, dniCliente, telefonoCliente, correoCliente,
                    profesionCliente, cargaFamiliarCliente, direccionCliente,
                    cuentaAhorros, cuentaCorriente, cuentaDepositoPlazoFijo,
                    tarjetaDeDebito, tarjetaDeCredito, liquidezFinanciera
            );
                aniadirClienteArchivo(nuevoCliente);
        } else {
            System.out.println("No se pudo añadir al cliente debido a errores en los datos.");
        }
    }
    public void aniadirClienteArchivo(Cliente cliente) {
        try (FileWriter writer = new FileWriter("clientes.txt", true)) {
            writer.append(cliente.getNombres() + ";");
            writer.append(cliente.getApellidoPaterno() + ";");
            writer.append(cliente.getApellidoMaterno() + ";");
            writer.append(cliente.getSexo() + ";");
            writer.append(cliente.getDni() + ";");
            writer.append(cliente.getTelefono() + ";");
            writer.append(cliente.getCorreoCliente() + ";");
            writer.append(cliente.getProfesionCliente() + ";");
            writer.append(cliente.getCargaFamiliarCliente() + ";");
            writer.append(cliente.getDireccionCliente() + ";");
            writer.append(cliente.getLiquidezFinanciera() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void actualizarDatosCliente(Cliente[] clientes, String dni) {
        Scanner entrada = new Scanner(System.in);
        boolean clienteEncontrado = false;
        int opcion2=0;
        boolean opcionIncorrecta=false;

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null && clientes[i].getDni().equals(dni)) {
                clienteEncontrado = true;
                try{
                    System.out.println("Seleccione una opción: ");
                    System.out.println("1. Modificar dirección.");
                    System.out.println("2. Modificar teléfono.");
                    System.out.println("3. Modificar correo.");

                    opcion2 = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer
                }catch(InputMismatchException e){
                    System.out.println("Error. digite un numero.");
                    opcionIncorrecta = true;
                }

                if(!opcionIncorrecta){
                    switch (opcion2) {
                        case 1: {
                            System.out.println("Digite la nueva dirección: ");
                            String nuevaDireccion = entrada.nextLine();
                            clientes[i].setDireccionCliente(nuevaDireccion);
                        }
                        break;
                        case 2: {
                            System.out.println("Digite el nuevo teléfono: ");
                            String nuevoTelefono = entrada.nextLine();
                            clientes[i].setTelefono(nuevoTelefono);
                        }
                        break;
                        case 3: {
                            System.out.println("Digite el nuevo correo: ");
                            String nuevoCorreo = entrada.nextLine();
                            clientes[i].setCorreoCliente(nuevoCorreo);
                        }
                        break;
                        default:
                            System.out.println("Opción no válida.");
                            return; // Salir si la opción no es válida
                    }
                    // Guardar los cambios en el archivo
                        guardarClientesEnArchivo(clientes);
                    if(!opcionIncorrecta){System.out.println("Datos actualizados correctamente.");}
                }
            }
        }

        if (!clienteEncontrado) {
            System.out.println("Cliente con DNI " + dni + " no encontrado.");
        }
    }
    public void guardarClientesEnArchivo(Cliente[] clientes)  {
        try (FileWriter writer = new FileWriter("clientes.txt")) {
            for (Cliente cliente : clientes) {
                if (cliente != null) {
                    writer.append(cliente.getNombres() + ";");
                    writer.append(cliente.getApellidoPaterno() + ";");
                    writer.append(cliente.getApellidoMaterno() + ";");
                    writer.append(cliente.getSexo() + ";");
                    writer.append(cliente.getDni() + ";");
                    writer.append(cliente.getTelefono() + ";");
                    writer.append(cliente.getCorreoCliente() + ";");
                    writer.append(cliente.getProfesionCliente() + ";");
                    writer.append(cliente.getCargaFamiliarCliente() + ";");
                    writer.append(cliente.getDireccionCliente() + ";");
                    writer.append(cliente.getLiquidezFinanciera() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
            guardarClientesEnArchivo(clientes);

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
    public void agregarCuentaCorriente(Cliente[] clientes, String dni) {
        try {
            System.out.println("Ingrese el número de cuenta: ");
            String numCuenta = entrada.nextLine();

            double saldo = 0; // Saldo inicial
            Transaccion[] historialCuenta = new Transaccion[100];

            System.out.println("Ingrese el tipo de cuenta: ");
            String tipoCuenta = entrada.nextLine();

            System.out.println("Ingrese el límite de sobregiro: ");
            double limite = entrada.nextDouble();
            if (limite < 0) {
                throw new IllegalArgumentException("El límite de sobregiro no puede ser negativo.");
            }

            System.out.println("Ingrese la comisión por sobregiro: ");
            double comision = entrada.nextDouble();
            if (comision < 0) {
                throw new IllegalArgumentException("La comisión por sobregiro no puede ser negativa.");
            }
            entrada.nextLine();

            CuentaCorriente cuentaC = new CuentaCorriente(numCuenta, saldo, tipoCuenta, limite, comision);

            boolean clienteEncontrado = false;
            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i] != null && clientes[i].getDni().equals(dni)) {
                    clientes[i].setCuentaCorriente(cuentaC);
                    clienteEncontrado = true;
                    break;
                }
            }

            if (!clienteEncontrado) {
                throw new IllegalArgumentException("No se encontró un cliente con el DNI especificado.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: se esperaba un valor numérico. Intente nuevamente.");
            entrada.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
    public void eliminaCuentaCorriente(Cliente[] clientes, String dni) {
        boolean clienteEncontrado = false;
        try {
            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i] != null && clientes[i].getDni().equals(dni)) {
                    clientes[i].setCuentaCorriente(null); // Asignar null para indicar que no tiene cuenta
                    clienteEncontrado = true;
                    System.out.println("La cuenta corriente del cliente con DNI " + dni + " ha sido eliminada.");
                    break;
                }
            }

            if (!clienteEncontrado) {
                throw new IllegalArgumentException("No se encontró un cliente con el DNI especificado.");
            }

        } catch (NullPointerException e) {
            System.out.println("Error, el elemento es nulo.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
    public void agregarCuentaAhorro(Cliente[] clientes, String dni) {
        try {
            System.out.println("Ingrese el número de cuenta: ");
            String numCuenta = entrada.nextLine();

            double saldo = 0;
            Transaccion[] historialCuenta = new Transaccion[100];

            System.out.println("Ingrese el tipo de cuenta: ");
            String tipoCuenta = entrada.nextLine();

            System.out.println("Ingrese el límite de retiros: ");
            int limite = entrada.nextInt();
            if (limite < 0) {
                throw new IllegalArgumentException("El límite de retiros no puede ser negativo.");
            }

            System.out.println("Ingrese la tasa de interés: ");
            double interes = entrada.nextDouble();
            if (interes < 0) {
                throw new IllegalArgumentException("La tasa de interés no puede ser negativa.");
            }
            entrada.nextLine();

            CuentaAhorro cuentaC = new CuentaAhorro(numCuenta, saldo, tipoCuenta, interes, limite);

            boolean clienteEncontrado = false;
            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i] != null && clientes[i].getDni().equals(dni)) {
                    clientes[i].setCuentaAhorros(cuentaC);
                    clienteEncontrado = true;
                    System.out.println("La cuenta de ahorros ha sido asignada al cliente con DNI " + dni);
                    break;
                }
            }

            if (!clienteEncontrado) {
                throw new IllegalArgumentException("No se encontró un cliente con el DNI especificado.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Se esperaba un valor numérico. Intente nuevamente.");
            entrada.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: La lista de clientes o uno de sus elementos es nulo.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
    public void eliminaCuentaAhorro(Cliente[] clientes, String dni) {
        try {
            boolean clienteEncontrado = false;

            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i] != null && clientes[i].getDni().equals(dni)) {
                    clientes[i].setCuentaAhorros(null);
                    clienteEncontrado = true;
                    System.out.println("La cuenta de ahorros del cliente con DNI " + dni + " ha sido eliminada.");
                    break;
                }
            }

            if (!clienteEncontrado) {
                throw new IllegalArgumentException("No se encontró un cliente con el DNI especificado.");
            }

        } catch (NullPointerException e) {
            System.out.println("Error: La lista de clientes o uno de sus elementos es nulo.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
    public void agregarCuentaPlazoFijo(Cliente[] clientes, String dni) {
        try {
            System.out.println("Ingrese el número de cuenta:");
            String numCuenta = entrada.nextLine().trim();

            double saldo = 0;
            List<Transaccion> historialCuenta = new ArrayList<>();

            System.out.println("Ingrese el tipo de cuenta:");
            String tipoCuenta = entrada.nextLine().trim();

            System.out.println("Ingrese el plazo (en meses):");
            int plazo = entrada.nextInt();

            System.out.println("Ingrese la tasa de interés a plazo fijo:");
            double interes = entrada.nextDouble();

            entrada.nextLine();

            System.out.println("Ingrese la fecha de inicio (formato: yyyy-MM-dd):");
            String fechaInicioStr = entrada.nextLine().trim();
            LocalDate inicio;
            try {
                inicio = LocalDate.parse(fechaInicioStr);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Formato de fecha inválido. Use el formato yyyy-MM-dd.");
            }

            System.out.println("Ingrese la penalización:");
            int penalizacion = entrada.nextInt();


            CuentaDepositoaPlazoFijo cuentaC = new CuentaDepositoaPlazoFijo(
                    numCuenta, saldo, tipoCuenta, plazo, interes, inicio, penalizacion, historialCuenta);


            boolean clienteEncontrado = false;
            for (Cliente cliente : clientes) {
                if (cliente != null && cliente.getDni().equals(dni)) {
                    cliente.setCuentaDepositoPlazoFijo(cuentaC);
                    clienteEncontrado = true;
                    System.out.println("La cuenta a plazo fijo se ha asignado al cliente con DNI " + dni);
                    break;
                }
            }

            if (!clienteEncontrado) {
                throw new IllegalArgumentException("No se encontró un cliente con el DNI especificado.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Tipo de dato ingresado no válido.");
            entrada.nextLine(); // Limpiar el buffer
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: La lista de clientes contiene elementos nulos.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
    public void eliminaCuentaPlazoFijo(Cliente[] clientes, String dni) {
        try {
            if (clientes == null || clientes.length == 0) {
                throw new IllegalArgumentException("La lista de clientes está vacía o no ha sido inicializada.");
            }

            boolean clienteEncontrado = false;

            for (Cliente cliente : clientes) {
                if (cliente != null && cliente.getDni().equals(dni)) {
                    cliente.setCuentaDepositoPlazoFijo(null);
                    clienteEncontrado = true;
                    System.out.println("Se eliminó la cuenta a plazo fijo del cliente con DNI " + dni);
                    break;
                }
            }
            if (!clienteEncontrado) {
                throw new IllegalArgumentException("No se encontró un cliente con el DNI especificado.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: Uno o más elementos en la lista de clientes son nulos.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
    public void generarTarjetaCredito(Cliente cliente, int plazo) {
        double liquidezMinimaRequerida = 5000.00;
        double limiteCreditoInicial = 10000.00;
        double deudaInicial = 0.0;
        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaPago = fechaInicio.plusMonths(plazo);

        try {
            if (cliente == null) {
                throw new IllegalArgumentException("El cliente no puede ser nulo.");
            }

            if (cliente.getTarjetaDeCredito() != null) {
                throw new IllegalStateException("El cliente ya tiene una tarjeta de crédito activa.");
            }

            if (cliente.getLiquidezFinanciera() < liquidezMinimaRequerida) {
                throw new IllegalArgumentException("La liquidez financiera del cliente es insuficiente para otorgar una tarjeta de crédito.");
            }
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

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    public void generarTarjetaDebito(Cliente cliente) {
        try {
            if (cliente == null) {
                throw new IllegalArgumentException("El cliente no puede ser nulo.");
            }
            if (cliente.getTarjetaDeDebito() != null) {
                throw new IllegalStateException("El cliente ya tiene una tarjeta de débito activa.");
            }
            if (cliente.getCuentaAhorros() == null) {
                throw new IllegalStateException("El cliente no tiene una cuenta de ahorros disponible.");
            }

            // Generar tarjeta de débito
            String numeroTarjetaGenerado = Tarjeta.generarNumeroTarjeta();
            String claveTarjetaGenerada = Tarjeta.generarClaveTarjeta();
            boolean estadoTarjeta = true;

            TarjetaDeDebito tarjeta = new TarjetaDeDebito(
                    numeroTarjetaGenerado,
                    claveTarjetaGenerada,
                    cliente.getCuentaAhorros(),
                    estadoTarjeta
            );

            cliente.setTarjetaDeDebito(tarjeta);

            System.out.println("Tarjeta de débito otorgada exitosamente al cliente.");
            System.out.println("Número de tarjeta: " + numeroTarjetaGenerado);

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    public void bloquearTarjetaDebito(Cliente[] clientes, String dni) {
        try {
            Cliente cliente = buscarCliente(clientes, dni);
            if (cliente == null) {
                throw new IllegalArgumentException("Cliente con DNI " + dni + " no encontrado.");
            }
            if (cliente.getTarjetaDeDebito() == null) {
                throw new IllegalStateException("El cliente con DNI " + dni + " no tiene tarjeta de débito asociada.");
            }
            cliente.getTarjetaDeDebito().bloquearTarjeta();
            System.out.println("La tarjeta de débito del cliente con DNI " + dni + " ha sido bloqueada.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: La tarjeta de débito no está disponible.");
        }
    }
    public void bloquearTarjetaCredito(Cliente[] clientes, String dni) {
        try {
            Cliente cliente = buscarCliente(clientes, dni);

            if (cliente == null) {
                throw new IllegalArgumentException("Cliente con DNI " + dni + " no encontrado.");
            }

            if (cliente.getTarjetaDeCredito() == null) {
                throw new IllegalStateException("El cliente con DNI " + dni + " no tiene tarjeta de crédito asociada.");
            }

            cliente.getTarjetaDeCredito().bloquearTarjeta();
            System.out.println("La tarjeta de crédito del cliente con DNI " + dni + " ha sido bloqueada.");

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: La tarjeta de crédito no está disponible.");
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