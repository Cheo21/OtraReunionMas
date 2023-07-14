/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.PersonaDao;
import entidades.Acta;
import entidades.Persona;
import entidades.Reunion;
import entidades.Sala;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author jg211
 */
public class AppTodoPersona {
    
    public static void main(String[] args) {
        
        
        PersonaDao personaDao = new PersonaDao();
        
        Optional<Persona> optPersona = personaDao.get(1);
        if(optPersona.isPresent()){
            Persona p = optPersona.get();
            System.out.println("Persona: "+ p);
            
            Set<Reunion> reuniones = p.getReuniones();
            System.out.println("Reuniones: "+ reuniones);
         
            Set<Sala> salas = new HashSet();
            Set<Acta> actas = new HashSet();
            Set<Persona> compis = new HashSet();
            
            
            for (Reunion reunion: reuniones){
                salas.add(reunion.getSala());
                compis.addAll(reunion.getParticipantes());
                actas.add(reunion.getActa());
                
            }
            
            
            System.out.println("Salas: "+ salas);
            System.out.println("Compis: "+ compis);
            System.out.println("Actas: "+ actas);
            
        }
       
        
        
    }
    
    
}
