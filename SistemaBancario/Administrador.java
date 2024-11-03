package Banco.SistemaBancario;
import java.util.Scanner;
public class Administrador extends Empleado {

    public Administrador(String nombreEmpleado, String apellidoPaternoEmpleado,String apellidoMaternoEmpleado, String sexoEmpleado,
                         String telefonoEmpleado, int edadEmpleado, String dniEmpleado, double salarioEmpleado,
                         String puestoEmpleado,String sucursalEmpleado) {
        super(nombreEmpleado, apellidoPaternoEmpleado,apellidoMaternoEmpleado, sexoEmpleado, telefonoEmpleado,
                edadEmpleado, dniEmpleado,salarioEmpleado, puestoEmpleado,sucursalEmpleado);
    }

    Scanner entrada = new Scanner(System.in);

    public void mostrar(Empleado empleado) {
        mostrarEmpleado(empleado);
    }

    public void AniadirEmpleado(Empleado[] empleados){
        System.out.print("Ingrese el nombre del empleado: ");
        String nombreEmpleado = entrada.nextLine();
        System.out.print("Ingrese el apellido paterno del empleado: ");
        String apellidoPaternoEmpleado = entrada.nextLine();
        System.out.print("Ingrese el apellido materno del empleado: ");
        String apellidoMaternoEmpleado = entrada.nextLine();
        System.out.print("Ingrese el sexo del empleado: ");
        String sexoEmpleado = entrada.nextLine();
        System.out.print("Ingrese el telefono del empleado: ");
        String telefonoEmpleado = entrada.nextLine();
        System.out.print("Ingrese el edad del empleado: ");
        int edadEmpleado = entrada.nextInt();
        System.out.print("Ingrese el dni del empleado: ");
        String dniEmpleado = entrada.nextLine();
        entrada.nextLine();
        System.out.print("Ingrese el salario del empleado: ");
        double salarioEmpleado = entrada.nextDouble();
        entrada.nextLine();
        System.out.print("Ingrese el puesto del empleado: ");
        String puestoEmpleado = entrada.nextLine();
        entrada.nextLine();
        System.out.print("Ingrese el codigo de la sucursal del empleado: ");
        String sucursalEmpleado = entrada.nextLine();
        entrada.nextLine();

        Empleado nuevoEmpleado = new Empleado(nombreEmpleado,
                apellidoPaternoEmpleado,apellidoMaternoEmpleado, sexoEmpleado,
                telefonoEmpleado, edadEmpleado, dniEmpleado,
                salarioEmpleado, puestoEmpleado,sucursalEmpleado);
    }


    public static void eliminarEmpleadoSucursal(Empleado[] empleados, String numDni){
        for(int i=0;i<empleados.length;i++){
            if(empleados[i].getDni().equals(numDni)){
                empleados[i].setSucursalEmpleado(null);
            }
        }
    }

    public void  modificarDatosSucursal(Sucursal[] sucursal, String Codigo){

        for(int i=0;i<sucursal.length;i++){
            if(sucursal[i].getCodigo().equals(Codigo)){
                System.out.println("Seleccione una opcion: ");
                System.out.println("1.Modificar direccion de la sucursal. ");
                System.out.println("2.Modificar codigo de la sucursal. ");
                System.out.println("3.Modificar ciudad de la sucursal. ");
                int opcion1= entrada.nextInt();
                switch(opcion1){
                    case 1:{
                        System.out.println("Ingrese la nueva direccion: ");
                        String direccion = entrada.next();
                        sucursal[i].setDireccion(direccion);
                    };break;
                    case 2:{
                        System.out.println("Ingrese el nuevo codigo de la sucursal: ");
                        String nuevo = entrada.next();
                        sucursal[i].setCodigo(nuevo);
                        System.out.println(sucursal[i].getCodigo());
                    };break;
                    case 3:{
                        System.out.println("Ingrese la nueva ciudad de la sucursal: ");
                        String ciudad = entrada.next();
                        sucursal[i].setCiudad(ciudad);
                    };break;
                }
            }
        }
    }

    public static void  buscarSucursal(Sucursal[] sucursal, String Codigo) {
        int existencia=0;
        for(int i=0;i<sucursal.length;i++){
            if(sucursal[i].getCodigo().equals(Codigo)) {
                sucursal[i].mostrarInfoSucursal();
                existencia = 1;
                System.out.println("Si existe el sucursal buscado, los datos son: " + sucursal[i].getCiudad() + sucursal[i].getDireccion() + sucursal[i].getCodigo());
            }
        }
        if (existencia==0){
            System.out.println("No hay sucursal asociado al codigo proporcionado.");
        }
    }

    public static void eliminarSucursal(Sucursal[] sucursal, String Codigo ){
        int existencia=0;
        boolean flag = false;
        for(int i=0;i<sucursal.length;i++){
            if(sucursal[i].getCodigo().equals(Codigo) || flag) {
             if(sucursal[i+1] == null){
                sucursal[i] = null;
                i = sucursal.length;
             }else{
                 sucursal[i] = sucursal[i+1];
             }
            flag = true;
            }
        }
        if (existencia==0){
            System.out.println("No hay sucursal asociado al codigo proporcionado.");
        }
    }
    public static void ordenarPorApellido(Cliente[] clientes) {
        if(clientes.length>0){
            for (int i = 0; i < clientes.length - 1; i++) {
                for (int j = 0; j < clientes.length - i - 1; j++) {
                    if (clientes[j].getApellidoMaterno().compareToIgnoreCase(clientes[j + 1].getApellidoMaterno()) > 0) {
                        Cliente temp = clientes[j];
                        clientes[j] = clientes[j + 1];
                        clientes[j + 1] = temp;
                    }
                }
            }
            System.out.println("\n--------------------------\n");
            for(int i=0;i<clientes.length;i++){
                System.out.println(clientes[i].getApellidoMaterno()+" "+clientes[i].getApellidoPaterno()+" "+clientes[i].getNombres());
            }
            System.out.println("\n--------------------------\n");
        }
        else{System.out.println("No hay clientes registrados");}
    }
    public static void mostrarCarreraProfesional(Cliente[] clientes){
        if(clientes.length>0){
            System.out.println("\n--------------------------\n");
            for(int i=0;i<clientes.length;i++){
                System.out.println("Carrera profesional del " + (i+1)+" cliente: " + clientes[i].getProfesionCliente());
            }
            System.out.println("\n--------------------------\n");
        }
        else{System.out.println("Primero añada algunos clientes");}
    }
    public static void mostrarCorreosClientes(Cliente[] clientes){
        if(clientes.length>0){
            System.out.println("\n--------------------------\n");
            for(int i=0;i<clientes.length;i++){
                System.out.println("Correo del " + (i+1)+" cliente: " + clientes[i].getCorreoCliente());
            }
            System.out.println("\n--------------------------\n");
        }
        else{System.out.println("Primero añada algunos clientes");}
    }
    public static void mostrarNumerosClientes(Cliente[] clientes){
        if(clientes.length>0){
            System.out.println("\n--------------------------\n");
            for(int i=0;i<clientes.length;i++){
                System.out.println("Numero telefonico del " + (i+1)+" cliente: " + clientes[i].getTelefono());
            }
            System.out.println("\n--------------------------\n");
        }
        else{
            System.out.println("Primero añada algunos clientes");
        }
    }
    public static void mostrarDireccionClientes(Cliente[] clientes){
        if(clientes.length>0){
            System.out.println("\n--------------------------\n");
            for(int i=0;i<clientes.length;i++){
                System.out.println("Direccion del " + (i+1)+" cliente: " + clientes[i].getCorreoCliente());
            }
            System.out.println("\n--------------------------\n");
        }
        else{System.out.println("Primero añada algunos clientes");}
    }
    public static void mostrarCargaFamiliarClientes(Cliente[] clientes){
        if(clientes.length>0){
            System.out.println("\n--------------------------\n");
            for(int i=0;i<clientes.length;i++){
                System.out.println("Carga familiar del " + (i+1)+" cliente: " + clientes[i].getCorreoCliente());
            }
            System.out.println("\n--------------------------\n");
        }
        else{System.out.println("Primero añada algunos clientes");}
    }
    public void agregarSucursal(Sucursal [] sucursales){
        System.out.println("Ingrese la direccion de la sucursal : ");
        String direccion = entrada.nextLine();
        System.out.println("Ingrese el codigo de la sucursal: ");
        String codigo = entrada.nextLine();
        System.out.println("Ingrese la ciudad en donde se encuentra la sucursal: ");
        String ciudad = entrada.nextLine();
        System.out.println("Ingrese la cantidad de empleados de la sucursal: ");
        int cantidadEmple = entrada.nextInt();
        Empleado[] empleados;
        empleados = new Empleado[100];
        Sucursal su1= new Sucursal(direccion,codigo,ciudad,cantidadEmple,empleados);
        for(int i =0;i<sucursales.length;i++){
            if(sucursales[i]==null){
                sucursales[i]=su1;
            }
            else if(i+1==sucursales.length && sucursales[i]!=null){
                Sucursal[] sucursales2;
                sucursales2 = new Sucursal[(sucursales.length + 10)];
                for(int a =0;a<sucursales.length;a++) {
                    sucursales2[i]=sucursales[i];
                }
                sucursales2[sucursales.length]=su1;
            }
        }
    }
}