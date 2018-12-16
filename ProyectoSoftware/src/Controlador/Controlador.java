package Controlador;

import java.util.ArrayList;
import java.util.List;

import Modelo.Equipo;
import Modelo.MiembrodeEquipo;
import Modelo.ProductBackLog;
import Modelo.Requisito;
import Modelo.SprintBackLog;
import Modelo.Tarea;

public class Controlador {
	private static ProductBackLog productbacklog = new ProductBackLog();
	private static List<SprintBackLog> listasprint= new ArrayList<SprintBackLog>();
	private static Equipo equipo;
	private static List<Requisito> requisitos= new ArrayList<Requisito>();

	public void anadirSprint() {
		listasprint.add(new SprintBackLog());
	}
	public List<SprintBackLog> consultarSprint() {
		return listasprint;
	}
	public List<Tarea> consultarTareasPB() {
		return productbacklog.getTareas();
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
		return equipo.getListaMiembros();
	}
	public void anadirRequisito() {
		requisitos.add(new Requisito());
	}
	public List<Requisito> consultarRequisitos() {
		return requisitos;
	}
	public void anadirTareaARequisito(int id) {
		if(id<requisitos.size()) {
			requisitos.get(id).addTarea();
			List<Tarea> tareas= requisitos.get(id).consultarTareas();
			productbacklog.anadeTareas(tareas.get(tareas.size()-1));
		}
	}
	public void moverTarea(Tarea tarea) {
		listasprint.get(listasprint.size()-1).anadirTareas(productbacklog.cogeTarea(tarea));
	}
	public void actualizarEstado(int id) {
		Tarea tarea=new Tarea();
		tarea=null;
		for(int i=0;i<listasprint.get(listasprint.size()-1).tareasTotal().size();i++) {
			if(listasprint.get(listasprint.size()-1).tareasTotal().get(i).getIdTarea()==id){
				tarea=listasprint.get(listasprint.size()-1).tareasTotal().get(i);
			}
		}
		listasprint.get(listasprint.size()-1).actualizarTareas(tarea);
	}
	public List<Tarea> consTotalTareas(){
		return listasprint.get(listasprint.size()-1).tareasTotal();
	}
	public void cambiarNTarea(String nombre,int id) {
		productbacklog.getTarea(id).setNombre(nombre);;
	}
	public void cambiarCTarea(float coste,int id) {
		productbacklog.getTarea(id).setCoste(coste);
	}
	public void cambiarDTarea(String descripcion,int id) {
		productbacklog.getTarea(id).setDescripcion(descripcion);
	}
	public void cambiarBTarea(float beneficio,int id) {
		productbacklog.getTarea(id).setBeneficio(beneficio);
	}
}
