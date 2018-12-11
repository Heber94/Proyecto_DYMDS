package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SprintBackLog extends BackLog {
	protected static int id;
	protected int duracion;
	protected LocalDate inicio;
	protected List<Tarea> TareasPendientes = new ArrayList<Tarea>();
	protected List<Tarea> TareasProceso = new ArrayList<Tarea>();
	protected List<Tarea> TareasValidacion = new ArrayList<Tarea>();
	protected List<Tarea> TareasCompletadas = new ArrayList<Tarea>();

	public SprintBackLog() {
		id = id++;
		duracion = 4;
		LocalDate localDate = LocalDate.now();
		inicio = localDate;
	}

	public void anadirTareas(Tarea tarea) {
		TareasPendientes.add(tarea);
	}

	public void actualizarTareas(Tarea tarea) {
		if (tarea.getState().equals(Estado.PENDIENTES)) {
			TareasPendientes.remove(tarea);
			tarea.setState(Estado.PROCESO);
			TareasProceso.add(tarea);
		}else if (tarea.getState().equals(Estado.PROCESO)) {
			TareasProceso.remove(tarea);
			tarea.setState(Estado.VALIDACION);
			TareasValidacion.add(tarea);
		}else if (tarea.getState().equals(Estado.VALIDACION)) {
			TareasValidacion.remove(tarea);
			tarea.setState(Estado.COMPLETADAS);
			TareasCompletadas.add(tarea);
		}
		
	}
	public int getId() {
		return id;
	}
	public List<Tarea> getTP() {
		return TareasPendientes;
	}

	public List<Tarea> getTPr() {
		return TareasProceso;
	}

	public List<Tarea> getTV() {
		return TareasValidacion;
	}

	public List<Tarea> getTC() {
		return TareasCompletadas;
	}
}
