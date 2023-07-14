/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.ActaDao;
import entidades.Acta;
import java.util.List;

/**
 *
 * @author jg211
 */
public class AppActas {
    public static void main(String[] args) {
        
        
        ActaDao actaDao = new ActaDao();
        List<Acta> actasAntiguas = actaDao.findActasReunionesAntiguasQuery();
        System.out.println("Actas antiguas: "+ actasAntiguas);
        
    }
}
