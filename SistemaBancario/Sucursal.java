package Banco.SistemaBancario;

public class Sucursal{
    private String direccionSucursal;
    private String codigoSucursal;
    private String ciudadSurcursal;
    private int cantidadEmpleados;
    private Empleado[] conjuntoEmpleados;

    public Sucursal(){
        direccionSucursal = "";
        codigoSucursal = "";
        ciudadSurcursal = "";
        cantidadEmpleados = 0;
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
}
