package Banco.SistemaBancario;
import java.util.Scanner;

public class Empleado extends Persona {
    protected int edadEmpleado;
    protected double salarioEmpleado;
    protected String puestoEmpleado;
    protected String sucursalEmpleado;

    Scanner entrada=new Scanner(System.in);

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
    public static void buscarEmpleado(Empleado[] empleados, String numDni) {
        int existencia=0;
        for(int i = 0; i < empleados.length; i++) {
            if (empleados[i].getDni().equals(numDni)) {
                System.out.println("Empleado: " + empleados[i].getNombres());
                System.out.println("Apellido: " + empleados[i].getApellidoEmpleado());
                System.out.println("Sexo: " + empleados[i].getSexo());
                System.out.println("Telefono: " + empleados[i].getTelefono());
                System.out.println("Edad: " + empleados[i].getEdadEmpleado());
                System.out.println("Dni: " + empleados[i].getDni());
                System.out.println("Salario: " + empleados[i].getSalarioEmpleado());
                System.out.println("Puesto: " + empleados[i].getPuestoEmpleado());
                System.out.println("Sucursal: " + empleados[i].getSucursalEmpleado());
                existencia=1;
            }

        }
        if (existencia==0){System.out.println("No existe empleado, que esta asociado al dni proporcionado");}
    }
    public void actualizarEmpleado(Empleado[] empleados, String numDni) {
        int existencia=0;
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].getDni().equals(numDni) ) {
                System.out.println("Seleccione que dato quiere actualizar");
                System.out.println("1.Salario.");
                System.out.println("2.Telefono.");
                System.out.println("3.Puesto.");
                int opcion=entrada.nextInt();
                switch (opcion){
                    case 1:{
                        System.out.println("Ingrese el nuevo salario: ");
                        double salario=entrada.nextDouble();
                        empleados[i].setSalarioEmpleado(salario);
                    };break;
                    case 2:{
                        System.out.println("Ingrese el nuevo telefono: ");
                        String telefono=entrada.next();
                        empleados[i].setTelefono(telefono);
                    };break;
                    case 3:{
                        System.out.println("Ingrese el nuevo puesto: ");
                        String puesto=entrada.next();
                        empleados[i].setPuestoEmpleado(puesto);
                    };break;

                }
                existencia=1;
            }

        }
        if (existencia==0){System.out.println("No existe empleado, que esta asociado al dni proporcionado");}

    }
    public void eliminarEmpleado(Empleado [] empleados, String numDni) {
        boolean flag = false;
        for (int i = 0; i < empleados.length; i++) {
            if(empleados[i].getDni().equals(numDni) || flag) {
                if(empleados[i+1] == null){
                    empleados[i] = null;
                    i = empleados.length;
                }else{
                    empleados[i] = empleados[i+1];
                }
                flag = true;
            }
        }
        System.out.println("Empleado eliminado correctamente");
        if (flag==false){System.out.println("No existe empleado, que esta asociado al dni proporcionado");}
    }
    //Por revisar
    public void mostrarEmpleado(Empleado empleado){
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