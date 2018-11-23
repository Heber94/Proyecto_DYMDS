package BackLog;

import Tarea.Tarea;

public class ProductBackLog extends BackLog {

	@Override
	public BackLog copy() {
		// TODO Auto-generated method stub
		ProductBackLog pBack = new ProductBackLog();
		return pBack;

	}

	public void añadeTareas(Tarea tarea) {
		if (tarea.getState().equals("Pendiente")) {
			TareasPendientes.add(tarea);

		}
	}

	public Tarea cogeTarea(Tarea tarea) {
		Tarea tareaEnv = null;
		for (int i = 0; i < TareasPendientes.size(); i++) {
			if (TareasPendientes.get(i).equals(tarea)) {
				tareaEnv = TareasPendientes.get(i);
				TareasPendientes.remove(i);

			}
			

		}
		return tareaEnv;
	}
}
