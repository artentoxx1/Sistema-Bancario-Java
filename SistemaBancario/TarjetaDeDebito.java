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

    }