package Modelo;

import java.util.ArrayList;
import java.util.List;



public class ProductBackLog extends BackLog {
	protected List<Tarea> tareasPendientes=new ArrayList<Tarea>();;
	
	public ProductBackLog() {
		// TODO Auto-generated method stub
	}

	public void anadeTareas(Tarea tarea) {
		if (tarea.getState().equals(Estado.PENDIENTES)) {
			tareasPendientes.add(tarea);
		}
	}

	public Tarea cogeTarea(Tarea tarea) {
		Tarea tareaEnv = null;
		for (int i = 0; i < tareasPendientes.size(); i++) {
			if (tareasPendientes.get(i).getIdTarea()==(tarea.getIdTarea())) {
				tareaEnv = tareasPendientes.get(i);
				
				tareasPendientes.remove(i);

			}
			

		}
		return tareaEnv;
	}
	public List<Tarea> getTareas() {
		return tareasPendientes;
	}
	public Tarea getTarea(int id) {
		for(int i=0;i<tareasPendientes.size();i++) {
			if(tareasPendientes.get(i).getIdTarea()==id) {
				return tareasPendientes.get(i);
			}
		}
		return null;
	}
}
