package BackLog;
import java.util.List;

import Tarea.Tarea;
public abstract class BackLog {
	protected List<Tarea> TareasPendientes;
	protected List<Tarea> TareasProceso;
	protected List<Tarea> TareasValidacion;
	protected List<Tarea> TareasCompletadas;
	public abstract BackLog copy();
}
