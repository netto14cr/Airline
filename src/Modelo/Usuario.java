/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author netto
 */
public class Usuario{

//    String Dia;
//    String Hora;
//    String Mes;
//    String Anio;
    String identificacion;
    String contrasenia;
    String nombre;
    String apellido1;
    String apellido2;
    String correoElectronico;
    Fecha fechaNacimiento;
    String direccion;
    String tipoUsuario;
    String celular,telefonoTrabajo;

    public Usuario() {
        
    identificacion="";
    contrasenia="";
    nombre="";
    apellido1="";
    apellido2="";
    correoElectronico="";
    fechaNacimiento=new Fecha();
    direccion="";
    tipoUsuario="";
    celular="";
    telefonoTrabajo="";
    }
    public void registrarse(){}
    public void consultarVuelos(){}

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo(String telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }

    public Usuario(String identificacion, String contrasenia, String nombre, String apellido1, String apellido2, String correoElectronico, Fecha fechaNacimiento, String direccion, String tipoUsuario, String celular, String telefonoTrabajo) {
        this.identificacion = identificacion;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.tipoUsuario = tipoUsuario;
        this.celular = celular;
        this.telefonoTrabajo = telefonoTrabajo;
    }

}
