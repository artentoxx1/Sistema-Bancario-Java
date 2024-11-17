package Banco.SistemaBancario;
import java.util.ArrayList;
public class Sucursal{
    private String direccionSucursal;
    private String codigoSucursal;
    private String ciudadSurcursal;
    private int cantidadEmpleados;
    private Empleado[] conjuntoEmpleados;

    public Sucursal(String direccionSucursal, String number, String lima, int cantidadEmpleados, ArrayList<Empleado> empleados){
        this.direccionSucursal = "";
        codigoSucursal = "";
        ciudadSurcursal = "";
        this.cantidadEmpleados = 0;
        conjuntoEmpleados = new Empleado[0];
    }
    public Sucursal(String direccionSucursal, String codigoSucursal,
                    String ciudadSurcursal, int cantidadEmpleados,Empleado[] conjuntoEmpleados){
        this.direccionSucursal = direccionSucursal;
        this.codigoSucursal = codigoSucursal;
        this.ciudadSurcursal = ciudadSurcursal;
        this.cantidadEmpleados = cantidadEmpleados;
        this.conjuntoEmpleados = conjuntoEmpleados;
    }
    public void mostrarInfoSucursal(){
        System.out.println("Direccion Sucursal: " + direccionSucursal);
        System.out.println("Codigo Sucursal: " + codigoSucursal);
        System.out.println("Ciudad Surcursal: " + ciudadSurcursal);
        System.out.println("Cantidad Empleados: " + cantidadEmpleados);
    }
    public String getDireccion(){
        return direccionSucursal;
    }
    public void setDireccion(String direccion){
        this.direccionSucursal = direccion;
    }
    public String getCodigo(){
        return codigoSucursal;
    }
    public void setCodigo(String codigo){
        this.codigoSucursal = codigo;
    }
    public String getCiudad(){
        return ciudadSurcursal;
    }
    public void setCiudad(String ciudad){
        this.ciudadSurcursal = ciudad;
    }

}