/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.*;
import entidades.*;
import java.util.List;

/**
 *
 * @author jg211
 */
public class AppConsultas {
    
    public static void main(String[] args) {
               
    SalaDao salaDao = new SalaDao();
    
    
    List<Sala> salasPara4 = salaDao.findSalasParaNQuery(4);
    List<Sala> salasPara3 = salaDao.findSalasParaNQuery(3);
   
    
    System.out.println("Salas para 3: "+ salasPara3);
    System.out.println("Salas para 4"+ salasPara4);

        
        
        
        
    }
}
