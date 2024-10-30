package Banco.SistemaBancario;

public class TarjetaDeDebito extends Tarjeta {
    public TarjetaDeDebito(String numeroTarjetaGenerado, String claveTarjetaGenerada,CuentaAhorro CuentaAhorro) {
        super(numeroTarjetaGenerado, claveTarjetaGenerada, CuentaAhorro); {
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