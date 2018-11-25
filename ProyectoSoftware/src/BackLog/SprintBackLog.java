package BackLog;

import java.util.ArrayList;
import java.util.List;

import Tarea.Estado;
import Tarea.Tarea;

public class SprintBackLog extends BackLog {
	protected List<Tarea> TareasPendientes=new ArrayList<Tarea>();
	protected List<Tarea> TareasProceso=new ArrayList<Tarea>();
	protected List<Tarea> TareasValidacion=new ArrayList<Tarea>();
	protected List<Tarea> TareasCompletadas=new ArrayList<Tarea>();

	@Override
	public SprintBackLog copy() {
		// TODO Auto-generated method stub
		SprintBackLog sBack = new SprintBackLog();
		
		
		
		
		return sBack;
	}

	public void añadirTareas(Tarea tarea) {
		TareasPendientes.add(tarea);
	}

	public void moverTareas(Tarea tarea, Estado estado) {
		if (!tarea.getState().equals(estado)) {
			Estado estadoActual = tarea.getState();
			if (estadoActual == Estado.PENDIENTES) {
				for (int i = 0; i < TareasPendientes.size(); i++) {
					if (TareasPendientes.get(i).equals(tarea)) {
						TareasPendientes.remove(i);
					}

				}
			} else if (estadoActual == Estado.PROCESO) {
				for (int i = 0; i < TareasProceso.size(); i++) {
					if (TareasProceso.get(i).equals(tarea)) {
						TareasProceso.remove(i);
					}

				}
			} else if (estadoActual == Estado.VALIDACION) {
				for (int i = 0; i < TareasValidacion.size(); i++) {
					if (TareasValidacion.get(i).equals(tarea)) {
						TareasValidacion.remove(i);
					}

				}
			} else if (estadoActual.equals(Estado.COMPLETADAS)){
				for (int i = 0; i < TareasCompletadas.size(); i++) {
					if (TareasCompletadas.get(i).equals(tarea)) {
						TareasCompletadas.remove(i);
					}

				}
			}
			if (estado.equals(Estado.PENDIENTES)) {
				TareasPendientes.add(tarea);
			}else if (estado == Estado.PROCESO) {
				TareasProceso.add(tarea);
			}else if (estado.equals(Estado.VALIDACION)) {
				TareasValidacion.add(tarea);
			}else if (estado.equals(Estado.COMPLETADAS)) {
				TareasCompletadas.add(tarea);
			}
		}
	}
	public List<Tarea> getTP(){
		return TareasPendientes;
	}
	public List<Tarea> getTPr(){
		return TareasProceso;
	}
	public List<Tarea> getTV(){
		return TareasValidacion;
	}
	public List<Tarea> getTC(){
		return TareasCompletadas;
	}
}
