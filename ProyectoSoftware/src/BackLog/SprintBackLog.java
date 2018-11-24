package BackLog;

import java.util.List;

import Tarea.Tarea;

public class SprintBackLog extends BackLog {
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

	public void moverTareas(Tarea tarea, String estado) {
		if (!tarea.getState().equals(estado)) {
			String estadoActual = tarea.getState();
			if (estadoActual == "Pendiente") {
				for (int i = 0; i < TareasPendientes.size(); i++) {
					if (TareasPendientes.get(i).equals(tarea)) {
						TareasPendientes.remove(i);
					}

				}
			} else if (estadoActual == "Proceso") {
				for (int i = 0; i < TareasProceso.size(); i++) {
					if (TareasProceso.get(i).equals(tarea)) {
						TareasProceso.remove(i);
					}

				}
			} else if (estadoActual == "Validacion") {
				for (int i = 0; i < TareasValidacion.size(); i++) {
					if (TareasValidacion.get(i).equals(tarea)) {
						TareasValidacion.remove(i);
					}

				}
			} else if (estadoActual.equals("Completada")){
				for (int i = 0; i < TareasCompletadas.size(); i++) {
					if (TareasCompletadas.get(i).equals(tarea)) {
						TareasCompletadas.remove(i);
					}

				}
			}
			if (estado.equals("Pendiente")) {
				TareasPendientes.add(tarea);
			}else if (estado.equals("Proceso")) {
				TareasProceso.add(tarea);
			}else if (estado.equals("Validacion")) {
				TareasValidacion.add(tarea);
			}else if (estado.equals("Pendiente")) {
				TareasCompletadas.add(tarea);
			}
		}
	}
}
