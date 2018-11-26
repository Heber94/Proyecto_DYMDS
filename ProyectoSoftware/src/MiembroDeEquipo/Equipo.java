package MiembroDeEquipo;

import java.util.ArrayList;
import java.util.List;

import Tarea.Tarea;

public class Equipo {
	private int idEq;
	private List<MiembrodeEquipo> miembros;

	public Equipo() {
		miembros=new ArrayList<MiembrodeEquipo>();
	}

	public void addMiembro(String nombre, String apellido, int edad) {
		// TODO
			miembros.add(new MiembrodeEquipo(nombre,apellido,edad,miembros.size()+1));
	}

	public void removeMiembro(int id) {
			for (int i = 0; i < miembros.size(); i++) {
				if(miembros.get(i).getId()==(id)) {
					miembros.remove(i);
					break;
				}	
			}
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Equipo) {
			if (this.idEq==((Equipo) obj).getId())
				return true;
		}
		return false;
	}
}
