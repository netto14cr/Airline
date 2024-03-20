/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Netto
 */
public class Vuelo {
    
    // un vuelo en teoria no deberia de crearse sin sus atributos ya que no tendria mucho sentido hacerlo
    // de esa manera , ya que un vuelo deberia de crearse con el objetivo de que se lleve acabo
    // no tiene sentido que se cree un vuelo sin su avion asociado por ejemplo...
    
//  Declaracion de variables (Basado en el uml del proyecto)
    String identificacion;
    int precio;
    Avion avion;
    Ruta ruta;
    String tipoVuelo;// si es de ida o de vuelta

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public String getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(String tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public Vuelo() {
        avion=new Avion();
        ruta=new Ruta();
    }

    public Vuelo(String identificacion, int precio, Avion avion, Ruta ruta, String tipoVuelo) {
        this.identificacion = identificacion;
        this.precio = precio;
        this.avion = avion;
        this.ruta = ruta;
        this.tipoVuelo = tipoVuelo;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "identificacion=" + identificacion + ", precio=" + precio + ", avion=" + avion.getIdentificacion() + ", ruta=" + ruta.getIdentificador() + ", tipoVuelo=" + tipoVuelo + '}';
    }

    
}
