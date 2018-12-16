package Vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controlador.Controlador;
import Modelo.Equipo;
import Modelo.Estado;
import Modelo.MiembrodeEquipo;
import Modelo.ProductBackLog;
import Modelo.Requisito;
import Modelo.SprintBackLog;
import Modelo.Tarea;

public class Main {

	public static void main(String[] args) {
		Controlador controlador = new Controlador();
		int control2 = 0;
		Scanner scanIn = new Scanner(System.in);
		while (control2 == 0) {
			System.out.println("1.Gestion miembros");
			System.out.println("2.Gestion de Sprints");
			System.out.println("3.Gestion de tareas");
			System.out.println("4.Para mover una tarea de estado");
			System.out.println("5.Editar tarea");
			int opcion;
			int control = 0;
			opcion = scanIn.nextInt();

			switch (opcion) {
			case 1:
				while (control == 0) {
					System.out.println("1.Añadir miembro");
					System.out.println("2.Consultar miembro");
					System.out.println("3.Eliminar miembro");
					System.out.println("0.Salir");
					opcion = scanIn.nextInt();
					switch (opcion) {
					case 1:
						int id = controlador.añadirMiembro();
						System.out.println(
								"Se ha añadido el miembro " + id + "\nPara añadir sus datos selecciona la opcion 4.");
						break;
					case 2:
						List<MiembrodeEquipo> miembros = controlador.consultarLista();
						for (int i = 0; i < miembros.size(); i++) {
							System.out.println("Miembro con id: " + miembros.get(i).getId());
						}
						System.out.println("1.Introduce el id del miembro a consultar");
						id = scanIn.nextInt();
						MiembrodeEquipo miembro = controlador.consultaMiembro(id);
						System.out.println("Su nombre es: " + miembro.getNombre());
						System.out.println("Su apellido es: " + miembro.getApellido());
						System.out.println("Su edad es: " + miembro.getEdad());
						break;
					case 3:
						miembros = controlador.consultarLista();
						for (int i = 0; i < miembros.size(); i++) {
							System.out.println("Miembro con id: " + miembros.get(i).getId());
						}
						System.out.println("1.Introduce el id del miembro a eliminar");
						id = scanIn.nextInt();
						controlador.removeMiembro(id);
						break;
					case 0:
						control = 1;
						break;
					default:
						System.out.println("Opcion no valida introduzca otra.");
						break;

					}
					/*
					 * Equipo eq = new Equipo(); if (equipos.size() == 0) { equipos.add(eq);
					 * eq.addMiembro(nombre, apellido, edad); } else { for (int i = 0; i <
					 * equipos.size(); i++) { if (equipos.get(i).equals(eq)) { equipos.add(eq);
					 * eq.addMiembro(nombre, apellido, edad); } } }
					 */
				}
				break;
			case 2:
				while (control == 0) {
					System.out.println("1.Añadir sprints");
					System.out.println("2.Consultar sprints");
					System.out.println("0.Salir");
					opcion = scanIn.nextInt();
					switch (opcion) {
					case 1:
						controlador.anadirSprint();
						break;
					case 2:
						List<SprintBackLog> listasprints = controlador.consultarSprint();
						for (int i = 0; i < listasprints.size(); i++) {
							System.out.println("Sprint con id: " + listasprints.get(i).getId());
						}
						break;
					case 0:
						control = 1;
						break;
					default:
						System.out.println("Opcion no valida introduzca otra.");
						break;

					}
					/*
					 * System.out.println("1.Introducir nombre de la tarea"); nombreTarea =
					 * scanIn.next(); Tarea tarea1 = new Tarea(nombreTarea);
					 * productbacklog.anadeTareas(tarea1);
					 * System.out.println("1.Introducir 0 para añadir otra tarea"); control =
					 * scanIn.nextInt();
					 */
				}
				break;
			case 3:
				control = 0;
				while (control == 0) {
					System.out.println("1.Añadir tarea");
					System.out.println("2.Mover tarea");
					System.out.println("3.Cambiar estado");
					System.out.println("4.Editar tarea");
					System.out.println("0.Salir");
					opcion = scanIn.nextInt();
					switch (opcion) {
					case 1:
						while (control2 == 0) {
							// Editar requisto
							System.out.println("1.Añadir requisito");
							System.out.println("2.Añadir tarea a requisito existente");
							System.out.println("0.Salir");
							opcion = scanIn.nextInt();
							switch (opcion) {
							case 1:
								controlador.anadirRequisito();
							case 2:
								List<Requisito> listarequisitos = controlador.consultarRequisitos();
								for (int i = 0; i < listarequisitos.size(); i++) {
									System.out.println("Sprint con id: " + listarequisitos.get(i).getId());
								}
								System.out.println("Introducir id de requisito");
								int id = scanIn.nextInt();
								controlador.anadirTareaARequisito(id);
							case 0:
								control2 = 1;
								break;
							default:
								System.out.println("Opcion no valida introduzca otra.");
								break;
							}
						}
						break;
					case 2:
						List<Tarea> listaproduct = controlador.consultarTareasPB();
						for (int i = 0; i < listaproduct.size(); i++) {
							System.out.println("Sprint con id: " + listaproduct.get(i).getIdTarea());
						}
						System.out.println("Introducir id de tarea");
						int id = scanIn.nextInt();
						controlador.moverTarea(listaproduct.get(id));
						break;
					case 3:
						List<Tarea> totaltareas = controlador.consTotalTareas();
						for (int i = 0; i < totaltareas.size(); i++) {
							System.out.println("Sprint con id: " + totaltareas.get(i).getIdTarea());
						}
						System.out.println("Introducir id de tarea");
						id = scanIn.nextInt();
						controlador.actualizarEstado(id);
						break;

					case 4:
						List<Tarea> listaproduct2 = controlador.consultarTareasPB();
						for (int i = 0; i < listaproduct2.size(); i++) {
							System.out.println("Sprint con id: " + listaproduct2.get(i).getIdTarea());
						}
						System.out.println("Introducir id de tarea");
						id = scanIn.nextInt();
						while (control2 == 0) {
							System.out.println("1.Cambiar nombre");
							System.out.println("2.Cambiar coste");
							System.out.println("3.Cambiar beneficio");
							System.out.println("4.Cambiar descripcion");
							opcion = scanIn.nextInt();
							switch (opcion) {
							case 1:
								System.out.println("Introduce el nombre");
								String nombre = scanIn.next();
								controlador.cambiarNTarea(nombre, id);
							case 2:
								System.out.println("Introduce el coste");
								float coste = scanIn.nextFloat();
								controlador.cambiarCTarea(coste, id);
							case 3:
								System.out.println("Introduce el beneficio");
								float beneficio = scanIn.nextFloat();
								controlador.cambiarBTarea(beneficio, id);
							case 4:
								System.out.println("Introduce la descripcion");
								String descripcion = scanIn.next();
								controlador.cambiarDTarea(descripcion, id);
							case 0:
								control2 = 1;
								break;
							default:
								System.out.println("Opcion no valida introduzca otra.");
								break;
							}
						}
						break;
					default:
						System.out.println("Opcion no valida introduzca otra.");
						break;

					}

				}
				break;
			}
		}
	}
}
