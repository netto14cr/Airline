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
public class LineaDetalleVuelo {
    String identificacion, tipoVuelo,horaSalida,horaLlegada, paisOrigen, paisDestino, diaSalida, mesSalida, AnioSalida, diaLlegada, mesLlegada, AnioLlegada;

    
    
    
    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    int precio, cantidadPasajeros;

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(String tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public String getDiaSalida() {
        return diaSalida;
    }

    public void setDiaSalida(String diaSalida) {
        this.diaSalida = diaSalida;
    }

    public String getMesSalida() {
        return mesSalida;
    }

    public void setMesSalida(String mesSalida) {
        this.mesSalida = mesSalida;
    }

    public String getAnioSalida() {
        return AnioSalida;
    }

    public void setAnioSalida(String AnioSalida) {
        this.AnioSalida = AnioSalida;
    }

    public String getDiaLlegada() {
        return diaLlegada;
    }

    public void setDiaLlegada(String diaLlegada) {
        this.diaLlegada = diaLlegada;
    }

    public String getMesLlegada() {
        return mesLlegada;
    }

    public void setMesLlegada(String mesLlegada) {
        this.mesLlegada = mesLlegada;
    }

    public String getAnioLlegada() {
        return AnioLlegada;
    }

    public void setAnioLlegada(String AnioLlegada) {
        this.AnioLlegada = AnioLlegada;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    @Override
    public String toString() {
        return "LineaDetalleVuelo{" + "identificacion=" + identificacion + ", tipoVuelo=" + tipoVuelo + ", horaSalida=" + horaSalida + ", horaLlegada=" + horaLlegada + ", paisOrigen=" + paisOrigen + ", paisDestino=" + paisDestino + ", diaSalida=" + diaSalida + ", mesSalida=" + mesSalida + ", AnioSalida=" + AnioSalida + ", diaLlegada=" + diaLlegada + ", mesLlegada=" + mesLlegada + ", AnioLlegada=" + AnioLlegada + ", precio=" + precio + ", cantidadPasajeros=" + cantidadPasajeros + '}';
    }

}
