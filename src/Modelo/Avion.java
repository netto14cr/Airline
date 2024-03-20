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
public class Avion {

    @Override
    public String toString() {
        return "Avion{" + "identificacion=" + identificacion + ", anio=" + anio + ", modelo=" + modelo + ", marca=" + marca + ", cantidadPasajeros=" + cantidadPasajeros + ", capacidadPasajeros=" + capacidadPasajeros + ", cantidadFilas=" + cantidadFilas + '}';
    }

    public Avion(){
        identificacion = "";
        anio = "";
        modelo = "";
        marca = "";
        cantidadPasajeros = 0;// para ver cuantos pasajeros hay abordos en un momento dado...

    }

//  Declaracion de variables
    
    String identificacion;
    String anio;
    String modelo;
    String marca;
    int cantidadPasajeros;// para ver cuantos pasajeros hay abordos en un momento dado...
    final int capacidadPasajeros=60;// van a ver un total de 6 personas por fila ver imagen(CHEKIN)...
    final int cantidadFilas=10;//mejor restringir las filas para asi tener el mismo chekin para
                            //todos los vuelos dado que el tamaño deñ avion va a ser el mismo siempre
    

    public Avion(String identificacion, String anio, String modelo, String marca) {
        this.identificacion = identificacion;
        this.anio = anio;
        this.modelo = modelo;
        this.marca = marca;
        cantidadPasajeros=capacidadPasajeros;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }
    
    
}
