package Persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import Controlador.Controlador;
import Modelo.Requisito;
public class Persistencia {
	
	public void Introducirdatos(List<Requisito> requisitos) {
	PrintWriter pw = null;
	try {
	    pw = new PrintWriter(new File("NewData.csv"));
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	StringBuilder builder = new StringBuilder();
	String ColumnNamesList = "Req,Tarea";
	builder.append(ColumnNamesList +"\n");
	requisitos.get(0).
	builder.append(+",");
	}

}
