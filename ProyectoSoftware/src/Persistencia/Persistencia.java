package Persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import Controlador.Controlador;
import Modelo.Estado;
import Modelo.Requisito;
import Modelo.Tarea;

public class Persistencia {
	private Controlador controlador = new Controlador();

	public void Introducirdatos(Controlador controlador) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("TareasRequisitos.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StringBuilder builder = new StringBuilder();
		builder.append(controlador.getidRequisito() + ",");
		builder.append(controlador.getidTarea() + ",");
		for (int i = 0; i < controlador.consultarRequisitos().size(); i++) {
			List<Tarea> tareas = controlador.consultarRequisitos().get(i).consultarTareas();
			for (int j = 0; j < tareas.size(); j++) {
				builder.append(controlador.consultarRequisitos().get(i).getId() + ",");
				builder.append(tareas.get(j).getIdTarea() + ",");
				builder.append(tareas.get(j).getNombre() + ",");
				builder.append(tareas.get(j).getCoste() + ",");
				builder.append(tareas.get(j).getBeneficio() + ",");
				builder.append(tareas.get(j).getDescripcion() + ",");

			}
		}
		pw.write(builder.toString());
		pw.close();
		pw = null;
		try {
			pw = new PrintWriter(new File("Sprints.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		builder = new StringBuilder();
		builder.append(controlador.consultarSprint().size() + ",");
		for (int i = 0; i < controlador.consultarSprint().size(); i++) {
			for (int j = 0; j < controlador.consultarSprint().get(i).tareasTotal().size(); j++) {
				builder.append(i + ",");
				builder.append(controlador.consultarSprint().get(i).tareasTotal().get(j).getIdTarea() + ",");
				builder.append(controlador.consultarSprint().get(i).tareasTotal().get(j).getState() + ",");
			}
		}
		pw.write(builder.toString());
		pw.close();
	}

	public Controlador cargarDatos() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("TareasRequisitos.csv"));
		scanner.useDelimiter(",");
		int idReq = scanner.nextInt();
		int idTar = scanner.nextInt();
		controlador.setidRequisito(idReq);
		controlador.setidTarea(idTar);
		while (scanner.hasNext()) {

			String req = scanner.next();
			int tar = scanner.nextInt();
			String nombre = scanner.next();
			float coste = Float.valueOf(scanner.next()).floatValue();
			float beneficio = Float.valueOf(scanner.next()).floatValue();
			String descripcion = scanner.next();

			if (!controlador.containsReq(Integer.parseInt(req))) {
				controlador.anadirRequisitoPersist(Integer.parseInt(req));
			}
			controlador.anadirTareaARequisitoPersist(Integer.parseInt(req), tar);
			controlador.cambiarNTarea(nombre, tar);
			controlador.cambiarCTarea(coste, tar);
			controlador.cambiarBTarea(beneficio, tar);
			controlador.cambiarDTarea(descripcion, tar);

		}
		scanner.close();
		scanner = new Scanner(new File("Sprints.csv"));
		scanner.useDelimiter(",");
		int totalsp = scanner.nextInt();
		controlador.anadirSprint();
		while (scanner.hasNext()) {
			for (int i = 0; i < totalsp; i++) {
				int spri = scanner.nextInt();
				int tarea = scanner.nextInt();
				String estado = scanner.next();
				if (controlador.consultarSprint().size() - 1 != spri) {
					controlador.anadirSprint();
				}
				int aux = -1;
				for (int j = 0; j < controlador.consultarTareasPB().size(); j++) {
					if (controlador.consultarTareasPB().get(j).getIdTarea() == tarea) {
						aux = j;
					}
				}
				controlador.moverTarea(controlador.consultarTareasPB().get(aux));
				controlador.EstadoTareaPersist(estado, controlador.consTotalTareas().get(controlador.consTotalTareas().size()-1), spri);

			}
		}
		scanner.close();
		return controlador;
	}
}
