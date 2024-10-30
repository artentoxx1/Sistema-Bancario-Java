package Banco.SistemaBancario;
import java.util.Scanner;
public class Cajero {
    Scanner entrada = new Scanner(System.in);
    public void actualizarDatosCliente(Cliente[] cliente, String dni){
        for (int i=0; i<cliente.length; i++){
            if(cliente[i].getDniCliente().equals(dni)){
                System.out.println("Seleccione una opcion: ");
                System.out.println("1.Modificar direccion. ");
                System.out.println("2.Modificar telefono. ");
                System.out.println("3.Modificar correo. ");
            }
            int opcion2 = entrada.nextInt();
            switch (opcion2){
                case 1:{
                    System.out.println("Digite la nueva direccion: ");
                    String nuevadireccion=entrada.next();
                    cliente[i].setDniCliente(nuevadireccion);
                };break;
                case 2:{
                    System.out.println("Digite el nuevo telefono: ");
                    String nuevotelefono=entrada.next();
                    cliente[i].setTelefonoCliente(nuevotelefono);
                };break;
                case 3:{
                    System.out.println("Digite el nuevo correo: ");
                    String nuevocorreo=entrada.next();
                    cliente[i].setCorreoCliente(nuevocorreo);
                };break;

            }
        }

    }

    public void eliminarCliente(Cliente[] clientes, String dni){
        boolean flag = false;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].getDniCliente().equals(dni)) {
                for (int j=i;j<clientes.length-1;j++){
                    clientes[j]=clientes[j+1];
                }
                flag=true;
            }
        }
        System.out.println("Empleado eliminado correctamente");
        if (flag==false){System.out.println("No existe cliente, que esta asociado al dni proporcionado");}
    }

    public void buscarCliente(Cliente[] clientes,String dni){
        int existencia=0;
        for(int i = 0; i < clientes.length; i++) {
            if (clientes[i].getDniCliente().equals(dni)) {
                System.out.println("Nombres: " + clientes[i].getNombresCliente());
                System.out.println("Apellido Paterno: " + clientes[i].getApellidoPaternoCliente());
                System.out.println("Apellido Materno: " + clientes[i].getApellidoMaternoCliente());
                System.out.println("Sexo: " + clientes[i].getSexoCliente());
                System.out.println("Dni: " + clientes[i].getDniCliente());
                System.out.println("Telefono: " + clientes[i].getTelefonoCliente());
                System.out.println("Correo: " + clientes[i].getCorreoCliente());
                System.out.println("Direccion: " + clientes[i].getDireccionCliente());
                existencia=1;
            }

        }
        if (existencia==0){System.out.println("No existe cliente, que esta asociado al dni proporcionado");}

    }
}