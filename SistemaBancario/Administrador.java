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
    public void aniadirPersona(ArrayList<Cajero> cajeros) {
        boolean datosValidos = true; // Bandera para controlar errores

        try {
            System.out.println("Ingrese el nombre del cajero: ");
            String nombreEmpleado = entrada.nextLine().trim();

            System.out.println("Ingrese el apellido paterno del cajero: ");
            String apellidoPaternoEmpleado = entrada.nextLine().trim();

            System.out.println("Ingrese el apellido materno del cajero: ");
            String apellidoMaternoEmpleado = entrada.nextLine().trim();

            System.out.println("Ingrese el sexo del cajero: ");
            String sexoEmpleado = entrada.nextLine().trim();

            System.out.println("Ingrese el teléfono del cajero: ");
            String telefonoEmpleado = entrada.nextLine().trim();

            System.out.println("Ingrese la edad del cajero: ");
            int edadEmpleado = entrada.nextInt();
            entrada.nextLine();  // Limpiar buffer

            System.out.println("Ingrese el DNI del cajero: ");
            String dniEmpleado = entrada.nextLine().trim();
            if (dniEmpleado.length() != 8) {
                System.out.println("DNI inválido. Debe tener 8 dígitos numéricos.");
                datosValidos = false;
            }

            System.out.println("Ingrese el salario del cajero: ");
            double salarioEmpleado = entrada.nextDouble();
            entrada.nextLine(); // Limpiar buffer

            System.out.println("Ingrese el puesto del cajero: ");
            String puestoEmpleado = entrada.nextLine().trim();

            System.out.println("Ingrese el código de la sucursal del cajero: ");
            String sucursalEmpleado = entrada.nextLine().trim();

            // Validación de datos
            if (edadEmpleado <= 0) {
                System.out.println("Edad inválida. Debe ser mayor a 0.");
                datosValidos = false;
            }
            if (salarioEmpleado < 0) {
                System.out.println("Salario inválido. Debe ser mayor o igual a 0.");
                datosValidos = false;
            }

            // Solo agregar el cajero si los datos son válidos
            if (datosValidos) {
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
                        "", // Suponiendo que hay campos vacíos o nulos
                        ""
                );

                cajeros.add(nuevoCajero); // Añadir al ArrayList en lugar de un arreglo fijo
                guardarCajerosArchivo(cajeros); // Guardar la lista actualizada en el archivo
                System.out.println("Cajero añadido correctamente. Total actual: " + cajeros.size());
            } else {
                System.out.println("No se pudo añadir el cajero debido a errores en los datos.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada inválida. Por favor, revise los datos ingresados.");
            entrada.nextLine();
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    public void eliminarPersona(ArrayList<Cajero> cajeros, String numDni) {
        Cajero cajero = buscarPersona(cajeros, numDni);
        try {
            if (cajero == null) {
                throw new IllegalArgumentException("No se encontró un cajero con el DNI especificado.");
            }
            else{
                cajeros.remove(cajero);
                guardarCajerosArchivo(cajeros);
                System.out.println("Cajero eliminado exitosamente");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public Cajero buscarPersona(ArrayList<Cajero> cajeros, String numDni) {
        for (Cajero cajero : cajeros) {
            if (cajero.getDni().equals(numDni)) {
                return cajero; // Devuelve el cliente si lo encuentra
            }
        }

        System.out.println("No existe cajero asociado al DNI proporcionado.");
        return null; // Retorna null si no encuentra al cajero
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
    public void guardarCajerosArchivo(ArrayList<Cajero> cajeros) {
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