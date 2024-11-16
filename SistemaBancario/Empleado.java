package Banco.SistemaBancario;
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
        System.out.println("Ingrese el nombre del empleado: ");
        String nombreEmpleado = entrada.nextLine();
        System.out.println("Ingrese el apellido paterno del empleado: ");
        String apellidoPaternoEmpleado = entrada.nextLine();
        System.out.println("Ingrese el apellido materno del empleado: ");
        String apellidoMaternoEmpleado = entrada.nextLine();
        System.out.println("Ingrese el sexo del empleado: ");
        String sexoEmpleado = entrada.nextLine();
        System.out.println("Ingrese el telefono del empleado: ");
        String telefonoEmpleado = entrada.nextLine();
        System.out.println("Ingrese el edad del empleado: ");
        int edadEmpleado = entrada.nextInt();
        System.out.println("Ingrese el dni del empleado: ");
        String dniEmpleado = entrada.nextLine();
        System.out.println("Ingrese el salario del empleado: ");
        double salarioEmpleado = entrada.nextDouble();
        System.out.println("Ingrese el puesto del empleado: ");
        String puestoEmpleado = entrada.nextLine();
        System.out.println("Ingrese el codigo de la sucursal del empleado:");
        String sucursalEmpleado = entrada.nextLine();


        Empleado nuevoEmpleado = new Empleado(nombreEmpleado,
                apellidoPaternoEmpleado,apellidoMaternoEmpleado, sexoEmpleado,
                telefonoEmpleado, edadEmpleado, dniEmpleado,
                salarioEmpleado, puestoEmpleado,sucursalEmpleado);
        empleados[totalEmpleados] = nuevoEmpleado;
        totalEmpleados++;
        //guardarCajerosEnArchivo(cajeros, totalCajeros)
    }
    public void actualizarPersona(Empleado[] empleados,int totalEmpleados, String numDni) {
        int index = buscarPersona(empleados, numDni); // Usamos la búsqueda para obtener el índice
        if (index != -1) {  // Si se encuentra el empleado
            // Realizar las actualizaciones (por ejemplo, actualizar el salario)
            System.out.println("Seleccione qué dato quiere actualizar:");
            System.out.println("1. Salario.");
            System.out.println("2. Teléfono.");
            System.out.println("3. Puesto.");
            int opcion = entrada.nextInt();
            entrada.nextLine();  // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nuevo salario: ");
                    double salario = entrada.nextDouble();
                    empleados[index].setSalarioEmpleado(salario);
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo teléfono: ");
                    String telefono = entrada.nextLine();
                    empleados[index].setTelefono(telefono);
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo puesto: ");
                    String puesto = entrada.nextLine();
                    empleados[index].setPuestoEmpleado(puesto);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            //guardarEmpleadoEnArchivo(empleados,totalEmpleados);
        }
        else{
            System.out.println("Empleado no encontrado");
        }
    }

    public void eliminarPersona(Empleado [] empleados,int totalEmpleados, String numDni) {
        int index = buscarPersona(empleados, numDni); // Usamos la búsqueda para obtener el índice
        if (index != -1) {  // Si se encuentra el empleado
            // Desplazamos los elementos a la izquierda para eliminar el empleado
            for (int i = index; i < totalEmpleados - 1; i++) {
                empleados[i] = empleados[i + 1];

            }
            totalEmpleados--;
            //empleados[empleados.length - 1] = null;  // Eliminamos el último elemento (ahora duplicado)
            System.out.println("Empleado eliminado correctamente.");
            //guardarEmpleadosEnArchivo
        }
        else{
            System.out.println("Empleado no encontrado");
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