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
public class Horario{
    
    
    Fecha FechaSalida;
    Fecha FechaLLegada;

    public Horario(Fecha FechaSalida, Fecha FechaLLegada) {
        this.FechaSalida = FechaSalida;
        this.FechaLLegada = FechaLLegada;
    }

    public Horario() {

        FechaSalida=new Fecha();
        FechaLLegada=new Fecha();
    }

    public Fecha getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(Fecha FechaSalida) {
        this.FechaSalida = FechaSalida;
    }

    public Fecha getFechaLLegada() {
        return FechaLLegada;
    }

    public void setFechaLLegada(Fecha FechaLLegada) {
        this.FechaLLegada = FechaLLegada;
    }

    @Override
    public String toString() {
        return "Horario{" + "FechaSalida=" + FechaSalida + ", FechaLLegada=" + FechaLLegada + '}';
    }
    
    
    
}
