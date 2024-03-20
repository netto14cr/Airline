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
//NOTA : como la clase ruta esta compuesta con un horario como atributo tiene que existir una 
// relacion entre estas clases , por lo tanto la clase ruta debe de tener instancias de la clase horario...
public class Ruta{

    String identificador;
    String paisOrigen;
    String paisDestino;
    Horario horario;
    
    
    public String obtenerDia(int i)
    {
        String aux="";
        switch(i){
            case 0:
                aux= "Domingo";
                break;
            case 1:
                aux= "Lunes";
                break;
            case 2:
                aux= "Martes";
                break;
            case 3:
                aux= "Miercoles";
                break;
            case 4:
                aux= "Jueves";
                break;
            case 5:
                aux= "Viernes";
                break;
            case 6:
                aux= "Sabado";
                break;
        }
        return aux;
    }
    public String obtenerMes(int i)
    {
          String aux="";
        switch(i){
            case 0:
                aux= "Enero";
                break;
            case 1:
                aux= "Febrero";
                break;
            case 2:
                aux= "Marzo";
                break;
            case 3:
                aux= "Abril";
                break;
            case 4:
                aux= "Mayo";
                break;
            case 5:
                aux= "Junio";
                break;
            case 6:
                aux= "Julio";
                break;
            case 7:
                aux= "Agosto";
                break;
            case 8:
                aux= "Setiembre";
                break;
            case 9:
                aux= "Octubre";
                break;
            case 10:
                aux= "Noviembre";
                break;
            case 11:
                aux= "Diciembre";
                break;
        }
        return aux;
    }
    //----------------------------------------mismos metodos pero a la inversa...........................................
    public int obtenerDia(String i)
    {
        int aux=-1;
        switch(i){
            case "Domingo":
                aux= 0;
                break;
            case "Lunes":
                aux= 1;
                break;
            case "Martes":
                aux= 2;
                break;
            case "Miercoles":
                aux= 3;
                break;
            case "Jueves":
                aux= 4;
                break;
            case "Viernes":
                aux= 5;
                break;
            case "Sabado":
                aux= 6;
                break;
        }
        return aux;
    }
    public int obtenerMes(String i)
    {
          int aux=-1;
        switch(i){
            case "Enero":
                aux= 0;
                break;
            case "Febrero":
                aux= 1;
                break;
            case  "Marzo":
                aux=2;
                break;
            case "Abril":
                aux= 3;
                break;
            case "Mayo":
                aux= 4;
                break;
            case "Junio":
                aux= 5;
                break;
            case "Julio":
                aux= 6;
                break;
            case "Agosto":
                aux= 7;
                break;
            case "Setiembre":
                aux= 8;
                break;
            case "Octubre":
                aux= 9;
                break;
            case "Noviembre":
                aux= 10;
                break;
            case "Diciembre":
                aux= 11;
                break;
        }
        return aux;
    }
    
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
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

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Ruta() {
        identificador="";
        paisOrigen="";
        paisDestino="";
        horario=new Horario();

    }

    @Override
    public String toString() {
        return "Ruta{" + "identificador=" + identificador + ", paisOrigen=" + paisOrigen + ", paisDestino=" + paisDestino + ", horario=" + horario + '}';
    }

    public Ruta(String identificador, String paisOrigen, String paisDestino, Horario horario) {
        this.identificador = identificador;
        this.paisOrigen = paisOrigen;
        this.paisDestino = paisDestino;
        this.horario = horario;
    }
    
}
