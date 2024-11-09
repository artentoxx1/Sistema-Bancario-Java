package Banco.SistemaBancario;

public abstract class Persona {
    protected String nombres;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected String sexo;
    protected String dni;
    protected String telefono;

    public Persona(){
        nombres="";
        apellidoPaterno="";
        apellidoMaterno="" ;
        sexo="";
        dni="";
        telefono="";
    }
    public Persona (String nombres,String apellidoPaterno,String apellidoMaterno, String sexo, String dni, String telefono){
        this.apellidoMaterno=apellidoMaterno;
        this.apellidoPaterno=apellidoPaterno;
        this.nombres=nombres;
        this.sexo=sexo;
        this.dni=dni;
        this.telefono=telefono;
    }
    public abstract String getNombres();
    public abstract void setNombres(String nombres);
    public abstract String getApellidoPaterno();
    public abstract void setApellidoPaterno(String apellidoPaterno);
    public abstract String getApellidoMaterno();
    public abstract void setApellidoMaterno(String apellidoMaterno);
    public abstract String getSexo();
    public abstract void setSexo(String sexo);
    public abstract String getDni();
    public abstract void setDni(String dni);
    public abstract String getTelefono();
    public abstract void setTelefono(String telefono);
}
