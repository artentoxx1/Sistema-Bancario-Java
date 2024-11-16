package Banco.SistemaBancario;
import java.util.ArrayList;
import java.util.Scanner;
public class Administrador extends Empleado {

    public Administrador(){
        super();
    }
    public Administrador(String nombreEmpleado, String apellidoPaternoEmpleado,String apellidoMaternoEmpleado, String sexoEmpleado,
                         String telefonoEmpleado, int edadEmpleado, String dniEmpleado, double salarioEmpleado,
                         String puestoEmpleado,String sucursalEmpleado) {
        super(nombreEmpleado, apellidoPaternoEmpleado,apellidoMaternoEmpleado, sexoEmpleado, telefonoEmpleado,
                edadEmpleado, dniEmpleado,salarioEmpleado, puestoEmpleado,sucursalEmpleado);
    }

    Scanner entrada = new Scanner(System.in);

    public void mostrar(Empleado empleado) {
        mostrarPersona(empleado);
    }

    public void aniadirPersona(Cajero[] cajeros, int totalCajeros){
        System.out.println("Ingrese el nombre del cajero: ");
        String nombreEmpleado = entrada.nextLine();
        System.out.println("Ingrese el apellido paterno del cajero: ");
        String apellidoPaternoEmpleado = entrada.nextLine();
        System.out.println("Ingrese el apellido materno del cajero: ");
        String apellidoMaternoEmpleado = entrada.nextLine();
        System.out.println("Ingrese el sexo del cajero: ");
        String sexoEmpleado = entrada.nextLine();
        System.out.println("Ingrese el telefono del cajero: ");
        String telefonoEmpleado = entrada.nextLine();
        System.out.println("Ingrese el edad del cajero: ");
        int edadEmpleado = entrada.nextInt();
        System.out.println("Ingrese el dni del cajero: ");
        String dniEmpleado = entrada.nextLine();
        System.out.println("Ingrese el salario del cajero: ");
        double salarioEmpleado = entrada.nextDouble();
        System.out.println("Ingrese el puesto del cajero: ");
        String puestoEmpleado = entrada.nextLine();
        System.out.println("Ingrese el codigo de la sucursal del cajero:");

        String sucursalEmpleado = entrada.nextLine();
        entrada.nextLine();

        Cajero nuevoCajero = new Cajero(nombreEmpleado,
                apellidoPaternoEmpleado,apellidoMaternoEmpleado, sexoEmpleado,
                telefonoEmpleado, edadEmpleado, dniEmpleado,

                salarioEmpleado, puestoEmpleado,sucursalEmpleado,"","");
        cajeros[totalCajeros] = nuevoCajero;
        totalCajeros++;
        //guardarCajerosEnArchivo(cajeros, totalCajeros)

    }
    public void eliminarPersona(Cajero[] cajeros,int totalCajeros, String numDni){
        int index = buscarPersona(cajeros, numDni); // Usamos la búsqueda para obtener el índice
        if (index != -1) {  // Si se encuentra el empleado
            // Desplazamos los elementos a la izquierda para eliminar el empleado
            for (int i = index; i < totalCajeros - 1; i++) {
                cajeros[i] = cajeros[i + 1];
            }
            totalCajeros--;
            //empleados[empleados.length - 1] = null;  // Eliminamos el último elemento (ahora duplicado)
            System.out.println("Cajero eliminado correctamente.");
            //guardarEmpleadosEnArchivo
        }
        else{
            System.out.println("Cajero no encontrado");
        }
    }
    public static int buscarPersona(Cajero[] cajeros, String numDni) {
        for (int i = 0; i < cajeros.length; i++) {
            if (cajeros[i] != null && cajeros[i].getDni().equals(numDni)) {
                return i; // Devuelve el índice del empleado encontrado
            }
        }
        return -1; // Si no se encuentra, se devuelve -1
    }
    public static void ordenarPorApellido(ArrayList<Cliente> clientes) {
        if (clientes.size() > 0) {
            for (int i = 0; i < clientes.size() - 1; i++) {
                for (int j = 0; j < clientes.size() - i - 1; j++) {
                    // Obtener los clientes en las posiciones j y j+1
                    Cliente cliente1 = clientes.get(j);
                    Cliente cliente2 = clientes.get(j + 1);

                    // Comparar apellidos de forma insensible a mayúsculas y minúsculas
                    if (cliente1.getApellidoMaterno().compareToIgnoreCase(cliente2.getApellidoMaterno()) > 0) {
                        // Intercambiar los elementos si están en el orden incorrecto
                        clientes.set(j, cliente2);
                        clientes.set(j + 1, cliente1);
                    }
                }
            }
        }
    }
    public static void mostrarCarreraProfesional(ArrayList<Cliente> clientes){
        if(clientes.size()>0){
            System.out.println("\n--------------------------\n");
            for(int i=0;i<clientes.size();i++){
                System.out.println("Carrera profesional del " + (i+1)+" cliente: " + clientes.get(i).getProfesionCliente());
            }
            System.out.println("\n--------------------------\n");
        }
        else{System.out.println("Primero añada algunos clientes");}
    }
    public static void mostrarCorreosClientes(ArrayList<Cliente> clientes){
        if(clientes.size()>0){
            System.out.println("\n--------------------------\n");
            for(int i=0;i<clientes.size();i++){
                System.out.println("Correo del " + (i+1)+" cliente: " + clientes.get(i).getCorreoCliente());
            }
            System.out.println("\n--------------------------\n");
        }
        else{System.out.println("Primero añada algunos clientes");}
    }
    public static void mostrarNumerosClientes(ArrayList<Cliente> clientes){
        if(clientes.size()>0){
            System.out.println("\n--------------------------\n");
            for(int i=0;i<clientes.size();i++){
                System.out.println("Numero telefonico del " + (i+1)+" cliente: " + clientes.get(i).getTelefono());
            }
            System.out.println("\n--------------------------\n");
        }
        else{
            System.out.println("Primero añada algunos clientes");
        }
    }
    public static void mostrarDireccionClientes(ArrayList<Cliente> clientes){
        if(clientes.size()>0){
            System.out.println("\n--------------------------\n");
            for(int i=0;i<clientes.size();i++){
                System.out.println("Direccion del " + (i+1)+" cliente: " + clientes.get(i).getCorreoCliente());
            }
            System.out.println("\n--------------------------\n");
        }
        else{System.out.println("Primero añada algunos clientes");}
    }
    public static void mostrarCargaFamiliarClientes(ArrayList<Cliente> clientes){
        if(clientes.size()>0){
            System.out.println("\n--------------------------\n");
            for(int i=0;i<clientes.size();i++){
                System.out.println("Carga familiar del " + (i+1)+" cliente: " + clientes.get(i).getCorreoCliente());
            }
            System.out.println("\n--------------------------\n");
        }
        else{System.out.println("Primero añada algunos clientes");}
    }
}