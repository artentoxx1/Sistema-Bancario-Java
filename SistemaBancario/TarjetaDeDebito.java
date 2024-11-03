package Banco.SistemaBancario;

public class TarjetaDeDebito extends Tarjeta {
    public TarjetaDeDebito() {
        super();
    }
    public TarjetaDeDebito(String numeroTarjetaGenerado, String claveTarjetaGenerada,CuentaAhorro CuentaAhorro, boolean estadoTarjeta) {
        super(numeroTarjetaGenerado, claveTarjetaGenerada, CuentaAhorro, estadoTarjeta); {
            this.numeroTarjeta = numeroTarjetaGenerado;
            this.claveTarjeta = claveTarjetaGenerada;
            this.cuentaVinculada= CuentaAhorro;

        }
        this.cuentaVinculada= CuentaAhorro;
    }

    public void retirarDineros(double montoR){
        cuentaVinculada.retirar(montoR);
    }
    public void mostrarSaldos(){
        cuentaVinculada.mostrarSaldo();
    }
    public void mostrarEstadoCuenta(){
        System.out.println("Numero de tarjeta: " + numeroTarjeta);
        System.out.println("Clave: " + claveTarjeta);
        System.out.println("Saldo: " + cuentaVinculada.getSaldoCuenta());
        System.out.println("Numero de cuenta: " + cuentaVinculada.getNumeroCuenta());
        System.out.println("Cuenta Vinculada: " + cuentaVinculada);
    }

}