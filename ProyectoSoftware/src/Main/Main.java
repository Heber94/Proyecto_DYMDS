package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BackLog.*;
import MiembroDeEquipo.*;
import Tarea.*;
import Requisitos.*;

public class Main {
	private static ProductBackLog productbacklog = new ProductBackLog();
	private static SprintBackLog sprintbacklog = new SprintBackLog();
	private static List<Equipo> equipos;

	public static void main(String[] args) {
		int control2 = 0;
		Scanner scanIn = new Scanner(System.in);
		while (control2 == 0) {
			System.out.println("1.Introducir miembros");
			System.out.println("2.Introducir tareas al product backlog");
			System.out.println("3.Pasar tareas al sprint");
			System.out.println("4.Para mover una tarea de estado");
			System.out.println("5.Editar tarea");
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
				Equipo eq = new Equipo();
				if (equipos.size() == 0) {
					equipos.add(eq);
					eq.addMiembro(nombre, apellido, edad);
				} else {
					for (int i = 0; i < equipos.size(); i++) {
						if (equipos.get(i).equals(eq)) {
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
					System.out.println("1.Introducir 0 para añadir otra tarea");
					control = scanIn.nextInt();
				}
				break;
			case 3:
				control = 0;
				while (control == 0) {
					System.out.println("1.Introducir nombre de la tarea");
					nombreTarea = scanIn.next();
					tarea = new Tarea(nombreTarea);
					tarea = productbacklog.cogeTarea(tarea);
					if (tarea != null) {
						sprintbacklog.añadirTareas(tarea);
					} else
						System.out.println("No existe la tarea: " + nombreTarea);
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
			case 5:
				System.out.println("1.Introduce la tarea");
				nombre = scanIn.next();
				Tarea tareaaux = null;
				List<Tarea> listaT = productbacklog.getTareas();
				for (int i = 0; i < listaT.size(); i++) {
					if (listaT.get(i).getNombre().equals(nombre))
						tareaaux = listaT.get(i);
				}
				if (tareaaux != null) {
					System.out.println("1.Cambiar coste");
					System.out.println("2.Cambiar beneficio");
					System.out.println("3.Cambiar descripcion");
					System.out.println("4.Asignar miembro");
					System.out.println("5.Consultar tarea");
					System.out.print("0.Salir");
					sWhatever = scanIn.nextInt();
					switch (sWhatever) {
					case 1:
						System.out.println("1.Introduce coste");
						float coste = scanIn.nextInt();

					case 2:
					case 3:
					case 4:
					case 5:
					default:
						break;

					}
				}else System.out.println("No existe la tarea");

			}
			List<Tarea> tareaspb = productbacklog.getTareas();
			List<Tarea> tareasspp = sprintbacklog.getTP();
			List<Tarea> tareassppr = sprintbacklog.getTPr();
			List<Tarea> tareasspv = sprintbacklog.getTV();
			List<Tarea> tareasspc = sprintbacklog.getTC();

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
