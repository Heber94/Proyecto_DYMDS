package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BackLog.*;
import MiembroDeEquipo.*;
import Tarea.*;
import Requisitos.*;

public class Main {
	private static ProductBackLog productbacklog;
	private SprintBackLog sprintbacklog;
	private static List<Equipo> equipos;

	public static void main(String[] args) {
		System.out.println("1.Introducir miembros");
		System.out.println("2.Introducir tareas al product backlog");
		System.out.println("3.");
		System.out.println("4.");
		equipos = new ArrayList<Equipo>();
		int sWhatever;
		int idmiembro = 0;
		int idequipo = 0;
		String nombre;
		String apellido;
		String nombreTarea;
		String descripcionTarea;
		int edad;
		Scanner scanIn = new Scanner(System.in);
		sWhatever = scanIn.nextInt();

		switch (sWhatever) {
		case 1:
			System.out.println("1.Introducir nombre y apellido");
			nombre = scanIn.next();
			apellido = scanIn.next();
			System.out.println("1.Introducir edad");
			edad = scanIn.nextInt();
			System.out.println("1.Introducir id equipo");
			idequipo = scanIn.nextInt();
			Equipo eq = new Equipo(idequipo);
			if (equipos.size() == 0) {
				equipos.add(eq);
				eq.addMiembro(nombre, apellido, edad);
			} else {
				for (int i = 0; i < equipos.size(); i++) {
					if (equipos.get(i).getId() != eq.getId()) {
						equipos.add(eq);
						eq.addMiembro(nombre, apellido, edad);
					}
				}
			}
		case 2:
			System.out.println("1.Introducir nombre de la tarea");
			nombreTarea = scanIn.next();
			System.out.println("1.Introducir descripcion de la tarea");
			descripcionTarea = scanIn.next();
			productbacklog.añadeTareas(new Tarea(nombreTarea,descripcionTarea));
		}

		scanIn.close();
	}

}
