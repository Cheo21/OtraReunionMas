/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.ReunionDao;


public class AppReuniones {
	public static void main(String[] args) {

		ReunionDao reunionDao = new ReunionDao();
		System.out.println("Reuniones de Pedro: " + reunionDao.reunionesParticipante("E002"));
	}
}

