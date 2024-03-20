package Aplicacion;


import Controladora.ControladorPrincipal;
import Modelo.Modelo;
import Vista.VentanaPrincipal;



/**
 *
 * @author Netto
 */
public class Princial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Modelo modelo = new Modelo();
        
        VentanaPrincipal vPrincipal = new VentanaPrincipal();
        ControladorPrincipal controlPrincipal = new ControladorPrincipal(modelo, vPrincipal);
  

    }
}

