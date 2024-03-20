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
public class Fecha {

    String Dia;
    String Hora;
    String Mes;
    String Anio;

    @Override
    public String toString() {
        return Dia + "/"+ Mes + "/" + Anio + ", " +Hora;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String Dia) {
        this.Dia = Dia;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getMes() {
        return Mes;
    }

    public void setMes(String Mes) {
        this.Mes = Mes;
    }

    public String getAnio() {
        return Anio;
    }

    public void setAnio(String Anio) {
        this.Anio = Anio;
    }

    public Fecha(String Dia, String Hora, String Mes, String Anio) {
        this.Dia = Dia;
        this.Hora = Hora;
        this.Mes = Mes;
        this.Anio = Anio;
    }
    public Fecha(String Dia, String Mes, String Anio) {
        this.Dia = Dia;
        this.Mes = Mes;
        this.Anio = Anio;
    }

    public Fecha() {
        this.Dia = "";
        this.Hora = "";
        this.Mes ="";
        this.Anio = "";
    }

}
