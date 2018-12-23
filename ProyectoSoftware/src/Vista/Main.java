package Vista;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import Controlador.Controlador;
import Modelo.MiembrodeEquipo;
import Modelo.Requisito;
import Modelo.SprintBackLog;
import Modelo.Tarea;
import Persistencia.Persistencia;

public class Main {

	public static void main(String[] args) {
		Controlador controlador = null;
		Persistencia persistencia = new Persistencia();
		System.out.println("Quieres cargar datos de una base de datos[1->si 0->no]\nEn caso de decir que no se borrara la base de datos anterior");
		Scanner scanIn = new Scanner(System.in);
		int opcion;
		opcion = scanIn.nextInt();
		if (opcion == 1) {
			try {
				controlador = persistencia.cargarDatos();
				controlador.comprobacionTareasRequisitos();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		} else {
			controlador = new Controlador();
		}
		int controlPri = 0;
		while (controlPri == 0) {
			System.out.println("\n-----------MENU PRINCIPAL---------");
			System.out.println("1.Gestion miembros");
			System.out.println("2.Gestion de Sprints");
			System.out.println("3.Gestion de tareas");
			System.out.println("0.Salir");

			opcion = scanIn.nextInt();

			switch (opcion) {
			case 1:
				int controlMiem = 0;
				while (controlMiem == 0) {
					System.out.println("\n-----------MENU MIEMBROS---------");
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
						try {
							MiembrodeEquipo miembro = controlador.consultaMiembro(id);

							System.out.println("Su nombre es: " + miembro.getNombre());
							System.out.println("Su apellido es: " + miembro.getApellido());
							System.out.println("Su edad es: " + miembro.getEdad());
						} catch (NullPointerException ex) {
							System.out.println("El id del miembro no existe");
						}
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
						controlMiem = 1;
						break;
					default:
						System.out.println("Opcion no valida introduzca otra.");
						break;

					}
				}
				break;
			case 2:
				int controlSpr = 0;
				while (controlSpr == 0) {
					System.out.println("\n-----------MENU SPRINTS---------");
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
						if (listasprints.size() == 0) {
							System.out.println("No se ha creado ningun sprint");
						}
						for (int i = 0; i < listasprints.size(); i++) {
							System.out.println("Sprint con id: " + listasprints.get(i).getId());
						}
						break;
					case 0:
						controlSpr = 1;
						break;
					default:
						System.out.println("Opcion no valida introduzca otra.");
						break;

					}
					
				}
				break;
			case 3:
				int controlTar = 0;
				while (controlTar == 0) {
					System.out.println("\n-----------MENU TAREAS---------");
					System.out.println("1.Añadir tarea");
					System.out.println("2.Mover tarea");
					System.out.println("3.Cambiar estado");
					System.out.println("4.Editar tarea");
					System.out.println("0.Salir");
					opcion = scanIn.nextInt();
					switch (opcion) {
					case 1:
						int controlATa = 0;
						while (controlATa == 0) {
							
							System.out.println("1.Añadir requisito");
							System.out.println("2.Añadir tarea a requisito existente");
							System.out.println("0.Salir");
							opcion = scanIn.nextInt();
							switch (opcion) {
							case 1:
								controlador.anadirRequisito();
								break;
							case 2:
								List<Requisito> listarequisitos = controlador.consultarRequisitos();
								for (int i = 0; i < listarequisitos.size(); i++) {
									System.out.println("Requisito con id: " + listarequisitos.get(i).getId());
								}
								System.out.println("Introducir id de requisito");
								int id = scanIn.nextInt();
								if (controlador.containsReq(id)) {
									controlador.anadirTareaARequisito(id);
								} else
									System.out.println("No existe el requisito\n");
								break;
							case 0:
								controlATa = 1;
								break;
							default:
								System.out.println("Opcion no valida introduzca otra.");
								break;
							}
						}
						break;
					case 2:
						List<Tarea> listaproduct = controlador.consultarTareasPB();
						if (listaproduct.size() == 0) {
							System.out.println("No se han creado tareas");
						} else {
							for (int i = 0; i < listaproduct.size(); i++) {
								System.out.println("Tarea con id: " + listaproduct.get(i).getIdTarea()+" y nombre: "+listaproduct.get(i).getNombre());
							}
							int tarea = -1;
							System.out.println("Introducir id de tarea");
							int id = scanIn.nextInt();
							for (int i = 0; i < listaproduct.size(); i++) {
								if (listaproduct.get(i).getIdTarea() == id) {
									tarea = i;
								}
							}
							if (tarea != -1) {
								controlador.moverTarea(listaproduct.get(tarea));
							}else System.out.println("La tarea no existe");
						}
						break;
					case 3:
						List<SprintBackLog> listasprints = controlador.consultarSprint();
						if (listasprints.size() == 0) {
							System.out.println("No se ha creado ningun sprint");
						} else {
							List<Tarea> totaltareas = controlador.consTotalTareas();
							for (int i = 0; i < totaltareas.size(); i++) {
								System.out.println("Tarea con id: " + totaltareas.get(i).getIdTarea()+" y nombre: "+totaltareas.get(i).getNombre());
							}
							System.out.println("Introducir id de tarea");
							int id = scanIn.nextInt();
							int tarea = -1;
							for (int i = 0; i < totaltareas.size(); i++) {
								if (totaltareas.get(i).getIdTarea() == id) {
									tarea = i;
								}
							}
							if(tarea!=-1) {
							controlador.actualizarEstado(totaltareas.get(tarea));
							}else System.out.println("La tarea no existe en el sprint");
						}
						break;

					case 4:
						List<Tarea> listaproduct2 = controlador.consultarTareasPB();
						for (int i = 0; i < listaproduct2.size(); i++) {
							System.out.println("Tarea con id: " + listaproduct2.get(i).getIdTarea()+" y nombre: "+listaproduct2.get(i).getNombre());
						}
						System.out.println("Introducir id de tarea");
						int id = scanIn.nextInt();
						int controlETa = 0;
						if (!controlador.containsTar(id)) {
							System.out.println("La tarea no existe\n");
							controlETa = 1;
						}

						while (controlETa == 0) {
							System.out.println("1.Cambiar nombre");
							System.out.println("2.Cambiar coste");
							System.out.println("3.Cambiar beneficio");
							System.out.println("4.Cambiar descripcion");
							System.out.println();
							opcion = scanIn.nextInt();
							switch (opcion) {
							case 1:
								System.out.println("Introduce el nombre");
								String nombre = scanIn.next();
								controlador.cambiarNTarea(nombre, id);
								break;
							case 2:
								System.out.println("Introduce el coste");
								float coste = scanIn.nextFloat();
								controlador.cambiarCTarea(coste, id);
								break;
							case 3:
								System.out.println("Introduce el beneficio");
								float beneficio = scanIn.nextFloat();
								controlador.cambiarBTarea(beneficio, id);
								break;
							case 4:
								System.out.println("Introduce la descripcion");
								String descripcion = scanIn.next();
								controlador.cambiarDTarea(descripcion, id);
								break;
							case 0:
								controlETa = 1;
								break;
							default:
								System.out.println("Opcion no valida introduzca otra.");
								break;
							}
						}
						break;
					case 0:
						controlTar = 1;
						break;
					default:
						System.out.println("Opcion no valida introduzca otra.");
						break;

					}

				}
				break;
			case 0:
				controlPri = 1;
				break;
			default:
				System.out.println("Opcion invalida");
				break;
			}
		}
		persistencia.Introducirdatos(controlador);
		scanIn.close();
	}
}
