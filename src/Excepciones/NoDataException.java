/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Netto
 */
public class NoDataException extends java.lang.Exception {
    
    /** Creates a new instance of NoDataException */
    public NoDataException() {
    }
    
    public NoDataException(String msg) {
        super(msg);
    }
}

