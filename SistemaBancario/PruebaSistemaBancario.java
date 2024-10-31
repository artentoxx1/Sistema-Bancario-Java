package Banco.SistemaBancario;

import java.util.Scanner;

public class PruebaSistemaBancario {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Administrador admin= new Administrador("Andre",
                "Salas","Masculino","923826161",
                19,"71345893",8235.45,
                "Administrador","BCP Av. Argentina");

        Cliente[] clientes;
        clientes = new Cliente[100];
        Empleado[] empleados;
        empleados = new Empleado[100];
        int opc, opc2, opc3;

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
                                            case 7:break;
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
                                                admin.AniadirEmpleado(empleados);
                                            case 2:
                                                System.out.println("Ingrese el DNI del empleado: ");
                                                dni=entrada.nextLine();
                                                admin.actualizarEmpleado(empleados,dni);
                                            case 3:
                                                System.out.println("Ingrese el DNI del empleado: ");
                                                dni=entrada.nextLine();
                                                admin.eliminarEmpleado(empleados,dni);
                                            case 4:
                                                System.out.println("Ingrese el DNI del empleado: ");
                                                dni=entrada.nextLine();
                                                Empleado.buscarEmpleado(empleados,dni);
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

                                        switch(opc3) {

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
                    if(inicioDeSesionCajero()){
                        do{
                            System.out.println("\n");
                            pantallaDeInicioCajero();
                            opc2 = entrada.nextInt();

                            switch(opc2) {
                                case 1:
                                    do{
                                        System.out.println("\n");
                                        pantallaClientesCajero();
                                        opc3 = entrada.nextInt();

                                        switch(opc3) {

                                        }
                                    } while(opc3 != 7);

                                    break;
                                case 2:
                                    do{
                                        System.out.println("\n");
                                        pantallaCuentasCajero();
                                        opc3 = entrada.nextInt();

                                        switch(opc3) {

                                        }
                                    } while(opc3 != 10);

                                    break;
                                case 3:
                                    do{
                                        System.out.println("\n");
                                        pantallaTarjetasCajero();
                                        opc3 = entrada.nextInt();

                                        switch(opc3) {

                                        }
                                    } while(opc3 != 8);

                                    break;
                                case 4:
                                    do{
                                        System.out.println("\n");
                                        pantallaOperaciones();
                                        opc3 = entrada.nextInt();

                                        switch(opc3) {

                                        }
                                    } while(opc3 != 4);

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

    public static boolean inicioDeSesionCajero() {
        // Todos los empleados deberán especificar sus credenciales de inicio de sesión dentro del programa
        String userGenerado = String.format("%10d", (long) (Math.random() * 1_000_000_000)).trim();
        String passGenerada = String.format("%04d", (int) (Math.random() * 1_000)).trim();
        String userIngresado, passIngresada;
        int opcion, cambiarCredenciales;

        Scanner sc = new Scanner(System.in);

        System.out.println("¿Es nuevo usuario? (1 = Sí, 2 = No): ");
        opcion = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea después del entero

        if (opcion == 1) {
            System.out.println("Usuario generado: " + userGenerado);
            System.out.println("Clave generada: " + passGenerada);
            System.out.println("¿Desea cambiar sus credenciales? (1 = Sí, 2 = No): ");
            cambiarCredenciales = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea después del entero

            if (cambiarCredenciales == 1) {
                System.out.print("Escriba su nuevo usuario: ");
                userGenerado = sc.nextLine();
                System.out.print("Escriba su nueva contraseña: ");
                passGenerada = sc.nextLine();
            }
        }

        // Proceso de inicio de sesión
        System.out.println("\nComplete sus credenciales de inicio de sesión:");
        System.out.print("Ingrese su usuario: ");
        userIngresado = sc.nextLine();
        System.out.print("Ingrese su contraseña: ");
        passIngresada = sc.nextLine();

        // Validar credenciales ingresadas con las generadas o cambiadas
        return userGenerado.equals(userIngresado) && passGenerada.equals(passIngresada);
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
        System.out.println("1. Añadir un nuevo cliente");
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
        System.out.println("2. Anular la tarjeta de crédito de un cliente");
        System.out.println("3. Generar una tarjeta de débito para un cliente");
        System.out.println("4. Anular la tarjeta de débito de un cliente");
        System.out.println("5. Vincular la tarjeta de crédito a una cuenta bancaria");
        System.out.println("6. Vincular la tarjeta de débito a una cuenta bancaria");
        System.out.println("7. Mostrar la información de la tarjeta de un cliente");
        System.out.println("8. Regresar");
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
        System.out.println("2. Realizar una transacción");
        System.out.println("3. Revisar el historial de cuenta");
        System.out.println("4. Regresar");
        System.out.print("Opcion: ");
    }
}