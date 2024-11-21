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

    public void AniadirCliente(ArrayList<Cliente> clientes) {
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
            if (dniCliente.length() != 8 || !dniCliente.matches("\\d+")) { // Verifica que el DNI tenga 8 dígitos numéricos
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
            entrada.nextLine(); // Limpia el buffer

        } catch (InputMismatchException e) {
            System.out.println("Error: tipo de dato no válido.");
            entrada.nextLine(); // Limpia el buffer en caso de error
            datosValidos = false;
        }

        if (datosValidos) {
            // Crear cuentas y tarjetas por defecto
            CuentaAhorro cuentaAhorros = new CuentaAhorro();
            CuentaCorriente cuentaCorriente = new CuentaCorriente();
            CuentaDepositoaPlazoFijo cuentaDepositoPlazoFijo = new CuentaDepositoaPlazoFijo();
            TarjetaDeDebito tarjetaDeDebito = new TarjetaDeDebito();
            TarjetaDeCredito tarjetaDeCredito = new TarjetaDeCredito();

            // Crear el nuevo cliente con los datos ingresados
            Cliente nuevoCliente = new Cliente(
                    nombresCliente, apellidoPaternoCliente, apellidoMaternoCliente,
                    sexoCliente, dniCliente, telefonoCliente, correoCliente,
                    profesionCliente, cargaFamiliarCliente, direccionCliente,
                    cuentaAhorros, cuentaCorriente, cuentaDepositoPlazoFijo,
                    tarjetaDeDebito, tarjetaDeCredito, liquidezFinanciera
            );

            // Añadir el nuevo cliente al ArrayList
            clientes.add(nuevoCliente);

            // Llamar al metodo para añadir al archivo (si existe)
            aniadirClienteArchivo(nuevoCliente);

            System.out.println("Cliente añadido exitosamente.");
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

    public void actualizarDatosCliente(ArrayList<Cliente> clientes, String dni) {
        boolean clienteEncontrado = false;
        int opcion2 = 0;
        boolean opcionIncorrecta = false;

        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                clienteEncontrado = true;
                try {
                    System.out.println("Seleccione una opción: ");
                    System.out.println("1. Modificar dirección.");
                    System.out.println("2. Modificar teléfono.");
                    System.out.println("3. Modificar correo.");

                    opcion2 = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer
                } catch (InputMismatchException e) {
                    System.out.println("Error. Digite un número.");
                    opcionIncorrecta = true;
                }

                if (!opcionIncorrecta) {
                    switch (opcion2) {
                        case 1: {
                            System.out.println("Digite la nueva dirección: ");
                            String nuevaDireccion = entrada.nextLine();
                            cliente.setDireccionCliente(nuevaDireccion);
                        }
                        break;
                        case 2: {
                            System.out.println("Digite el nuevo teléfono: ");
                            String nuevoTelefono = entrada.nextLine();
                            cliente.setTelefono(nuevoTelefono);
                        }
                        break;
                        case 3: {
                            System.out.println("Digite el nuevo correo: ");
                            String nuevoCorreo = entrada.nextLine();
                            cliente.setCorreoCliente(nuevoCorreo);
                        }
                        break;
                        default:
                            System.out.println("Opción no válida.");
                            return; // Salir si la opción no es válida
                    }
                    guardarClientesEnArchivo(clientes);
                    System.out.println("Datos actualizados correctamente.");
                }
            }
        }

        if (!clienteEncontrado) {
            System.out.println("Cliente con DNI " + dni + " no encontrado.");
        }
    }

    public void guardarClientesEnArchivo(ArrayList<Cliente> clientes) {
        try (FileWriter writer = new FileWriter("clientes.txt")) {
            for (Cliente cliente : clientes) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCliente(ArrayList<Cliente> clientes, String dni) {
        boolean flag = false;

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni().equals(dni)) {
                clientes.remove(i);
                flag = true;
                break;
            }
        }

        guardarClientesEnArchivo(clientes);
        if (flag) {
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("No existe cliente asociado al DNI proporcionado.");
        }
    }

    public void mostrarCliente(ArrayList<Cliente> clientes, String dni) {
        boolean existencia = false;

        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                System.out.println("Nombres: " + cliente.getNombres());
                System.out.println("Apellido Paterno: " + cliente.getApellidoPaterno());
                System.out.println("Apellido Materno: " + cliente.getApellidoMaterno());
                System.out.println("Sexo: " + cliente.getSexo());
                System.out.println("DNI: " + cliente.getDni());
                System.out.println("Teléfono: " + cliente.getTelefono());
                System.out.println("Correo: " + cliente.getCorreoCliente());
                System.out.println("Dirección: " + cliente.getDireccionCliente());
                existencia = true;
            }
        }

        if (!existencia) {
            System.out.println("No existe cliente asociado al DNI proporcionado.");
        }
    }

    public Cliente buscarCliente(ArrayList<Cliente> clientes, String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente; // Devuelve el cliente si lo encuentra
            }
        }

        System.out.println("No existe cliente asociado al DNI proporcionado.");
        return null; // Retorna null si no encuentra al cliente
    }

    public void agregarCuentaCorriente(ArrayList<Cliente> clientes, String dni) {
        try {
            System.out.println("Ingrese el número de cuenta: ");
            String numCuenta = entrada.nextLine();

            double saldo = 0; // Saldo inicial
            ArrayList<Transaccion> historialCuenta = new ArrayList<>();

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
            for (Cliente cliente : clientes) {
                if (cliente.getDni().equals(dni)) {
                    cliente.setCuentaCorriente(cuentaC);
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

    public void eliminaCuentaCorriente(ArrayList<Cliente> clientes, String dni) {
        try {
            boolean clienteEncontrado = false;
            for (Cliente cliente : clientes) {
                if (cliente != null && cliente.getDni().equals(dni)) {
                    cliente.setCuentaCorriente(null); // Asignar null para indicar que no tiene cuenta
                    clienteEncontrado = true;
                    System.out.println("La cuenta corriente del cliente con DNI " + dni + " ha sido eliminada.");
                    break;
                }
            }

            if (!clienteEncontrado) {
                throw new IllegalArgumentException("No se encontró un cliente con el DNI especificado.");
            }

        } catch (NullPointerException e) {
            System.out.println("Error: El elemento es nulo.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    public void agregarCuentaAhorro(ArrayList<Cliente> clientes, String dni) {
        try {
            System.out.println("Ingrese el número de cuenta: ");
            String numCuenta = entrada.nextLine();

            double saldo = 0;
            ArrayList<Transaccion> historialCuenta = new ArrayList<>();

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
            for (Cliente cliente : clientes) {
                if (cliente != null && cliente.getDni().equals(dni)) {
                    cliente.setCuentaAhorros(cuentaC);
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

    public void eliminaCuentaAhorro(ArrayList<Cliente> clientes, String dni) {
        try {
            boolean clienteEncontrado = false;

            for (Cliente cliente : clientes) {
                if (cliente != null && cliente.getDni().equals(dni)) {
                    cliente.setCuentaAhorros(null);
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

    public void agregarCuentaPlazoFijo(ArrayList<Cliente> clientes, String dni) {
        try {
            System.out.println("Ingrese el número de cuenta:");
            String numCuenta = entrada.nextLine().trim();

            double saldo = 0;
            ArrayList<Transaccion> historialCuenta = new ArrayList<>();

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

    public void eliminaCuentaPlazoFijo(ArrayList<Cliente> clientes, String dni) {
        try {
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

    public void bloquearTarjetaDebito(ArrayList<Cliente> clientes, String dni) {
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

    public void bloquearTarjetaCredito(ArrayList<Cliente> clientes, String dni) {
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

    public void mostrarInformacionTarjeta(String claveTarjeta, String dni, ArrayList<Cliente> clientes) {
        try {
            Cliente cliente = buscarCliente(clientes, dni);
            if (cliente == null) {
                throw new IllegalArgumentException("Cliente con DNI " + dni + " no encontrado.");
            }

            if (cliente.getTarjetaDeDebito() != null &&
                    cliente.getTarjetaDeDebito().getClaveTarjeta().equals(claveTarjeta)) {
                cliente.getTarjetaDeDebito().mostrarEstadoCuenta();
            } else if (cliente.getTarjetaDeCredito() != null &&
                    cliente.getTarjetaDeCredito().getClaveTarjeta().equals(claveTarjeta)) {
                cliente.getTarjetaDeCredito().mostrarEstadoCuenta();
            } else {
                System.out.println("La clave proporcionada no coincide con ninguna tarjeta de crédito o débito.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: El cliente o sus tarjetas no están disponibles.");
        }
    }
}