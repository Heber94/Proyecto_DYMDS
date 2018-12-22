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
		//String ColumnNamesList = "Req,Tarea,Nombre,Coste,Beneficio,Descripcion";
		//builder.append(ColumnNamesList + "\n");
		for (int i = 0; i < controlador.consultarRequisitos().size(); i++) {
			List<Tarea> tareas = controlador.consultarRequisitos().get(i).consultarTareas();
			for (int j = 0; j < tareas.size(); j++) {
				builder.append(controlador.consultarRequisitos().get(i).getId() + ",");
				builder.append(tareas.get(j).getIdTarea() + ",");
				builder.append(tareas.get(j).getNombre() + ",");
				builder.append(tareas.get(j).getCoste() + ",");
				builder.append(tareas.get(j).getBeneficio() + ",");
				builder.append(tareas.get(j).getDescripcion() + ",");
				builder.append('\n');
			}
		}
		pw.write(builder.toString());
		pw.close();
	}

	public Controlador cargarDatos() throws FileNotFoundException {
	    Scanner scanner = new Scanner(new File("TareasRequisitos.csv"));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
        	String req = scanner.next();
        int tar =scanner.nextInt();
        String nombre=scanner.next();
        float coste=Float.valueOf(scanner.next()).floatValue();
        float beneficio=Float.valueOf(scanner.next()).floatValue();
        String descripcion=scanner.next();
        System.out.println(req+""+tar+""+nombre+""+coste+""+beneficio+"");
        /*
        if(!controlador.containsReq(Integer.parseInt(scan))) {
            controlador.anadirRequisitoPersist(Integer.parseInt(scan));
        }
		controlador.anadirTareaARequisitoPersist(Integer.parseInt(scan),scanner.nextInt());
		controlador.cambiarNTarea(nombre, id);
		*/
        scanner.close();
    }
		return controlador;

	}
}
