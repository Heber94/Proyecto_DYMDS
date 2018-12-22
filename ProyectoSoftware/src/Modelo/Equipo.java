package Modelo;

import java.util.ArrayList;
import java.util.List;



public class Equipo {
	private List<MiembrodeEquipo> miembros;

	public Equipo() {
		miembros=new ArrayList<MiembrodeEquipo>();
	}

	public int addMiembro() {
			miembros.add(new MiembrodeEquipo(miembros.size()+1));
			return miembros.get(miembros.size()-1).getId();
	}

	public void removeMiembro(int id) {
			for (int i = 0; i < miembros.size(); i++) {
				if(miembros.get(i).getId()==(id)) {
					miembros.remove(i);
					break;
				}	
			}
	}
	public MiembrodeEquipo consultarMiembro(int id) {
		for (int i = 0; i < miembros.size(); i++) {
			if(miembros.get(i).getId()==id) {
				return miembros.get(i);
			}
		}
		return null;	
	}
	
	public List<MiembrodeEquipo> getListaMiembros(){
		return miembros;
	}

}
