package Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BackLog.*;
import MiembroDeEquipo.*;
import Tarea.*;
import Requisitos.*;

public class Main {
	private ProductBackLog productbacklog;
	private SprintBackLog sprintbacklog;
	private static List<Equipo> equipos;
	public static void main(String[] args)  {
		System.out.println("1.Introducir miembros");
		System.out.println("2.");
		System.out.println("3.");
		System.out.println("4.");
		equipos=new ArrayList<Equipo>();
		int sWhatever;
		int idmiembro=0;
		int idequipo=0;
		String nombre;
		String apellido;
		int edad;

	      Scanner scanIn = new Scanner(System.in);
	      sWhatever = scanIn.nextInt();

	       
	    switch(sWhatever) {
	    case 1:
	    		System.out.println("1.Introducir nombre y apellido");
	    		nombre = scanIn.next();
	    		apellido = scanIn.next();
	    		System.out.println("1.Introducir edad");
	    		edad = scanIn.nextInt();
	    		System.out.println("1.Introducir id equipo");
	    		idequipo=scanIn.nextInt();
	    		Equipo eq=new Equipo(idequipo);
	    		for(int i=0;i<equipos.size();i++) {
	    			if(equipos.get(i).getId()!=eq.getId())
	    				equipos.add(eq);
	    				eq.addMiembro(nombre, apellido, edad);
	    		}
	    		System.out.println(eq.getId());
	    }
	    scanIn.close();
	}
	
}
