package Controlador;

import java.util.ArrayList;
import java.util.List;

import Modelo.Equipo;
import Modelo.Estado;
import Modelo.MiembrodeEquipo;
import Modelo.ProductBackLog;
import Modelo.Requisito;
import Modelo.SprintBackLog;
import Modelo.Tarea;
import Persistencia.Persistencia;

public class Controlador {
	private static ProductBackLog productbacklog = new ProductBackLog();
	private static List<SprintBackLog> listasprint = new ArrayList<SprintBackLog>();
	private static Equipo equipo = new Equipo();
	private static List<Requisito> requisitos = new ArrayList<Requisito>();
	private static int idTarea = -1;
	private static int idRequisito = -1;
	static Persistencia persistencia = new Persistencia();

	public void anadirSprint() {
		listasprint.add(new SprintBackLog(listasprint.size()));
	}

	public List<SprintBackLog> consultarSprint() {
		return listasprint;
	}

	public int getidTarea() {
		return idTarea;
	}
	public void setidTarea(int idTar) {
		idTarea=idTar;
	}
	public int getidRequisito() {
		return idRequisito;
	}
	public void setidRequisito(int idReq) {
		idRequisito=idReq;
	}

	public List<Tarea> consultarTareasPB() {
		return productbacklog.getTareas();
	}

	public int añadirMiembro() {
		int id = equipo.addMiembro();
		return id;
	}

	public MiembrodeEquipo consultaMiembro(int id) {
		return equipo.consultarMiembro(id);
	}

	public void removeMiembro(int id) {
		equipo.removeMiembro(id);
	}

	public List<MiembrodeEquipo> consultarLista() {
		return equipo.getListaMiembros();
	}

	public void anadirRequisito() {
		requisitos.add(new Requisito(++idRequisito));
	}

	public List<Requisito> consultarRequisitos() {
		return requisitos;
	}

	public void anadirTareaARequisito(int id) {
		if (id < requisitos.size()) {
			requisitos.get(id).addTarea(++idTarea);
			List<Tarea> tareas = requisitos.get(id).consultarTareas();
			productbacklog.anadeTareas(tareas.get(tareas.size() - 1));
		}
	}

	public void moverTarea(Tarea tarea) {
		if (listasprint.size() != 0) {
			listasprint.get(listasprint.size() - 1).anadirTareas(productbacklog.cogeTarea(tarea),listasprint.size() - 1);
		} else
			System.out.println("No existe ningun sprint\n");
	}

	public void actualizarEstado(Tarea tarea) {
		listasprint.get(listasprint.size() - 1).actualizarTareas(tarea);
	}

	public List<Tarea> consTotalTareas() {
		return listasprint.get(listasprint.size() - 1).tareasTotal();
	}

	public void cambiarNTarea(String nombre, int id) {
		productbacklog.getTarea(id).setNombre(nombre);

	}

	public void cambiarCTarea(float coste, int id) {
		productbacklog.getTarea(id).setCoste(coste);
	}

	public void cambiarDTarea(String descripcion, int id) {
		productbacklog.getTarea(id).setDescripcion(descripcion);
	}

	public void cambiarBTarea(float beneficio, int id) {
		productbacklog.getTarea(id).setBeneficio(beneficio);
	}
	
	public void cambiarETarea(String estado, int id) {
		if(estado.equals("PENDIENTES")) {
		productbacklog.getTarea(id).setState(Estado.PENDIENTES);
		}else if(estado.equals("VALIDACION")) {
			productbacklog.getTarea(id).setState(Estado.VALIDACION);
		}else if(estado.equals("PROCESO")) {
			productbacklog.getTarea(id).setState(Estado.PROCESO);
		}else if(estado.equals("COMPLETADAS")) {
			productbacklog.getTarea(id).setState(Estado.COMPLETADAS);
		}
	}
	
	public Boolean containsReq(int idReq) {
		boolean flag = false;
		for (int i = 0; i < requisitos.size(); i++) {
			if (requisitos.get(i).getId() == idReq) {
				flag = true;
			}
		}
		return flag;
	}

	public Boolean containsTar(int idTar) {
		for (int i = 0; i < productbacklog.getTareas().size(); i++) {
			if (productbacklog.getTareas().get(i).getIdTarea() == idTar) {
				return true;
			} else
				return false;
		}
		return false;
	}

	// Metodos persistencia
	public void anadirRequisitoPersist(int id) {
		requisitos.add(new Requisito(id));
	}

	public void anadirTareaARequisitoPersist(int id, int idT) {
		if (id < requisitos.size()) {
			requisitos.get(id).addTarea(idT);
			List<Tarea> tareas = requisitos.get(id).consultarTareas();
			productbacklog.anadeTareas(tareas.get(tareas.size() - 1));
		}
	}

	public void comprobacionTareasRequisitos() {
		for (int i = 0; i < requisitos.size(); i++) {
			List<Tarea> tareas = requisitos.get(i).consultarTareas();
			for (int j = 0; j < tareas.size(); j++) {
				int req = requisitos.get(i).getId();
				int tar = tareas.get(j).getIdTarea();
				
			}
		}
	}

	public void EstadoTareaPersist(String estado,Tarea tarea,int sp) {
		if (estado.equals("PROCESO")) {
			listasprint.get(sp).actualizarTareas(tarea);
		}else if (estado.equals("VALIDACION")) {
			listasprint.get(sp).actualizarTareas(tarea);
			listasprint.get(sp).actualizarTareas(tarea);
		}else if (estado.equals("VALIDACION")) {
			listasprint.get(sp).actualizarTareas(tarea);
			listasprint.get(sp).actualizarTareas(tarea);
			listasprint.get(sp).actualizarTareas(tarea);
		}
	}
	
}
