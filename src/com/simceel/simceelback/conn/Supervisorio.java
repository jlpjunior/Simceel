/*
 * Comunica&ccedil;&atilde;o Serial Java Arduino.
 * By Leonardo Godoi.
 */
package com.simceel.simceelback.conn;

/**
 *
 * @author Leogodoi
 */
public class Supervisorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SerialRxTx serial = new SerialRxTx();

        System.out.println("MAIN");
            if(serial.iniciaSerial()){
                
                while(true){
            }
                
            }   
                else{
        
        }
    }
    
}
