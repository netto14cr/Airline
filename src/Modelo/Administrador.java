package Modelo;

/**
 *
 * @author netto
 */
public class Administrador extends Usuario {

    public Administrador() {
        tipoUsuario="Administrador";
    }

    public Administrador(String identificacion, String contrasenia, String nombre, String apellido1, String apellido2, String correoElectronico, Fecha fechaNacimiento, String direccion, String tipoUsuario, String celular, String telefonoTrabajo) {
        super(identificacion, contrasenia, nombre, apellido1, apellido2, correoElectronico, fechaNacimiento, direccion, tipoUsuario, celular, telefonoTrabajo);
    tipoUsuario="Administrador";
    }

    @Override
    public String getTipoUsuario() {
        return "Administrador";
    }

    
  

   
    
    //supongo que para realizar esas operaciones el objeto debe de tener acceso a la base de datos
    
    public void gestionarAviones(){}
    public void gestionarHorarios(){}
    public void gestionarRutas(){}
    public void mostrarInfoCantidadFacturadoMes(){}
    public void mostrarInfoCantidadIngresoAño(){}
    public void mostrarListadoClientesAvion(String identificadorAvion){}
    public void mostrarRutasConMasVentas(){}
    
    
    
    
}
