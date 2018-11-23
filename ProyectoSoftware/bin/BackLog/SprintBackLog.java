package BackLog;

import java.util.List;

import Tarea.Tarea;

public class SprintBackLog extends BackLog{
	protected List<Tarea> TareasPendientes;
	protected List<Tarea> TareasProceso;
	protected List<Tarea> TareasValidacion;
	protected List<Tarea> TareasCompletadas;
	
	@Override
	public BackLog copy() {
		// TODO Auto-generated method stub
		SprintBackLog sBack = new SprintBackLog();
		return sBack;
	}
	public void añadirTareas(Tarea tarea) {
		TareasPendientes.add(tarea);
	}
}
