package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Requisito {
	private int idReq=-1;
	private String nombre;
	private List<Tarea> tareas=new ArrayList<Tarea>();
	public Requisito(int idReq){
		this.idReq=idReq;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public int getId() {
		return idReq;
	}
	public void addTarea(int idTarea) {
		tareas.add(new Tarea(idTarea));
	}

	public void deleteTarea(Tarea tarea) {
		for (int i = 0; i < tareas.size(); i++) {
			if (tareas.get(i).equals(tarea)) {
				tareas.remove(i);
			}
		}
	}

	public List<Tarea> consultarTareas() {
		return tareas;
	}
	public Tarea getTarea(int id) {
		for(int i=0;i<tareas.size();i++) {
			if(tareas.get(i).getIdTarea()==id) {
				return tareas.get(i);
			}
		}
		return null;
	}

}
