package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BackLog.*;
import MiembroDeEquipo.*;
import Tarea.*;
import Requisitos.*;

public class Main {
	private static ProductBackLog productbacklog = new ProductBackLog().copy();
	private static SprintBackLog sprintbacklog = new SprintBackLog().copy();
	private static List<Equipo> equipos;

	public static void main(String[] args) {
		int control2 = 0;
		Scanner scanIn = new Scanner(System.in);
		while (control2 == 0) {
			System.out.println("1.Introducir miembros");
			System.out.println("2.Introducir tareas al product backlog");
			System.out.println("3.Pasar tareas al sprint");
			System.out.println("4.Para mover una tarea de estado");
			equipos = new ArrayList<Equipo>();
			int sWhatever;
			Tarea tarea;
			int idequipo = 0;
			String nombre;
			String apellido;
			String nombreTarea;

			int edad;
			int control = 0;
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
				break;
			case 2:
				while (control == 0) {
					System.out.println("1.Introducir nombre de la tarea");
					nombreTarea = scanIn.next();
					Tarea tarea1 = new Tarea(nombreTarea);
					productbacklog.añadeTareas(tarea1);
					System.out.println("1.Introducir 0 para introducir otra tarea");
					control = scanIn.nextInt();
				}
				break;
			case 3:
				control = 0;
				while (control == 0) {
					System.out.println("1.Introducir nombre de la tarea");
					nombreTarea = scanIn.next();
					tarea = new Tarea(nombreTarea);
					try {
						tarea = productbacklog.cogeTarea(tarea);
					} catch (NullPointerException ex) {
						throw ex;
					}
					try {
						sprintbacklog.añadirTareas(tarea);
					} catch (NullPointerException ex) {
						throw ex;
					}
					System.out.println("1.Introducir 0 para cambiar otra tarea");
					control = scanIn.nextInt();
				}
				break;
			case 4:
				System.out.println("1.Introducir nombre de la tarea");
				nombreTarea = scanIn.next();
				System.out.println("1.Introducir el estado");
				String estado1 = scanIn.next();
				Estado estado2 = stringToEstado(estado1);
				tarea = new Tarea(nombreTarea);
				sprintbacklog.moverTareas(tarea, estado2);
				break;
			}
			List<Tarea> tareaspb = productbacklog.getTareas();
			List<Tarea> tareasspp = sprintbacklog.getTP();
			List<Tarea> tareassppr = sprintbacklog.getTPr();
			List<Tarea> tareasspv = sprintbacklog.getTV();
			List<Tarea> tareasspc = sprintbacklog.getTC();
			try {
				for (int i = 0; i < tareaspb.size(); i++) {
					System.out.println("Tarea pb" + tareaspb.get(i).getNombre());
				}
				for (int i = 0; i < tareasspp.size(); i++) {
					System.out.println("Tarea Pend " + tareasspp.get(i).getNombre());
				}
				for (int i = 0; i < tareassppr.size(); i++) {
					System.out.println("Tarea Pr " + tareassppr.get(i).getNombre());
				}
				for (int i = 0; i < tareasspv.size(); i++) {
					System.out.println("Tarea V " + tareasspv.get(i).getNombre());
				}
				for (int i = 0; i < tareasspc.size(); i++) {
					System.out.println("Tarea C " + tareasspc.get(i).getNombre());
				}
			} catch (Exception ex) {
				throw ex;
			}
			System.out.println("Introducir 0 para volver al menu");
			control = scanIn.nextInt();

		}
		scanIn.close();
	}

	public static Estado stringToEstado(String estado) {
		Estado estador;
		if (estado == "Pendientes") {
			estador = Estado.PENDIENTES;
		} else if (estado == "Proceso") {
			estador = Estado.PROCESO;
		} else if (estado == "Validacion") {
			estador = Estado.VALIDACION;
		} else
			estador = Estado.COMPLETADAS;
		return estador;

	}

}
