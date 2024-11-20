package Banco.SistemaBancario;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
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
    public void aniadirPersona(Cajero[] cajeros, int totalCajeros) {
        try {
            if (totalCajeros >= cajeros.length) {
                System.out.println("No hay espacio para agregar más cajeros. Total actual: " + totalCajeros);
            } else {
                System.out.println("Ingrese el nombre del cajero: ");
                String nombreEmpleado = entrada.nextLine();

                System.out.println("Ingrese el apellido paterno del cajero: ");
                String apellidoPaternoEmpleado = entrada.nextLine();

                System.out.println("Ingrese el apellido materno del cajero: ");
                String apellidoMaternoEmpleado = entrada.nextLine();

                System.out.println("Ingrese el sexo del cajero: ");
                String sexoEmpleado = entrada.nextLine();

                System.out.println("Ingrese el teléfono del cajero: ");
                String telefonoEmpleado = entrada.nextLine();

                System.out.println("Ingrese la edad del cajero: ");
                int edadEmpleado = entrada.nextInt();
                entrada.nextLine();

                System.out.println("Ingrese el DNI del cajero: ");
                String dniEmpleado = entrada.nextLine();

                System.out.println("Ingrese el salario del cajero: ");
                double salarioEmpleado = entrada.nextDouble();
                entrada.nextLine();

                System.out.println("Ingrese el puesto del cajero: ");
                String puestoEmpleado = entrada.nextLine();

                System.out.println("Ingrese el código de la sucursal del cajero: ");
                String sucursalEmpleado = entrada.nextLine();

                Cajero nuevoCajero = new Cajero(
                        nombreEmpleado,
                        apellidoPaternoEmpleado,
                        apellidoMaternoEmpleado,
                        sexoEmpleado,
                        telefonoEmpleado,
                        edadEmpleado,
                        dniEmpleado,
                        salarioEmpleado,
                        puestoEmpleado,
                        sucursalEmpleado,
                        "",
                        ""
                );

                cajeros[totalCajeros] = nuevoCajero;
                totalCajeros++;

                guardarCajerosArchivo(cajeros);
                System.out.println("Cajero añadido correctamente. Total actual: " + totalCajeros);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada inválida. Por favor, revise los datos ingresados.");
            entrada.nextLine();
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    public void eliminarPersona(Cajero[] cajeros, int totalCajeros, String numDni) {
        try {
            int index = buscarPersona(cajeros, numDni);
            if (index != -1) {

                for (int i = index; i < totalCajeros - 1; i++) {
                    cajeros[i] = cajeros[i + 1];
                }
                cajeros[totalCajeros - 1] = null;
                totalCajeros--;
                System.out.println("Cajero eliminado correctamente.");
                guardarCajerosArchivo(cajeros);
            } else {
                System.out.println("Cajero no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
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
    public void aniadirCajeroArchivo(Cajero cajero) {
        try (FileWriter writer = new FileWriter("cajeros.txt", true)) {
            if(cajero != null){
                writer.append(cajero.getNombres() + ";");
                writer.append(cajero.getApellidoPaterno() + ";");
                writer.append(cajero.getApellidoMaterno() + ";");
                writer.append(cajero.getSexo() + ";");
                writer.append(cajero.getDni() + ";");
                writer.append(cajero.getTelefono() + ";");
                writer.append(cajero.getPuestoEmpleado() + ";");
                writer.append(cajero.getSalarioEmpleado() + ";");
                writer.append(cajero.getUsuario()+";");
                writer.append(cajero.getClave()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void guardarCajerosArchivo(Cajero[] cajeros) {
        try (FileWriter writer = new FileWriter("cajeros.txt")) {
            for(Cajero cajero : cajeros) {
                if(cajero != null){
                    writer.append(cajero.getNombres() + ";");
                    writer.append(cajero.getApellidoPaterno() + ";");
                    writer.append(cajero.getApellidoMaterno() + ";");
                    writer.append(cajero.getSexo() + ";");
                    writer.append(cajero.getDni() + ";");
                    writer.append(cajero.getTelefono() + ";");
                    writer.append(cajero.getPuestoEmpleado() + ";");
                    writer.append(cajero.getSalarioEmpleado() + ";");
                    writer.append(cajero.getUsuario()+";");
                    writer.append(cajero.getClave()+"\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}