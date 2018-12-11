package Controlador;

import java.util.ArrayList;
import java.util.List;

import Modelo.Equipo;
import Modelo.MiembrodeEquipo;
import Modelo.ProductBackLog;
import Modelo.SprintBackLog;

public class Controlador {
	private static ProductBackLog productbacklog = new ProductBackLog();
	private static List<SprintBackLog> listasprint= new ArrayList<SprintBackLog>();
	private static Equipo equipo;
	

	public void anadirSprint() {
		listasprint.add(new SprintBackLog());
	}
	public List<SprintBackLog> consultarSprint() {
		return listasprint;
	}
	public int añadirMiembro() {
		int id=equipo.addMiembro();
		return id;
	}
	public MiembrodeEquipo consultaMiembro(int id) {
		return equipo.consultarMiembro(id);
	}
	public void removeMiembro(int id) {
		equipo.removeMiembro(id);
	}
	public List<MiembrodeEquipo> consultarLista(){
}
