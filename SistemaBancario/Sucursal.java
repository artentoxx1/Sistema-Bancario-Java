package Banco.SistemaBancario;

import java.util.ArrayList;

public class Sucursal {
    private String direccionSucursal;
    private String codigoSucursal;
    private String ciudadSurcursal;
    private int cantidadEmpleados;
    private Empleado[] conjuntoEmpleados;

    public Sucursal(String direccionSucursal, String codigoSucursal, String ciudadSurcursal, int cantidadEmpleados, ArrayList<Empleado> empleados) {
        if (direccionSucursal == null || direccionSucursal.isEmpty()) {
            throw new IllegalArgumentException("La dirección de la sucursal no puede ser nula o vacía.");
        }
        if (codigoSucursal == null || codigoSucursal.isEmpty()) {
            throw new IllegalArgumentException("El código de la sucursal no puede ser nulo o vacío.");
        }
        if (ciudadSurcursal == null || ciudadSurcursal.isEmpty()) {
            throw new IllegalArgumentException("La ciudad de la sucursal no puede ser nula o vacía.");
        }
        if (cantidadEmpleados < 0) {
            throw new IllegalArgumentException("La cantidad de empleados no puede ser negativa.");
        }
        if (empleados == null) {
            throw new IllegalArgumentException("La lista de empleados no puede ser nula.");
        }

        this.direccionSucursal = direccionSucursal;
        this.codigoSucursal = codigoSucursal;
        this.ciudadSurcursal = ciudadSurcursal;
        this.cantidadEmpleados = cantidadEmpleados;
        this.conjuntoEmpleados = empleados.toArray(new Empleado[0]);
    }

    public Sucursal(String direccionSucursal, String codigoSucursal, String ciudadSurcursal, int cantidadEmpleados, Empleado[] conjuntoEmpleados) {
        if (direccionSucursal == null || direccionSucursal.isEmpty()) {
            throw new IllegalArgumentException("La dirección de la sucursal no puede ser nula o vacía.");
        }
        if (codigoSucursal == null || codigoSucursal.isEmpty()) {
            throw new IllegalArgumentException("El código de la sucursal no puede ser nulo o vacío.");
        }
        if (ciudadSurcursal == null || ciudadSurcursal.isEmpty()) {
            throw new IllegalArgumentException("La ciudad de la sucursal no puede ser nula o vacía.");
        }
        if (cantidadEmpleados < 0) {
            throw new IllegalArgumentException("La cantidad de empleados no puede ser negativa.");
        }
        if (conjuntoEmpleados == null) {
            throw new IllegalArgumentException("El conjunto de empleados no puede ser nulo.");
        }

        this.direccionSucursal = direccionSucursal;
        this.codigoSucursal = codigoSucursal;
        this.ciudadSurcursal = ciudadSurcursal;
        this.cantidadEmpleados = cantidadEmpleados;
        this.conjuntoEmpleados = conjuntoEmpleados;
    }

    public void mostrarInfoSucursal() {
        try {
            System.out.println("Dirección Sucursal: " + direccionSucursal);
            System.out.println("Código Sucursal: " + codigoSucursal);
            System.out.println("Ciudad Sucursal: " + ciudadSurcursal);
            System.out.println("Cantidad Empleados: " + cantidadEmpleados);
        } catch (Exception e) {
            throw new RuntimeException("Error al mostrar la información de la sucursal: " + e.getMessage());
        }
    }

    public String getDireccion() {
        return direccionSucursal;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede ser nula o vacía.");
        }
        this.direccionSucursal = direccion;
    }

    public String getCodigo() {
        return codigoSucursal;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío.");
        }
        this.codigoSucursal = codigo;
    }

    public String getCiudad() {
        return ciudadSurcursal;
    }

    public void setCiudad(String ciudad) {
        if (ciudad == null || ciudad.isEmpty()) {
            throw new IllegalArgumentException("La ciudad no puede ser nula o vacía.");
        }
        this.ciudadSurcursal = ciudad;
    }
}
