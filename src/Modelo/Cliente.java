package Modelo;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Netto
 */
public class Cliente extends Usuario {

    public Cliente(String identificacion, String contrasenia, String nombre, String apellido1, String apellido2, String correoElectronico, Fecha fechaNacimiento, String direccion, String tipoUsuario, String celular, String telefonoTrabajo) {
        super(identificacion, contrasenia, nombre, apellido1, apellido2, correoElectronico, fechaNacimiento, direccion, tipoUsuario, celular, telefonoTrabajo);
        tipoUsuario = "Cliente";
    }



    
    

    public Cliente() {
        tipoUsuario="Cliente";
        
    }

    
    public void verHistoricoCompras(){}
    public void modificarInformacionPersonal(){}
    public void chekin(){}
    public void consultarVuelo(){}
    public void comprarVuelo(){}
    

}
