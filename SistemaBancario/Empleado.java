package Banco.SistemaBancario;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Empleado extends Persona {
    protected int edadEmpleado;
    protected double salarioEmpleado;
    protected String puestoEmpleado;
    protected String sucursalEmpleado;

    Scanner entrada=new Scanner(System.in);
    public Empleado() {
        super();
        edadEmpleado=0;
        salarioEmpleado=0;
        puestoEmpleado="";
        sucursalEmpleado="";
    }
    public Empleado(String nombreEmpleado, String apellidoPaternoEmpleado,
                    String apellidoMaternoEmpleado, String sexoEmpleado,
                    String telefonoEmpleado, int edadEmpleado,
                    String dniEmpleado, double salarioEmpleado, String puestoEmpleado,
                    String sucursalEmpleado) {
        super(nombreEmpleado, apellidoPaternoEmpleado,apellidoMaternoEmpleado,  sexoEmpleado, dniEmpleado, telefonoEmpleado);
        this.edadEmpleado = edadEmpleado;
        this.salarioEmpleado = salarioEmpleado;
        this.puestoEmpleado = puestoEmpleado;
        this.sucursalEmpleado = sucursalEmpleado;
    }
    public String getNombres(){
        return nombres;
    }
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    public String getApellidoPaterno(){
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno){
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno(){
        return apellidoMaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno){
        this.apellidoMaterno = apellidoMaterno;
    }
    public String getSexo(){
        return sexo;
    }
    public String getDni(){
        return dni;
    }
    public void setDni(String dni){
        this.dni = dni;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public String getApellidoEmpleado() {
        String apellidos= apellidoPaterno+" "+apellidoMaterno;
        return apellidos;
    }
    public int getEdadEmpleado() {
        return edadEmpleado;
    }
    public void setEdadEmpleado(int edadEmpleado) {
        this.edadEmpleado = edadEmpleado;
    }
    public double getSalarioEmpleado() {
        return salarioEmpleado;
    }
    public void setSalarioEmpleado(double salarioEmpleado) {
        this.salarioEmpleado = salarioEmpleado;
    }
    public String getPuestoEmpleado() {
        return puestoEmpleado;
    }
    public void setPuestoEmpleado(String puestoEmpleado) {
        this.puestoEmpleado = puestoEmpleado;
    }
    public String getSucursalEmpleado() {
        return sucursalEmpleado;
    }
    public void setSucursalEmpleado(String sucursalEmpleado) {
        this.sucursalEmpleado = sucursalEmpleado;
    }

    public void aniadirPersona(Empleado[] empleados, int totalEmpleados){
        String nombreEmpleado = "", apellidoPaternoEmpleado = "", apellidoMaternoEmpleado = "", sexoEmpleado = "",
                telefonoEmpleado = "", dniEmpleado = "", puestoEmpleado = "", sucursalEmpleado = "";
        int edadEmpleado = 0;
        double salarioEmpleado = 0;
        boolean datosValidos = true;

        try {

            System.out.println("Ingrese el nombre del empleado: ");
            nombreEmpleado = entrada.nextLine();
            if (nombreEmpleado.trim().isEmpty()) {
                System.out.println("Error: El nombre no puede estar vacío.");
                datosValidos = false;
            }


            System.out.println("Ingrese el apellido paterno del empleado: ");
            apellidoPaternoEmpleado = entrada.nextLine();
            if (apellidoPaternoEmpleado.trim().isEmpty()) {
                System.out.println("Error: El apellido paterno no puede estar vacío.");
                datosValidos = false;
            }


            System.out.println("Ingrese el apellido materno del empleado: ");
            apellidoMaternoEmpleado = entrada.nextLine();
            if (apellidoMaternoEmpleado.trim().isEmpty()) {
                System.out.println("Error: El apellido materno no puede estar vacío.");
                datosValidos = false;
            }


            System.out.println("Ingrese el sexo del empleado: ");
            sexoEmpleado = entrada.nextLine();
            if (sexoEmpleado.trim().isEmpty()) {
                System.out.println("Error: El sexo no puede estar vacío.");
                datosValidos = false;
            }


            System.out.println("Ingrese el teléfono del empleado: ");
            telefonoEmpleado = entrada.nextLine();
            if (telefonoEmpleado.trim().isEmpty()) {
                System.out.println("Error: El teléfono no puede estar vacío.");
                datosValidos = false;
            }


            System.out.println("Ingrese la edad del empleado: ");
            try {
                edadEmpleado = entrada.nextInt();
                if (edadEmpleado <= 0) {
                    System.out.println("Error: La edad debe ser un número positivo.");
                    datosValidos = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: La edad debe ser un número.");
                entrada.nextLine(); // Limpia el buffer
                datosValidos = false;
            }


            entrada.nextLine();
            System.out.println("Ingrese el DNI del empleado: ");
            dniEmpleado = entrada.nextLine();
            if (dniEmpleado.length() != 8 || !dniEmpleado.matches("\\d+")) {
                System.out.println("Error: El DNI debe tener 8 dígitos numéricos.");
                datosValidos = false;
            }


            System.out.println("Ingrese el salario del empleado: ");
            try {
                salarioEmpleado = entrada.nextDouble();
                if (salarioEmpleado <= 0) {
                    System.out.println("Error: El salario debe ser un número positivo.");
                    datosValidos = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: El salario debe ser un número.");
                entrada.nextLine();
                datosValidos = false;
            }


            entrada.nextLine();
            System.out.println("Ingrese el puesto del empleado: ");
            puestoEmpleado = entrada.nextLine();
            if (puestoEmpleado.trim().isEmpty()) {
                System.out.println("Error: El puesto no puede estar vacío.");
                datosValidos = false;
            }


            System.out.println("Ingrese el código de la sucursal del empleado: ");
            sucursalEmpleado = entrada.nextLine();
            if (sucursalEmpleado.trim().isEmpty()) {
                System.out.println("Error: El código de sucursal no puede estar vacío.");
                datosValidos = false;
            }
        }catch(Exception e){
            System.out.println("Error inesperado: " + e.getMessage());
            datosValidos = false;
        }
        if (datosValidos) {
            Empleado nuevoEmpleado = new Empleado(
                    nombreEmpleado, apellidoPaternoEmpleado, apellidoMaternoEmpleado, sexoEmpleado,
                    telefonoEmpleado, edadEmpleado, dniEmpleado, salarioEmpleado, puestoEmpleado, sucursalEmpleado
            );

            empleados[totalEmpleados] = nuevoEmpleado;
            totalEmpleados++;
            System.out.println("Empleado agregado correctamente.");
        } else {
            System.out.println("No se pudo añadir al empleado debido a errores en los datos.");
        }
    }
    public void actualizarPersona(Empleado[] empleados, int totalEmpleados, String numDni) {
        int index = buscarPersona(empleados, numDni);
        if (index != -1) {
            boolean datosValidos = true;

            System.out.println("Seleccione qué dato quiere actualizar:");
            System.out.println("1. Salario.");
            System.out.println("2. Teléfono.");
            System.out.println("3. Puesto.");

            int opcion = -1;
            try {
                opcion = entrada.nextInt();
                entrada.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Opción no válida. Debe ingresar un número.");
                entrada.nextLine();
                datosValidos = false;
            }

            if (datosValidos) {
                switch (opcion) {
                    case 1:
                        double salario = 0;
                        System.out.println("Ingrese el nuevo salario: ");
                        try {
                            salario = entrada.nextDouble();
                            entrada.nextLine();
                            if (salario <= 0) {
                                System.out.println("Error: El salario debe ser un número positivo.");
                            } else {
                                empleados[index].setSalarioEmpleado(salario);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Error: El salario debe ser un número.");
                            entrada.nextLine();
                        }
                        break;

                    case 2:
                        String telefono = "";
                        System.out.println("Ingrese el nuevo teléfono: ");
                        telefono = entrada.nextLine();
                        if (telefono.trim().isEmpty()) {
                            System.out.println("Error: El teléfono no puede estar vacío.");
                        } else {
                            empleados[index].setTelefono(telefono);
                        }
                        break;

                    case 3:
                        String puesto = "";
                        System.out.println("Ingrese el nuevo puesto: ");
                        puesto = entrada.nextLine();
                        if (puesto.trim().isEmpty()) {
                            System.out.println("Error: El puesto no puede estar vacío.");
                        } else {
                            empleados[index].setPuestoEmpleado(puesto);
                        }
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            }
        } else {
            System.out.println("Empleado no encontrado");
        }
    }
    public void eliminarPersona(Empleado[] empleados, int totalEmpleados, String numDni) {
        try {
            int index = buscarPersona(empleados, numDni); // Usamos la búsqueda para obtener el índice

            if (index != -1) {
                for (int i = index; i < totalEmpleados - 1; i++) {
                    empleados[i] = empleados[i + 1];
                }

                empleados[totalEmpleados - 1] = null;
                totalEmpleados--;

                System.out.println("Empleado eliminado correctamente.");
            } else {
                System.out.println("Empleado no encontrado");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: El índice está fuera de los límites del array.");
        } catch (NullPointerException e) {
            System.out.println("Error: El array de empleados es nulo o no está correctamente inicializado.");
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    public static int buscarPersona(Empleado[] empleados, String numDni) {
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i] != null && empleados[i].getDni().equals(numDni)) {
                return i; // Devuelve el índice del empleado encontrado
            }
        }
        return -1; // Si no se encuentra, se devuelve -1
    }
    public void mostrarPersona(Empleado empleado){
        if(empleado!=null){
            System.out.println("Nombre: "+empleado.getNombres());
            System.out.println("Apellido: "+empleado.getApellidoEmpleado());
            System.out.println("Sexo: "+empleado.getSexo());
            System.out.println("Telefono: "+empleado.getTelefono());
            System.out.println("Edad: "+empleado.getEdadEmpleado());
            System.out.println("Dni: "+empleado.getDni());
            System.out.println("Salario: "+empleado.getSalarioEmpleado());
            System.out.println("Puesto: "+empleado.getPuestoEmpleado());
            System.out.println("Sucursa"+empleado.getSucursalEmpleado());
        }
    }
}