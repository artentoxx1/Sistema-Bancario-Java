package Banco.SistemaBancario;

import java.util.Scanner;
import java.util.ArrayList;

public class PruebaSistemaBancario {
    public static void main(String[] args) {
        CuentaBancaria[] cuentas = new CuentaBancaria[100];
        int contadorCuentas = 0;
        Scanner entrada = new Scanner(System.in);
        Cajero[] cajeros = new Cajero[100];
        int totalCajeros = 0;
        ArrayList<Cliente> clientes = new ArrayList<>();
        Empleado[] empleados;
        empleados = new Empleado[100];
        int opc, opc2, opc3;
        Cajero cajero= new Cajero(null,null,null,null,null,
                0,"",0.0,null,"",null,null);
        Fecha fecha = new Fecha();


        Administrador admin= new Administrador("Andre",
                "Salas","Echenique","Masculino","923826161",
                19,"71345893",0.10,
                "Administrador","Av. Óscar R. Benavides 5483, Callao 07006");

        Sucursal sucursales[];
        sucursales= new Sucursal[10];
        Sucursal sucursal= new Sucursal("Av. Óscar R. Benavides 5483, Callao 07006",
                "14343","Lima" ,100, empleados);
        sucursales[0]= sucursal;


        do{
            System.out.println("\t\t\t¡BIENVENIDO!\t\t\t");
            System.out.println("Escoja si es un empleado o un administrador");
            System.out.println("1. Administrador");
            System.out.println("2. Cajero");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            opc = entrada.nextInt();

            switch(opc) {
                case 1:
                    if(inicioDeSesionAdministrador()){
                        do{
                            System.out.println("\n");
                            pantallaDeInicioAdministrador();
                            opc2 = entrada.nextInt();

                            switch(opc2) {
                                case 1:
                                    do{
                                        System.out.println("\n");
                                        pantallaClientesAdministrador();
                                        opc3 = entrada.nextInt();
                                        switch(opc3) {
                                            case 1:
                                                Administrador.ordenarPorApellido(clientes);
                                                break;
                                            case 2:
                                                Administrador.mostrarCarreraProfesional(clientes);
                                                break;
                                            case 3:
                                                Administrador.mostrarCorreosClientes(clientes);
                                                break;
                                            case 4:
                                                Administrador.mostrarNumerosClientes(clientes);
                                                break;
                                            case 5:
                                                Administrador.mostrarDireccionClientes(clientes);
                                                break;
                                            case 6:
                                                Administrador.mostrarCargaFamiliarClientes(clientes);
                                                break;
                                            case 7:
                                                break;
                                            default:
                                                System.out.println("Digite una opcion valida");
                                        }
                                    } while(opc3 != 7);
                                    break;
                                case 2:
                                    do{
                                        System.out.println("\n");
                                        pantallaEmpleadosAdministrador();
                                        opc3 = entrada.nextInt();
                                        String dni;
                                        switch(opc3) {
                                            case 1:
                                                admin.aniadirPersona(cajeros,totalCajeros);
                                            case 2:
                                                System.out.println("Ingrese el DNI del empleado: ");
                                                dni=entrada.nextLine();
                                                admin.actualizarPersona(cajeros,totalCajeros,dni);
                                            case 3:
                                                System.out.println("Ingrese el DNI del empleado: ");
                                                dni=entrada.nextLine();
                                                admin.eliminarPersona(cajeros,totalCajeros,dni);
                                            case 4:
                                                System.out.println("Ingrese el DNI del empleado: ");
                                                dni=entrada.nextLine();
                                                Empleado.buscarPersona(empleados,dni);
                                            case 5: break;
                                            default: System.out.println("Digite una opcion valida");
                                        }
                                    } while(opc3 != 5);
                                    break;
                                case 3:
                                    do{
                                        System.out.println("\n");
                                        pantallaSucursales();
                                        opc3 = entrada.nextInt();
                                        String cod;
                                        switch(opc3) {
                                            //Opciones de sucursal
                                            case 1:
                                                //admin.agregarSucursal(sucursales);
                                                break;
                                            case 2:
                                                System.out.println("Ingrese el codigo de sucursal: ");
                                                cod =entrada.nextLine();
                                                //Administrador.eliminarSucursal(sucursales,cod);
                                                break;
                                            case 3:
                                                System.out.println("Ingrese el codigo de sucursal: ");

                                                 cod =entrada.nextLine();

                                                //admin.modificarDatosSucursal(sucursales,cod);
                                                break;
                                            case 4:
                                                admin.aniadirPersona(cajeros,totalCajeros);
                                                break;
                                            case 5:
                                                System.out.println("Ingrese el DNI del empleado: ");
                                                String dni =entrada.nextLine();
                                                admin.eliminarPersona(cajeros,totalCajeros,dni);
                                                break;
                                            case 6:
                                                break;
                                            default:
                                                System.out.println("Digite una opcion valida");
                                        }
                                    } while(opc3 != 6);

                                    break;
                                case 4:
                                    break;
                                default:
                                    System.out.println("Ingrese una opción válida e inténtelo nuevamente.");
                            }
                        } while(opc2 != 4);
                        System.out.println("\n");
                    }
                    else{
                        System.out.println("Usuario o contraseña no válidos.");
                    }
                    break;
                case 2:
                    int pos = inicioDeSesionCajero(cajeros, totalCajeros);
                    if (pos != -1) {
                        do {
                            System.out.println("\n");
                            pantallaDeInicioCajero();
                            opc2 = entrada.nextInt();

                            switch (opc2) {
                                case 1: // Gestión de clientes
                                    do {
                                        System.out.println("\n");
                                        pantallaClientesCajero();
                                        opc3 = entrada.nextInt();

                                        switch (opc3) {
                                            case 1: // Añadir cliente
                                                cajeros[pos].AniadirCliente(clientes);
                                                break;

                                            case 2: // Modificar información del cliente
                                                System.out.println("Ingrese el índice del cliente a modificar: ");
                                                int index = entrada.nextInt();
                                                if (index >= 0 && index < clientes.size()) {
                                                    System.out.println("Ingrese el nuevo nombre: ");
                                                    clientes.get(index).setNombres(entrada.next());
                                                    System.out.println("Información modificada.");
                                                } else {
                                                    System.out.println("Cliente no encontrado.");
                                                }
                                                break;

                                            case 3: // Eliminar cliente
                                                entrada.nextLine(); // Limpiar buffer
                                                System.out.println("Ingrese el DNI del cliente a eliminar: ");
                                                String dniEliminar = entrada.nextLine();
                                                cajeros[pos].eliminarCliente(clientes, dniEliminar);
                                                break;

                                            case 4: // Mostrar información del cliente
                                                entrada.nextLine(); // Limpiar buffer
                                                System.out.println("Ingrese el DNI del cliente a mostrar: ");
                                                String dniMostrar = entrada.nextLine();
                                                cajeros[pos].mostrarCliente(clientes, dniMostrar);
                                                break;

                                            case 5: // Regresar
                                                break;

                                            default:
                                                System.out.println("Opción inválida.");
                                        }
                                    } while (opc3 != 5);
                                    break;

                                case 2: // Gestión de cuentas
                                    do {
                                        System.out.println("\n");
                                        pantallaCuentasCajero();
                                        opc3 = entrada.nextInt();

                                        switch (opc3) {
                                            case 1: // Agregar Cuenta Corriente
                                                System.out.print("Ingrese el DNI del cliente: ");
                                                String dni = entrada.next();
                                                cajeros[pos].agregarCuentaCorriente(clientes, dni);
                                                break;

                                            case 2: // Eliminar Cuenta Corriente
                                                System.out.print("Ingrese el DNI del cliente: ");
                                                dni = entrada.next();
                                                cajeros[pos].eliminaCuentaCorriente(clientes, dni);
                                                break;

                                            case 3: // Agregar Cuenta Ahorro
                                                System.out.print("Ingrese el DNI del cliente: ");
                                                dni = entrada.next();
                                                cajeros[pos].agregarCuentaAhorro(clientes, dni);
                                                break;

                                            case 4: // Eliminar Cuenta Ahorro
                                                System.out.print("Ingrese el DNI del cliente: ");
                                                dni = entrada.next();
                                                cajeros[pos].eliminaCuentaAhorro(clientes, dni);
                                                break;

                                            case 5: // Agregar Cuenta Plazo Fijo
                                                System.out.print("Ingrese el DNI del cliente: ");
                                                dni = entrada.next();
                                                cajeros[pos].agregarCuentaPlazoFijo(clientes, dni);
                                                break;

                                            case 6: // Eliminar Cuenta Plazo Fijo
                                                System.out.print("Ingrese el DNI del cliente: ");
                                                dni = entrada.next();
                                                cajeros[pos].eliminaCuentaPlazoFijo(clientes, dni);
                                                break;

                                            case 7: // Depósito en cuenta
                                                System.out.println("Ingrese el tipo de cuenta:");
                                                System.out.println("1. Cuenta Ahorro");
                                                System.out.println("2. Cuenta Corriente");
                                                System.out.println("3. Cuenta Depósito Plazo Fijo");
                                                int tipoC = entrada.nextInt();
                                                System.out.print("Ingrese el monto que quiere depositar: ");
                                                double monto = entrada.nextDouble();
                                                entrada.nextLine(); // Limpiar buffer
                                                System.out.print("Ingrese el número de cuenta: ");
                                                String numC = entrada.nextLine();
                                                clientes.forEach(cliente -> cliente.depositarCuenta(tipoC, monto, numC));
                                                break;

                                            case 8: // Retiro en cuenta
                                                System.out.println("Ingrese el tipo de cuenta:");
                                                System.out.println("1. Cuenta Ahorro");
                                                System.out.println("2. Cuenta Corriente");
                                                System.out.println("3. Cuenta Depósito Plazo Fijo");
                                                tipoC = entrada.nextInt();
                                                System.out.print("Ingrese el monto que quiere retirar: ");
                                                monto = entrada.nextDouble();
                                                entrada.nextLine(); // Limpiar buffer
                                                System.out.print("Ingrese su contraseña de cuenta: ");
                                                numC = entrada.nextLine();
                                                clientes.forEach(cliente -> cliente.retirarCuenta(tipoC, monto, numC));
                                                break;

                                            case 9: // Historial de cuenta
                                                System.out.println("Ingrese el tipo de cuenta:");
                                                System.out.println("1. Cuenta Ahorro");
                                                System.out.println("2. Cuenta Corriente");
                                                System.out.println("3. Cuenta Depósito Plazo Fijo");
                                                tipoC = entrada.nextInt();
                                                entrada.nextLine(); // Limpiar buffer
                                                System.out.print("Ingrese el número de cuenta: ");
                                                numC = entrada.nextLine();

                                                clientes.forEach(cliente -> {
                                                    switch (tipoC) {
                                                        case 1 -> {
                                                            if (cliente.getCuentaAhorros() != null &&
                                                                    cliente.getCuentaAhorros().getNumeroCuenta().equals(numC)) {
                                                                cliente.getCuentaAhorros().getHistorialCuenta();
                                                            }
                                                        }
                                                        case 2 -> {
                                                            if (cliente.getCuentaCorriente() != null &&
                                                                    cliente.getCuentaCorriente().getNumeroCuenta().equals(numC)) {
                                                                cliente.getCuentaCorriente().getHistorialCuenta();
                                                            }
                                                        }
                                                        case 3 -> {
                                                            if (cliente.getCuentaDepositoPlazoFijo() != null &&
                                                                    cliente.getCuentaDepositoPlazoFijo().getNumeroCuenta().equals(numC)) {
                                                                cliente.getCuentaDepositoPlazoFijo().getHistorialCuenta();
                                                            }
                                                        }
                                                    }
                                                });
                                                break;

                                            case 10: // Regresar
                                                break;

                                            default:
                                                System.out.println("Digite una opción válida.");
                                        }
                                    } while (opc3 != 10);
                                    break;
                                case 3:
                                    do {
                                        System.out.println("\n");
                                        pantallaTarjetasCajero();
                                        opc3 = entrada.nextInt();
                                        entrada.nextLine(); // Limpiar el buffer después de `nextInt`

                                        String dni;
                                        switch (opc3) {
                                            case 1:
                                                System.out.print("Ingrese el plazo para la cuenta: ");
                                                int plazo = entrada.nextInt();
                                                entrada.nextLine(); // Limpiar el buffer después de `nextInt`

                                                System.out.print("Ingrese el número de cuenta: ");
                                                String numC = entrada.nextLine().trim();

                                                boolean cuentaEncontrada = false;
                                                for (Cliente cliente : clientes) {
                                                    if (cliente.getCuentaCorriente() != null &&
                                                            numC.equals(cliente.getCuentaCorriente().getNumeroCuenta())) {
                                                        cajero.generarTarjetaCredito(cliente, plazo);
                                                        cuentaEncontrada = true;
                                                        break;
                                                    }
                                                }

                                                if (!cuentaEncontrada) {
                                                    System.out.println("No se encontró una cuenta corriente con el número especificado.");
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Ingrese su numero de DNI: ");
                                                dni= entrada.nextLine();
                                                cajero.bloquearTarjetaCredito(clientes, dni);
                                                break;
                                            case 3:
                                                System.out.println("Ingrese su dni");
                                                dni=entrada.nextLine();
                                                Cliente nuevo= cajero.buscarCliente(clientes,dni);
                                                cajero.generarTarjetaDebito(nuevo);
                                                break;
                                            case 4:
                                                System.out.println("Ingrese su numero de DNI: ");
                                                dni= entrada.nextLine();
                                                cajero.bloquearTarjetaDebito(clientes, dni);
                                                break;
                                            case 5:
                                                System.out.println("Ingrese su numero de DNI: ");
                                                dni= entrada.nextLine();
                                                System.out.println("Ingrese su clave de tarjeta: ");
                                                String clave= entrada.nextLine();
                                                cajero.mostrarInformacionTarjeta(clave,dni,clientes);
                                                break;
                                            case 6:
                                                break;
                                            default:
                                                System.out.println("Digite una opcion valida");
                                        }
                                    } while(opc3 != 6);

                                    break;
                                case 4:
                                    CuentaBancaria cuentaVinculada = null;
                                    System.out.print("Ingrese el número de cuenta vinculada: ");
                                    String numeroCuenta = entrada.nextLine();
                                    for (int i = 0; i < contadorCuentas; i++) {
                                        if (cuentas[i].getNumeroCuenta().equals(numeroCuenta)) {
                                            cuentaVinculada = cuentas[i];
                                            break;
                                        }
                                    }

                                    if (cuentaVinculada == null) {
                                        System.out.println("La cuenta vinculada no existe.");
                                        return;
                                    }

                                    Prestamo prestamo = null;

                                    do {
                                        System.out.println("\n");
                                        pantallaOperaciones();
                                        opc3 = entrada.nextInt();
                                        entrada.nextLine(); // Limpiar el buffer

                                        switch (opc3) {
                                            case 1: // Realizar un préstamo
                                                if (prestamo == null) {
                                                    prestamo = Prestamo.crearPrestamo(entrada, cuentaVinculada);
                                                    System.out.println("Préstamo configurado exitosamente.");
                                                } else {
                                                    System.out.println("Ya existe un préstamo asociado a esta cuenta.");
                                                }
                                                break;

                                            case 2: // Realizar el pago de un préstamo
                                                if (prestamo != null) {
                                                    System.out.print("Ingrese el monto a pagar: ");
                                                    double montoPago = entrada.nextDouble();

                                                    System.out.print("Ingrese el monto adicional al pago regular (opcional, ingrese 0 si no aplica): ");
                                                    double pagoAdicional = entrada.nextDouble();

                                                    // Verificar y realizar el pago desde la cuenta vinculada
                                                    prestamo.actualizarCuentaPrestamo(cuentaVinculada, montoPago + pagoAdicional);
                                                } else {
                                                    System.out.println("No hay préstamo asociado para realizar el pago.");
                                                }
                                                break;

                                            case 3: // Verificar el estado del préstamo
                                                if (prestamo != null) {
                                                    System.out.println(prestamo.estadoPrestamo());
                                                } else {
                                                    System.out.println("No hay préstamo asociado para verificar el estado.");
                                                }
                                                break;

                                            case 4: // Penalización por mora
                                                if (prestamo != null) {
                                                    prestamo.penalizarMora();
                                                } else {
                                                    System.out.println("No hay préstamo asociado para penalizar mora.");
                                                }
                                                break;

                                            case 5: // Mostrar detalles del préstamo
                                                if (prestamo != null) {
                                                    prestamo.mostrarDetalles();
                                                } else {
                                                    System.out.println("No hay préstamo asociado para mostrar detalles.");
                                                }
                                                break;

                                            case 6: // Realizar una transacción
                                                System.out.print("Ingrese el tipo de transacción (deposito/retiro/transferencia): ");
                                                String tipoTransaccion = entrada.next();
                                                System.out.print("Ingrese el monto de la transacción: ");
                                                double montoTransaccion = entrada.nextDouble();
                                                entrada.nextLine(); // Limpiar el buffer

                                                if (tipoTransaccion.equalsIgnoreCase("deposito") || tipoTransaccion.equalsIgnoreCase("retiro")) {
                                                    Transaccion.crearYEjecutar(tipoTransaccion, montoTransaccion, fecha, cuentaVinculada, null);
                                                } else if (tipoTransaccion.equalsIgnoreCase("transferencia")) {
                                                    System.out.print("Ingrese el número de cuenta de destino: ");
                                                    String numeroCuentaDestino = entrada.nextLine();

                                                    CuentaHija cuentaDestino = null;
                                                    for (int i = 0; i < contadorCuentas; i++) {
                                                        if (cuentas[i].getNumeroCuenta().equals(numeroCuentaDestino)) {
                                                            cuentaDestino = cuentas[i];
                                                            break;
                                                        }
                                                    }

                                                    if (cuentaDestino != null) {
                                                        Transaccion.crearYEjecutar("Transferencia", montoTransaccion, fecha, cuentaVinculada, cuentaDestino);
                                                    } else {
                                                        System.out.println("La cuenta de destino no existe.");
                                                    }
                                                } else {
                                                    System.out.println("Tipo de transacción no válido.");
                                                }
                                                break;

                                            case 7: // Mostrar detalles de la transacción más reciente
                                                System.out.println("Detalle de la transacción más reciente:");
                                                if (cuentaVinculada.getHistorialCuenta() != null && !cuentaVinculada.getHistorialCuenta().isEmpty()) {
                                                    // Obtén el índice del último elemento de la lista
                                                    int indiceReciente = cuentaVinculada.getHistorialCuenta().size() - 1;
                                                    // Usa get() para acceder a la transacción más reciente
                                                    cuentaVinculada.getHistorialCuenta().get(indiceReciente).mostrarDetalles();
                                                } else {
                                                    System.out.println("No hay transacciones registradas.");
                                                }
                                                break;


                                            case 8: // Revisar el historial de la cuenta
                                                System.out.println("Historial de cuenta:");
                                                cuentaVinculada.mostrarHistorial();
                                                break;

                                            case 9: // Salir
                                                break;

                                            default:
                                                System.out.println("Opción no válida. Intente nuevamente.");
                                        }
                                    } while (opc3 != 9);

                                    break;
                                case 5:
                                    break;
                                default:
                                    System.out.println("Ingrese una opción válida e inténtelo nuevamente.");
                            }
                        } while(opc2 != 5);
                        System.out.println("\n");
                    }
                    else{
                        System.out.println("Usuario o contraseña no válidos.");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Ingrese una opción válida e inténtelo nuevamente.");
            }
            System.out.println("\n");
        } while(opc != 3);
    }

    public static int inicioDeSesionCajero(Cajero[] cajeros, int totalCajeros) {
        Scanner sc = new Scanner(System.in);
        String userIngresado, passIngresada;
        int index = -1; // Variable para almacenar el índice del cajero

        System.out.println("¿Es nuevo usuario? (1 = Sí, 2 = No): ");
        int opcion = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea después del entero
       

        if (opcion == 1) {
            String userGenerado = String.format("%10d", (long) (Math.random() * 1_000_000_000)).trim();
            String passGenerada = String.format("%04d", (int) (Math.random() * 1_000)).trim();

            System.out.println("Usuario generado: " + userGenerado);
            System.out.println("Clave generada: " + passGenerada);

            cajeros[totalCajeros].setUsuario(userGenerado);
            cajeros[totalCajeros].setClave(passGenerada);
            index = totalCajeros;

            System.out.print("¿Desea cambiar sus credenciales? (1 = Sí, 2 = No): ");
            int cambiarCredenciales = sc.nextInt();
            sc.nextLine();

            if (cambiarCredenciales == 1) {
                System.out.print("Escriba su nuevo usuario: ");
                userGenerado = sc.nextLine();
                System.out.print("Escriba su nueva contraseña: ");
                passGenerada = sc.nextLine();

                cajeros[totalCajeros].setUsuario(userGenerado);
                cajeros[totalCajeros].setClave(passGenerada);
            }
        } else if (opcion == 2) {
            System.out.println("\nComplete sus credenciales de inicio de sesión:");
            System.out.print("Ingrese su usuario: ");
            userIngresado = sc.nextLine();
            System.out.print("Ingrese su contraseña: ");
            passIngresada = sc.nextLine();

            for (int i = 0; i < totalCajeros; i++) {
                if (cajeros[i].getUsuario().equals(userIngresado) &&
                        cajeros[i].getClave().equals(passIngresada)) {
                    index = i;
                }
            }

            if (index == -1) {
                // Credenciales incorrectas
                System.out.println("Credenciales incorrectas. Intente nuevamente.");
            }
        }

        return index; // Devuelve el índice del cajero o -1 si no se encuentra
    }

    public static boolean inicioDeSesionAdministrador(){    //El administrador debe especificar sus credenciales de inicio de sesion dentro del programa
        String user = "AdministradorBanco";
        String pass = "administrador01";
        String userIngresadoA, passIngresadoA;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nComplete sus credenciales de inicio de sesión");
        System.out.print("Ingrese su usuario: ");
        userIngresadoA = sc.nextLine();
        System.out.print("Ingrese su contraseña: ");
        passIngresadoA = sc.nextLine();

        return user.equals(userIngresadoA) && pass.equals(passIngresadoA);
    }

    public static void pantallaDeInicioCajero(){
        System.out.println("----------\tBIENVENIDO AL SISTEMA BANCARIO\t----------");
        System.out.println("Escoja alguna de las siguientes opciones");
        System.out.println("1. Clientes");
        System.out.println("2. Cuentas");
        System.out.println("3. Tarjetas");
        System.out.println("4. Operaciones");
        System.out.println("5. Salir");
        System.out.print("Opción: ");
    }

    public static void pantallaDeInicioAdministrador(){
        System.out.println("----------\tBIENVENIDO AL SISTEMA BANCARIO\t----------");
        System.out.println("Escoja alguna de las siguientes opciones");
        System.out.println("1. Clientes");
        System.out.println("2. Empleados");
        System.out.println("3. Cuentas");
        System.out.println("4. Tarjetas");
        System.out.println("5. Sucursales");
        System.out.println("6. Salir");
        System.out.print("Opción: ");
    }

    public static void pantallaClientesAdministrador(){
        System.out.println("CLIENTES");
        System.out.println("1. Ordenar clientes por apellido");
        System.out.println("2. Mostrar carrera profesional de los clientes");
        System.out.println("3. Mostrar correos electronicos de los clientes");
        System.out.println("4. Mostrar numeros de telefonos de los clientes");
        System.out.println("5. Mostrar direccion de los clientes");
        System.out.println("6. Mostrar carga familiar de los clientes");
        System.out.println("7. Regresar");
        System.out.print("Opción: ");
    }

    public static void pantallaClientesCajero(){
        System.out.println("CLIENTES");
        System.out.println("1. Añadir un nuevo cliente"); //
        System.out.println("2. Modificar la información de un cliente");
        System.out.println("3. Eliminar cliente");
        System.out.println("4. Mostrar la información de un cliente");
        System.out.println("5. Añadir saldo a la cuenta de un cliente");
        System.out.println("6. Retirar saldo de la cuenta de un cliente");
        System.out.println("7. Regresar");
        System.out.print("Opción: ");
    }

    public static void pantallaEmpleadosAdministrador(){
        System.out.println("EMPLEADOS");
        System.out.println("1. Añadir un empleado");
        System.out.println("2. Modificar la información de un empleado");
        System.out.println("3. Eliminar un empleado existente");
        System.out.println("4. Mostrar la información de un empleado");
        System.out.println("5. Regresar");
        System.out.print("Opción: ");
    }

    public static void pantallaCuentasCajero(){
        System.out.println("CUENTAS");
        System.out.println("1. Abrir una cuenta corriente vinculada a un cliente");
        System.out.println("2. Eliminar una cuenta corriente vinculada a un cliente");
        System.out.println("3. Abrir una cuenta de ahorro vinculada a un cliente");
        System.out.println("4. Eliminar una cuenta de ahorro vinculada a un cliente");
        System.out.println("5. Abrir una cuenta con deposito a plazo fijo vinculada a un cliente");
        System.out.println("6. Eliminar una cuenta con deposito a plazo fijo vinculada a un cliente");
        System.out.println("7. Añadir saldo a la cuenta de un cliente");
        System.out.println("8. Retirar saldo a la cuenta de un cliente");
        System.out.println("9. Mostrar la información de la cuenta de un cliente");
        System.out.println("10. Salir");
        System.out.print("Opción: ");
    }

    public static void pantallaTarjetasCajero(){
        System.out.println("TARJETAS");
        System.out.println("1. Generar una tarjeta de crédito para un cliente");
        System.out.println("2. Bloquear la tarjeta de crédito de un cliente");
        System.out.println("3. Generar una tarjeta de débito para un cliente");
        System.out.println("4. Bloquear la tarjeta de débito de un cliente");
        System.out.println("5. Mostrar la información de la tarjeta de un cliente");
        System.out.println("6. Regresar");
        System.out.print("Opcion: ");
    }

    public static void pantallaSucursales(){
        System.out.println("SUCURSALES");
        System.out.println("1. Añadir una sucursal del banco");
        System.out.println("2. Eliminar una sucursal del banco");
        System.out.println("3. Modificar los datos de una sucursal del banco");
        System.out.println("4. Registrar empleados que trabajan en una sucursal");
        System.out.println("5. Eliminar empleados que trabajan en una sucursal");
        System.out.println("6. Regresar");
        System.out.print("Opción: ");
    }

    public static void pantallaOperaciones(){
        System.out.println("OPERACIONES");
        System.out.println("1. Realizar un préstamo");
        System.out.println("2. Realizar el pago de un préstamo");
        System.out.println("3. Verificar el estado de un préstamo");
        System.out.println("4. Renegociar plazo de un préstamo");
        System.out.println("5. Mostrar detalles de un préstamo");
        System.out.println("6. Realizar una transacción");
        System.out.println("7. Mostrar detalles de una transacción");
        System.out.println("8. Revisar el historial de una cuenta");
        System.out.println("9. Regresar");
        System.out.print("Opcion: ");
    }
}
