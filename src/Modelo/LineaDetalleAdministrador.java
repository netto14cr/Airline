/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author gabri
 */
public class LineaDetalleAdministrador {
    
    String id,nombre,apell1,apell2,cel,contrasenia;

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public LineaDetalleAdministrador(String id, String nombre, String apell1, String apell2, String cel, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.apell1 = apell1;
        this.apell2 = apell2;
        this.cel = cel;
        this.contrasenia = contrasenia;
    }

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApell1() {
        return apell1;
    }

    public void setApell1(String apell1) {
        this.apell1 = apell1;
    }

    public String getApell2() {
        return apell2;
    }

    public void setApell2(String apell2) {
        this.apell2 = apell2;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }
    
}
