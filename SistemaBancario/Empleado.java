package Banco.SistemaBancario;
import java.util.Scanner;

public class Empleado {
    protected String nombreEmpleado;
    protected String apellidoEmpleado;
    protected String sexoEmpleado;
    protected String TelefonoEmpleado;
    protected int edadEmpleado;
    protected String dniEmpleado;
    protected double salarioEmpleado;
    protected String puestoEmpleado;
    protected String sucursalEmpleado;

    Scanner entrada=new Scanner(System.in);

    public Empleado() {};

    public Empleado(String nombreEmpleado, String apellidoEmpleado, String sexoEmpleado, String telefonoEmpleado, int edadEmpleado, String dniEmpleado, double salarioEmpleado, String puestoEmpleado,String sucursalEmpleado ) {
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado=apellidoEmpleado;
        this.sexoEmpleado = sexoEmpleado;
        this.TelefonoEmpleado = telefonoEmpleado;
        this.edadEmpleado = edadEmpleado;
        this.dniEmpleado = dniEmpleado;
        this.salarioEmpleado = salarioEmpleado;
        this.puestoEmpleado = puestoEmpleado;
        this.sucursalEmpleado = sucursalEmpleado;
    }
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }
    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }
    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }
    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }
    public String getSexoEmpleado() {
        return sexoEmpleado;
    }
    public void setSexoEmpleado(String sexoEmpleado) {
        this.sexoEmpleado = sexoEmpleado;
    }
    public String getTelefonoEmpleado() {
        return TelefonoEmpleado;
    }
    public void setTelefonoEmpleado(String telefonoEmpleado) {
        TelefonoEmpleado = telefonoEmpleado;
    }
    public int getEdadEmpleado() {
        return edadEmpleado;
    }
    public void setEdadEmpleado(int edadEmpleado) {
        this.edadEmpleado = edadEmpleado;
    }
    public String getDniEmpleado() {
        return dniEmpleado;
    }
    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
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
            if (empleados[i].getDniEmpleado().equals(numDni)) {
                System.out.println("Empleado: " + empleados[i].getNombreEmpleado());
                System.out.println("Apellido: " + empleados[i].getApellidoEmpleado());
                System.out.println("Sexo: " + empleados[i].getSexoEmpleado());
                System.out.println("Telefono: " + empleados[i].getTelefonoEmpleado());
                System.out.println("Edad: " + empleados[i].getEdadEmpleado());
                System.out.println("Dni: " + empleados[i].getDniEmpleado());
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
            if (empleados[i].getDniEmpleado().equals(numDni) ) {
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
                        empleados[i].setTelefonoEmpleado(telefono);
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
            if (empleados[i].getDniEmpleado().equals(numDni)) {
                for (int j=i;j<empleados.length-1;j++){
                    empleados[j]=empleados[j+1];
                }
                flag=true;
            }
        }
        System.out.println("Empleado eliminado correctamente");
        if (flag==false){System.out.println("No existe empleado, que esta asociado al dni proporcionado");}
    }

    //Por revisar
    public void mostrarEmpleado(Empleado empleado){
        System.out.println("Nombre: "+empleado.getNombreEmpleado());
        System.out.println("Apellido: "+empleado.getApellidoEmpleado());
        System.out.println("Sexo: "+empleado.getSexoEmpleado());
        System.out.println("Telefono: "+empleado.getTelefonoEmpleado());
        System.out.println("Edad: "+empleado.getEdadEmpleado());
        System.out.println("Dni: "+empleado.getDniEmpleado());
        System.out.println("Salario: "+empleado.getSalarioEmpleado());
        System.out.println("Puesto: "+empleado.getPuestoEmpleado());
        System.out.println("Sucursa"+empleado.getSucursalEmpleado());
    }

}